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
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator.LF;
import static java.util.Locale.ENGLISH;

public class OptionalAttributes {
	public static final String Template = "ExampleOptionalAttributes.itr";

	public static void main(String[] args) throws ITRulesSyntaxError, IOException {
		TemplateReader reader = new TemplateReader(load(Template));
		var template = reader.read();
		Assert.assertNotNull(template.rules());
		String result = new TemplateEngine(template.rules(), new TemplateEngine.Configuration(ENGLISH, LF)).render(frame());
		System.out.println(result);
		Assertions.assertThat(result).isEqualTo(expected());
	}

	private static String expected() throws IOException {
		return new String(load(Template.replace(".itr", ".expected.txt")).readAllBytes());
	}

	private static InputStream load(String resource) {
		return OptionalAttributes.class.getResourceAsStream("/" + resource);
	}

	private static Roster frame() {
		return new Roster(
				new Person("Juan Antonio Orenga", date(1966, Calendar.JULY, 29), "Spain"),
				new Person("Pau Gasol", date(1980, Calendar.JULY, 6), "Spain", "L.A. Lakers"),
				new Person("Rudy Fernandez", date(1985, Calendar.APRIL, 4), "Spain"),
				new Person("Juan Carlos Navarro", date(1980, Calendar.JUNE, 17), "Spain")
		);
	}

	private static Date date(int year, int month, int day) {
		return new GregorianCalendar(year, month, day).getTime();
	}

	public static class Roster {
		private Person coach;
		private Person[] players;

		public Roster(Person coach, Person... players) {
			this.coach = coach;
			this.players = players;
		}
	}

	public static class Person {
		private String name;
		private Date birthday;
		private String country;
		private String club;

		public Person(String name, Date birthday, String country) {
			this(name, birthday, country, null);
		}

		public Person(String name, Date birthday, String country, String club) {
			this.name = name;
			this.birthday = birthday;
			this.country = country;
			this.club = club;
		}

	}

}
