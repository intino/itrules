package org.siani.itrules;

import org.siani.itrules.lang.RulesReader;
import org.siani.itrules.lang.model.Condition;
import org.siani.itrules.lang.model.Mark;
import org.siani.itrules.lang.model.Rule;
import org.siani.itrules.operation.OperatorFactory;

import java.io.InputStream;
import java.util.List;

final class RuleSet {


	private final List<Rule> rules;

	public RuleSet(InputStream rulesStream) {
		rules = new RulesReader(rulesStream).readAll();
		rules.add(createDefaultRule());
	}

	private Rule createDefaultRule() {
		Rule rule = new Rule();
		rule.add(new Condition(Function.ATTR, "value", false));
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
