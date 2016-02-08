package org.siani.itrules.intellij.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.ProjectRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import org.siani.itrules.intellij.facet.ItrulesFacet;
import org.siani.itrules.intellij.lang.file.ItrulesFileType;

public final class ActionUtils {

    private ActionUtils() {
    }

    public static void selectedFileIsItrules(AnActionEvent e) {
        VirtualFile vfile = getItrulesFileFromEvent(e);
        if (vfile == null) disable(e);
        else enable(e);
    }

    public static VirtualFile getItrulesFileFromEvent(AnActionEvent e) {
        VirtualFile[] files = LangDataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext());
        if ((files == null) || (files.length == 0)) return null;
        VirtualFile file = files[0];
        if ((file != null) && (file.getName().endsWith(ItrulesFileType.INSTANCE.getDefaultExtension()))) {
            return file;
        }
        return null;
    }

    public static void selectedFilesIsInItrulesModule(AnActionEvent e) {
        VirtualFile file = getItrulesFileFromEvent(e);
        if (file == null) return;
        if (e.getProject() == null) disable(e);
        else {
            Module module = ProjectRootManager.getInstance(e.getProject()).getFileIndex().getModuleForFile(file);
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
