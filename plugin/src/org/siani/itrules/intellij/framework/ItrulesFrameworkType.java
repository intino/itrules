package org.siani.itrules.intellij.framework;

import com.intellij.framework.FrameworkTypeEx;
import com.intellij.framework.addSupport.FrameworkSupportInModuleProvider;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.intellij.lang.ItrulesIcons;

import javax.swing.*;

public class ItrulesFrameworkType extends FrameworkTypeEx {
	public static final String ID = "itrules-java";

	public ItrulesFrameworkType() {
		super(ID);
	}

	static ItrulesFrameworkType getFrameworkType() {
		return EP_NAME.findExtension(ItrulesFrameworkType.class);
	}

	@NotNull
	@Override
	public FrameworkSupportInModuleProvider createProvider() {
		return new ItrulesSupportProvider();
	}

	@NotNull
	@Override
	public String getPresentableName() {
		return "ItRules";
	}

	@NotNull
	@Override
	public Icon getIcon() {
		return ItrulesIcons.ICON_13;
	}
}
