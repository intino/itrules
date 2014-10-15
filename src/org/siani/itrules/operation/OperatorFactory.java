package org.siani.itrules.operation;

import org.siani.itrules.Function;
import org.siani.itrules.lang.model.Condition;

public final class OperatorFactory {

	public static Function get(Condition condition) {
		String[] parameters = condition.getParameters();
		if (condition.name().equals(Function.TYPE)) return new TypeFunction(parameters);
		else if (condition.name().equals(Function.TRIGGER)) return new TriggerFunction(parameters);
		else if (condition.name().equals(Function.SLOT_NAME)) return new SlotNameFunction(parameters);
		else if (condition.name().equals(Function.SLOT_TYPE)) return new SlotTypeFunction(parameters);
		else return new EvalFunction(parameters[0], parameters[1], parameters[2]);
	}
}
