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

import io.intino.itrules.TemplateEngine;

import static io.intino.itrules.template.condition.BinaryOperator.AND;
import static io.intino.itrules.template.condition.BinaryOperator.OR;

public class BinaryExpression implements LogicalExpression {
	private final LogicalExpression left;

	private final BinaryOperator operator;
	private final LogicalExpression right;
	public BinaryExpression(LogicalExpression left, BinaryOperator operator, LogicalExpression right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

	@Override
	public boolean evaluate(TemplateEngine.Trigger trigger) {
		if (operator == AND) return left.evaluate(trigger) && right.evaluate(trigger);
		return left.evaluate(trigger) || right.evaluate(trigger);
	}

	public LogicalExpression left() {
		return left;
	}

	public BinaryOperator operator() {
		return operator;
	}

	public LogicalExpression right() {
		return right;
	}

	public static BinaryExpression all(LogicalExpression left, LogicalExpression right) {
		return new BinaryExpression(left, AND, right);
	}


	public static BinaryExpression all(LogicalExpression one, LogicalExpression two, LogicalExpression three) {
		return new BinaryExpression(new BinaryExpression(one, AND, two), AND, three);
	}


	public static BinaryExpression any(LogicalExpression left, LogicalExpression right) {
		return new BinaryExpression(left, OR, right);
	}


	public static BinaryExpression any(LogicalExpression one, LogicalExpression two, LogicalExpression three) {
		return new BinaryExpression(new BinaryExpression(one, OR, two), OR, three);
	}
}
