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
import org.siani.itrules.reader.itr.DedentInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AcceptedDedentInputStream {

    private String[] cases = {
           "JavaClass",
            "InMiddleEarth",
            "Roster"

    };

	@Test
	public void should_do_nothing_when_no_indentation() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/NoIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/NoIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_same_indentation() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/SameIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/SameIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_keep_indentation() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/KeepIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/KeepIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_do_nothing_when_first_line_is_not_indented() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/FirstLineWithoutIndentation.itr"));
        InputStream expected = inputStream("/dedent/expected/FirstLineWithoutIndentation.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_one_level_when_two_levels() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/TwoIndentationLevel.itr"));
        InputStream expected = inputStream("/dedent/expected/TwoIndentationLevel.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_one_level_when_four_levels() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/FourIndentationLevel.itr"));
        InputStream expected = inputStream("/dedent/expected/FourIndentationLevel.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_empty_lines_exists() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/EmptyLines.itr"));
        InputStream expected = inputStream("/dedent/expected/EmptyLines.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_first_line_is_empty() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/FirstLineEmpty.itr"));
        InputStream expected = inputStream("/dedent/expected/FirstLineEmpty.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_when_two_rules() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/TwoRules.itr"));
        InputStream expected = inputStream("/dedent/expected/TwoRules.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_java_class_case() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/JavaClass.itr"));
        InputStream expected = inputStream("/dedent/expected/JavaClass.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_roster_case() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/Roster.itr"));
        InputStream expected = inputStream("/dedent/expected/Roster.itr");
        assertEquals(text(expected), text(actual));
	}

	@Test
	public void should_dedent_middle_earth_case() {
        InputStream actual = new DedentInputStream(inputStream("/dedent/source/InMiddleEarth.itr"));
        InputStream expected = inputStream("/dedent/expected/InMiddleEarth.itr");
        assertEquals(text(expected), text(actual));
	}

    private InputStream inputStream(String fileName) {
        return this.getClass().getResourceAsStream(fileName);
    }

    private String text(InputStream inputStream) throws NullPointerException {
		Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
		String result = scanner.hasNext() ? scanner.next() : "";
		scanner.close();
		return result;
	}


}
