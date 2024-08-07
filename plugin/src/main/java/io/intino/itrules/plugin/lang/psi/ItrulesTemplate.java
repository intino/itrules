package io.intino.itrules.plugin.lang.psi;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public interface ItrulesTemplate extends PsiFile {

	@NotNull
	PsiFile getContainingFile();

	@NotNull
	String getName();

	VirtualFile getVirtualFile();

	PsiDirectory getParent();

	String getPresentableName();

	@NotNull
	Project getProject();

	String getText();
}
