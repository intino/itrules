package org.siani.itrules.intellij.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressManager;
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

public class GenerateAction extends AnAction implements DumbAware {
	public static final Logger LOG = Logger.getInstance("Itrules Generate Action");
	private static final String JSON = ".json";

	public GenerateAction() {
	}

	public void update(@NotNull AnActionEvent e) {
		ActionUtils.selectedFileIsItrules(e);
	}


	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		if (projectExists(e, project)) return;
		VirtualFile rulesFile = getVirtualFile(e);
		if (rulesFile == null) return;
		String title = "Itrules Json Generation";
		if (checkDocument(project, rulesFile)) return;
		File destiny = new File(findOutputDirName(project, rulesFile), rulesFile.getName() + JSON);
		RunItrulesOnRulesFile gen = new RunItrulesOnRulesFile(rulesFile, project, title, destiny);
		ProgressManager.getInstance().run(gen);
		refreshFiles(destiny);
		notify(project, rulesFile, destiny);
	}

	private VirtualFile getVirtualFile(AnActionEvent e) {
		VirtualFile rulesFile = ActionUtils.getItrulesFileFromEvent(e);
		LOG.info("actionPerformed " + (rulesFile == null ? "NONE" : rulesFile));
		if (rulesFile == null) return null;
		return rulesFile;
	}

	private boolean projectExists(AnActionEvent e, Project project) {
		if (project == null) {
			LOG.error("actionPerformed: no project for " + e);
			return true;
		}
		return false;
	}

	private void notify(Project project, VirtualFile rulesFile, File destiny) {
		Notification notification = new Notification("Itrules JSON Generation", "JSON for " + rulesFile.getName() + " generated", "to " + destiny.getPath(), NotificationType.INFORMATION);
		Notifications.Bus.notify(notification, project);
	}

	private void refreshFiles(File destiny) {
		Set<File> generatedFiles = new HashSet<>();
		generatedFiles.add(destiny);
		LocalFileSystem.getInstance().refreshIoFiles(generatedFiles, true, true, null);
	}

	private boolean checkDocument(Project project, VirtualFile rulesFile) {
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

	private String findOutputDirName(Project project, VirtualFile file) {
		Module moduleForFile = ProjectRootManager.getInstance(project).getFileIndex().getModuleForFile(file);
		if (moduleForFile == null) return project.getBasePath();
		File res = new File(moduleForFile.getModuleFile().getParent().getPath(), "res");
		res.mkdirs();
		return res.getPath();
	}
}
