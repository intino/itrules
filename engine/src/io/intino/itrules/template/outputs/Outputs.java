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

package io.intino.itrules.template.outputs;

import io.intino.itrules.template.Output;

public class Outputs {
	public static Placeholder placeholder(String[] context, String name, String... formatters) {
		return new Placeholder(name, context, formatters);
	}

	public static Placeholder placeholder(String name, String... formatters) {
		return new Placeholder(name, formatters);
	}

	public static Literal literal(String text) {
		return new Literal(text);
	}

	public static Expression expression(Output... outputs) {
		return new Expression(outputs);
	}
}
