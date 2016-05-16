package org.siani.itrules.intellij.actions;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManagerListener;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class ItrFileDocumentManagerListener implements FileDocumentManagerListener {
	@Override
	public void beforeAllDocumentsSaving() {

	}

	@Override
	public void beforeDocumentSaving(@NotNull Document document) {

	}

	@Override
	public void beforeFileContentReload(VirtualFile file, @NotNull Document document) {

	}

	@Override
	public void fileWithNoDocumentChanged(@NotNull VirtualFile file) {

	}

	@Override
	public void fileContentReloaded(@NotNull VirtualFile file, @NotNull Document document) {

	}

	@Override
	public void fileContentLoaded(@NotNull VirtualFile file, @NotNull Document document) {

	}

	@Override
	public void unsavedDocumentsDropped() {

	}
}
