package org.siani.itrules.intellij.facet;

import com.intellij.facet.ui.FacetEditorTab;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Locale;

public class ItrulesFacetEditor extends FacetEditorTab {

	private final ItrulesFacetConfiguration myFacetConfiguration;
	private JComboBox<String> localeComboBox;
	private JPanel myMainPanel;
	private JComboBox<String> encodingBox;

	public ItrulesFacetEditor(ItrulesFacetConfiguration facetConfiguration) {
		myFacetConfiguration = facetConfiguration;
		localeComboBox.addItem("English");
		localeComboBox.addItem("Español");
		encodingBox.addItem("UTF-8");
		encodingBox.addItem("UTF-16");
		encodingBox.addItem("ISO-8859-1");
		localeComboBox.setSelectedItem(myFacetConfiguration.getLocale().equals(Locale.ENGLISH) ? "English" : "Español");
		encodingBox.setSelectedItem(myFacetConfiguration.getEncoding());
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
		return !localeComboBox.getSelectedItem().equals(myFacetConfiguration.getLocale().equals(Locale.ENGLISH) ? "English" : "Español") ||
			!encodingBox.getSelectedItem().equals(myFacetConfiguration.getEncoding());
	}


	public void apply() {
		myFacetConfiguration.setLocale(localeComboBox.getSelectedItem().equals("English") ? Locale.ENGLISH : new Locale("Spanish", "Spain", "es_ES"));
		myFacetConfiguration.setEncoding((String) encodingBox.getSelectedItem());
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
