package org.siani.itrules;

import org.siani.itrules.model.Condition;
import org.siani.itrules.model.Expression;
import org.siani.itrules.model.Literal;
import org.siani.itrules.model.Rule;
import org.siani.itrules.model.marks.Mark;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class Template {

	protected final TemplateEngine engine;

	protected Template(Locale locale, LineSeparator lineSeparator) {
		this.engine = new TemplateEngine(locale, lineSeparator);
	}

	public String format(Object object) {
		return engine.render(object);
	}

	public Template add(String format, Formatter formatter) {
		engine.add(format, formatter);
		return this;
	}

	public Template add(String format, final Template template) {
		add(format, new Formatter() {
			@Override
			public Object format(Object value) {
				return template.format(value);
			}
		});
		return this;
	}

	public Template add(Class class_, Adapter adapter) {
		engine.add(class_, adapter);
		return this;
	}

	public Template add(String name, Function function) {
		engine.add(name, function);
		return this;
	}

	protected Rule rule() {
		return new Rule();
	}

	protected Condition condition(String id, String parameter) {
		return new Condition(id, parameter);
	}

	protected Condition not(Condition condition) {
		return new Condition.Negated(condition);
	}

	protected Literal literal(String literal) {
		return new Literal(literal);
	}

	protected Mark mark(String mark, String... options) {
		return new Mark(mark, options);
	}

	protected Expression expression() {
		return new Expression();
	}

	protected Template add(Rule... rules) {
		engine.add(rules);
		return this;
	}

	public Rule[] rules() {
		return collectRules(engine.ruleSet().iterator());
	}

	private Rule[] collectRules(Iterator<Rule> iterator) {
		List<Rule> rules = new ArrayList<>();
		while (iterator.hasNext()) rules.add(iterator.next());
		return rules.toArray(new Rule[rules.size()]);
	}


}
