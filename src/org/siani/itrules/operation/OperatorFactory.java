package org.siani.itrules.operation;

import org.siani.itrules.ITRulesException;
import org.siani.itrules.Operator;
import org.siani.itrules.lang.model.Function;

public final class OperatorFactory {

	private static final String TYPE_OP = "type";
	private static final String TRIGGER_OP = "trigger";
	private static final String ATTRIBUTE_OP = "attr";

	public static Operator get(Function function) throws ITRulesException {
		if (function.name().equals(TYPE_OP)) return new TypeOperator(function.getParameter());
		if (function.name().equals(TRIGGER_OP)) return new TriggerOperator(function.getParameter());
		if (function.name().equals(ATTRIBUTE_OP)) return new AttributeOperator(function.getParameter());
		throw new ITRulesException("No operation found");
	}
}
