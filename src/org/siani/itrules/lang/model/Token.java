package org.siani.itrules.lang.model;

public class Token {
	public <Type> Type as(Class<Type> type) {
		return (Type) this;
	}
}
