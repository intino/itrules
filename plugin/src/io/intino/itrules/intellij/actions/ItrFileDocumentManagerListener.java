package io.intino.itrules.intellij.actions;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManagerListener;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import io.intino.itrules.intellij.actions.java.TemplateGeneration;
import io.intino.itrules.intellij.lang.file.ItrulesFileType;


public class ItrFileDocumentManagerListener implements FileDocumentManagerListener {

	private TemplateGeneration generator = new TemplateGeneration();

	@Override
	public void beforeAllDocumentsSaving() {
	}

	@Override
	public void beforeDocumentSaving(@NotNull Document document) {
		final Project[] openProjects = ProjectManager.getInstance().getOpenProjects();
		for (Project project : openProjects) {
			if (!project.isInitialized()) continue;
			final PsiFile psiFile = PsiDocumentManager.getInstance(project).getPsiFile(document);
			if (psiFile != null && psiFile.getModificationStamp() != 0 && psiFile.getFileType().equals(ItrulesFileType.INSTANCE))
				ApplicationManager.getApplication().invokeLater(() -> generator.createTemplate(project, psiFile.getVirtualFile()), ModalityState.NON_MODAL);
		}
	}

	@Override
	public void beforeFileContentReload(VirtualFile file, @NotNull Document document) {

	}

	@Override
	public void fileWithNoDocumentChanged(@NotNull VirtualFile file) {

	}

	@Override
	public void fileContentReloaded(@NotNull VirtualFile file, @NotNull Document document) {

	}

	@Override
	public void fileContentLoaded(@NotNull VirtualFile file, @NotNull Document document) {

	}

	@Override
	public void unsavedDocumentsDropped() {

	}
}
