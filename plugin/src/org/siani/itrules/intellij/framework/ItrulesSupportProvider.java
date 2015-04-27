package org.siani.itrules.intellij.framework;

import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetType;
import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleConfigurable;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModel;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportModelListener;
import com.intellij.ide.util.frameworkSupport.FrameworkSupportProvider;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.FacetsProvider;
import com.intellij.openapi.startup.StartupManager;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.vcsUtil.VcsUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.idea.maven.project.MavenProjectsManager;
import org.siani.itrules.intellij.facet.ItrulesFacet;
import org.siani.itrules.intellij.facet.ItrulesFacetConfiguration;
import org.siani.itrules.intellij.framework.maven.ModulePomTemplate;
import org.siani.itrules.intellij.framework.maven.ProjectPomTemplate;
import org.siani.itrules.model.Frame;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.io.File.separator;

public class ItrulesSupportProvider extends FrameworkSupportInModuleProvider {

	private static final String POM_XML = "pom.xml";

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
	                        Locale locale, String encoding) {
		createTemplateDirectory(rootModel.getContentEntries()[0]);
		if (rootModel.getProject().isInitialized()) addMavenToProject(module);
		else startWithMaven(module);
		FacetType<ItrulesFacet, ItrulesFacetConfiguration> facetType = ItrulesFacet.getFacetType();
		ItrulesFacet itrulesFacet = FacetManager.getInstance(module).addFacet(facetType, facetType.getDefaultFacetName(), null);
		final ItrulesFacetConfiguration facetConfiguration = itrulesFacet.getConfiguration();
		facetConfiguration.setLocale(locale);
		facetConfiguration.setEncoding(encoding);
	}

	private void startWithMaven(final Module module) {
		StartupManager.getInstance(module.getProject()).registerPostStartupActivity(new Runnable() {
			@Override
			public void run() {
				addMavenToProject(module);
			}
		});
	}

	private void addMavenToProject(final Module module) {
		List<VirtualFile> pomFiles = createPoms(module);
		MavenProjectsManager manager = MavenProjectsManager.getInstance(module.getProject());
		manager.addManagedFilesOrUnignore(pomFiles);
		manager.importProjects();
		manager.forceUpdateAllProjectsOrFindAllAvailablePomFiles();
	}

	private List<VirtualFile> createPoms(Module module) {
		List<VirtualFile> files = new ArrayList<>();
		files.add(projectPom(module));
		files.add(modulePom(module));
		return files;
	}

	private VirtualFile modulePom(final Module module) {
		final PsiFile[] file = new PsiFile[1];
		ApplicationManager.getApplication().runWriteAction(new Runnable() {
			@Override
			public void run() {
				PsiDirectory root = PsiManager.getInstance(module.getProject()).findDirectory(module.getModuleFile().getParent());
				file[0] = findPom(root);
				if (file[0] == null) file[0] = root.createFile("pom.xml");
				createPom(file[0].getVirtualFile().getPath(), new ModulePomTemplate().render(createModuleFrame(module)));
			}
		});
		return file[0].getVirtualFile();
	}

	private PsiFile findPom(PsiDirectory root) {
		for (PsiElement element : root.getChildren())
			if (element instanceof PsiFile && "pom.xml".equals(((PsiFile) element).getVirtualFile().getName()))
				return (PsiFile) element;
		return null;
	}

	private File createPom(String path, String text) {
		try {
			File file = new File(path);
			FileWriter writer = new FileWriter(file);
			writer.write(text);
			writer.close();
			return file;
		} catch (IOException ignored) {
		}
		return null;
	}

	private VirtualFile projectPom(final Module module) {
		final PsiFile[] file = new PsiFile[1];
		ApplicationManager.getApplication().runWriteAction(new Runnable() {
			@Override
			public void run() {
				File pomFile = new File(module.getProject().getBaseDir().getPath() + separator + POM_XML);
				VirtualFile directory = VcsUtil.getVcsRootFor(module.getProject(), VcsUtil.getFilePath(pomFile));
				PsiDirectory root = PsiManager.getInstance(module.getProject()).findDirectory(directory);
				file[0] = findPom(root);
				if (file[0] == null) file[0] = root.createFile("pom.xml");
				createPom(file[0].getVirtualFile().getPath(), new ProjectPomTemplate().render(createProjectFrame(module, getModulesOf(module.getProject()))));
			}
		});
		return file[0].getVirtualFile();
	}

	@NotNull
	private Module[] getModulesOf(Project project) {
		return ModuleManager.getInstance(project).getModules();
	}

	private Frame createModuleFrame(Module module) {
		Frame frame = new Frame(null).addTypes("pom");
		frame.addFrame("project", module.getProject().getName());
		if (!module.getModuleFile().getParent().equals(module.getProject().getBaseDir()))
			frame.addFrame("parent", new Frame(frame).addTypes("parent").addFrame("project", module.getProject().getName()).addFrame("module", module.getName()));
		frame.addFrame("module", module.getName());
		return frame;
	}

	private Frame createProjectFrame(Module module, Module[] modules) {
		Project project = module.getProject();
		MavenProjectsManager manager = new MavenProjectsManager(project);
		Frame frame = new Frame(null).addTypes("pom");
		frame.addFrame("project", project.getName());
		for (Module aModule : modules)
			if (aModule.getName().equalsIgnoreCase(module.getProject().getName()) && (manager.isMavenizedModule(aModule) || aModule.equals(module)))
				frame.addFrame("module", "<module>" + aModule.getName() + "</module>");
		return frame;
	}

	private void createTemplateDirectory(ContentEntry contentEntry) {
		try {
			if (contentEntry.getFile() == null) return;
			String modulePath = contentEntry.getFile().getPath();
			VirtualFile templates = VfsUtil.createDirectories(modulePath + separator + "templates");
		} catch (IOException ignored) {
		}
	}

	@NotNull
	@Override
	public FrameworkSupportInModuleConfigurable createConfigurable(@NotNull FrameworkSupportModel model) {
		return new ItrulesSupportConfigurable(model);
	}

	private class ItrulesSupportConfigurable extends FrameworkSupportInModuleConfigurable implements FrameworkSupportModelListener {
		private JPanel myMainPanel;
		private JComboBox<String> localeComboBox;
		private JComboBox<String> encodingBox;

		private ItrulesSupportConfigurable(FrameworkSupportModel model) {
			model.addFrameworkListener(this);
			localeComboBox.addItem("English");
			localeComboBox.addItem("Español");
			localeComboBox.setEnabled(false);
			encodingBox.setEnabled(false);
			encodingBox.addItem("UTF-8");
			encodingBox.addItem("UTF-16");
			encodingBox.addItem("ISO-8859-1");
		}


		@Override
		public void frameworkSelected(@NotNull FrameworkSupportProvider frameworkSupportProvider) {
			localeComboBox.setEnabled(true);
			encodingBox.setEnabled(true);
		}

		@Override
		public void frameworkUnselected(@NotNull FrameworkSupportProvider frameworkSupportProvider) {
			localeComboBox.setEnabled(false);
			encodingBox.setEnabled(false);
		}

		@Override
		public void wizardStepUpdated() {
		}

		@Override
		public void addSupport(@NotNull Module module,
		                       @NotNull ModifiableRootModel rootModel,
		                       @NotNull ModifiableModelsProvider modifiableModelsProvider) {
			ItrulesSupportProvider.this.addSupport(module, rootModel, localeComboBox.getSelectedItem().equals("English") ? Locale.ENGLISH : new Locale("Spanish", "Spain", "es_ES"), (String) encodingBox.getSelectedItem());
		}

		@Nullable
		@Override
		public JComponent createComponent() {
			return myMainPanel;
		}
	}
}
