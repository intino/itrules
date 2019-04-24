package io.intino.itrules;

import io.intino.itrules.Rule.Condition;
import io.intino.itrules.rules.conditions.AttributeCondition;
import io.intino.itrules.rules.conditions.NegatedCondition;
import io.intino.itrules.rules.conditions.TriggerCondition;
import io.intino.itrules.rules.conditions.TypeCondition;
import io.intino.itrules.rules.output.Expression;
import io.intino.itrules.rules.output.Literal;
import io.intino.itrules.rules.output.Mark;

import static io.intino.itrules.rules.conditions.TypeCondition.Operator.All;
import static io.intino.itrules.rules.conditions.TypeCondition.Operator.Any;

public abstract class Template {

    public String render(Object object) {
        TemplateEngine engine = new TemplateEngine(ruleSet());
        init(engine);
        return engine.render(object);
    }

    protected void init(TemplateEngine engine) {
    }

    protected abstract RuleSet ruleSet();

    protected Rule rule() {
        return new Rule();
    }

    protected Condition not(Condition condition) {
        return new NegatedCondition(condition);
    }

    protected Condition attribute(String attribute) {
        return new AttributeCondition(attribute);
    }

    protected Condition attribute(String attribute, Object value) {
        return new AttributeCondition(attribute, value);
    }

    protected Condition type(String type) {
        return new TypeCondition(Any, type);
    }

    protected Condition anyType(String... types) {
        return new TypeCondition(Any, types);
    }

    protected Condition allTypes(String... types) {
        return new TypeCondition(All, types);
    }

    protected Condition trigger(String name) {
        return new TriggerCondition(name);
    }

    protected Mark mark(String name, String... options) {
        return new Mark(name, options);
    }

    protected Literal literal(String text) {
        return new Literal(text);
    }

    protected Expression expression(Rule.Output... outputs) {
        return new Expression(outputs);
    }


}
