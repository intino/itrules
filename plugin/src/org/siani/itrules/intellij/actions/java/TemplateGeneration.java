package org.siani.itrules.intellij.actions.java;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableRootModel;
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
import java.util.List;

import static java.io.File.separator;

public class TemplateGeneration extends GenerationAction {

	public static final String TEMPLATES = "templates";
	private static final String JAVA = ".java";
	private static final String GEN = "gen";

	public void actionPerformed(@NotNull AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		if (projectExists(e, project)) return;
		List<VirtualFile> rulesFiles = getVirtualFile(e);
		if (rulesFiles.isEmpty()) return;
		for (VirtualFile rulesFile : rulesFiles) {
			if (checkDocument(project, rulesFile)) return;
			RunTemplateGeneration javaGeneration;
			File destiny;
			try {
				destiny = getDestinyFile(project, rulesFile);
				javaGeneration = createTask(getModuleOf(project, rulesFile), rulesFile, "Generate Template", destiny);
			} catch (Exception e1) {
				error(project, e1.getMessage());
				return;
			}
			ProgressManager.getInstance().run(javaGeneration);
			if (!javaGeneration.getIndicator().isCanceled()) refreshAndNotify(project, rulesFile, destiny);
			else error(project, javaGeneration.getIndicator().getText());
		}
	}

	@NotNull
	private RunTemplateGeneration createTask(Module module, VirtualFile rulesFile, String title, File destiny) throws Exception {
		return new RunTemplateGeneration(rulesFile, module, title, destiny, getPackage(rulesFile, module));
	}

	private void error(Project project, String message) {
		Notifications.Bus.notify(
			new Notification("Itrules Template Generation", "Error occurred during template generation", message, NotificationType.ERROR), project);
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

		VirtualFile gen = find(module, GEN);
		if (gen == null) gen = createGen(module);
		return gen.getPath() + separator + getPackage(file, module).replace(".", separator);
	}

	private VirtualFile find(Module module, String sourcePath) {
		VirtualFile[] sourceRoots = ModuleRootManager.getInstance(module).getSourceRoots();
		for (VirtualFile sourceRoot : sourceRoots) if (sourceRoot.getName().equals(sourcePath)) return sourceRoot;
		return null;
	}

	private String getPackage(VirtualFile file, Module module) throws Exception {
		String path = file.getParent().getPath();
		final VirtualFile virtualFile = find(module, TEMPLATES);
		if (virtualFile == null) throw new Exception("templates directory not found");
		String formattedPackage = format(path, virtualFile.getPath());
		return formattedPackage.isEmpty() ? "itrules" : formattedPackage;
	}

	private String format(String path, String modulePath) {
		String name = new File(path).toURI().getPath().replace(new File(modulePath).toURI().getPath(), "");
		if (name.endsWith("/")) name = name.substring(0, name.length() - 1);
		return name.replace("/", ".");
	}

	private VirtualFile createGen(final Module module) {
		final SourceFolder[] sourceFolder = {null};
		ApplicationManager.getApplication().runWriteAction(() -> {
			ModifiableRootModel modifiableModel = ModuleRootManager.getInstance(module).getModifiableModel();
			ContentEntry[] contentEntries = modifiableModel.getContentEntries();
			File moduleDirectory = new File(module.getModuleFilePath()).getParentFile();
			String gen = moduleDirectory.getPath() + separator + GEN;
			new File(gen).mkdirs();
			final VirtualFile sourceRoot = LocalFileSystem.getInstance().refreshAndFindFileByPath(FileUtil.toSystemIndependentName(gen));
			if (sourceRoot != null) {
				JavaSourceRootProperties properties = JpsJavaExtensionService.getInstance().createSourceRootProperties("", true);
				sourceFolder[0] = contentEntries[0].addSourceFolder(sourceRoot, JavaSourceRootType.SOURCE, properties);
			}
			modifiableModel.commit();
		});

		return sourceFolder[0].getFile();
	}

	@NotNull
	private String classSimpleName(String rulesFile) {
		String name = rulesFile.substring(0, rulesFile.lastIndexOf("."));
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}