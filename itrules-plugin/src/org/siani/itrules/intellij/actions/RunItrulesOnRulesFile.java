package org.siani.itrules.intellij.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task.Modal;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.ItrRulesReader;

import java.io.File;
import java.io.FileWriter;

public class RunItrulesOnRulesFile extends Modal {

	public static final Logger LOG = Logger.getInstance("RunItrulesOnRulesFile");

	public static final String groupDisplayId = "Itrules JSON Generation";
	public VirtualFile rulesFile;
	public Project project;
	private final File destiny;

	public RunItrulesOnRulesFile(VirtualFile rulesFile, Project project, String title, File destiny) {
		super(project, title, true);
		this.rulesFile = rulesFile;
		this.project = project;
		this.destiny = destiny;
	}

	public void run(@NotNull ProgressIndicator indicator) {
		indicator.setIndeterminate(true);
		itrules();
	}

	public void itrules() {
		if (this.rulesFile == null) return;
		LOG.info("itrules(\"" + this.rulesFile.getPath() + "\")");
		try {
			FileWriter writer = new FileWriter(this.destiny);
			writer.write(JsonRulesWriter.toJSON(new ItrRulesReader(this.rulesFile.getInputStream()).read()));
			writer.close();
		} catch (Throwable e) {
			e.printStackTrace();
			Notification notification = new Notification(groupDisplayId, "can't generate JSON for " + this.rulesFile.getName(), e.toString(), NotificationType.INFORMATION);
			Notifications.Bus.notify(notification, this.project);
		}
	}
}
