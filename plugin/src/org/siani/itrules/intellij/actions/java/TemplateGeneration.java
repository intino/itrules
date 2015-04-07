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

public class TemplateGeneration extends GenerationAction {

	private static final String JAVA = ".java";

	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		if (projectExists(e, project)) return;
		VirtualFile rulesFile = getVirtualFile(e);
		if (rulesFile == null) return;
		String title = "Generate Template";
		if (checkDocument(project, rulesFile)) return;
		Module moduleOf = getModuleOf(project, rulesFile);
		File destiny = new File(findDestiny(project, moduleOf, rulesFile), rulesFile.getName() + JAVA);
		RunTemplateGeneration gen = new RunTemplateGeneration(rulesFile, project, title, destiny, getPackage(rulesFile, moduleOf.getModuleFile().getParent()));
		ProgressManager.getInstance().run(gen);
		refreshFiles(destiny);
		notify(project, rulesFile, destiny);
	}

	private void notify(Project project, VirtualFile rulesFile, File destiny) {
		Notifications.Bus.notify(
			new Notification("Itrules Template Generation", "Template for " + rulesFile.getName() + " generated", "to " + destiny.getPath(), NotificationType.INFORMATION), project);
	}

	protected String findDestiny(Project project, Module module, VirtualFile file) { //TODO PACKAGE
		if (module == null) return project.getBasePath();
		VirtualFile moduleDir = module.getModuleFile().getParent();
		String filePackage = getPackage(file, moduleDir);
		SourceFolder gen = createGen(module);
		return gen.getFile().getPath() + File.separator + filePackage;
	}

	private String getPackage(VirtualFile file, VirtualFile moduleDir) {
		return file.getParent().getPath().replace(moduleDir.getPath() + File.separator + "templates", "");
	}

	private SourceFolder createGen(Module module) {
		ContentEntry[] contentEntries = ModuleRootManager.getInstance(module).getModifiableModel().getContentEntries();
		VirtualFile moduleDirectory = module.getModuleFile().getParent();
		new File(moduleDirectory.getPath()).mkdirs();
		final VirtualFile sourceRoot = LocalFileSystem.getInstance().refreshAndFindFileByPath(FileUtil.toSystemIndependentName(module.getModuleFile().getParent().getPath()));
		if (sourceRoot != null) {
			JavaSourceRootProperties properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
			return contentEntries[0].addSourceFolder(sourceRoot, JavaSourceRootType.SOURCE, properties);
		}
		return null;
	}

}
