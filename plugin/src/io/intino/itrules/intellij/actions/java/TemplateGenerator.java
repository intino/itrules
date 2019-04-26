package io.intino.itrules.intellij.actions.java;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.encoding.EncodingManager;
import io.intino.itrules.RuleSet;
import io.intino.itrules.intellij.facet.ItrulesFacet;
import io.intino.itrules.parser.ITRulesSyntaxError;
import io.intino.itrules.parser.ParsedTemplate;
import io.intino.itrules.readers.ItrRuleSetReader;
import org.apache.velocity.runtime.directive.Parse;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Locale;

public class TemplateGenerator extends Task.Modal {

	public static final Logger LOG = Logger.getInstance("RunItrulesOnRulesFile");
	private final Module module;
	private final File destiny;
	private final String aPackage;
	private VirtualFile rulesFile;
	private ProgressIndicator indicator;

	public TemplateGenerator(VirtualFile rulesFile, Module module, String title, File destiny, String aPackage) {
		super(module.getProject(), title, true);
		this.rulesFile = rulesFile;
		this.module = module;
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
			addFileToEncodings();
		} catch (Throwable e) {
			error(this.module.getProject(), e.getMessage());
			indicator.setText(e.getMessage());
			indicator.cancel();

		}
	}

	@NotNull
	private ParsedTemplate rules() throws IOException, ITRulesSyntaxError {
		return new ItrRuleSetReader(this.rulesFile.getInputStream()).read(rulesFile.getCharset());
	}

	private void toJava(ParsedTemplate template) throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(this.destiny), Charset.forName("UTF-8"));
		String content = new TemplateRulesWriter(simpleFileName(), aPackage, locale(), lineSeparator()).toJava(template);
		writer.write(content);
		writer.close();
	}

	private void addFileToEncodings() {
		final VirtualFile virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(destiny);
		new Runnable() {
			public void run() {
				EncodingManager.getInstance().setEncoding(virtualFile, Charset.forName("UTF-8"));
			}
		};

	}

	private String locale() {
		ItrulesFacet facet = ItrulesFacet.of(module);
		if (facet != null) {
			Locale locale = facet.getConfiguration().getLocale();
			if (locale.equals(Locale.ENGLISH)) return "Locale.ENGLISH";
			return "new Locale(\"es\", \"Spain\", \"es_ES\")";
		}
		return "";
	}

	private String lineSeparator() {
		ItrulesFacet facet = ItrulesFacet.of(module);
		if (facet != null) return facet.getConfiguration().getLineSeparator();
		return "";
	}

	@NotNull
	private String simpleFileName() {
		return rulesFile.getName().substring(0, rulesFile.getName().lastIndexOf("."));
	}

	public ProgressIndicator getIndicator() {
		return indicator;
	}

	private void error(Project project, String message) {
		Notifications.Bus.notify(new Notification("Itrules", "Error generating template", message, NotificationType.ERROR), project);
	}
}

