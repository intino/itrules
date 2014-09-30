package org.siani.itrules.lang.model;

public abstract class Token implements Link {

	protected Token previous;

	public <Type> Type as(Class<Type> type) {
		return (Type) this;
	}

	@Override
	public Token prevToken() {
		return previous;
	}

	@Override
	public void prevToken(Token previous) {
		this.previous = previous;
	}
}
