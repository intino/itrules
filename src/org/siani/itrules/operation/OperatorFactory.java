package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.lang.model.Condition;

public final class OperatorFactory {

	public static Function get(Condition condition) {
		if (condition.name().equals(Function.TYPE)) return new TypeFunction(condition.getParameter());
		if (condition.name().equals(Function.TRIGGER)) return new TriggerFunction(condition.getParameter());
		if (condition.name().equals(Function.ATTR)) return new AttributeFunction(condition.getParameter());
		return null;
	}
}
