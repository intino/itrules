package io.intino.itrules.plugin.file;

import com.intellij.openapi.fileTypes.LanguageFileType;
import io.intino.itrules.plugin.lang.ItrulesIcons;
import io.intino.itrules.plugin.lang.ItrulesLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ItrulesFileType extends LanguageFileType {
	public static final ItrulesFileType INSTANCE = new ItrulesFileType();

	private ItrulesFileType() {
		super(ItrulesLanguage.INSTANCE);
	}

	public static ItrulesFileType instance() {
		return INSTANCE;
	}

	@NotNull
	@Override
	public String getName() {
		return "Itrules";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "Itrules file";
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
