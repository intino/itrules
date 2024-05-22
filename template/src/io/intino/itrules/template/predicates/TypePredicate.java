package io.intino.itrules.template.predicates;


import java.util.Set;

import static io.intino.itrules.template.predicates.TypePredicate.Operator.Any;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

public class TypePredicate implements Predicate {
	private final Checker checker;
	private final Operator operator;
	private final String[] types;

	public TypePredicate(Operator operator, String... types) {
		this.operator = operator;
		this.types = types;
		this.checker = types.length > 1 ?
				multiple(operator, setOf(types)) :
				single(types[0].toLowerCase());
	}

	@SuppressWarnings("unused")
	public Operator operator() {
		return operator;
	}

	@SuppressWarnings("unused")
	public String[] types() {
		return types;
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
		return trigger -> types.stream().allMatch(t -> trigger.frame().is(t));
	}

	private Checker createAnyChecker(Set<String> types) {
		return trigger -> types.stream().anyMatch(t -> trigger.frame().is(t));
	}

	interface Checker {
		boolean check(Trigger trigger);
	}

	@Override
	public boolean matches(Trigger trigger) {
		return checker.check(trigger);
	}

	private Set<String> setOf(String[] types) {
		return stream(types).map(String::toLowerCase).collect(toSet());
	}

	public enum Operator {
		All, Any
	}

}
