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

import io.intino.itrules.FrameBuilder;
import io.intino.itrules.TemplateEngine;
import io.intino.itrules.TemplateEngine.Configuration;
import io.intino.itrules.TemplateReader;
import io.intino.itrules.parser.ITRulesSyntaxError;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;

import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator.LF;
import static java.util.Locale.ENGLISH;

public class Api {

	public static final String Template = "Api.itr";

	public static void main(String[] args) throws ITRulesSyntaxError, IOException {
		TemplateReader reader = new TemplateReader(load(Template));
		var template = reader.read();
		Assert.assertNotNull(template.rules());
		String result = new TemplateEngine(template.rules(), new Configuration(ENGLISH, LF))
				.add("className", Object::toString).render(frame());
		Assertions.assertThat(result).isEqualTo(expected());
	}

	private static String expected() throws IOException {
		return new String(load(Template.replace(".itr", ".expected.txt")).readAllBytes());
	}

	private static InputStream load(String resource) {
		return Api.class.getResourceAsStream("/" + resource);
	}

	public static FrameBuilder frame() {
		return new FrameBuilder().add("api").add("service")
				.add("basepath", "/api")
				.add("resource", booksResource())
				.add("resource", bookResource())
				.add("schema", bookInputSchema())
				.add("schema", bookSchema());
	}

	private static FrameBuilder booksResource() {
		return new FrameBuilder("resource")
				.add("name", "books")
				.add("operation", getBooksOperation())
				.add("operation", postBooksOperation());
	}

	private static FrameBuilder bookResource() {
		return new FrameBuilder("resource")
				.add("name", "books")
				.add("operation", getBookOperation())
				.add("operation", putBookOperation());
	}

	private static FrameBuilder bookInputSchema() {
		return new FrameBuilder("schema")
				.add("name", "BookInput")
				.add("attribute", attribute("title", "String", true))
				.add("attribute", attribute("authorId", "Integer", true))
				.add("attribute", attribute("publicationDate", "java.util.Date", false))
				.add("attribute", attribute("genre", "String", false));
	}

	private static FrameBuilder bookSchema() {
		return new FrameBuilder("schema")
				.add("name", "Book")
				.add("attribute", attribute("id", "Integer", true))
				.add("attribute", attribute("title", "String", true))
				.add("attribute", attribute("authorId", "Integer", true))
				.add("attribute", attribute("publicationDate", "java.util.Date", true))
				.add("attribute", attribute("genre", "String", true));
	}

	private static FrameBuilder attribute(String name, String type, boolean required) {
		return new FrameBuilder("attribute", type, required ? "required" : "optional")
				.add("name", name)
				.add("type", type);
	}

	private static FrameBuilder getBooksOperation() {
		return new FrameBuilder()
				.add("path", "/books")
				.add("method", "get")
				.add("resource", "books");
	}

	private static FrameBuilder postBooksOperation() {
		return new FrameBuilder()
				.add("path", "/books")
				.add("method", "post")
				.add("resource", "books");
	}

	private static FrameBuilder getBookOperation() {
		return new FrameBuilder()
				.add("path", "/book")
				.add("method", "get")
				.add("resource", "books")
				.add("parameter", parameter("id", "integer", "path", true));
	}

	private static FrameBuilder putBookOperation() {
		return new FrameBuilder()
				.add("path", "/book")
				.add("method", "put")
				.add("resource", "book")
				.add("parameter", parameter("id", "integer", "path", true))
				.add("parameter", parameter("bookInput", "BookInput", "body", true));
	}

	private static FrameBuilder parameter(String name, String type, String in, boolean required) {
		return new FrameBuilder("parameter", type, required ? "required" : "optional")
				.add("name", name)
				.add("type", type)
				.add("in", in);
	}
}