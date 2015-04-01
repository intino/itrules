/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.siani.itrules.reader.itr;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;

public class AcceptedDedentInputStream {

    private String[] cases = {
           "JavaClass",
            "InMiddleEarth",
            "Roster"

    };

	@Test
	public void should_do_nothing_when_no_indentation() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/NoIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/NoIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_same_indentation() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/SameIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/SameIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_keep_indentation() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/KeepIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/KeepIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_do_nothing_when_first_line_is_not_indented() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/FirstLineWithoutIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/FirstLineWithoutIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_one_level_when_two_levels() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/TwoIndentationLevel.itr"));
        InputStream expected = inputStream("/dedent/expected/TwoIndentationLevel.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_one_level_when_four_levels() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/FourIndentationLevel.itr"));
        InputStream expected = inputStream("/dedent/expected/FourIndentationLevel.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_empty_lines_exists() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/EmptyLines.itr"));
        InputStream expected = inputStream("/dedent/expected/EmptyLines.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_first_line_is_empty() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/FirstLineEmpty.itr"));
        InputStream expected = inputStream("/dedent/expected/FirstLineEmpty.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_two_rules() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/TwoRules.itr"));
        InputStream expected = inputStream("/dedent/expected/TwoRules.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_java_class_case() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/JavaClass.itr"));
        InputStream expected = inputStream("/dedent/expected/JavaClass.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_roster_case() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/Roster.itr"));
        InputStream expected = inputStream("/dedent/expected/Roster.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_do_nothing_in_middle_earth_case() throws IOException {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/InMiddleEarth.itr"));
        InputStream expected = inputStream("/dedent/expected/InMiddleEarth.itr");
        assertEquals(text(expected), text(actual));
	}

    private InputStream inputStream(String fileName) {
        return this.getClass().getResourceAsStream(fileName);
    }

    private String text(InputStream inputStream) throws NullPointerException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String result = "";
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            result += line + "\n";
        }
        reader.close();
        return result;
	}


}
