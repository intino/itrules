package org.siani.itrules.engine;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FunctionEvaluator {
    private final String parameter;

    public FunctionEvaluator(String parameter) {
        this.parameter = parameter;
    }

    private Stream<String> stream() {
        return Arrays.stream(parameter.replaceAll("\\s| ", "").split("\\||&"));
    }

    public boolean evaluate(Predicate<String> predicate) {
        return any() ? stream().anyMatch(predicate) : stream().allMatch(predicate);
    }

    private boolean any() {
        return parameter.contains("|");
    }
}
