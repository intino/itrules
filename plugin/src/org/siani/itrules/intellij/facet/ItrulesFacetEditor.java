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
    private JComboBox<String> lineSeparatorBox;

    public ItrulesFacetEditor(ItrulesFacetConfiguration facetConfiguration) {
        myFacetConfiguration = facetConfiguration;
        localeComboBox.addItem("English");
        localeComboBox.addItem("Español");
        lineSeparatorBox.addItem("LF - Unix and OS X (\\n)");
        lineSeparatorBox.addItem("CRLF - Windows (\\r\\n)");
        localeComboBox.setSelectedItem(myFacetConfiguration.getLocale().equals(Locale.ENGLISH) ? "English" : "Español");
        lineSeparatorBox.setSelectedIndex(myFacetConfiguration.getLineSeparator().equals("LF") ? 0 : 1);
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
                !getLineSeparator().equals(myFacetConfiguration.getLineSeparator());
    }

    public void apply() {
        myFacetConfiguration.setLocale(localeComboBox.getSelectedItem().equals("English") ? Locale.ENGLISH : new Locale("es", "Spain", "es_ES"));
        myFacetConfiguration.setLineSeparator(getLineSeparator());
    }

    public void reset() {
        localeComboBox.setSelectedItem(myFacetConfiguration.getLocale());
    }

    public void disposeUIResources() {
    }

    private String getLineSeparator() {
        String encoding = (String) lineSeparatorBox.getSelectedItem();
        return encoding.substring(0, encoding.indexOf(" ")).trim();
    }

    @Override
    public String getHelpTopic() {
        return "itrules_facet";
    }

}
