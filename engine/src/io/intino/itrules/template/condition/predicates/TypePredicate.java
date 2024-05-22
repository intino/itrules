/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.template.condition.predicates;


import io.intino.itrules.Trigger;
import io.intino.itrules.template.condition.Predicate;

import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

public class TypePredicate implements Predicate {
	private final Checker checker;
	private final String[] types;

	public TypePredicate(String... types) {
		this.types = types;
		this.checker = types.length > 1 ?
				multiple(setOf(types)) :
				single(types[0].toLowerCase());
	}

	@Override
	public boolean evaluate(Trigger trigger) {
		return checker.check(trigger);
	}

	@SuppressWarnings("unused")
	public String[] types() {
		return types;
	}

	private Checker multiple(Set<String> types) {
		return trigger -> types.stream().allMatch(t -> trigger.frame().is(t));
	}

	private Checker single(String type) {
		return trigger -> trigger.frame().is(type);
	}

	private Set<String> setOf(String[] types) {
		return stream(types).map(String::toLowerCase).collect(toSet());
	}

	@Override
	public String toString() {
		return "type(" + String.join(", ", types) + ")";
	}

	interface Checker {
		boolean check(Trigger trigger);
	}
}