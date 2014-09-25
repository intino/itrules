package org.siani.itrules.operation;

import org.siani.itrules.Operator;
import org.siani.itrules.Trigger;

public class AttributeOperator implements Operator {
	private final String parameter;

	public AttributeOperator(String parameter) {
		this.parameter = parameter;
	}

	@Override
	public boolean match(Trigger trigger) {
		return trigger.frame().attributes(parameter).length > 0;
	}
}
