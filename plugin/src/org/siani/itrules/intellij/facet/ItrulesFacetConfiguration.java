package org.siani.itrules.intellij.facet;

import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.siani.itrules.intellij.module.impl.ItrulesModuleExtensionProperties;

import java.util.Locale;

public class ItrulesFacetConfiguration implements FacetConfiguration, PersistentStateComponent<ItrulesModuleExtensionProperties> {

	private ItrulesModuleExtensionProperties myProperties = new ItrulesModuleExtensionProperties();

	public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
		return new FacetEditorTab[]{
			new ItrulesFacetEditor(this)
		};
	}

	public void readExternal(Element element) throws InvalidDataException {
	}

	public void writeExternal(Element element) throws WriteExternalException {
	}

	public ItrulesModuleExtensionProperties getState() {
		return myProperties;
	}

	public void loadState(ItrulesModuleExtensionProperties state) {
		myProperties = state;
	}

	public String getSdkHomePath() {
		return myProperties.mySdkHomePath;
	}

	public Locale getLocale() {
		return myProperties.locale.equals("en") ? Locale.ENGLISH : new Locale("Spanish", "Spain", "es_ES");
	}

	public void setSdkHomePath(String sdkHomePath) {
		myProperties.mySdkHomePath = sdkHomePath;
	}

	public void setLocale(Locale locale) {
		myProperties.locale = locale.equals(Locale.ENGLISH) ? "en" : "es";
	}
}
