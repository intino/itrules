/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.siani.itrules.engine.functions;

import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.Function;
import org.siani.itrules.model.Trigger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public final class EvalFunction implements Function {
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
			return (Boolean) engine.eval(expr);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String trySolve(String op, AbstractFrame frame) {
        //TODO
//		AbstractFrame abstractFrame = frame.frame(op);
//		return abstractFrame != null ? abstractFrame.value().toString() : op;
        return "";
	}
}
