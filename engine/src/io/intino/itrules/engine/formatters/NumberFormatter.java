package io.intino.itrules.engine.formatters;

import io.intino.itrules.Formatter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class NumberFormatter {

    public static Map<String, Formatter> get(Locale locale) {
        Map<String, Formatter> map = new HashMap<>();
        map.put("Words".toLowerCase(), new NumberSpellingFormatter(locale));
        map.put("Separators".toLowerCase(), separators(locale));
        map.put("TwoDecimals".toLowerCase(), twoDecimals(locale));
        return map;
    }

    public static Formatter separators(final Locale locale) {
        return value -> {
            if (!isNumber(value)) return value;
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            df.setGroupingUsed(true);
            df.setGroupingSize(3);
            return df.format(value);
        };
    }

    public static Formatter twoDecimals(final Locale locale) {
        return value -> {
            if (!isNumber(value)) return value;
            double n = ((Number) value).doubleValue();
            return String.format(locale, "%.2f", n);
        };
    }

    private static boolean isNumber(Object value) {
        return Number.class.isAssignableFrom(value.getClass());
    }
}
