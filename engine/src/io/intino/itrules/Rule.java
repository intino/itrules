package io.intino.itrules;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Rule  {
    private List<Condition> conditions = new ArrayList<>();
    private List<Output> outputs = new ArrayList<>();

    public Rule condition(Condition condition, Condition... other) {
        this.conditions.add(condition);
        this.conditions.addAll(asList(other));
        return this;
    }

    public Rule output(Output... outputs) {
        this.outputs.addAll(asList(outputs));
        return this;
    }

    public Stream<Condition> conditions() {
        return conditions.stream();
    }

    public Stream<Output> outputs() {
        return outputs.stream();
    }

    public interface Condition {
        boolean check(TemplateEngine.Trigger trigger);
    }

    public interface Output {

    }

}
