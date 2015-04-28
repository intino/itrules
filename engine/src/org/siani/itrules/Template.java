package org.siani.itrules;

import org.siani.itrules.model.*;

import java.util.Locale;

public abstract class Template {

	protected final TemplateEngine engine;

	public Template(Locale locale, LineSeparator lineSeparator) {
		this.engine = new TemplateEngine(locale, lineSeparator);
		this.definition();
	}

	public String format(Object object) {
		return engine.render(object);
	}

	public Template add(String name, Formatter formatter) {
		engine.add(name, formatter);
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

	protected abstract void definition();

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

}
