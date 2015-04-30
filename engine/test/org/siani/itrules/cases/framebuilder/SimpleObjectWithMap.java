package org.siani.itrules.cases.framebuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SimpleObjectWithMap {

    private final Map<Object, Object> map = new LinkedHashMap<>();

    public SimpleObjectWithMap(List<Object> keys, List<Object> values) {
        for (int i = 0; i < keys.size(); i++)
            map.put(keys.get(i), values.get(i));
    }
}
