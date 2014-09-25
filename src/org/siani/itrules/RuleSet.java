package org.siani.itrules;

import org.siani.itrules.lang.RulesReader;
import org.siani.itrules.lang.model.Function;
import org.siani.itrules.lang.model.Rule;
import org.siani.itrules.operation.OperatorFactory;

import java.io.InputStream;

final class RuleSet {

	private Rule[] rules;

	public RuleSet(InputStream rulesStream) {
		rules = new RulesReader(rulesStream).readAll();
	}

	public Rule match(Trigger trigger) throws ITRulesException {
		for (Rule rule : rules)
			if (match(rule, trigger)) return rule;
		return null;
	}

	private boolean match(Rule rule, Trigger trigger) throws ITRulesException {
		for (Function function : rule.getFunctions())
			if (OperatorFactory.get(function).match(trigger) == !function.negated())
				return false;
		return true;
	}
}
