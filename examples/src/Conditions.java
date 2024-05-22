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

import io.intino.itrules.Engine;
import io.intino.itrules.TemplateReader;
import io.intino.itrules.parser.ITRulesSyntaxError;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.io.InputStream;

public class Conditions {
	public static final String Template = "ExampleConditions.itr";

	public static void main(String[] args) throws ITRulesSyntaxError, IOException {
		TemplateReader reader = new TemplateReader(load(Template));
		var template = reader.read();
		String result = new Engine(template).render(frame());
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
		return new Person("Pau Gasol",
				new Person.Dog("Ruffo", 5),
				new Person.Cat("Missy", 1),
				new Person.Dog(3)
		);
	}

	public static class Person {
		private String name;
		private Pet[] pets;

		public Person(String name, Pet... pets) {
			this.name = name;
			this.pets = pets;
		}

		public static abstract class Pet {
			private String name;
			private int age;

			public Pet(String name, int age) {
				this.name = name;
				this.age = age;
			}
		}

		public static class Dog extends Pet {
			public Dog(int age) {
				this(null, age);
			}

			public Dog(String name, int age) {
				super(name, age);
			}
		}

		public static class Cat extends Pet {
			public Cat(String name, int age) {
				super(name, age);
			}
		}
	}
}