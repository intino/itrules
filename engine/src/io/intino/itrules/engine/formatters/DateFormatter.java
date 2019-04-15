package io.intino.itrules.engine.formatters;

import io.intino.itrules.Formatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateFormatter {

	public static Map<String, Formatter> get(Locale locale) {
		Map<String, Formatter> map = new HashMap<>();
		map.put("Year".toLowerCase(), year());
		map.put("MonthYear".toLowerCase(), monthYear(locale));
		map.put("ShortDate".toLowerCase(), shortDate(locale));
		map.put("FullDate".toLowerCase(), fullDate(locale));
		map.put("DayOfWeek".toLowerCase(), dayOfWeek(locale));
		map.put("Time".toLowerCase(), time(locale));
		return map;
	}

	public static Formatter year() {
		return value -> value instanceof Date ? ((Date) value).getYear() + 1900 : value;
	}


	public static Formatter monthYear(final Locale locale) {
		return value -> formatDate(value, "MMMM yyyy", locale);
	}

	public static Formatter shortDate(final Locale locale) {
		return value -> formatDate(value, "dd/MM/yyyy", locale);
	}

	public static Formatter fullDate(final Locale locale) {
		return value -> formatDate(value, "dd MMMM yyyy", locale);
	}

	public static Formatter dayOfWeek(final Locale locale) {
		return value -> formatDate(value, "EEEE", locale);
	}

	public static Formatter time(final Locale locale) {
		return value -> formatDate(value, "HH:mm", locale);
	}

	private static Object formatDate(Object value, String format, final Locale locale) {
		return value instanceof Date ? new SimpleDateFormat(format, locale).format((Date) value) : value;
	}
}
