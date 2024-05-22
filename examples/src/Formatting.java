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

import io.intino.itrules.TemplateEngine;
import io.intino.itrules.TemplateReader;
import io.intino.itrules.parser.ITRulesSyntaxError;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator.LF;
import static java.util.Locale.ENGLISH;

public class Formatting {
	public static final String Template = "ExampleFormatting.itr";

	public static void main(String[] args) throws ITRulesSyntaxError, IOException {
		TemplateReader reader = new TemplateReader(load(Template));
		var template = reader.read();
		String result = new TemplateEngine(template.rules(), new TemplateEngine.Configuration(ENGLISH, LF)).render(frame());
		System.out.println(result);
		Assertions.assertThat(result).isEqualTo(expected());
	}

	private static String expected() throws IOException {
		return new String(load(Template.replace(".itr", ".expected.txt")).readAllBytes());
	}

	private static InputStream load(String resource) {
		return Formatting.class.getResourceAsStream("/" + resource);
	}

	private static Person frame() {
		return new Person("Pau Gasol", date(1980, Calendar.JULY, 6), 213, 19285850);
	}

	private static Date date(int year, int month, int day) {
		return new GregorianCalendar(year, month, day).getTime();
	}

	public static class Person {
		private String name;
		private Date birthday;
		private int height;
		private Double salary;

		public Person(String name, Date birthday, int height, double salary) {
			this.name = name;
			this.birthday = birthday;
			this.height = height;
			this.salary = salary;
		}
	}
}