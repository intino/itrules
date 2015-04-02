package org.siani.itrules;

import org.siani.itrules.model.*;

import java.util.Locale;

public abstract class Template {

    private final RuleEngine engine;

    public Template() {
        this.engine = new RuleEngine(Locale.getDefault());
        this.definition();
    }

    public Template(Locale locale) {
        this.engine = new RuleEngine(locale);
    }

    public abstract void definition();

    protected Rule rule() {
        return new Rule();
    }

    protected Condition condition(String name, String parameter) {
        return new Condition(name, parameter);
    }

    protected Literal literal(String literal) {
        return new Literal(literal);
    }

    protected Mark mark(String mark, String... options) {
        return new Mark(mark, options);
    }

    protected Expression expression(BodyToken... tokens) {
        Expression expression = new Expression();
        for (BodyToken token : tokens) expression.add(token);
        return expression;
    }

    public RuleEngine add(Rule... rules) {
        return engine.add(rules);
    }

    public RuleEngine add(String name, Formatter formatter) {
        return engine.add(name, formatter);
    }

    public RuleEngine add(String name, Function function) {
        return engine.add(name, function);
    }

    public <T> RuleEngine add(Class<T> aClass, Adapter<T> adapter) {
        return engine.add(aClass, adapter);
    }

    public <T> RuleEngine exclude(Class<T> aClass, String... fields) {
        return engine.exclude(aClass, fields);
    }

    public Document render(Object object) {
        return engine.render(object);
    }



}
