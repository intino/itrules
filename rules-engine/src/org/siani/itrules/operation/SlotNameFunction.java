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
		return trigger.frame().isPrimitive() ?
			parameters[NAME].equalsIgnoreCase("value") :
			trigger.frame().searchByName(parameters[NAME], parameters.length != 1) != null;
	}
}
