package org.siani.itrules;

import java.util.*;

public class Frame implements AbstractFrame {

	private final List<String> types;
	private final Map<String, List<AbstractFrame>> properties;

	public Frame(String... types) {
		this.properties = new LinkedHashMap<>();
		this.types = new ArrayList<>();
		for (String type : types)
			this.types.add(type.toLowerCase());
	}

	@Override
	public boolean is(String type) {
		return this.types.contains(type.toLowerCase());
	}

	@Override
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public Iterator<AbstractFrame> property(String property) {
		return (properties.get(property) != null) ? properties.get(property).iterator() : null;
	}

	public void property(String property, Object value) {
		if (!properties.containsKey(property))
			properties.put(property, new ArrayList<AbstractFrame>());
		properties.get(property).add((value instanceof AbstractFrame) ? (AbstractFrame) value : new PrimitiveFrame(value));
	}

	@Override
	public Object value() {
		return null;
	}
}
