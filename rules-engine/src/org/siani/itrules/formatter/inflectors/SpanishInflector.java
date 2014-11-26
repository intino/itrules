package org.siani.itrules.formatter.inflectors;

import org.siani.itrules.formatter.Inflector;

public class SpanishInflector extends Inflector {


    @Override
    public String plural(String word) {
        if (isIrregular(word)) return irregularPlural(word);
        return doReplaces(word + "es");
    }

    @Override
    protected void setReplaces() {
        addReplace("zes", "ces");
        addReplace("xes", "x");
        addReplace("ses", "s");
        addReplace("aes", "as");
        addReplace("ees", "es");
        addReplace("ies", "is");
        addReplace("oes", "os");
        addReplace("ues", "us");
    }

    @Override
    protected void setIrregulars() {

    }

}
