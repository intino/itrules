package org.siani.itrules.engine.formatters;

import org.siani.itrules.Formatter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DateFormatter {

    public static Map<String, Formatter> get(Locale locale) {
        Map<String,Formatter> map = new HashMap<>();
        map.put("Year".toLowerCase(), year());
        map.put("MonthYear".toLowerCase(), monthYear(locale));
        map.put("ShortDate".toLowerCase(), shortDate(locale));
        map.put("FullDate".toLowerCase(), fullDate(locale));
        map.put("DayOfWeek".toLowerCase(), dayOfWeek(locale));
        map.put("Time".toLowerCase(), time(locale));
        return map;
    }

    private static Formatter year() {
        return new Formatter() {
            @SuppressWarnings("deprecation")
            @Override
            public Object format(Object value) {
                return value instanceof Date ? ((Date)value).getYear() + 1900 : value;
            }
        };
    }


    private static Formatter monthYear(final Locale locale) {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return formatDate(value, "MMMM yyyy", locale);
            }
        };
    }

    private static Formatter shortDate(final Locale locale) {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return formatDate(value, "dd/MM/yyyy", locale);
            }
        };
    }

    private static Formatter fullDate(final Locale locale) {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return formatDate(value, "dd MMMM yyyy", locale);
            }
        };
    }

    private static Formatter dayOfWeek(final Locale locale) {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return formatDate(value, "EEEE", locale);
            }
        };
    }

    private static Formatter time(final Locale locale) {
        return new Formatter() {
            @Override
            public Object format(Object value) {
                return formatDate(value, "HH:mm", locale);
            }
        };
    }

    private static Object formatDate(Object value, String format, final Locale locale) {
        return value instanceof Date ?
                new SimpleDateFormat(format, locale).format((Date) value) : value;
    }
}
