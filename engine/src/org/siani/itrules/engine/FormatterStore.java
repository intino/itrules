package org.siani.itrules.engine;

import org.siani.itrules.Formatter;
import org.siani.itrules.engine.formatters.DateFormatter;
import org.siani.itrules.engine.formatters.NumberFormatter;
import org.siani.itrules.engine.formatters.PluralFormatter;
import org.siani.itrules.engine.formatters.StringFormatter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FormatterStore {

    private Map<String, Formatter> map = new HashMap<>();

    public FormatterStore(Locale locale) {
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
