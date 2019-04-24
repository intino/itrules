package io.intino.itrules.rules.conditions;

import io.intino.itrules.Rule.Condition;
import io.intino.itrules.TemplateEngine;

public class NegatedCondition implements Condition {
    private final Condition condition;

    public NegatedCondition(Condition condition) {
        this.condition = condition;
    }

    public Condition condition() {
        return condition;
    }

    @Override
    public boolean check(TemplateEngine.Trigger trigger) {
        return !condition.check(trigger);
    }
}
