package org.siani.itrules;

import java.util.Iterator;

class PrimitiveFrame implements AbstractFrame {
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
	public Iterator<AbstractFrame> property(String property) {
		return null;
	}

	@Override
	public Object value() {
		return value;
	}
}
