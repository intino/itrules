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

package io.intino.itrules.engine.functions;

import io.intino.itrules.Function;
import io.intino.itrules.engine.FunctionEvaluator;
import io.intino.itrules.engine.Trigger;

import java.util.HashMap;
import java.util.Map;

public final class TypeFunction implements Function {
	private static final Map<String, FunctionEvaluator> map = new HashMap<>();

	private static FunctionEvaluator get(String parameter) {
		if (!map.containsKey(parameter)) map.put(parameter, new FunctionEvaluator(parameter));
		return map.get(parameter);
	}

	@Override
	public boolean match(Trigger trigger, String parameter) {
		return get(parameter).evaluate(type -> trigger.frame().is(type));
	}
}
