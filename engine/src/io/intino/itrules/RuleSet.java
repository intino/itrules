package io.intino.itrules;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.addAll;

public class RuleSet implements Iterable<Rule> {
    private final List<Rule> rules;

    public RuleSet() {
        this.rules = new ArrayList<>();
    }

    public RuleSet(List<Rule> rules) {
        this.rules = new ArrayList<>(rules);
    }

    public RuleSet add(Rule... rules) {
        addAll(this.rules, rules);
        return this;
    }

    public Iterator<Rule> iterator() {
        return rules.iterator();
    }

}
