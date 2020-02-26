package io.intino.itrules.rules.conditions;

import io.intino.itrules.Frame;
import io.intino.itrules.Rule.Condition;
import io.intino.itrules.TemplateEngine;

import java.util.Iterator;

public class AttributeCondition implements Condition {
	private static final String THIS = "this";
	private final String attribute;
	private final boolean isThis;
	private Object value;


	public AttributeCondition(String attribute) {
		this(attribute, null);
	}

	public AttributeCondition(String attribute, Object value) {
		this.isThis = attribute.equals(THIS) || attribute.isEmpty();
		this.attribute = this.isThis ? "" : attribute.toLowerCase();
		this.value = value;
	}

	public String attribute() {
		return attribute;
	}

	public Object value() {
		return value;
	}

	@Override
	public boolean check(TemplateEngine.Trigger trigger) {
		return checkAttribute(trigger.frame()) && checkValue(trigger.frame());
	}

	private boolean checkAttribute(Frame frame) {
		return isThis ? frame != null : frame.contains(attribute);
	}

	private boolean checkValue(Frame frame) {
		if (value == null) return true;
		return isThis ? equalTo(frame.value()) : isIn(frame);
	}

	private boolean isIn(Frame frame) {
		Iterator<Frame> frames = frame.frames(attribute);
		while (frames.hasNext())
			if (equalTo(frames.next().value())) return true;
		return false;
	}

	private boolean equalTo(Object o) {
		if (o == null) return false;
		return this == o || o.toString().equalsIgnoreCase(value.toString());
	}

}
