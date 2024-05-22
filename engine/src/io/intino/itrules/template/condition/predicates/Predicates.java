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

import io.intino.itrules.template.condition.BinaryExpression;
import io.intino.itrules.template.condition.LogicalExpression;
import io.intino.itrules.template.condition.NotExpression;
import io.intino.itrules.template.condition.Predicate;

import static io.intino.itrules.template.condition.BinaryOperator.AND;
import static io.intino.itrules.template.condition.BinaryOperator.OR;

public class Predicates {
	public static Predicate not(Predicate condition) {
		return new NotExpression(condition);
	}

	public static Predicate attribute(String attribute) {
		return new AttributePredicate(attribute);
	}

	public static Predicate attribute(String attribute, Object value) {
		return new AttributePredicate(attribute, value);
	}

	public static Predicate type(String type) {
		return new TypePredicate(type);
	}

	public static Predicate allTypes(String... types) {
		return new TypePredicate(types);
	}

	public static Predicate trigger(String name) {
		return new TriggerPredicate(name);
	}

	public static BinaryExpression all(LogicalExpression left, LogicalExpression right) {
		return new BinaryExpression(left, AND, right);
	}

	public static LogicalExpression all(LogicalExpression... expressions) {
		LogicalExpression root = expressions[0];
		if (expressions.length == 1) return root;
		for (int i = 0; i < expressions.length - 1; i++)
			root = new BinaryExpression(root, AND, expressions[i + 1]);
		return root;
	}

	public static BinaryExpression any(LogicalExpression left, LogicalExpression right) {
		return new BinaryExpression(left, OR, right);
	}

	public static LogicalExpression any(LogicalExpression... expressions) {
		LogicalExpression root = expressions[0];
		if (expressions.length == 1) return root;
		for (int i = 0; i < expressions.length - 1; i++)
			root = new BinaryExpression(root, OR, expressions[i + 1]);
		return root;
	}
}
