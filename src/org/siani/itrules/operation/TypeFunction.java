package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

final class TypeFunction implements Function {

	private final String type;

	public TypeFunction(String type) {
		this.type = type;
	}

	@Override
	public boolean match(Trigger trigger) {
		return trigger.frame().is(type);
	}
}
