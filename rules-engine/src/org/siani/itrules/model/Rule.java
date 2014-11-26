package org.siani.itrules.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rule extends Token {

	private List<Token> tokens;
	private List<Condition> conditions;

	public Rule() {
		tokens = new ArrayList<>();
		conditions = new ArrayList<>();
	}

	public void add(Token token) {
		if (Expression.class.isInstance(token) || AbstractMark.class.isInstance(token) || Literal.class.isInstance(token)) {
			if (!tokens.isEmpty())
				token.prevToken(tokens.get(tokens.size() - 1));
			tokens.add(token);
		}
	}

	public void add(Condition condition) {
		this.conditions.add(condition);
	}

	public boolean addAll(Collection<? extends Condition> c) {
		return conditions.addAll(c);
	}

	public Iterable<Token> getTokens() {
		return tokens;
	}

	public Iterable<Condition> getConditions() {
		return conditions;
	}
}
