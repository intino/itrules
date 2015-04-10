package org.siani.itrules.engine.formatters;

import org.siani.itrules.Formatter;
import org.siani.itrules.engine.formatters.inflectors.EnglishInflector;
import org.siani.itrules.engine.formatters.inflectors.SpanishInflector;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PluralFormatter implements Formatter {

    private static Map<String, Inflector> inflectors = new HashMap<>();
    private Locale locale;

    public PluralFormatter(Locale locale) {
        this.locale = locale;
    }

    static {
            inflectors.put("en", new EnglishInflector());
            inflectors.put("es", new SpanishInflector());
    }


    @Override
    public Object format(Object value) {
        return getInflector().plural(value.toString());
    }


    public Inflector getInflector() {
        return getInflector(locale.toString().split("_")[0]);
    }

    private Inflector getInflector(String key) {
        return inflectors.containsKey(key) ? inflectors.get(key) : inflectors.get("en");
    }


    public abstract static class Inflector {

        private Map<String, String> irregulars = new HashMap<>();
        private Map<String, String> replaces = new HashMap<>();

        public Inflector() {
            setIrregulars();
            setReplaces();
        }

        public abstract String plural(String word);

        protected abstract void setReplaces();
        protected abstract void setIrregulars();

        protected void addReplace(String from, String to) {
            replaces.put(from, to);
        }

        protected void addIrregular(String from, String to) {
            irregulars.put(from, to);
        }

        protected String doReplaces(String word) {
            for (String ending : replaces.keySet()) {
                if (!word.endsWith(ending)) continue;
                return replaceLast(word, ending);
            }
            return word;
        }

        protected char[] consonants() {
            return "bcdfghjklmnpqrstvwxyz".toCharArray();
        }

        protected boolean isIrregular(String word) {
            return irregulars.containsKey(word);
        }

        protected String irregularPlural(String word) {
            return irregulars.get(word);
        }

        private String replaceLast(String word, String ending) {
            return removeEnding(word, ending) + replaces.get(ending);
        }

        private String removeEnding(String word, String ending) {
            return word.substring(0, word.length() - ending.length());
        }


    }
}
