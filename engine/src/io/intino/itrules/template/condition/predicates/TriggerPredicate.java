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

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public record TriggerPredicate(String name) implements Predicate {
	public TriggerPredicate(String name) {
		this.name = name.toLowerCase();
	}

	@Override
	public boolean evaluate(Trigger trigger) {
		return trigger.name().equals(name) || formattersIn(trigger.name()).anyMatch(s -> s.equals(name));
	}

	private Stream<String> formattersIn(String trigger) {
		return stream(skipName(trigger).split("\\+"));
	}

	private String skipName(String trigger) {
		return trigger.contains("+") ? trigger.substring(trigger.indexOf('+')) : "";
	}

	@Override
	public String toString() {
		return "trigger(" + name + ")";
	}
}