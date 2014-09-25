package org.siani.itrules.lang.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rule extends Token {

	private List<Token> tokens;
	private List<Function> functions;

	public Rule() {
		tokens = new ArrayList<>();
		functions = new ArrayList<>();
	}

	public void add(Token token) {
		if (Expression.class.isInstance(token) || Mark.class.isInstance(token) || Literal.class.isInstance(token))
			tokens.add(token);
	}

	public void add(Function function) {
		this.functions.add(function);
	}

	public boolean addAll(Collection<? extends Function> c) {
		return functions.addAll(c);
	}

	public Iterable<Token> getTokens() {
		return tokens;
	}

	public Iterable<Function> getFunctions() {
		return functions;
	}
}
