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
		map.put("FirstUpperCase", firstUpperCase());
		map.put("FirstLowerCase", firstLowerCase());
		map.put("Camelcase", camelCase());
		map.put("LowerCamelCase", lowerCamelCase());
		map.put("SnakeCase", snakeCase());
		map.put("Capitalize", capitalize());
		map.put("Length", length());
		map.put("OnlyDigits", onlyDigits());
		map.put("OnlyLetters", onlyLetters());
		map.put("OnlyDigitsAndLetters", onlyDigitsAndLetters());
		map.put("Plural", plural(locale));
		return map;
	}

	private static Formatter onlyDigitsAndLetters() {
		return value -> value.toString().replaceAll("[^0-9A-Za-z]", "");
	}

	private static Formatter onlyLetters() {
		return value -> value.toString().replaceAll("[^A-Za-z]", "");
	}

	private static Formatter onlyDigits() {
		return value -> value.toString().replaceAll("[^0-9]", "");
	}

	private static HashMap<String, Formatter> map() {
        return new HashMap<String,Formatter>() {
            @Override
            public Formatter put(String key, Formatter value) {
                return super.put(key.toLowerCase(), value);
            }
        };
    }

    private static Formatter upperCase() {
		return value -> value.toString().toUpperCase();
	}

	private static Formatter lowerCase() {
		return value -> value.toString().toLowerCase();
	}

	private static Formatter camelCase() {
		return value -> {
			String[] parts = value.toString().split(" ");
			String result = "";
			for (String part : parts) result = result + capitalize().format(part);
			return result;
		};
	}

	private static Formatter lowerCamelCase() {
		return value -> {
			String[] parts = value.toString().split(" ");
			String result = "";
			for (String part : parts)
				result = result + capitalize().format(part);
			return result.substring(0, 1).toLowerCase() + result.substring(1);
		};
	}

	private static Formatter snakeCase() {
		return value -> value.toString().toLowerCase().replaceAll(" ", "-");
	}

	private static Formatter firstUpperCase() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1);
	}

	private static Formatter firstLowerCase() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toLowerCase() + value.toString().substring(1);
	}

	private static Formatter capitalize() {
		return value -> value.toString().isEmpty() ? "" : value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1).toLowerCase();
	}

	private static Formatter length() {
		return value -> String.valueOf(value.toString().length());
	}

	private static Formatter plural(Locale locale) {
		PluralInflector pluralInflector = (locale.getLanguage().equals("es")) ?
				new SpanishPluralInflector():
				new EnglishPluralInflector();
		return value -> pluralInflector.plural(value.toString());
	}

	public abstract static class PluralInflector {
		private Map<String, String> irregulars = new HashMap<>();
		private Map<String, String> replaces = new HashMap<>();

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
