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

package io.intino.itrules.template.condition;

import io.intino.itrules.Trigger;

import static io.intino.itrules.template.condition.BinaryOperator.AND;

public record BinaryExpression(LogicalExpression left, BinaryOperator operator,
							   LogicalExpression right) implements LogicalExpression {
	@Override
	public boolean evaluate(Trigger trigger) {
		if (operator == AND) return left.evaluate(trigger) && right.evaluate(trigger);
		return left.evaluate(trigger) || right.evaluate(trigger);
	}

	@Override
	public String toString() {
		return embrace(left) + " " + operator.name() + " " + embrace(right);
	}

	private String embrace(LogicalExpression expression) {
		String result = expression.toString();
		return expression instanceof Predicate ? result : "(" + result + ")";
	}
}