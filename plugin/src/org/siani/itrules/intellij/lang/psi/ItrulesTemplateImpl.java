package org.siani.itrules.intellij.lang.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.OrderRootType;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.roots.libraries.Library;
import com.intellij.openapi.roots.libraries.LibraryTable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.siani.itrules.intellij.lang.ItrulesIcons;
import org.siani.itrules.intellij.lang.ItrulesLanguage;
import org.siani.itrules.intellij.lang.file.ItrulesFileType;

import javax.swing.*;

public class ItrulesTemplateImpl extends PsiFileBase implements ItrulesTemplate {

	public ItrulesTemplateImpl(@NotNull FileViewProvider viewProvider) {
		super(viewProvider, ItrulesLanguage.INSTANCE);
		addItrulesLibrary(findItrulesLibrary());
	}

	private void addItrulesLibrary(final String library) {
		ApplicationManager.getApplication().runWriteAction(
			new Runnable() {
				@Override
				public void run() {
					Module module = ProjectRootManager.getInstance(getProject()).getFileIndex().getModuleForFile(getVirtualFile());
					if (module == null) return;
					ModifiableRootModel rootModel = ModuleRootManager.getInstance(module).getModifiableModel();
					LibraryTable.ModifiableModel modifiableModel = rootModel.getModuleLibraryTable().getModifiableModel();
					VirtualFile libraryPath = VirtualFileManager.getInstance().findFileByUrl(library);
					if (libraryPath != null)
						commit(library(modifiableModel, libraryPath), rootModel);
				}

				private Library library(LibraryTable.ModifiableModel modifiableModel, VirtualFile libraryPath) {
					Library itrules = modifiableModel.createLibrary("itrules");
					Library.ModifiableModel libModel = itrules.getModifiableModel();
					libModel.addRoot(libraryPath, OrderRootType.CLASSES);
					libModel.commit();
					modifiableModel.commit();
					return itrules;
				}

				private void commit(Library itrules, ModifiableRootModel rootModel) {
					rootModel.addLibraryEntry(itrules);
					rootModel.commit();
				}
			}

		);
	}

	private String findItrulesLibrary() {
		return null;
	}

	@NotNull
	@Override
	public FileType getFileType() {
		return ItrulesFileType.INSTANCE;
	}

	@Override
	public String toString() {
		return getPresentableName();
	}

	@NotNull
	public String getPresentableName() {
		return getName().contains(".") ? getName().substring(0, getName().lastIndexOf(".")) : getName();
	}

	@Override
	public ItemPresentation getPresentation() {
		return new ItemPresentation() {
			@Override
			public String getPresentableText() {
				return getName().substring(0, getName().lastIndexOf("."));
			}

			@Override
			public String getLocationString() {
				final PsiDirectory psiDirectory = getParent();
				if (psiDirectory != null) {
					return psiDirectory.getVirtualFile().getPresentableUrl();
				}
				return null;
			}

			@Override
			public Icon getIcon(final boolean open) {
				return ItrulesIcons.ICON_13;
			}
		};
	}

	@Nullable
	@Override
	public Icon getIcon(int flags) {
		return ItrulesIcons.ICON_13;
	}

}