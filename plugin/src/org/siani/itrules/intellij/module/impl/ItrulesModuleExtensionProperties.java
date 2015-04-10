package org.siani.itrules.intellij.module.impl;

import com.intellij.util.xmlb.annotations.Tag;

public class ItrulesModuleExtensionProperties {

	@Tag("sdk-home-path")
	public String mySdkHomePath = "";

	@Tag("locale")
	public String locale = "en";
}