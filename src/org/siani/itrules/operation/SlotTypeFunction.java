package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

final class SlotTypeFunction implements Function {
	private static final int TYPE = 0;
	private final String[] parameters;

	public SlotTypeFunction(String[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean match(Trigger trigger) {
		return !trigger.frame().isPrimitive() && trigger.frame().searchByType(parameters[TYPE], parameters.length != 1) != null;
	}
}