package org.siani.itrules.intellij.facet;

import com.intellij.facet.ui.FacetEditorTab;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Locale;

public class ItrulesFacetEditor extends FacetEditorTab {

	private final ItrulesFacetConfiguration myFacetConfiguration;
	private JComboBox localeComboBox;
	private JPanel myMainPanel;

	public ItrulesFacetEditor(ItrulesFacetConfiguration facetConfiguration) {
		myFacetConfiguration = facetConfiguration;
		localeComboBox.addItem(Locale.ENGLISH);
		localeComboBox.addItem(new Locale("Spanish", "Spain", "es_ES"));
	}

	@Nls
	public String getDisplayName() {
		return "Itrules Engine";
	}

	@NotNull
	public JComponent createComponent() {
		return myMainPanel;
	}

	public boolean isModified() {
		return localeComboBox.getSelectedIndex() != 0;
	}


	public void apply() {
		myFacetConfiguration.setLocale((Locale) localeComboBox.getSelectedItem());
	}

	public void reset() {
		localeComboBox.setSelectedItem(myFacetConfiguration.getLocale());
	}

	public void disposeUIResources() {
	}



	@Override
	public String getHelpTopic() {
		return "itrules_facet";
	}

}
