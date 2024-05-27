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

package io.intino.test;

import io.intino.itrules.Formatter;
import io.intino.itrules.formatters.DateFormatters;
import io.intino.itrules.formatters.NumberFormatters;
import io.intino.itrules.formatters.StringFormatters;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class FormattersTest {

	@Test
	public void should_format_in_uppercase() {
		assertThat(formatter("UpperCase").format("Hello world")).isEqualTo("HELLO WORLD");
	}

	@Test
	public void should_format_in_lowercase() {
		assertThat(formatter("LowerCase").format("Hello world")).isEqualTo("hello world");
	}

	@Test
	public void should_format_in_uppercase_first_letter() {
		assertThat(formatter("FirstUpperCase").format("hello world")).isEqualTo("Hello world");
	}

	@Test
	public void should_format_in_lowercase_first_letter() {
		assertThat(formatter("FirstLowerCase").format("Hello world")).isEqualTo("hello world");
	}

	@Test
	public void should_format_in_camelcase() {
		assertThat(formatter("CamelCase").format("Hello world")).isEqualTo("helloWorld");
	}

	@Test
	public void should_remove_non_letters() {
		assertThat(formatter("OnlyLetters").format("Hello world")).isEqualTo("Helloworld");
	}

	@Test
	public void should_remove_non_digits() {
		assertThat(formatter("OnlyDigits").format("1990/12/01")).isEqualTo("19901201");
	}

	@Test
	public void should_remove_non_digits_and_letters() {
		assertThat(formatter("OnlyDigitsAndLetters").format("M 1990/12/01")).isEqualTo("M19901201");
	}

	@Test
	public void should_format_a_year() {
		assertThat(formatter("Year").format(LocalDate.of(1950, 1, 20))).isEqualTo("1950");
	}

	@Test
	public void should_format_a_year_month() {
		assertThat(formatter("YearMonth").format(LocalDate.of(1950, 1, 20))).isEqualTo("195001");
	}

	@Test
	public void should_format_a_year_month_day() {
		assertThat(spanishFormatter("YearMonthDay").format(LocalDate.of(1950, 1, 20))).isEqualTo("19500120");
	}

	@Test
	public void should_format_a_year_month_day_time() {
		assertThat(spanishFormatter("YearMonthDayTime").format(LocalDateTime.of(1950, 1, 20, 10, 10, 0))).isEqualTo("19500120101000");
	}

	@Test
	public void should_format_short_date() {
		assertThat(formatter("ShortDate").format(LocalDate.of(1950, 1, 20))).isEqualTo("20/01/1950");
	}

	@Test
	public void should_format_full_date() {
		assertThat(formatter("FullDate").format(LocalDate.of(1950, 1, 20))).isEqualTo("Friday, 20 January 1950");
	}

	@Test
	public void should_format_full_date_in_spanish() {
		assertThat(spanishFormatter("FullDate").format(LocalDate.of(1950, 1, 20))).isEqualTo("viernes, 20 enero 1950");
	}

	@Test
	public void should_format_compact_date() {
		assertThat(formatter("CompactDate").format(LocalDate.of(1950, 1, 20))).isEqualTo("Fri, 20 Jan 1950");
	}

	@Test
	public void should_format_compact_date_in_spanish() {
		assertThat(spanishFormatter("CompactDate").format(LocalDate.of(1950, 1, 20))).isEqualTo("vie, 20 ene 1950");
	}

	@Test
	public void should_format_american_compact_date() {
		assertThat(formatter("AmericanCompactDate").format(LocalDate.of(1950, 1, 20))).isEqualTo("Jan, 20 1950");
	}

	@Test
	public void should_format_american_date() {
		assertThat(formatter("AmericanDate").format(LocalDate.of(1950, 1, 20))).isEqualTo("January, 20 1950");
	}

	@Test
	public void should_format_day_of_week() {
		assertThat(formatter("DayOfWeek").format(LocalDate.of(1950, 1, 20))).isEqualTo("Friday");
	}

	@Test
	public void should_format_day_of_week_in_spanish() {
		assertThat(spanishFormatter("DayOfWeek").format(LocalDate.of(1950, 1, 20))).isEqualTo("viernes");
	}

	@Test
	public void should_format_local_datetime() {
		assertThat(formatter("Time").format(LocalDateTime.of(1950, 1, 20, 10, 32))).isEqualTo("10:32");
	}

	@Test
	public void should_format_zoned_datetime() {
		assertThat(formatter("Time").format(LocalDateTime.of(1950, 1, 20, 10, 32).atZone(ZoneId.of("America/Montreal")))).isEqualTo("10:32");
	}

	@Test
	public void should_format_a_number_in_letters() {
		assertThat(formatter("Words").format(1950)).isEqualTo("one thousand nine hundred and fifty");
	}

	@Test
	public void should_format_a_number_in_spanish_letters() {
		assertThat(spanishFormatter("Words").format(1950)).isEqualTo("mil novecientos cincuenta");
	}

	@Test
	public void should_format_a_number_with_separators() {
		assertThat(formatter("Separators").format(1950)).isEqualTo("1,950");
	}

	@Test
	public void should_format_a_number_with_two_decimals() {
		assertThat(formatter("TwoDecimals").format(1950.0)).isEqualTo("1950.00");
	}

	@Test
	public void should_format_letter_counts() {
		assertThat(formatter("Length").format("Hello")).isEqualTo("5");
	}

	private static Map<String, Formatter> formatters(Locale locale) {
		Map<String, Formatter> map = new HashMap<>();
		map.putAll(StringFormatters.get(locale));
		map.putAll(DateFormatters.get(locale));
		map.putAll(NumberFormatters.get(locale));
		return map;
	}

	private Formatter formatter(String name) {
		return formatters(Locale.ENGLISH).get(name.toLowerCase());
	}

	private Formatter spanishFormatter(String name) {
		return formatters(spanish()).get(name.toLowerCase());
	}

	private Locale spanish() {
		return new Locale("es", "Spain", "es_ES");
	}
}