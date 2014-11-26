package org.siani.itrules.model;

public class Condition {

	public static final String TYPE = "type";
	public static final String TRIGGER = "trigger";
	public static final String SLOT_NAME = "slot-name";
	public static final String SLOT_TYPE = "slot-type";
	public static final String EVAL = "eval";
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
