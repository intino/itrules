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
import io.intino.itrules.formatters.inflectors.EnglishPluralInflector;
import io.intino.itrules.formatters.inflectors.SpanishPluralInflector;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class StringFormatters {

	public static Map<String, Formatter> get(Locale locale) {
		Map<String, Formatter> map = map();
		map.put("UpperCase", upperCase());
		map.put("LowerCase", lowerCase());
		map.put("CamelCase", camelCase());
		map.put("SnakeCase", snakeCase());
		map.put("KebabCase", kebabCase());
		map.put("FirstUpperCase", firstUpperCase());
		map.put("FirstLowerCase", firstLowerCase());
		map.put("Capitalize", capitalize());
		map.put("Length", length());
		map.put("OnlyDigits", onlyDigits());
		map.put("OnlyLetters", onlyLetters());
		map.put("OnlyDigitsAndLetters", onlyDigitsAndLetters());
		map.put("Plural", plural(locale));
		return map;
	}

	public static Formatter onlyDigitsAndLetters() {
		return value -> value.toString().replaceAll("[^0-9A-Za-z]", "");
	}

	public static Formatter onlyLetters() {
		return value -> value.toString().replaceAll("[^A-Za-z]", "");
	}

	public static Formatter onlyDigits() {
		return value -> value.toString().replaceAll("[^0-9]", "");
	}

	public static HashMap<String, Formatter> map() {
		return new HashMap<String, Formatter>() {
			@Override
			public Formatter put(String key, Formatter value) {
				return super.put(key.toLowerCase(), value);
			}
		};
	}

	public static Formatter upperCase() {
		return value -> value.toString().toUpperCase();
	}

	public static Formatter lowerCase() {
		return value -> value.toString().toLowerCase();
	}

	public static Formatter camelCase() {
		return value -> {
			String[] parts = value.toString().split("[ _\\-]");
			String result = "";
			for (String part : parts) result = result + capitalize().format(part);
			return result.substring(0, 1).toLowerCase() + result.substring(1);
		};
	}

	public static Formatter snakeCase() {
		return value -> value.toString().toLowerCase().replaceAll(" -", "_");
	}

	public static Formatter kebabCase() {
		return value -> value.toString().toLowerCase().replaceAll(" _", "-");
	}

	public static Formatter firstUpperCase() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1);
	}

	public static Formatter firstLowerCase() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toLowerCase() + value.toString().substring(1);
	}

	public static Formatter capitalize() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1).toLowerCase();
	}

	public static Formatter length() {
		return value -> String.valueOf(value.toString().length());
	}

	private static Formatter plural(Locale locale) {
		PluralInflector pluralInflector = (locale.getLanguage().equals("es")) ?
				new SpanishPluralInflector() :
				new EnglishPluralInflector();
		return value -> pluralInflector.plural(value.toString());
	}

	public abstract static class PluralInflector {
		private final Map<String, String> irregulars = new HashMap<>();
		private final Map<String, String> replaces = new HashMap<>();

		public PluralInflector() {
			setIrregulars();
			setReplaces();
		}

		public abstract String plural(String word);

		protected abstract void setReplaces();

		protected abstract void setIrregulars();

		protected void addReplace(String from, String to) {
			replaces.put(from, to);
		}

		protected void addIrregular(String from, String to) {
			irregulars.put(from, to);
		}

		protected String doReplaces(String word) {
			for (String ending : replaces.keySet()) {
				if (!word.endsWith(ending)) continue;
				return replaceLast(word, ending);
			}
			return word;
		}

		protected char[] consonants() {
			return "bcdfghjklmnpqrstvwxyz".toCharArray();
		}

		protected boolean isIrregular(String word) {
			return irregulars.containsKey(word);
		}

		protected String irregularPlural(String word) {
			return irregulars.get(word);
		}

		private String replaceLast(String word, String ending) {
			return removeEnding(word, ending) + replaces.get(ending);
		}

		private String removeEnding(String word, String ending) {
			return word.substring(0, word.length() - ending.length());
		}


	}
}
