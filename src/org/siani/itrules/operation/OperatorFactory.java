package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.lang.model.Condition;

public final class OperatorFactory {

	public static Function get(Condition condition) {
		String parameter = condition.getParameter();
		if (condition.name().equals(Function.TYPE)) return new TypeFunction(parameter);
		if (condition.name().equals(Function.TRIGGER)) return new TriggerFunction(parameter);
		if (condition.name().equals(Function.ATTR)) return new AttributeFunction(parameter);
		if (condition.name().equals(Function.EVAL)) {
			String[] split = parameter.split("@");
			return new EvalFunction(split[0], split[1], split[2]);
		}
		return null;
	}
}
