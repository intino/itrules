package org.siani.itrules;

import org.siani.itrules.model.*;

import java.util.Locale;

public abstract class Template {

    private final TemplateEngine engine;

    public Template() {
        this.engine = new TemplateEngine(Locale.getDefault());
        this.definition();
    }

    public Template(Locale locale) {
        this.engine = new TemplateEngine(locale);
    }

    public abstract void definition();

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

    public Template add(Rule... rules) {
        engine.add(rules);
        return this;
    }

    public Template add(String name, Formatter formatter) {
        engine.add(name, formatter);
        return this;
    }

    public Template add(String name, Function function) {
        engine.add(name, function);
        return this;
    }

    public <T> Template add(Class<T> aClass, Adapter<T> adapter) {
        engine.add(aClass, adapter);
        return this;
    }

    public <T> Template exclude(Class<T> aClass, String... fields) {
        engine.exclude(aClass, fields);
        return this;
    }

    public String render(Object object) {
        return engine.render(object);
    }

}
