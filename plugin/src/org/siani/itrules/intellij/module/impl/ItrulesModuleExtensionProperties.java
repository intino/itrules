package org.siani.itrules.intellij.module.impl;

import com.intellij.util.xmlb.annotations.Tag;

public class ItrulesModuleExtensionProperties {

	@Tag("locale")
	public String locale = "en";

	@Tag("encoding")
	public String encoding= "UTF-8";
}