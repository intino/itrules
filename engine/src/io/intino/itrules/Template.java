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

package io.intino.itrules;

import io.intino.itrules.template.Output;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.condition.BinaryExpression;
import io.intino.itrules.template.condition.LogicalExpression;
import io.intino.itrules.template.condition.NotExpression;
import io.intino.itrules.template.condition.Predicate;
import io.intino.itrules.template.condition.predicates.AttributePredicate;
import io.intino.itrules.template.condition.predicates.TriggerPredicate;
import io.intino.itrules.template.condition.predicates.TypePredicate;
import io.intino.itrules.template.outputs.Expression;
import io.intino.itrules.template.outputs.Literal;
import io.intino.itrules.template.outputs.Placeholder;

import java.util.List;

import static io.intino.itrules.template.condition.BinaryOperator.AND;
import static io.intino.itrules.template.condition.BinaryOperator.OR;

public abstract class Template {
	private final TemplateEngine engine;

	public Template() {
		this(new TemplateEngine.Configuration());
	}

	public Template(TemplateEngine.Configuration configuration) {
		engine = new TemplateEngine(ruleSet(), configuration);
	}

	public Template add(String name, Formatter formatter) {
		engine.add(name, formatter);
		return this;
	}

	public <T> Template add(Class<T> class_, Adapter<T> adapter) {
		engine.add(class_, adapter);
		return this;
	}

	public String render(Object object) {
		init(engine);
		return engine.render(object);
	}

	protected void init(TemplateEngine engine) {
	}

	protected abstract List<Rule> ruleSet();

	protected Rule rule() {
		return new Rule();
	}

	protected Predicate not(Predicate condition) {
		return new NotExpression(condition);
	}

	protected Predicate attribute(String attribute) {
		return new AttributePredicate(attribute);
	}

	protected Predicate attribute(String attribute, Object value) {
		return new AttributePredicate(attribute, value);
	}

	protected Predicate type(String type) {
		return new TypePredicate(type);
	}

	protected Predicate allTypes(String... types) {
		return new TypePredicate(types);
	}

	protected Predicate trigger(String name) {
		return new TriggerPredicate(name);
	}

	public static BinaryExpression all(LogicalExpression left, LogicalExpression right) {
		return new BinaryExpression(left, AND, right);
	}

	protected LogicalExpression all(LogicalExpression... expressions) {
		LogicalExpression root = expressions[0];
		if (expressions.length == 1) return root;
		for (int i = 0; i < expressions.length - 1; i++)
			root = new BinaryExpression(root, AND, expressions[i + 1]);
		return root;
	}

	protected BinaryExpression any(LogicalExpression left, LogicalExpression right) {
		return new BinaryExpression(left, OR, right);
	}

	protected LogicalExpression any(LogicalExpression... expressions) {
		LogicalExpression root = expressions[0];
		if (expressions.length == 1) return root;
		for (int i = 0; i < expressions.length - 1; i++)
			root = new BinaryExpression(root, OR, expressions[i + 1]);
		return root;
	}

	protected Placeholder placeholder(String name, String... formatters) {
		return new Placeholder(name, formatters);
	}

	protected Literal literal(String text) {
		return new Literal(text);
	}

	protected Expression expression(Output... outputs) {
		return new Expression(outputs);
	}
}
