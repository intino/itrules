package io.intino.itrules;

public interface Formatter {
	Formatter Null = value -> value;

	Object format(Object value);
}
