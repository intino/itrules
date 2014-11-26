package org.siani.itrules;

import org.siani.itrules.model.Condition;
import org.siani.itrules.model.Mark;
import org.siani.itrules.model.Rule;
import org.siani.itrules.operation.OperatorFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class RuleSet {

	private final List<Rule> rules = new ArrayList<>();

	public RuleSet(Rule[] rules) {
		Collections.addAll(this.rules, rules);
		this.rules.add(createDefaultRule());
	}

	private Rule createDefaultRule() {
		Rule rule = new Rule();
		rule.add(new Condition(Function.SLOT_NAME, new String[]{"value"}, false));
		rule.add(new Mark("value"));
		return rule;
	}

	public Rule match(Trigger trigger) {
		for (Rule rule : rules)
			if (match(rule, trigger)) return rule;
		return null;
	}

	private boolean match(Rule rule, Trigger trigger) {
		for (Condition condition : rule.getConditions())
			if (OperatorFactory.get(condition).match(trigger) == condition.negated())
				return false;
		return true;
	}
}
