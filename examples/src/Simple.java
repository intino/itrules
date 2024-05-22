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
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.TemplateReader;
import io.intino.itrules.parser.ITRulesSyntaxError;
import org.assertj.core.api.Assertions;
import org.junit.Assert;

import java.io.InputStream;

public class Simple {
	public static final String Template = "ExampleSimple.itr";

	public static void main(String[] args) throws ITRulesSyntaxError {
		TemplateReader reader = new TemplateReader(load(Template));
		var template = reader.read();
		Assert.assertNotNull(template);
		String result = new Engine(template).render(frame());
		System.out.println(result);
		Assertions.assertThat(result).isEqualTo("textpublisher(String text)");
	}

	private static InputStream load(String resource) {
		return Formatting.class.getResourceAsStream("/" + resource);
	}

	public static FrameBuilder frame() {
		return new FrameBuilder().add("Publisher").add("name", "textPublisher")
				.add("measurements", new FrameBuilder("Measurement").add("datatype", "String").add("value", "text"));
	}
}
