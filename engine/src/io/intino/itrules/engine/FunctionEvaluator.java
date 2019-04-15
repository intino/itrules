package io.intino.itrules.engine;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class FunctionEvaluator {
    private final List<String> values;
    private final boolean any;

    public FunctionEvaluator(String parameter) {
        parameter = parameter.replaceAll("\\s| ", "");
        this.values = asList(parameter.split("[|&]"));
        this.any = parameter.contains("|");
    }

    private Stream<String> stream() {
        return values.stream();
    }

    public boolean evaluate(Predicate<String> predicate) {
        return any ? stream().anyMatch(predicate) : stream().allMatch(predicate);
    }

}
