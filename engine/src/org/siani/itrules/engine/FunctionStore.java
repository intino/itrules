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

import org.siani.itrules.Function;
import org.siani.itrules.engine.functions.SlotFunction;
import org.siani.itrules.engine.functions.TriggerFunction;
import org.siani.itrules.engine.functions.TypeFunction;
import org.siani.itrules.engine.logger.DebugLogger;
import org.siani.itrules.model.Condition;
import org.siani.itrules.model.Trigger;

import java.util.HashMap;
import java.util.Map;

public final class FunctionStore {

	private Map<String, Function> map = new HashMap<>();

	public FunctionStore() {
		add("Type", new TypeFunction());
		add("Trigger", new TriggerFunction());
		add("Slot", new SlotFunction());
	}

	public Function get(Condition condition) {
		return exists(condition.name()) ? createFunction(condition) : nullFunction(condition);
	}

	private Function createFunction(Condition condition) {
		Function function = map.get(condition.name().toLowerCase());
		return condition.negated() ? negatedFunction(function) : function;
	}

	private boolean exists(String function) {
		return map.containsKey(function.toLowerCase());
	}

	private Function negatedFunction(final Function function) {
		return new Function() {
			@Override
			public boolean match(Trigger trigger, String parameter) {
				return !function.match(trigger, parameter);
			}
		};
	}

	private Function nullFunction(final Condition condition) {
		return new Function() {
			@Override
			public boolean match(Trigger trigger, String parameter) {
				new DebugLogger().debug("Function %s doesn't exists", condition.name());
				return false;
			}
		};
	}

	public void add(String name, Function function) {
		map.put(name.toLowerCase(), function);
	}
}
