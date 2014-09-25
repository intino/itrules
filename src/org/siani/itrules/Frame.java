package org.siani.itrules;

import java.util.*;

public class Frame implements AbstractFrame, AbstractFrame.Attribute {

	private final List<String> types;
	private final Map<String, List<Attribute>> attributes;

	public Frame(String... types) {
		this.attributes = new LinkedHashMap<>();
		this.types = new ArrayList<>();
		Collections.addAll(this.types, types);
	}


	@Override
	public boolean is(String type) {
		return this.types.contains(type);
	}

	@Override
	public Attribute[] attributes(String attribute) {
		if (!attributes.containsKey(attribute)) return new Attribute[0];
		List<Attribute> attributeList = attributes.get(attribute);
		return attributeList.toArray(new Attribute[attributeList.size()]);
	}

	@Override
	public boolean has(String attribute) {
		return attributes.containsKey(attribute);
	}


	public void attribute(String attribute, Object value) {
		if (!attributes.containsKey(attribute))
			attributes.put(attribute, new ArrayList<Attribute>());
		attributes.get(attribute).add((value instanceof Frame) ? (Frame) value : createAttribute(value));
	}

	private Attribute createAttribute(final Object value) {
		return new Attribute() {
			@Override
			public boolean isFrame() {
				return false;
			}

			@Override
			public AbstractFrame asFrame() {
				return null;
			}

			@Override
			public Object value() {
				return value;
			}
		};
	}

	@Override
	public boolean isFrame() {
		return true;
	}

	@Override
	public AbstractFrame asFrame() {
		return this;
	}

	@Override
	public Object value() {
		return null;
	}
}
