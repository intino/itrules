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

import io.intino.alexandria.Json;
import io.intino.itrules.Engine;
import io.intino.itrules.TemplateReader;
import io.intino.itrules.parser.ITRulesSyntaxError;
import org.assertj.core.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MultivaluedAttributes {
	public static final String Template = "ExampleMultivaluedAttributes.itr";

	public static void main(String[] args) throws ITRulesSyntaxError, IOException {
		Message message = message();
		System.out.println(Json.toJson(message));
		TemplateReader reader = new TemplateReader(load(Template));
		String result = new Engine(reader.read()).render(message);
		System.out.println(result);
		Assertions.assertThat(result).isEqualTo(expected());
	}

	private static String expected() throws IOException {
		return new String(load(Template.replace(".itr", ".expected.txt")).readAllBytes());
	}

	private static InputStream load(String resource) {
		return MultivaluedAttributes.class.getResourceAsStream("/" + resource);
	}

	private static Message message() {
		return new Message("frodo@hobbiton.me", "gandalf@elrond.me", "bilbo@hobbiton.me")
				.subject("The ring")
				.addLine("I wish the Ring had never come to me.")
				.addLine("I wish none of this had happened.");
	}

	public static class Message {
		private final String from;
		private final String[] to;
		private String subject;
		private final List<String> line = new ArrayList<>();

		public Message(String from, String... to) {
			this.from = from;
			this.to = to;
		}

		public Message subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Message addLine(String line) {
			this.line.add(line);
			return this;
		}

	}

}
