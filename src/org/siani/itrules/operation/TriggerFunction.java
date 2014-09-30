package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

final class TriggerFunction implements Function {
	private final String parameter;

	public TriggerFunction(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public boolean match(Trigger trigger) {
		if (parameter.equalsIgnoreCase(trigger.mark().getName())) return true;
		for (String s : trigger.mark().getOptions())
			if (parameter.equalsIgnoreCase(s)) return true;
		return false;
	}
}
