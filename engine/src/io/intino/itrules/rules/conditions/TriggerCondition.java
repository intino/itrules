package io.intino.itrules.rules.conditions;

import io.intino.itrules.Rule.Condition;
import io.intino.itrules.TemplateEngine;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.stream;

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
        return trigger.name().equals(name) || formattersIn(trigger.name()).anyMatch(s->s.equals(name));
    }

    private Stream<String> formattersIn(String trigger) {
        return stream(skipName(trigger).split("\\+"));
    }

    private String skipName(String trigger) {
        return trigger.contains("+") ? trigger.substring(trigger.indexOf('+')) : "";
    }


}
