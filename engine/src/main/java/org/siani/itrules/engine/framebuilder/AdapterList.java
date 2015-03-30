package org.siani.itrules.engine.framebuilder;

import java.util.*;

public final class AdapterList {

    private final Map<Class<?>, Adapter> map = new HashMap<>();

    public void add(Class<?> aClass, Adapter adapter) {
        map.put(aClass, adapter);
    }

    public Adapter get(Class<?> aClass) {
        return map.get(aClass);
    }

	public boolean contains(Class<?> aClass) {
		return map.containsKey(aClass);
	}
}
