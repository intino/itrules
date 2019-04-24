package io.intino.itrules.rules.conditions;

import io.intino.itrules.Rule.Condition;
import io.intino.itrules.TemplateEngine;

public class TriggerCondition implements Condition {
    private final String name;

    public TriggerCondition(String name) {
        this.name = name.toLowerCase();
    }

    public String name() {
        return name;
    }

    @Override
    public boolean check(TemplateEngine.Trigger trigger) {
        return trigger.name().endsWith(name);
    }
}
