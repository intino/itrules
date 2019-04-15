package io.intino.itrules.engine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcludeAdapter<T> extends DefaultAdapter<T> {
	private final List<String> fields = new ArrayList<>();

	public ExcludeAdapter(String... fields) {
		Collections.addAll(this.fields, fields);
	}

	protected boolean isProcessable(Field field) {
		return super.isProcessable(field) && !this.fields.contains(field.getName());
	}
}