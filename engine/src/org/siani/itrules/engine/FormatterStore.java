package org.siani.itrules.engine;

import org.siani.itrules.Formatter;
import org.siani.itrules.engine.formatters.FormatterRepository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FormatterStore {

    private Map<String, Formatter> map = new HashMap<>();

    public FormatterStore(Locale locale) {
        map.putAll(FormatterRepository.formatters(locale));
    }

    public void add(String name, Formatter formatter) {
        map.put(name.toLowerCase(), formatter);
    }

    public Formatter get(String name) {
        return !name.isEmpty() ? formatter(name) : nullFormatter();
    }

    private Formatter formatter(String name) {
        return exists(name) ? map.get(name.toLowerCase()) : unkownFormatter(name);
    }

    private boolean exists(String name) {
        return map.containsKey(name.trim().toLowerCase());
    }

    private Formatter unkownFormatter(final String name) {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return name + " formatter not found";
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
