/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.siani.itrules.engine;

import org.siani.itrules.model.Condition;
import org.siani.itrules.model.Rule;
import org.siani.itrules.model.Trigger;

import java.util.ArrayList;
import java.util.List;

public final class RuleSet {

	private final List<Rule> rules = new ArrayList<>();

	public RuleSet() {
	}

    public RuleSet(List<Rule> rules) {
        this.rules.addAll(rules);
    }

    public Rule match(Trigger trigger) {
		for (Rule rule : rules)
			if (match(rule, trigger)) return rule;
		return null;
	}

	private boolean match(Rule rule, Trigger trigger) {
		for (Condition condition : rule.getConditions())
			if (FunctionFactory.get(condition).match(trigger) == condition.negated())
				return false;
		return true;
	}

    public void add(RuleSet ruleSet) {
        rules.addAll(0, ruleSet.rules);
    }

    public void add(Rule rule) {
        rules.add(rule);
    }
}
