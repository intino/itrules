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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.addAll;

public class Expression implements Output {
	private List<Output> outputs;
	private Expression next = null;

	public Expression(Output... outputs) {
		this.outputs = new ArrayList<>();
		this.output(outputs);
	}

	public Expression output(Output... outputs) {
		addAll(this.outputs, outputs);
		return this;
	}

	public Stream<Output> outputs() {
		return outputs.stream();
	}

	public Expression next() {
		return next;
	}

	public Expression next(Expression or) {
		last().next = or;
		return this;
	}

	private Expression last() {
		return this.next == null ? this : this.next.last();
	}

	public boolean isConstant() {
		return outputs().allMatch(t -> t instanceof Literal);
	}

	@Override
	public String toString() {
		return "<<" + outputs.stream().map(o -> o.toString()).collect(Collectors.joining()) + ">>";
	}
}
