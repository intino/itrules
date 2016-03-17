package org.siani.itrules.intellij.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class GenerationAction extends AnAction implements DumbAware {
	public static final Logger LOG = Logger.getInstance("itrules: Generate");

	public void update(@NotNull AnActionEvent e) {
		ActionUtils.selectedFilesAreItrules(e);
		ActionUtils.selectedFilesAreInItrulesModule(e);
	}

	protected abstract String findDestiny(Project project, Module module, VirtualFile file) throws Exception;

	protected List<VirtualFile> getVirtualFile(AnActionEvent e) {
		List<VirtualFile> rulesFiles = ActionUtils.getItrulesFilesFromEvent(e);
		LOG.info("actionPerformed " + (rulesFiles.isEmpty() ? "NONE" : rulesFiles));
		if (rulesFiles.isEmpty()) return null;
		return rulesFiles;
	}

	protected boolean projectExists(AnActionEvent e, Project project) {
		if (project == null) {
			LOG.error("actionPerformed: no project for " + e);
			return true;
		}
		return false;
	}

	protected void refreshFiles(File destiny) {
		Set<File> generatedFiles = new HashSet<>();
		generatedFiles.add(destiny);
		LocalFileSystem.getInstance().refreshIoFiles(generatedFiles, true, true, null);
	}

	protected boolean checkDocument(Project project, VirtualFile rulesFile) {
		PsiDocumentManager documentManager = PsiDocumentManager.getInstance(project);
		FileDocumentManager fileDocManager = FileDocumentManager.getInstance();
		Document doc = fileDocManager.getDocument(rulesFile);
		if (doc == null) return true;
		if ((!documentManager.isCommitted(doc)) || (fileDocManager.isDocumentUnsaved(doc))) {
			documentManager.commitDocument(doc);
			fileDocManager.saveDocument(doc);
		}
		return false;
	}

	protected Module getModuleOf(Project project, VirtualFile file) {
		return ProjectRootManager.getInstance(project).getFileIndex().getModuleForFile(file);
	}
}
