package org.siani.itrules.intellij.actions.java;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.readers.ItrRuleSetReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class RunTemplateGeneration extends Task.Modal {

	public static final Logger LOG = Logger.getInstance("RunItrulesOnRulesFile");

	private static final String groupDisplayId = "Itrules Template Generation";
	private VirtualFile rulesFile;
	private Project project;
	private final File destiny;
	private final String aPackage;

	public RunTemplateGeneration(VirtualFile rulesFile, Project project, String title, File destiny, String aPackage) {
		super(project, title, true);
		this.rulesFile = rulesFile;
		this.project = project;
		this.destiny = destiny;
		this.aPackage = aPackage;
	}

	public void run(@NotNull ProgressIndicator indicator) {
		indicator.setIndeterminate(true);
		if (this.rulesFile == null) return;
		LOG.info("itrules(\"" + this.rulesFile.getPath() + "\")");
		run();
	}

	private void run() {
		try {
			toJava(rules());
		} catch (Throwable e) {
			e.printStackTrace();
			Notifications.Bus.notify(new Notification(groupDisplayId, "can't generate type for " + simpleFileName(), e.toString(), NotificationType.INFORMATION), this.project);
		}
	}

	@NotNull
	private RuleSet rules() throws IOException {
		return new ItrRuleSetReader(this.rulesFile.getInputStream()).read(rulesFile.getCharset());
	}

	private void toJava(RuleSet rules) throws IOException, URISyntaxException {
		FileWriter writer = new FileWriter(this.destiny, false);
		String content = new TemplateRulesWriter(simpleFileName(), aPackage).toJava(rules);
		writer.write(content);
		writer.close();
	}

	@NotNull
	private String simpleFileName() {
		return rulesFile.getName().substring(0, rulesFile.getName().lastIndexOf("."));
	}

}

