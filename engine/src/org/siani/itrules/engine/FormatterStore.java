package org.siani.itrules.engine;

import org.siani.itrules.Formatter;
import org.siani.itrules.formatter.SystemFormatterRepository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FormatterStore {

    private Map<String, Formatter> map = new HashMap<>();

    public FormatterStore(Locale locale) {
        map.putAll(SystemFormatterRepository.formatters(locale));
    }

    public void add(String name, Formatter formatter) {
        map.put(name.toLowerCase(), formatter);
    }

    public Formatter get(String name) {
        return map.get(name.toLowerCase());
    }
}
