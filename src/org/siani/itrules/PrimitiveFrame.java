package org.siani.itrules;

import java.util.Iterator;

class PrimitiveFrame implements AbstractFrame {
	private static final String VALUE = "value";
	private final Object value;

	public PrimitiveFrame(Object value) {
		this.value = value;
	}

	@Override
	public boolean is(String type) {
		return type.equalsIgnoreCase(value.getClass().getSimpleName());
	}

	@Override
	public boolean isPrimitive() {
		return true;
	}

	@Override
	public Iterator<AbstractFrame> getSlots(String slot) {
		return null;
	}

	@Override
	public Object value() {
		return value;
	}

	@Override
	public AbstractFrame findSlot(String path) {
		return path.equalsIgnoreCase(VALUE) ? this : null;
	}

	@Override
	public AbstractFrame searchByType(String type, boolean deep) {
		return null;
	}

	@Override
	public AbstractFrame searchByName(String name, boolean deep) {
		return name.equalsIgnoreCase(VALUE) ? this : null;
	}
}
