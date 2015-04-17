package org.siani.itrules.intellij.actions.java;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.parser.ITRulesSyntaxError;
import org.siani.itrules.readers.ItrRuleSetReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class RunTemplateGeneration extends Task.Modal {

	public static final Logger LOG = Logger.getInstance("RunItrulesOnRulesFile");

	private VirtualFile rulesFile;
	private final File destiny;
	private final String aPackage;
	private ProgressIndicator indicator;

	public RunTemplateGeneration(VirtualFile rulesFile, Project project, String title, File destiny, String aPackage) {
		super(project, title, true);
		this.rulesFile = rulesFile;
		this.destiny = destiny;
		this.aPackage = aPackage;
	}

	public void run(@NotNull ProgressIndicator indicator) {
		this.indicator = indicator;
		this.indicator.setIndeterminate(true);
		if (this.rulesFile == null) return;
		LOG.info("itrules(\"" + this.rulesFile.getPath() + "\")");
		task();
	}

	private void task() {
		try {
			toJava(rules());
		} catch (Throwable e) {
			indicator.setText(e.getMessage());
			indicator.cancel();
		}
	}

	@NotNull
	private RuleSet rules() throws IOException, ITRulesSyntaxError {
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

	public ProgressIndicator getIndicator() {
		return indicator;
	}
}

