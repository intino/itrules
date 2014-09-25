package org.siani.itrules.lang.model;

public class Literal extends Token {

	private final String literal;


	public Literal(String literal) {
		this.literal = literal;
	}

	public String literal() {
		return literal;
	}

	@Override
	public String toString() {
		return literal;
	}
}