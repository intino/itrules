package org.siani.itrules.engine.formatters;

import org.siani.itrules.Formatter;
import org.siani.itrules.engine.formatters.readers.EnglishReader;
import org.siani.itrules.engine.formatters.readers.SpanishReader;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LetterFormatter implements Formatter {
    private static Map<String, LetterReader> readers = new HashMap<>();
    private Locale locale;

    public LetterFormatter(Locale locale) {
        this.locale = locale;
    }

    static {
        readers.put("en", new EnglishReader());
        readers.put("es", new SpanishReader());
    }


    @Override
    public Object format(Object value) {
        return isNumber(value) ? getReader().read((int) value) : value;
    }

    private static boolean isNumber(Object value) {
        return Number.class.isAssignableFrom(value.getClass());
    }

    public LetterReader getReader() {
        return getReader(locale.getLanguage());
    }

    private LetterReader getReader(String key) {
        return readers.containsKey(key) ? readers.get(key) : readers.get("en");
    }
}
