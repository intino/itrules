package io.intino.itrules.parser;

import io.intino.itrules.Rule;
import io.intino.itrules.RuleSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.toHexString;

public class ParsedTemplate {

	List<Rule> rules = new ArrayList<>();
	Map<String, String> formatters = new HashMap<>();

	public void add(Rule rule) {
		rules.add(rule);
	}

	public String add(String formatter) {
		String key = toHexString(formatter.hashCode());
		formatters.put(key, formatter);
		return key;
	}

	public RuleSet ruleset() {
		return new RuleSet(rules);
	}


	public Map<String, String> formatters() {
		return formatters;
	}
}
