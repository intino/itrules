package org.siani.itrules.framebuilder;

import java.lang.reflect.Field;
import java.util.*;

public final class AdapterList {

    private final Map<Class<?>, Adapter> map = new HashMap<>();

    protected void add(Class<?> aClass, Adapter adapter) {
        map.put(aClass, adapter);
    }

    protected Adapter get(Class<?> aClass) {
        return map.get(aClass);
    }

	public boolean contains(Class<?> aClass) {
		return map.containsKey(aClass);
	}
}
