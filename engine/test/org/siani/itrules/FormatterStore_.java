package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.engine.FormatterIndex;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class FormatterStore_ {

    @Test
    public void should_render_in_uppercase() throws Exception {
        assertEquals("HELLO WORLD", formatter("UpperCase").format("Hello world"));
    }

    @Test
    public void should_render_in_lowercase() throws Exception {
        assertEquals("hello world", formatter("LowerCase").format("Hello world"));
    }

    @Test
    public void should_render_in_uppercase_first_letter() throws Exception {
        assertEquals("Hello world", formatter("FirstUpperCase").format("hello world"));
    }

    @Test
    public void should_render_in_lowercase_first_letter() throws Exception {
        assertEquals("hello world", formatter("FirstLowerCase").format("Hello world"));
    }

    @Test
    public void should_render_in_camelcase() throws Exception {
        assertEquals("HelloWorld", formatter("CamelCase").format("Hello world"));
    }

    @Test
    public void should_render_in_lower_camelcase() throws Exception {
        assertEquals("helloWorld", formatter("LowerCamelCase").format("Hello world"));
    }

    @Test
    public void should_render_a_year() throws Exception {
        assertEquals(1950, formatter("Year").format(date(1950, Calendar.JANUARY, 20)));
    }

    @Test
    public void should_render_short_date() throws Exception {
        assertEquals("20/01/1950", formatter("ShortDate").format(date(1950, Calendar.JANUARY, 20)));
    }

    @Test
    public void should_render_time() throws Exception {
        assertEquals("10:32", formatter("Time").format(date(1950, Calendar.JANUARY, 20, 10, 32)));
    }

    @Test
    public void should_render_a_number_in_letters() throws Exception {
        assertEquals("one thousand nine hundred and fifty", formatter("Words").format(1950));
    }

    @Test
    public void should_render_a_number_in_spanish_letters() throws Exception {
        assertEquals("mil novecientos cincuenta", spanishFormatter("Words").format(1950));
    }

    @Test
    public void should_render_a_number_with_separators() throws Exception {
        assertEquals("1,950", formatter("Separators").format(1950));
    }

    @Test
    public void should_render_a_number_with_two_decimals() throws Exception {
        assertEquals("1950.00", formatter("TwoDecimals").format(1950.0));
    }

    @Test
    public void should_render_letter_counts() throws Exception {
        assertEquals("5", formatter("Length").format("Hello"));
    }

    private Formatter formatter(String name) {
        return new FormatterIndex(Locale.ENGLISH).get(name);
    }

    private Formatter spanishFormatter(String name) {
        return new FormatterIndex(new Locale("es", "Spain", "es_ES")).get(name);
    }

    private Date date(int year, int month, int day) {
        return new GregorianCalendar(year, month, day).getTime();
    }

    private Date date(int year, int month, int day, int hour, int minutes) {
        return new GregorianCalendar(year, month, day, hour, minutes).getTime();
    }


}
