package io.intino.itrules.plugin.actions;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import io.intino.itrules.plugin.file.ItrulesFileType;
import io.intino.itrules.plugin.lang.ItrulesIcons;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static com.intellij.notification.NotificationType.ERROR;

public class TemplateGeneration extends GenerationAction {
	private static final String[] ItRulesCoors = new String[]{"io.intino.itrules", "engine", "2.0.0"};
	private static final String JAVA = ".java";

	public void update(@NotNull AnActionEvent e) {
		ActionUtils.selectedFilesAre(e, ItrulesFileType.instance().getDefaultExtension());
		e.getPresentation().setIcon(ItrulesIcons.ICON_13);
	}

	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		if (projectExists(e, project)) return;
		List<VirtualFile> rulesFiles = itrFiles(e);
		rulesFiles.forEach(r -> {
			final TemplateGenerator generator = createTemplate(project, r);
			if (generator != null) notify(project, r);
		});
	}

	public TemplateGenerator createTemplate(Project project, VirtualFile rulesFile) {
		if (checkDocument(project, rulesFile)) return null;
		TemplateGenerator templateGenerator;
		File outputFile = outputFile(rulesFile);
		Module module = getModuleOf(project, rulesFile);
		try {
			templateGenerator = createTask(module, rulesFile, outputFile);
		} catch (Exception e1) {
			error(project, e1.getMessage());
			return null;
		}
		ProgressManager.getInstance().run(templateGenerator);
		refreshFiles(outputFile);
		return templateGenerator;
	}

	@Override
	public @NotNull ActionUpdateThread getActionUpdateThread() {
		return ActionUpdateThread.BGT;
	}

	@NotNull
	private TemplateGenerator createTask(Module module, VirtualFile rulesFile, File destination) {
		return new TemplateGenerator(rulesFile, module, "Generate Template", destination, getPackage(rulesFile, module));
	}

	private void error(Project project, String message) {
		Notifications.Bus.notify(new Notification("Itrules", "Error reading template", message, ERROR), project);
	}

	@NotNull
	private File outputFile(VirtualFile rulesFile) {
		return new File(rulesFile.getParent().getPath(), classSimpleName(rulesFile.getName()) + "Template" + JAVA);
	}

	private void notify(Project project, VirtualFile rulesFile) {
		Notifications.Bus.notify(
				new Notification("Itrules", "ItRules", outputFile(rulesFile).getName() + " generated", NotificationType.INFORMATION), project);
	}

	private String getPackage(VirtualFile file, Module module) {
		String path = file.getParent().getPath();
		final VirtualFile virtualFile = srcRoot(module, file);
		return virtualFile == null ? "" : format(path, virtualFile.getPath());
	}

	private VirtualFile srcRoot(Module module, VirtualFile file) {
		VirtualFile[] sourceRoots = ModuleRootManager.getInstance(module).getSourceRoots();
		return Arrays.stream(sourceRoots).filter(sourceRoot -> file.getPath().startsWith(sourceRoot.getPath())).findFirst().orElse(null);
	}

	private String format(String path, String modulePath) {
		String name = new File(path).toURI().getPath().replace(new File(modulePath).toURI().getPath(), "");
		if (name.endsWith("/")) name = name.substring(0, name.length() - 1);
		return name.replace("/", ".");
	}

	@NotNull
	private String classSimpleName(String rulesFile) {
		String name = rulesFile.substring(0, rulesFile.lastIndexOf("."));
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}