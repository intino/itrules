package siani.itrules.intellij.actions;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.LangDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

public final class ActionUtils {

	private ActionUtils() {
	}

	public static void selectedFileIsItrules(AnActionEvent e) {
		VirtualFile vfile = getItrulesFileFromEvent(e);
		if (vfile == null) {
			e.getPresentation().setEnabled(false);
			return;
		}
		e.getPresentation().setEnabled(true);
		e.getPresentation().setVisible(true);
	}

	public static VirtualFile getItrulesFileFromEvent(AnActionEvent e) {
		VirtualFile[] files = LangDataKeys.VIRTUAL_FILE_ARRAY.getData(e.getDataContext());
		if ((files == null) || (files.length == 0)) return null;
		VirtualFile vfile = files[0];
		if ((vfile != null) && (vfile.getName().endsWith(siani.itrules.intellij.lang.file.ItrulesFileType.INSTANCE.getDefaultExtension()))) {
			return vfile;
		}
		return null;
	}

}
