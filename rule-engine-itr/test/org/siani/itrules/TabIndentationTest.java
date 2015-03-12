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

package org.siani.itrules;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.reader.DedentInputStream;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TabIndentationTest {

	@Test
	public void rulesWithoutIndentation() {
		DedentInputStream stream = new DedentInputStream(getInputStream("/dedent/files/NoIndentation.itr"));
		Assert.assertEquals(passInputStreamToString(getInputStream
                ("/dedent/expected/NoIndentationExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void removesOneIndentationLevel() {
		DedentInputStream stream =
			new DedentInputStream(getInputStream("/dedent/files/EqualIndentation.itr"));

		Assert.assertEquals(passInputStreamToString(getInputStream
                ("/dedent/expected/NoIndentationExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void removeOneIndentationLevelForLinesWithDifferentOnes() {
		DedentInputStream stream = new DedentInputStream
			(getInputStream("/dedent/files/DifferentIndentationLevel.itr"));

		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/DifferentIndentationLevelExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void differentIndentationLevelWhereFirstLineHasNotIndentation() {
		DedentInputStream stream = new DedentInputStream
			(getInputStream("/dedent/files/FirstLineWithoutIndentation.itr"));

		assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/FirstLineWithoutIndentationExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void removeWithLevelTwoOfIndentation() {
		DedentInputStream stream = new DedentInputStream
			(getInputStream("/dedent/files/TwoIndentationLevel.itr"));

		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/TwoIndentationLevelExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void removeWithLevelFourOfIndentation() {
		DedentInputStream stream = new DedentInputStream
			(getInputStream("/dedent/files/FourIndentationLevel.itr"));

		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/FourIndentationLevelExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void dedentpectEmptyLinesTest() {
		DedentInputStream stream = new DedentInputStream
			(getInputStream("/dedent/files/RuleWithEmptyLines.itr"));

		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/RuleWithEmptyLinesExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void firstRuleContentLineIsEmpty() {
		DedentInputStream stream = new DedentInputStream
			(getInputStream("/dedent/files/FirstContentRuleLineEmpty.itr"));

		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/FirstContentRuleLineEmptyExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void dedentTwoRulesInSameFile() {
		DedentInputStream stream = new DedentInputStream
			(getInputStream("/dedent/files/TwoRules.itr"));
		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/TwoRulesExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void dedentJavaClassItRulesExample() {
		DedentInputStream stream = new DedentInputStream(getInputStream("/dedent/files/java_class.itr"));
		assertEquals(passInputStreamToString(getInputStream("/dedent/expected" +
                "/java_classExpected.itr")), new String(stream.getContent()));
	}

	@Test
	public void testMiddleEarth() throws Exception {
		DedentInputStream stream = new DedentInputStream(getInputStream("/dedent/files/in_middle_earth.itr"));
		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/files/in_middle_earth.itr")), new String(stream.getContent()));
	}

	@Test
	public void testRoster() throws Exception {
		DedentInputStream stream = new DedentInputStream(getInputStream("/dedent/files/roster.itr"));
		Assert.assertEquals(passInputStreamToString(getInputStream("/dedent/expected/roster.itr")), new String(stream.getContent()));
	}

	private String passInputStreamToString(InputStream inputStream) throws NullPointerException {
		Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
		String dedentult = scanner.hasNext() ? scanner.next() : "";
		scanner.close();
		return dedentult;
	}

	private InputStream getInputStream(String fileName) {
		return this.getClass().getResourceAsStream(fileName);
	}
}
