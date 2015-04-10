package org.siani.itrules.intellij.framework;

import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetType;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModelListener;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportProvider;
import com.intellij.openapi.application.Result;
import com.intellij.openapi.application.WriteAction;
import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.roots.libraries.LibraryTablesRegistrar;
import com.intellij.openapi.roots.ui.configuration.FacetsProvider;
import com.intellij.openapi.vfs.JarFileSystem;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.siani.itrules.intellij.facet.ItrulesFacet;
import org.siani.itrules.intellij.facet.ItrulesFacetConfiguration;
import org.siani.itrules.intellij.sdk.ItrulesSdk;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static java.io.File.separator;

public class ItrulesSupportProvider extends FrameworkSupportInModuleProvider {

	@NotNull
	@Override
	public FrameworkTypeEx getFrameworkType() {
		return ItrulesFrameworkType.getFrameworkType();
	}

	@Override
	public boolean isEnabledForModuleType(@NotNull ModuleType moduleType) {
		return moduleType instanceof JavaModuleType;
	}

	@Override
	public boolean isSupportAlreadyAdded(@NotNull Module module, @NotNull FacetsProvider facetsProvider) {
		return !facetsProvider.getFacetsByType(module, ItrulesFacet.ID).isEmpty();
	}

	private void addSupport(final Module module,
	                        final ModifiableRootModel rootModel,
	                        String sdkPath,
	                        Locale locale) {
		FacetType<ItrulesFacet, ItrulesFacetConfiguration> facetType = ItrulesFacet.getFacetType();
		ItrulesFacet itrulesFacet = FacetManager.getInstance(module).addFacet(facetType, facetType.getDefaultFacetName(), null);
		final ItrulesFacetConfiguration facetConfiguration = itrulesFacet.getConfiguration();
		final ItrulesSdk sdk = itrulesFacet.getSdk();
		facetConfiguration.setSdkHomePath(sdkPath);
		facetConfiguration.setLocale(locale);
		final Library apiJar = addProjectLibrary(module, "itrules", sdk.getUserLibraryPaths());
		rootModel.addLibraryEntry(apiJar);
		createTemplateDirectory(rootModel.getContentEntries()[0]);
	}

	private void createTemplateDirectory(ContentEntry contentEntry) {
		try {
			if (contentEntry.getFile() == null) return;
			String modulePath = contentEntry.getFile().getPath();
			VfsUtil.createDirectories(modulePath + separator + "templates");
		} catch (IOException ignored) {
		}
	}


	private static Library addProjectLibrary(final Module module, final String name, final List<String> jarDirectories) {
		return new WriteAction<Library>() {
			protected void run(@NotNull final Result<Library> result) {
				final LibraryTable libraryTable = LibraryTablesRegistrar.getInstance().getLibraryTable(module.getProject());
				Library library = libraryTable.getLibraryByName(name);
				if (library == null) library = addLibrary(libraryTable);
				result.setResult(library);
			}

			private Library addLibrary(LibraryTable libraryTable) {
				Library library;
				library = libraryTable.createLibrary(name);
				final Library.ModifiableModel model = library.getModifiableModel();
				for (String path : jarDirectories) {
					String url = VirtualFileManager.constructUrl(JarFileSystem.PROTOCOL, path) + JarFileSystem.JAR_SEPARATOR;
					VirtualFile jarVirtualFile = VirtualFileManager.getInstance().findFileByUrl(url);
					model.addRoot(jarVirtualFile, OrderRootType.CLASSES);
				}
				model.commit();
				return library;
			}
		}.execute().getResultObject();
	}

	@NotNull
	@Override
	public FrameworkSupportInModuleConfigurable createConfigurable(@NotNull FrameworkSupportModel model) {
		return new ItrulesSupportConfigurable(model);
	}


	private class ItrulesSupportConfigurable extends FrameworkSupportInModuleConfigurable implements FrameworkSupportModelListener {
		private JPanel myMainPanel;
		private JComboBox localeComboBox;

		private ItrulesSupportConfigurable(FrameworkSupportModel model) {
			model.addFrameworkListener(this);
			localeComboBox.addItem("English");
			localeComboBox.addItem("Español");
		}


		@Override
		public void frameworkSelected(@NotNull FrameworkSupportProvider frameworkSupportProvider) {
		}

		@Override
		public void frameworkUnselected(@NotNull FrameworkSupportProvider frameworkSupportProvider) {
		}

		@Override
		public void wizardStepUpdated() {
		}

		@Override
		public void addSupport(@NotNull Module module,
		                       @NotNull ModifiableRootModel rootModel,
		                       @NotNull ModifiableModelsProvider modifiableModelsProvider) {
			ItrulesSupportProvider.this.addSupport(module, rootModel, "##PATH##", localeComboBox.getSelectedItem().equals("English") ? Locale.ENGLISH : new Locale("Spanish", "Spain", "es_ES"));
		}

		@Nullable
		@Override
		public JComponent createComponent() {
			return myMainPanel;
		}
	}
}
