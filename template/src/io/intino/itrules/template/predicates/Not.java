package io.intino.itrules.template.predicates;

import io.intino.itrules.Rule.Predicate;
import io.intino.itrules.TemplateEngine;

public record Not(Predicate condition) implements Predicate {

	@Override
	public boolean matches(TemplateEngine.Trigger trigger) {
		return !condition.matches(trigger);
	}
}
