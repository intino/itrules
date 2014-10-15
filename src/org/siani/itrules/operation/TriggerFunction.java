package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

final class TriggerFunction implements Function {
	private final String[] parameters;

	public TriggerFunction(String[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean match(Trigger trigger) {
		if (parameters[0].equalsIgnoreCase(trigger.mark().getName())) return true;
		for (String s : trigger.mark().getOptions())
			if (parameters[0].equalsIgnoreCase(s)) return true;
		return false;
	}
}
