package siani.itrules.intellij.lang.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import siani.itrules.intellij.lang.ItrulesIcons;

import javax.swing.*;

public class ItrulesFileType extends LanguageFileType {
	public static final ItrulesFileType INSTANCE = new ItrulesFileType();

	private ItrulesFileType() {
		super(siani.itrules.intellij.lang.ItrulesLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName() {
		return "Itrules File";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "Itrules File";
	}

	@NotNull
	@Override
	public String getDefaultExtension() {
		return "itr";
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return ItrulesIcons.ICON_13;
	}
}
