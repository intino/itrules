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
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;

public class Recursive {
	public static final String Template = "ExampleRecursive.itr";

	public static void main(String[] args) throws ITRulesSyntaxError, IOException {
		TemplateReader reader = new TemplateReader(load(Template));
		var template = reader.read();
		Assert.assertNotNull(template);
		String result = new Engine(template).render(frame());
		System.out.println(result);
		Assertions.assertThat(result).isEqualTo(expected());
	}

	private static String expected() throws IOException {
		return new String(load(Template.replace(".itr", ".expected.txt")).readAllBytes());
	}

	private static InputStream load(String resource) {
		return Recursive.class.getResourceAsStream("/" + resource);
	}

	private static Module frame() {
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

	public static class Module {
		private String name;
		private Module[] modules;

		public Module(String name, Module... modules) {
			this.name = name;
			this.modules = modules;
		}
	}

}
