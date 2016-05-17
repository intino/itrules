package org.siani.itrules.intellij.project;

import com.intellij.util.xmlb.annotations.Tag;

public class ItrulesModuleExtensionProperties {

    @Tag("locale")
    public String locale = "en";

    @Tag("encoding")
    public String lineSeparator = "UTF-8";
}