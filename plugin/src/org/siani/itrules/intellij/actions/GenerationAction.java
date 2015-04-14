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
import java.util.Set;

public abstract class GenerationAction extends AnAction implements DumbAware {
	public static final Logger LOG = Logger.getInstance("itrules: Generate");

	public void update(@NotNull AnActionEvent e) {
		ActionUtils.selectedFileIsItrules(e);
	}

	protected abstract String findDestiny(Project project, Module module, VirtualFile file) throws Exception;

	protected VirtualFile getVirtualFile(AnActionEvent e) {
		VirtualFile rulesFile = ActionUtils.getItrulesFileFromEvent(e);
		LOG.info("actionPerformed " + (rulesFile == null ? "NONE" : rulesFile));
		if (rulesFile == null) return null;
		return rulesFile;
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
		PsiDocumentManager psiMgr = PsiDocumentManager.getInstance(project);
		FileDocumentManager docMgr = FileDocumentManager.getInstance();
		Document doc = docMgr.getDocument(rulesFile);
		if (doc == null) return true;
		if ((!psiMgr.isCommitted(doc)) || (docMgr.isDocumentUnsaved(doc))) {
			psiMgr.commitDocument(doc);
			docMgr.saveDocument(doc);
		}
		return false;
	}

	protected Module getModuleOf(Project project, VirtualFile file) {
		return ProjectRootManager.getInstance(project).getFileIndex().getModuleForFile(file);
	}
}
