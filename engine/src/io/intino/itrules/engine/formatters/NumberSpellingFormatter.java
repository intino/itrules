package io.intino.itrules.engine.formatters;

import io.intino.itrules.Formatter;
import io.intino.itrules.engine.formatters.spelling.EnglishSpelling;
import io.intino.itrules.engine.formatters.spelling.SpanishSpelling;
import io.intino.itrules.engine.formatters.spelling.WordSpelling;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NumberSpellingFormatter implements Formatter {
    private static Map<String, WordSpelling> readers = new HashMap<>();

    static {
        readers.put("en", new EnglishSpelling());
        readers.put("es", new SpanishSpelling());
    }

    private Locale locale;

    public NumberSpellingFormatter(Locale locale) {
        this.locale = locale;
    }

    private static boolean isNumber(Object value) {
        return Number.class.isAssignableFrom(value.getClass());
    }

    @Override
    public Object format(Object value) {
        return isNumber(value) ? getReader().spell((int) value) : value;
    }

    public WordSpelling getReader() {
        return getReader(locale.getLanguage());
    }

    private WordSpelling getReader(String key) {
        return readers.containsKey(key) ? readers.get(key) : readers.get("en");
    }
}
