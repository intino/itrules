package org.siani.itrules.framebuilder.object2frame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleObjectWithMap {

    private final Map<Object, Object> map = new HashMap<>();

    public SimpleObjectWithMap(List<Object> keys, List<Object> values) {
        for (int i = 0; i < keys.size(); i++)
            map.put(keys.get(i), values.get(i));
    }
}
