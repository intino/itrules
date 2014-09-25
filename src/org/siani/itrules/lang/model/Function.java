package org.siani.itrules.lang.model;

public class Function {
	public static final String ATTR = "attr";
	public static final String TRIGGER = "trigger";
	public static final String TYPE = "type";

	private final String name;
	private final String parameter;
	private final boolean negated;


	public Function(String name, String parameter, boolean negated) {
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
