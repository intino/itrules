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

package io.intino.itrules.template;

import io.intino.itrules.template.condition.LogicalExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Rule {
	private LogicalExpression condition;
	private final List<Output> outputs = new ArrayList<>();

	public Rule condition(LogicalExpression expression) {
		this.condition = expression;
		return this;
	}

	public Rule output(Output... outputs) {
		this.outputs.addAll(asList(outputs));
		return this;
	}

	public LogicalExpression condition() {
		return condition;
	}

	public Stream<Output> outputs() {
		return outputs.stream();
	}

}
