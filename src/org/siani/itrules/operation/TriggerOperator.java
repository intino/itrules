package org.siani.itrules.operation;

import org.siani.itrules.Operator;
import org.siani.itrules.Trigger;

public class TriggerOperator implements Operator {
	private final String parameter;

	public TriggerOperator(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public boolean match(Trigger trigger) {
		return trigger.mark().getName().equals(parameter);
	}
}
