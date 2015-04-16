package org.siani.itrules.intellij.actions.json;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task.Modal;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.readers.ItrRuleSetReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RunJsonGeneration extends Modal {

	public static final Logger LOG = Logger.getInstance("RunItrulesOnRulesFile");

	private static final String groupDisplayId = "Itrules JSON Generation";
	private VirtualFile rulesFile;
	private Project project;
	private final File destiny;

	public RunJsonGeneration(VirtualFile rulesFile, Project project, String title, File destiny) {
		super(project, title, true);
		this.rulesFile = rulesFile;
		this.project = project;
		this.destiny = destiny;
	}

	public void run(@NotNull ProgressIndicator indicator) {
		indicator.setIndeterminate(true);
		if (this.rulesFile == null) return;
		LOG.info("itrules(\"" + this.rulesFile.getPath() + "\")");
		run();
	}

	private void run() {
		try {
			toJson(rules());
		} catch (Throwable e) {
			e.printStackTrace();
			Notifications.Bus.notify(new Notification(groupDisplayId, "can't generate type for " + this.rulesFile.getName(), e.toString(), NotificationType.INFORMATION), this.project);
		}
	}

	@NotNull
	private RuleSet rules() throws IOException {
		return new ItrRuleSetReader(this.rulesFile.getInputStream()).read(rulesFile.getCharset());
	}

	private void toJson(RuleSet rules) throws IOException {
		FileWriter writer = new FileWriter(this.destiny);
		writer.write(JsonRulesWriter.toJSON(rules));
		writer.close();
	}
}
