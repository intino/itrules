package org.siani.itrules.engine.formatters;

import org.siani.itrules.Formatter;
import org.siani.itrules.engine.formatters.inflectors.EnglishPluralInflector;
import org.siani.itrules.engine.formatters.inflectors.PluralInflector;
import org.siani.itrules.engine.formatters.inflectors.SpanishPluralInflector;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PluralFormatter implements Formatter {

    private static Map<String, PluralInflector> inflectors = new HashMap<>();

    static {
        inflectors.put("en", new EnglishPluralInflector());
        inflectors.put("es", new SpanishPluralInflector());
    }

    private Locale locale;

    public PluralFormatter(Locale locale) {
        this.locale = locale;
    }

    @Override
    public Object format(Object value) {
        return getInflector().plural(value.toString());
    }

    public PluralInflector getInflector() {
        return getInflector(locale.getLanguage());
    }

    private PluralInflector getInflector(String key) {
        return inflectors.containsKey(key) ? inflectors.get(key) : inflectors.get("en");
    }


}
