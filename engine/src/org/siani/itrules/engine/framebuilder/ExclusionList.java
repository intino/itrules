package org.siani.itrules.engine.framebuilder;

import java.lang.reflect.Field;
import java.util.*;

public final class ExclusionList {

    private final Map<String, List<String>> map = new HashMap<String, List<String>>() {
        @Override
        public List<String> get(Object key) {
            if (!containsKey(key))
                put((String) key, new ArrayList<String>());
            return super.get(key);
        }
    };

    public void exclude(String aClass, String... fields) {
        map.get(aClass).addAll(Arrays.asList(fields));
    }

    public boolean isExcluded(Class<? extends Object> aClass, Field field) {
        return map.get(aClass.getSimpleName()).contains(field.getName());
    }
}
