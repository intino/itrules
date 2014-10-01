package org.siani.itrules;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

final class FormatterFactory {

	public static void fill(Map<String, Formatter> formatters) {
		formatters.put("uppercase", upperCase());
		formatters.put("lowercase", lowerCase());
		formatters.put("firstuppercase", firstUpperCase());
		formatters.put("firstlowercase", firstLowerCase());
		formatters.put("camelcase", camelCase());
		formatters.put("lowercamelcase", lowerCamelCase());
		formatters.put("year", year());
		formatters.put("monthyear", monthYear());
		formatters.put("shortdate", shortDate());
		formatters.put("fulldate", fullDate());
		formatters.put("dayofweek", dayOfWeek());
		formatters.put("time", time());
		formatters.put("letters", letters());
		formatters.put("separators", separators());
		formatters.put("count", count());
		formatters.put("twodecimals", twoDecimals());
	}

	private static Formatter upperCase() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return value.toString().toUpperCase();
			}
		};
	}

	private static Formatter lowerCase() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return value.toString().toLowerCase();
			}
		};
	}


	private static Formatter camelCase() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				String[] parts = value.toString().split(" ");
				String caseString = "";
				for (String part : parts) caseString = caseString + properCase().format(part);
				return caseString;
			}
		};
	}

	private static Formatter lowerCamelCase() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				String[] parts = value.toString().split(" ");
				String caseString = "";
				for (String part : parts)
					caseString = caseString + properCase().format(part);
				return caseString.substring(0, 1).toLowerCase() + caseString.substring(1);
			}
		};
	}

	private static Formatter firstUpperCase() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1);
			}
		};
	}

	private static Formatter firstLowerCase() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return value.toString().substring(0, 1).toLowerCase() + value.toString().substring(1);
			}
		};
	}

	private static Formatter properCase() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				String s = value.toString();
				return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
			}
		};
	}

	private static Formatter year() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return new SimpleDateFormat("yyyy", Locale.ENGLISH).format((Date) value);
			}
		};
	}

	private static Formatter monthYear() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH).format((Date) value);
			}
		};
	}

	private static Formatter shortDate() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format((Date) value);
			}
		};
	}


	private static Formatter fullDate() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH).format((Date) value);
			}
		};
	}

	private static Formatter dayOfWeek() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return new SimpleDateFormat("EEEE", Locale.ENGLISH).format((Date) value);
			}
		};
	}

	private static Formatter time() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format((Date) value);
			}
		};
	}

	private static Formatter letters() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				int n = (Integer) value;
				return (words(n / 1000000, " million " + and(n % 1000000)) +
					words((n % 1000000) / 1000, " thousand " + and(n % 1000)) + words(n % 1000, "")).replace("  ", " ").trim();
			}

			private String words(int n, String ending) {
				String[] first = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
					"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
				String[] tenSet = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
				return (n == 0) ? "" : ((n >= 100) ? first[n / 100] + " hundred" + and(n % 100) : "") +
					(((n % 100) >= 20) ? tenSet[(n % 100) / 10] + " " + first[n % 10] : first[n % 20]) + ending;
			}

			private String and(int number) {
				return ((number > 0) && (number < 100)) ? " and " : "";

			}

		};
	}

	private static Formatter count() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return value;
			}
		};
	}

	private static Formatter twoDecimals() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				return String.format("%.2f", (Double) value);
			}
		};
	}

	private static Formatter separators() {
		return new Formatter() {
			@Override
			public Object format(Object value) {
				DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
				df.setGroupingUsed(true);
				df.setGroupingSize(3);
				return df.format(value);
			}
		};
	}

}
