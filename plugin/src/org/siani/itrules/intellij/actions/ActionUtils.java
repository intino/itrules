package org.siani.itrules.intellij.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.intellij.facet.ItrulesFacet;
import org.siani.itrules.intellij.lang.file.ItrulesFileType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class ActionUtils {

	private ActionUtils() {
	}

	public static void selectedFilesAreItrules(AnActionEvent e) {
		List<VirtualFile> vfile = getItrulesFilesFromEvent(e);
		if (vfile.isEmpty()) disable(e);
		else enable(e);
	}

	@NotNull
	public static List<VirtualFile> getItrulesFilesFromEvent(AnActionEvent e) {
		VirtualFile[] files = LangDataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext());
		if ((files == null) || (files.length == 0)) return Collections.emptyList();
		final List<VirtualFile> virtualFiles = Arrays.asList(files);
		return virtualFiles.stream().filter(f -> f.getName().endsWith(ItrulesFileType.INSTANCE.getDefaultExtension())).collect(Collectors.toList());
	}

	public static void selectedFilesAreInItrulesModule(AnActionEvent e) {
		List<VirtualFile> files = getItrulesFilesFromEvent(e);
		if (files.isEmpty()) return;
		if (e.getProject() == null) disable(e);
		else {
			Module module = ProjectRootManager.getInstance(e.getProject()).getFileIndex().getModuleForFile(files.get(0));
			if (ItrulesFacet.of(module) == null) disable(e);
			else enable(e);
		}
	}

	private static void enable(AnActionEvent e) {
		e.getPresentation().setEnabled(true);
		e.getPresentation().setVisible(true);
	}

	private static void disable(AnActionEvent e) {
		e.getPresentation().setVisible(false);
		e.getPresentation().setEnabled(false);
	}

}
