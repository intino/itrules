package io.intino.itrules.engine;

import io.intino.itrules.Formatter;
import io.intino.itrules.engine.formatters.DateFormatter;
import io.intino.itrules.engine.formatters.NumberFormatter;
import io.intino.itrules.engine.formatters.PluralFormatter;
import io.intino.itrules.engine.formatters.StringFormatter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FormatterIndex {

    private Map<String, Formatter> map = new HashMap<>();

    public FormatterIndex(Locale locale) {
        map.putAll(StringFormatter.get());
        map.putAll(DateFormatter.get(locale));
        map.putAll(NumberFormatter.get(locale));
        map.put("plural", new PluralFormatter(locale));
    }

    public void add(String name, Formatter formatter) {
        map.put(name.toLowerCase(), formatter);
    }

    public Formatter get(String name) {
        return !name.isEmpty() ? formatter(name) : nullFormatter();
    }

    public boolean exists(String name) {
        return map.containsKey(name.trim().toLowerCase());
    }

    private Formatter formatter(String name) {
        return exists(name) ? map.get(name.toLowerCase()) : unknownFormatter();
    }

    private Formatter unknownFormatter() {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return value;
            }
        };
    }

    private Formatter nullFormatter() {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return value;
            }
        };
    }

}
