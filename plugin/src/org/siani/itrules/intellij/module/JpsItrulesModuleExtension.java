package org.siani.itrules.intellij.module;

import org.jetbrains.jps.model.JpsElement;
import org.jetbrains.jps.model.module.JpsModule;

import java.util.Locale;

public interface JpsItrulesModuleExtension extends JpsElement {

	JpsModule getModule();

	String getSdkHomePath();

	Locale getLocale();
}
