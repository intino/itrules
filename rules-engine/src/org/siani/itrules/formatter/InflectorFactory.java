package org.siani.itrules.formatter;

import org.siani.itrules.formatter.inflectors.EnglishInflector;
import org.siani.itrules.formatter.inflectors.SpanishInflector;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class InflectorFactory {

	private static Map<Locale, Inflector> inflectors = new HashMap<>();

	static {
		{
			inflectors.put(Locale.ENGLISH, new EnglishInflector());
			inflectors.put(Locale.getDefault(), new SpanishInflector());
		}
	}

	public static Inflector getInflector(Locale locale) {
		return inflectors.get(locale);
	}
}