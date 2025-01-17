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

package io.intino.itrules.dsl;

import io.intino.itrules.TemplateReader;
import io.intino.itrules.parser.ITRulesSyntaxError;
import io.intino.itrules.serializer.TemplateSerializer;
import io.intino.itrules.template.Template;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Locale;

public class TemplateGenerationTest {


	@Test
	public void should_serialize_java_representation() throws ITRulesSyntaxError {
		TemplateSerializer serializer = new TemplateSerializer("containerTest", "io.intino", Locale.getDefault(), Template.Configuration.LineSeparator.LF);
		TemplateReader reader = new TemplateReader(new ByteArrayInputStream(TestSources.CONTAINER_TEST.getBytes()));
		Template template = reader.read();
		System.out.println(serializer.toJava(template));

	}
}
