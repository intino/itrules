package org.siani.itrules.lang.model;

public class Condition {

	private final String name;
	private String[] parameters;
	private final boolean negated;

	public Condition(String name, String[] parameters, boolean negated) {
		this.name = name;
		this.parameters = parameters;
		this.negated = negated;
	}

	public String name() {
		return this.name;
	}

	public boolean negated() {
		return this.negated;
	}

	public String[] getParameters() {
		return parameters;
	}
}
