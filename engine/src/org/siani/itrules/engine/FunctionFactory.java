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

package org.siani.itrules.engine;

import org.siani.itrules.engine.functions.*;
import org.siani.itrules.model.Condition;
import org.siani.itrules.model.Function;

import static org.siani.itrules.model.Function.*;

public final class FunctionFactory {

	public static Function get(Condition condition) {
		Function function = getFunction(condition);
		return condition.negated() ? negatedFunction(function) : function;
	}

	private static Function getFunction(Condition condition) {
		String[] parameters = condition.getParameters();
		if (condition.is(Type)) return new TypeFunction(parameters[0]);
		if (condition.is(Trigger)) return new TriggerFunction(parameters[0]);
		if (condition.is(SlotName)) return new SlotNameFunction(parameters[0]);
		if (condition.is(SlotType)) return new SlotTypeFunction(parameters[0]);
		if (condition.is(Eval)) return new EvalFunction(parameters[0], parameters[1], parameters[2]);
		return null;
	}

	private static Function negatedFunction(final Function function) {
		return new Function() {
			@Override
			public boolean match(org.siani.itrules.model.Trigger trigger) {
				return !function.match(trigger);
			}
		};
	}
}
