package org.siani.itrules.intellij.actions.java;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.roots.SourceFolder;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jps.model.java.JavaSourceRootProperties;
import org.jetbrains.jps.model.java.JavaSourceRootType;
import org.jetbrains.jps.model.java.JpsJavaExtensionService;
import org.siani.itrules.intellij.actions.GenerationAction;

import java.io.File;

import static java.io.File.separator;

public class TemplateGeneration extends GenerationAction {

	private static final String JAVA = ".java";

	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		if (projectExists(e, project)) return;
		VirtualFile rulesFile = getVirtualFile(e);
		if (rulesFile == null) return;
		String title = "Generate Template";
		if (checkDocument(project, rulesFile)) return;
		RunTemplateGeneration gen = null;
		try {
			File destiny = getDestinyFile(project, rulesFile);
			gen = new RunTemplateGeneration(rulesFile, project, title, destiny, getPackage(rulesFile, new File(getModuleOf(project, rulesFile).getModuleFilePath()).getParentFile()));
			ProgressManager.getInstance().run(gen);
			refreshAndNotify(project, rulesFile, destiny);
		} catch (Exception exception) {
			Notifications.Bus.notify(
				new Notification("Itrules Template Generation", "Error occurred during template generation", exception.getMessage(), NotificationType.ERROR), project);
		}

	}

	@NotNull
	private File getDestinyFile(Project project, VirtualFile rulesFile) throws Exception {
		File file = new File(findDestiny(project, getModuleOf(project, rulesFile), rulesFile), classSimpleName(rulesFile.getName()) + "Template" + JAVA);
		file.getParentFile().mkdirs();
		return file;
	}

	private void refreshAndNotify(Project project, VirtualFile rulesFile, File destiny) {
		refreshFiles(destiny);
		notify(project, rulesFile, destiny);
	}

	private void notify(Project project, VirtualFile rulesFile, File destiny) {
		Notifications.Bus.notify(
			new Notification("Itrules Template Generation", "Template for " + rulesFile.getName() + " generated", "to " + destiny.getPath(), NotificationType.INFORMATION), project);
	}

	protected String findDestiny(Project project, Module module, VirtualFile file) throws Exception {
		if (module == null) return project.getBasePath();
		File moduleDir = new File(module.getModuleFilePath()).getParentFile();
		String filePackage = getPackage(file, moduleDir);
		SourceFolder gen = createGen(module);
		return gen.getFile().getPath() + separator + filePackage;
	}

	private String getPackage(VirtualFile file, File moduleDir) throws Exception {
		String path = file.getParent().getPath();
		if (!new File(moduleDir.getPath(), "templates").exists()) throw new Exception("templates directory not found");
		String modulePath = new File(moduleDir.getPath(), "templates").getPath();
		return new File(path).toURI().getPath().replace(new File(modulePath).toURI().getPath(), "").replace(separator, ".");
	}

	private SourceFolder createGen(Module module) {
		ContentEntry[] contentEntries = ModuleRootManager.getInstance(module).getModifiableModel().getContentEntries();
		File moduleDirectory = new File(module.getModuleFilePath()).getParentFile();
		String gen = moduleDirectory.getPath() + separator + "gen";
		new File(gen).mkdirs();
		final VirtualFile sourceRoot = LocalFileSystem.getInstance().refreshAndFindFileByPath(FileUtil.toSystemIndependentName(gen));
		if (sourceRoot != null) {
			JavaSourceRootProperties properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
			return contentEntries[0].addSourceFolder(sourceRoot, JavaSourceRootType.SOURCE, properties);
		}
		return null;
	}

	@NotNull
	private String classSimpleName(String rulesFile) {
		String name = rulesFile.substring(0, rulesFile.lastIndexOf("."));
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}