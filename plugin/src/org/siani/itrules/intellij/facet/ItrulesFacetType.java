package org.siani.itrules.intellij.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.openapi.module.JavaModuleType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.siani.itrules.intellij.lang.ItrulesIcons;

import javax.swing.*;

public class ItrulesFacetType extends FacetType<ItrulesFacet, ItrulesFacetConfiguration> {

	public static final String STRING_ID = "ItRules";

	public ItrulesFacetType() {
		super(ItrulesFacet.ID, STRING_ID, "ItRules");
	}

	public ItrulesFacetConfiguration createDefaultConfiguration() {
		return new ItrulesFacetConfiguration();
	}

	public ItrulesFacet createFacet(@NotNull Module module,
	                                String name,
	                                @NotNull ItrulesFacetConfiguration configuration,
	                                @Nullable Facet underlyingFacet) {
		return new ItrulesFacet(this, module, name, configuration);
	}

	public boolean isSuitableModuleType(ModuleType moduleType) {
		return moduleType instanceof JavaModuleType;
	}

	@NotNull
	@Override
	public String getDefaultFacetName() {
		return "ItRules";
	}

	@Override
	public Icon getIcon() {
		return ItrulesIcons.ICON_13;
	}
}
