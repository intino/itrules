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

import io.intino.test.templates.FormattingTemplate;
import io.intino.test.templates.MessageTemplate;
import io.intino.test.templates.RecursiveTemplate;
import io.intino.test.templates.RosterTemplate;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TemplatesTest {
	@Test
	public void should_render_formatting_template() {
		assertThat(new FormattingTemplate().render(new Person("Pau Gasol"))).isEqualTo(
				"Name: PAU GASOL\n" +
						"BirthYear: 1980\n" +
						"\n" +
						"Height: 208 (two hundred and eight) cm\n" +
						"Salary: $240,000");
	}

	@Test
	public void should_render_messaging_template() {
		assertThat(new MessageTemplate().render(new Message("frodo@gmail.com", to("bilbo@gmail.com", "sam@yahoo.com"), "My ring", "I want my ring right now", "Otherwise I will make a new one"))).isEqualTo(
				"From: frodo@gmail.com\n" +
						"To: bilbo@gmail.com, sam@yahoo.com\n" +
						"\"My ring\"\n" +
						"\tI want my ring right now\n" +
						"\tOtherwise I will make a new one");
		assertThat(new MessageTemplate().render(new MessageTemplate().render(new Message("frodo@gmail.com", to(), null, "I want my ring right now", "Otherwise I will make a new one")))).isEqualTo(
				"From: frodo@gmail.com\n" +
						"To:\n" +
						"(No subject)\n" +
						"\tI want my ring right now\n" +
						"\tOtherwise I will make a new one");
	}

	@Test
	public void should_render_recursive_template() {
		assertThat(new RecursiveTemplate().render(composite())).isEqualTo(
				"<module name=\"X\">\n" +
						"\t<module name=\"1\">\n" +
						"\t\t<module name=\"1.1\"/>\n" +
						"\t\t<module name=\"1.2\">\n" +
						"\t\t\t<module name=\"1.2.1\"/>\n" +
						"\t\t\t<module name=\"1.2.2\"/>\n" +
						"\t\t\t<module name=\"1.2.3\"/>\n" +
						"\t\t</module>\n" +
						"\t\t<module name=\"1.3\"/>\n" +
						"\t\t<module name=\"1.4\"/>\n" +
						"\t</module>\n" +
						"\t<module name=\"2\">\n" +
						"\t\t<module name=\"2.1\"/>\n" +
						"\t\t<module name=\"2.2\"/>\n" +
						"\t\t<module name=\"2.3\"/>\n" +
						"\t\t<module name=\"2.4\"/>\n" +
						"\t\t<module name=\"2.5\"/>\n" +
						"\t\t<module name=\"2.6\"/>\n" +
						"\t</module>\n" +
						"\t<module name=\"3\">\n" +
						"\t\t<module name=\"3.1\"/>\n" +
						"\t\t<module name=\"3.2\"/>\n" +
						"\t\t<module name=\"3.3\"/>\n" +
						"\t</module>\n" +
						"\t<module name=\"4\">\n" +
						"\t\t<module name=\"4.1\"/>\n" +
						"\t\t<module name=\"4.2\"/>\n" +
						"\t</module>\n" +
						"\t<module name=\"5\"/>\n" +
						"</module>");

	}

	@Test
	public void should_render_roster_with_coach() {
		Roster roster = new Roster(
				new Person("Juan Antonio Orenga"),
				new Person("Pau Gasol"),
				new Person("Rudy Fernandez"),
				new Person("Juan Carlos Navarro")
		);
		assertThat(new RosterTemplate().render(roster)).isEqualTo(
				"<roster>\n" +
						"\t<coach name=\"Juan Antonio Orenga\">\n" +
						"\t</coach>\n" +
						"\t<players>\n" +
						"\t\t<player name=\"Pau Gasol\">\n" +
						"\t\t</player>\n" +
						"\t\t<player name=\"Rudy Fernandez\">\n" +
						"\t\t</player>\n" +
						"\t\t<player name=\"Juan Carlos Navarro\">\n" +
						"\t\t</player>\n" +
						"\t</players>\n" +
						"</roster>");
	}

	@Test
	public void should_render_roster_without_coach() {
		Roster roster = new Roster(
				null,
				new Person("Pau Gasol"),
				new Person("Rudy Fernandez"),
				new Person("Juan Carlos Navarro")
		);
		assertThat(new RosterTemplate().render(roster)).isEqualTo(
				"<roster>\n" +
						"\t<players>\n" +
						"\t\t<player name=\"Pau Gasol\">\n" +
						"\t\t</player>\n" +
						"\t\t<player name=\"Rudy Fernandez\">\n" +
						"\t\t</player>\n" +
						"\t\t<player name=\"Juan Carlos Navarro\">\n" +
						"\t\t</player>\n" +
						"\t</players>\n" +
						"</roster>");
	}

	@Test
	public void should_render_roster_with_pets() {
		Roster roster = new Roster(
				new Person("Juan Antonio Orenga", "Toby"),
				new Person("Pau Gasol", "Rex"),
				new Person("Rudy Fernandez"),
				new Person("Juan Carlos Navarro", "Alf", "Leo")
		);
		assertThat(new RosterTemplate().render(roster)).isEqualTo(
				"<roster>\n" +
						"\t<coach name=\"Juan Antonio Orenga\">\n" +
						"\t\t<pets>\n" +
						"\t\t\t<pet>Toby</pet>\n" +
						"\t\t</pets>\n" +
						"\t</coach>\n" +
						"\t<players>\n" +
						"\t\t<player name=\"Pau Gasol\">\n" +
						"\t\t\t<pets>\n" +
						"\t\t\t\t<pet>Rex</pet>\n" +
						"\t\t\t</pets>\n" +
						"\t\t</player>\n" +
						"\t\t<player name=\"Rudy Fernandez\">\n" +
						"\t\t</player>\n" +
						"\t\t<player name=\"Juan Carlos Navarro\">\n" +
						"\t\t\t<pets>\n" +
						"\t\t\t\t<pet>Alf</pet>\n" +
						"\t\t\t\t<pet>Leo</pet>\n" +
						"\t\t\t</pets>\n" +
						"\t\t</player>\n" +
						"\t</players>\n" +
						"</roster>");
	}

	private static String[] to(String... recipients) {
		return recipients;
	}

	private static Module composite() {
		return new Module("X",
				new Module("1",
						new Module("1.1"),
						new Module("1.2",
								new Module("1.2.1"),
								new Module("1.2.2"),
								new Module("1.2.3")
						),
						new Module("1.3"),
						new Module("1.4")
				),
				new Module("2",
						new Module("2.1"),
						new Module("2.2"),
						new Module("2.3"),
						new Module("2.4"),
						new Module("2.5"),
						new Module("2.6")

				),
				new Module("3",
						new Module("3.1"),
						new Module("3.2"),
						new Module("3.3")
				),
				new Module("4",
						new Module("4.1"),
						new Module("4.2")
				),
				new Module("5")
		);
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
		String name;
		LocalDate birthdate = LocalDate.of(1980, 10, 2);
		int height = 208;
		double Salary = 240000;
		String[] pets;

		public Person(String name, String... pets) {
			this.name = name;
			this.pets = pets;
		}
	}

	public static class Message {
		private String from;
		private String[] to;
		private String subject;
		private String[] body;

		public Message(String from, String[] to, String subject, String... body) {
			this.from = from;
			this.to = to;
			this.subject = subject;
			this.body = body;
		}
	}

	public static class Module {
		private String name;
		private Module[] modules;

		public Module(String name, Module... modules) {
			this.name = name;
			this.modules = modules;
		}
	}


}
