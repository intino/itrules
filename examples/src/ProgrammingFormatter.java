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

import java.io.InputStream;

import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator.LF;
import static java.util.Locale.ENGLISH;

public class ProgrammingFormatter {
	public static final String Template = "ProgrammingFormatter.itr";

	public static void main(String[] args) throws ITRulesSyntaxError {
		TemplateReader reader = new TemplateReader(load(Template));
		var template = reader.read();
		Assert.assertNotNull(template.rules());
		String result = new TemplateEngine(template.rules(), new TemplateEngine.Configuration(ENGLISH, LF))
				.add("reverse", value -> new StringBuilder(value.toString()).reverse().toString())
				.render(frame());
		System.out.println(result);
		Assertions.assertThat(result).isEqualTo("losag uap");
	}

	private static InputStream load(String resource) {
		return Formatting.class.getResourceAsStream("/" + resource);
	}

	private static Person frame() {
		return new Person("Pau Gasol");
	}

	public static class Person {
		private final String name;

		public Person(String name) {
			this.name = name;
		}
	}
}