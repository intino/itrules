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
import io.intino.itrules.formatters.spelling.EnglishNumberSpelling;
import io.intino.itrules.formatters.spelling.SpanishNumberSpelling;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NumberFormatters {

	public static Map<String, Formatter> get(Locale locale) {
		Map<String, Formatter> map = map();
		map.put("Words", numberSpellingFormatter(locale));
		map.put("Separators", separators(locale));
		map.put("TwoDecimals", twoDecimals(locale));
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

	private static Formatter separators(final Locale locale) {
		return value -> {
			if (!isNumber(value)) return value;
			DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(locale);
			df.setGroupingUsed(true);
			df.setGroupingSize(3);
			return df.format(value);
		};
	}

	private static Formatter twoDecimals(final Locale locale) {
		return value -> {
			if (!isNumber(value)) return value;
			double n = ((Number) value).doubleValue();
			return String.format(locale, "%.2f", n);
		};
	}

	private static Formatter numberSpellingFormatter(Locale locale) {
		NumberSpelling spelling = (locale.getLanguage().equals("es")) ?
				new SpanishNumberSpelling() :
				new EnglishNumberSpelling();
		return value -> isNumber(value) ? spelling.spell((Integer) value) : value;
	}

	private static boolean isNumber(Object value) {
		return Number.class.isAssignableFrom(value.getClass());
	}

	public interface NumberSpelling {
		String spell(int number);
	}

}
