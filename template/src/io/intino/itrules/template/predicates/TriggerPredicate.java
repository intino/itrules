package io.intino.itrules.template.predicates;

import io.intino.itrules.Rule.Predicate;
import io.intino.itrules.TemplateEngine.Trigger;

import java.util.stream.Stream;

import static java.util.Arrays.stream;

public record TriggerPredicate(String name) implements Predicate {
	public TriggerPredicate(String name) {
		this.name = name.toLowerCase();
	}

	@Override
	public boolean matches(Trigger trigger) {
		return trigger.name().equals(name) || formattersIn(trigger.name()).anyMatch(s -> s.equals(name));
	}

	private Stream<String> formattersIn(String trigger) {
		return stream(skipName(trigger).split("\\+"));
	}

	private String skipName(String trigger) {
		return trigger.contains("+") ? trigger.substring(trigger.indexOf('+')) : "";
	}
}
