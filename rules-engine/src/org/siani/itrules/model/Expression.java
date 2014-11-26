package org.siani.itrules.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Expression extends Token implements Iterable<Token> {
	private List<Token> tokens;

	public Expression() {
		tokens = new ArrayList<>();
	}

	public boolean add(Token token) {
		if (AbstractMark.class.isInstance(token) || Literal.class.isInstance(token))
			return tokens.add(token);
		return false;
	}

	@Override
	public Iterator<Token> iterator() {
		return tokens.iterator();
	}
}
