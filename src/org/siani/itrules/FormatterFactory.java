package org.siani.itrules;

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

}
