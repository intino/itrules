package org.siani.itrules.formatter.inflectors;

import org.siani.itrules.formatter.Inflector;

public class EnglishInflector extends Inflector {

    @Override
    public String plural(String word) {
        if (isIrregular(word)) return irregularPlural(word);
        return doReplaces(word + "s");
    }

    @Override
    protected void setReplaces() {
        addReplace("sss", "sses");
        addReplace("ss", "ses");
        addReplace("shs", "shes");
        addReplace("chs", "ches");
        addReplace("xs", "xes");
        addReplace("zzs", "zzes");
        addReplace("zs", "zzes");
        addReplace("fes", "ves");
        addReplace("fs", "ves");
        addReplace("siss", "ses");
        setConsonantYReplaces();
    }

    private void setConsonantYReplaces() {
        for (char consonant : consonants())
            addReplace(consonant + "ys", consonant + "ies");
    }

    @Override
    protected void setIrregulars() {
        addIrregular("man", "men");
        addIrregular("woman", "women");
        addIrregular("child", "children");
        addIrregular("foot", "feet");
        addIrregular("tooth", "teeth");
        addIrregular("goose", "geese");
        addIrregular("mouse", "mice");
        addIrregular("sheep", "sheep");
        addIrregular("deer", "deer");
        addIrregular("moose", "moose");
        addIrregular("aircraft", "aircraft");
        addIrregular("potato", "potatoes");
        addIrregular("tomato", "tomatoes");
        addIrregular("echo", "echoes");
        addIrregular("hero", "heroes");
        addIrregular("torpedo", "torpedoes");
        addIrregular("buffalo", "buffaloes");
    }

}
