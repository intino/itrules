package io.intino.itrules.rules.conditions;

import io.intino.itrules.Rule.Condition;
import io.intino.itrules.TemplateEngine;

import java.util.Set;

import static io.intino.itrules.rules.conditions.TypeCondition.Operator.Any;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

public class TypeCondition implements Condition {
	private final Checker checker;

	public TypeCondition(Operator operator, String... types) {
		this.checker = types.length > 1 ?
				multiple(operator, setOf(types)) :
				single(types[0].toLowerCase());
	}

	private Checker multiple(Operator operator, Set<String> types) {
		return operator == Any ?
				createAnyChecker(types) :
				createAllChecker(types);
	}

	private Checker single(String type) {
		return trigger -> trigger.frame().is(type);
	}

	private Checker createAllChecker(Set<String> types) {
		return trigger -> types.stream().allMatch(t->trigger.frame().is(t));
	}

	private Checker createAnyChecker(Set<String> types) {
		return trigger -> types.stream().anyMatch(t->trigger.frame().is(t));
	}

	interface Checker {
		boolean check(TemplateEngine.Trigger trigger);
	}

	@Override
	public boolean check(TemplateEngine.Trigger trigger) {
		return checker.check(trigger);
	}

	private Set<String> setOf(String[] types) {
		return stream(types).map(String::toLowerCase).collect(toSet());
	}

	public enum Operator {
		All, Any
	}

}
