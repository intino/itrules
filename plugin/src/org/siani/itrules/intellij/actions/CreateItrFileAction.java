package org.siani.itrules.intellij.actions;

import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.actions.JavaCreateTemplateInPackageAction;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.siani.itrules.intellij.facet.ItrulesFacet;
import org.siani.itrules.intellij.lang.ItrulesIcons;
import org.siani.itrules.intellij.lang.file.ItrulesFileType;
import org.siani.itrules.intellij.lang.psi.ItrulesTemplateImpl;

import java.util.Map;

public class CreateItrFileAction extends JavaCreateTemplateInPackageAction<ItrulesTemplateImpl> {

	public CreateItrFileAction() {
		super("ItRules Template", "Creates new Itrules Model", ItrulesIcons.ICON_13, true);
	}

	@Override
	protected void buildDialog(Project project, PsiDirectory directory, CreateFileFromTemplateDialog.Builder builder) {
		builder.setTitle("Enter name for new Itrules Model");
		builder.addKind("itr template", ItrulesIcons.ICON_13, "");
	}

	@Override
	protected String getActionName(PsiDirectory directory, String newName, String templateName) {
		return "ItRules Template";
	}

	@Nullable
	@Override
	protected PsiElement getNavigationElement(@NotNull ItrulesTemplateImpl template) {
		return template;
	}

	@Override
	protected boolean isAvailable(DataContext dataContext) {
		PsiElement data = CommonDataKeys.PSI_ELEMENT.getData(dataContext);
		if (data == null || !(data instanceof PsiFile || data instanceof PsiDirectory)) return false;
		Module module = ModuleUtil.findModuleForPsiElement(data);
		return super.isAvailable(dataContext) && ItrulesFacet.of(module) != null && isInTemplatesDirectory(data, module);
	}

	private boolean isInTemplatesDirectory(PsiElement dir, Module module) {
		return isIn(getTemplatesSourceRoot(module), dir);
	}

	private boolean isIn(VirtualFile modelSourceRoot, PsiElement dir) {
		if (modelSourceRoot == null) return false;
		PsiElement parent = dir;
		while (parent != null && !modelSourceRoot.equals(getVirtualFile(parent)))
			parent = parent.getParent();
		return parent != null && getVirtualFile(parent).equals(modelSourceRoot);
	}

	private VirtualFile getVirtualFile(PsiElement element) {
		return element instanceof PsiDirectory ? ((PsiDirectory) element).getVirtualFile() : ((PsiFile) element).getVirtualFile();
	}

	private VirtualFile getTemplatesSourceRoot(Module module) {
		for (VirtualFile mySourceRootType : ModuleRootManager.getInstance(module).getSourceRoots())
			if (mySourceRootType.getName().equals("templates")) return mySourceRootType;
		return null;
	}

	@Nullable
	@Override
	protected ItrulesTemplateImpl doCreate(PsiDirectory directory, String newName, String templateName) throws IncorrectOperationException {
		final PsiFileFactory factory = PsiFileFactory.getInstance(directory.getProject());
		String fileName = newName + "." + ItrulesFileType.INSTANCE.getDefaultExtension();
		PsiFile file = factory.createFileFromText(fileName, ItrulesFileType.INSTANCE, "def\n" +
			"\n\t" +
			"\n\t" +
			"end");
		directory.add(file);
		return (ItrulesTemplateImpl) file;
	}

	@Override
	protected void postProcess(ItrulesTemplateImpl createdElement, String templateName, Map<String, String> customProperties) {
		super.postProcess(createdElement, templateName, customProperties);
		createdElement.navigate(true);
	}
}