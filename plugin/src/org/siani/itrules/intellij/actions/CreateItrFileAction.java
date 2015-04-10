package org.siani.itrules.intellij.actions;

import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.ide.actions.JavaCreateTemplateInPackageAction;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.siani.itrules.intellij.lang.ItrulesIcons;
import org.siani.itrules.intellij.lang.file.ItrulesFileType;

public class CreateItrFileAction extends JavaCreateTemplateInPackageAction<PsiPlainTextFile> {

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
	protected PsiElement getNavigationElement(@NotNull PsiPlainTextFile psiPlainTextFile) {
		return psiPlainTextFile;
	}

	@Nullable
	@Override
	protected PsiPlainTextFile doCreate(PsiDirectory directory, String newName, String templateName) throws IncorrectOperationException {
		final PsiFileFactory factory = PsiFileFactory.getInstance(directory.getProject());
		String fileName = newName + "." + ItrulesFileType.INSTANCE.getDefaultExtension();
		PsiFile file = factory.createFileFromText(fileName, ItrulesFileType.INSTANCE, "defrule\n" +
			"\n" +
			"\n" +
			"endrule");
		directory.add(file);
		return (PsiPlainTextFile) file;
	}
}