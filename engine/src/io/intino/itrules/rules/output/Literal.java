package io.intino.itrules.rules.output;

import io.intino.itrules.Rule;

public class Literal implements Rule.Output {
    private String value;

    public Literal(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
