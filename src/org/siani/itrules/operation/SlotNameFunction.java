package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

final class SlotNameFunction implements Function {

	private final String[] parameters;
	private static final int NAME = 0;

	public SlotNameFunction(String[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean match(Trigger trigger) {
		if (trigger.frame().isPrimitive())
			return parameters[NAME].equalsIgnoreCase("value");
		return trigger.frame().searchByType(parameters[NAME], parameters.length != 1) != null;
	}
}
