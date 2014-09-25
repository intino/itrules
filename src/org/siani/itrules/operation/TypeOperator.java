package org.siani.itrules.operation;

import org.siani.itrules.Operator;
import org.siani.itrules.Trigger;

public class TypeOperator implements Operator {

	private final String type;

	public TypeOperator(String type) {
		this.type = type;
	}

	@Override
	public boolean match(Trigger trigger) {
		return trigger.frame().is(type);
	}
}
