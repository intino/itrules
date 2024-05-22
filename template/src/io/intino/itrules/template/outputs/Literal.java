package io.intino.itrules.template.outputs;

import io.intino.itrules.Rule;

public class Literal implements Rule.Output {
	private String value;

	public Literal(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
