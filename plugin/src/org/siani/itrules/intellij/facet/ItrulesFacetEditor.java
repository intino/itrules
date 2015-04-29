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
		encodingBox.addItem("LF - Unix and OS X (\\n)");
		encodingBox.addItem("CRLF - Windows (\\r\\n)");
		localeComboBox.setSelectedItem(myFacetConfiguration.getLocale().equals(Locale.ENGLISH) ? "English" : "Español");
		encodingBox.setSelectedIndex(myFacetConfiguration.getEncoding().equals("LF") ? 0 : 1);
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
			!getEncoding().equals(myFacetConfiguration.getEncoding());
	}

	public void apply() {
		myFacetConfiguration.setLocale(localeComboBox.getSelectedItem().equals("English") ? Locale.ENGLISH : new Locale("Spanish", "Spain", "es_ES"));
		myFacetConfiguration.setEncoding(getEncoding());
	}

	public void reset() {
		localeComboBox.setSelectedItem(myFacetConfiguration.getLocale());
	}

	public void disposeUIResources() {
	}

	private String getEncoding() {
		String encoding = (String) encodingBox.getSelectedItem();
		return encoding.substring(0, encoding.indexOf(" ")).trim();
	}

	@Override
	public String getHelpTopic() {
		return "itrules_facet";
	}

}
