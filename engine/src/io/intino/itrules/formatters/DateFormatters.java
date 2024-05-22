/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.formatters;

import io.intino.itrules.Formatter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateFormatters {

	public static Map<String, Formatter> get(Locale locale) {
		Map<String, Formatter> map = map();
		map.put("Year", year(locale));
		map.put("YearMonth", yearMonth(locale));
		map.put("YearMonthDay", yearMonthDay(locale));
		map.put("YearMonthDayTime", yearMonthDayTime(locale));
		map.put("ShortDate", shortDate(locale));
		map.put("FullDate", fullDate(locale));
		map.put("CompactDate", compactDate(locale));
		map.put("AmericanCompactDate", americanCompactDate(locale));
		map.put("AmericanDate", americanDate(locale));
		map.put("DayOfWeek", dayOfWeek(locale));
		map.put("Time", time(locale));
		return map;
	}

	private static HashMap<String, Formatter> map() {
		return new HashMap<String, Formatter>() {
			@Override
			public Formatter put(String key, Formatter value) {
				return super.put(key.toLowerCase(), value);
			}
		};
	}

	private static Formatter year(Locale locale) {
		return value -> format(value, "yyyy", locale);
	}


	private static Formatter yearMonth(Locale locale) {
		return value -> format(value, "yyyyMM", locale);
	}

	private static Formatter yearMonthDay(Locale locale) {
		return value -> format(value, "yyyyMMdd", locale);
	}

	private static Formatter yearMonthDayTime(Locale locale) {
		return value -> format(value, "yyyyMMddhhmmss", locale);
	}

	private static Formatter shortDate(Locale locale) {
		return value -> format(value, "dd/MM/yyyy", locale);
	}

	private static Formatter americanCompactDate(Locale locale) {
		return value -> format(value, "MMM, dd yyyy", locale);
	}

	private static Formatter americanDate(Locale locale) {
		return value -> format(value, "MMMM, dd yyyy", locale);
	}

	private static Formatter fullDate(Locale locale) {
		return value -> format(value, "EEEE, dd MMMM yyyy", locale);
	}

	private static Formatter compactDate(Locale locale) {
		return value -> format(value, "EEE, dd MMM yyyy", locale);
	}

	private static Formatter dayOfWeek(Locale locale) {
		return value -> format(value, "EEEE", locale);
	}

	private static Formatter time(Locale locale) {
		return value -> format(value, "HH:mm", locale);
	}

	private static Object format(Object value, String pattern, Locale locale) {
		return value instanceof Temporal ? format((Temporal) value, pattern, locale) : value;
	}

	private static String format(Temporal value, String pattern, Locale locale) {
		return DateTimeFormatter.ofPattern(pattern).withLocale(locale).withZone(zoneOf(value)).format(value);
	}

	private static ZoneId zoneOf(Temporal value) {
		return value instanceof ZonedDateTime ? ((ZonedDateTime) value).getZone() : ZoneId.systemDefault();
	}
}
