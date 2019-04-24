package io.intino.itrules.rules.conditions;

import io.intino.itrules.Rule.Condition;
import io.intino.itrules.TemplateEngine;

import java.util.HashSet;
import java.util.Set;

import static io.intino.itrules.rules.conditions.TypeCondition.Operator.All;
import static java.util.Arrays.stream;

public class TypeCondition implements Condition {
    private final Operator operator;
    private final Set<String> types;

    public TypeCondition(Operator operator, String... types) {
        this.operator = operator;
        this.types = setOf(types);
    }

    public Operator operator() {
        return operator;
    }

    public Set<String> types() {
        return types;
    }

    @Override
    public boolean check(TemplateEngine.Trigger trigger) {
        return operator == All ?
                types.stream().allMatch(t->trigger.frame().is(t)) :
                types.stream().anyMatch(t->trigger.frame().is(t));
    }

    private Set<String> setOf(String[] types) {
        Set<String> result = new HashSet<>();
        stream(types).forEach(t->result.add(t.toLowerCase()));
        return result;
    }

    public enum Operator {
        All, Any
    }
}
