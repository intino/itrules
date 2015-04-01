package org.siani.itrules.engine.framebuilder;

import java.lang.reflect.Field;
import java.util.*;

public final class ExclusionList {

    private final Map<Class, List<String>> map = createMap();

    public void exclude(Class aClass, String... fields) {
        map.get(aClass).addAll(Arrays.asList(fields));
    }

    public boolean isExcluded(Class aClass, Field field) {
        return map.get(aClass).contains(field.getName());
    }

    private static HashMap<Class, List<String>> createMap() {
        return new HashMap<Class, List<String>>() {
            @Override
            public List<String> get(Object key) {
                if (!containsKey(key))
                    put((Class) key, new ArrayList<String>());
                return super.get(key);
            }
        };
    }
}
