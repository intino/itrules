package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

final class AttributeFunction implements Function {
	private final String parameter;

	public AttributeFunction(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public boolean match(Trigger trigger) {
		if (trigger.frame().isPrimitive())
			return parameter.equalsIgnoreCase("value");
		return trigger.frame().property(parameter) != null;
	}
}
