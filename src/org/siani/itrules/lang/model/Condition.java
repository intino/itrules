package org.siani.itrules.lang.model;

public class Condition {

	private final String name;
	private final String parameter;
	private final boolean negated;


	public Condition(String name, String parameter, boolean negated) {
		this.name = name;
		this.parameter = parameter;
		this.negated = negated;
	}

	public String name() {
		return this.name;
	}

	public boolean negated() {
		return this.negated;
	}

	public String getParameter() {
		return parameter;
	}
}
