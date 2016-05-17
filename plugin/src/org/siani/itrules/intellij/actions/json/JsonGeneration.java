package org.siani.itrules.intellij.actions.json;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.intellij.actions.GenerationAction;

import java.io.File;
import java.util.List;

public class JsonGeneration extends GenerationAction {
	private static final String JSON = ".json";

	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		if (projectExists(e, project)) return;
		List<VirtualFile> rulesFiles = getVirtualFile(e);
		if (rulesFiles.isEmpty()) return;
		for (VirtualFile rulesFile : rulesFiles) {
			if (checkDocument(project, rulesFile)) return;
			Module moduleOf = getModuleOf(project, rulesFile);
			File destiny = new File(findDestiny(project, moduleOf), rulesFile.getName() + JSON);
			RunJsonGeneration jsonGeneration = new RunJsonGeneration(rulesFile, project, "Generate Json", destiny);
			ProgressManager.getInstance().run(jsonGeneration);
			refreshFiles(destiny);
			if (!jsonGeneration.getIndicator().isCanceled()) notify(project, rulesFile, destiny);
			else error(project, jsonGeneration.getIndicator().getText());
		}
	}

	private void notify(Project project, VirtualFile rulesFile, File destiny) {
		Notifications.Bus.notify(
			new Notification("Itrules JSON Generation", "JSON for " + rulesFile.getName() + " generated", "to " + destiny.getPath(), NotificationType.INFORMATION), project);
	}

	private void error(Project project, String message) {
		Notifications.Bus.notify(
			new Notification("Itrules JSON Generation", "Error occurred during template generation", message, NotificationType.ERROR), project);
	}

	protected String findDestiny(Project project, Module module) {
		if (module == null) return project.getBasePath();
		File res = new File(module.getModuleFile().getParent().getPath(), "res");
		res.mkdirs();
		return res.getPath();
	}
}
