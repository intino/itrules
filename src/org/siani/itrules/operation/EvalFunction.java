package org.siani.itrules.operation;

import org.siani.itrules.AbstractFrame;
import org.siani.itrules.Function;
import org.siani.itrules.Trigger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

final class EvalFunction implements Function {
	private final String op1;
	private final String operator;
	private final String op2;

	public EvalFunction(String op1, String operator, String op2) {
		this.op1 = op1;
		this.operator = operator;
		this.op2 = op2;
	}

	@Override
	public boolean match(Trigger trigger) {
		try {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
			String expr = trySolve(op1, trigger.frame()) + operator + trySolve(op2, trigger.frame());
			return engine.eval(expr) == true;
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String trySolve(String op, AbstractFrame frame) {
		AbstractFrame abstractFrame = frame.findSlot(op);
		return abstractFrame != null ? abstractFrame.value().toString() : op;
	}
}
