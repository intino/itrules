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

package org.siani.itrules.lang;

public class TestSources {

	public static final String NULL_FILE = "\n\n    \n\n";
	public static final String MARK = "defrule type(Class) \t \t   \t\t\n$mark ññ\n\u0015";
	public static final String MARK_WITH_FORMAT = "defrule type(Attribute) trigger(attribute+Const) type(Const)\n" +
		"public static final $name+UPPERCASE;\n" + "\u0015";
	public static final String OTHER_WITH_MARK = "defrule type(Class)\npublic class $attri alalasda $other \n" + "\u0015";
	public static final String SCAPED_CHARACTERS = "defrule type(Class) \t \t   \t\t\n$] $$ \u0015";
	public static final String SIGNATURE = "defrule type(markca) \n\u0015";
	public static final String RULE_BEGIN = "\n\ndefrule";
	public static final String RULE_WITH_MARKS = "defrule type(Attribute) trigger(attribute+Field) type(!Const) type(readonly)\npublic class $attri alalasda $other \n\u0015";
	public static final String MARK_WITH_MODIFIERS = "defrule type(Class)\npublic class $attribute+Const...[$NL] alalasda $other \n\u0015";
	public static final String MEDIUM_TEST = "defrule type(Class)\n" +
		"public class [$static ]\n\u0015";
	public static final String TWO_RULES = "defrule type(Class)\n" +
		"public class [$static ]\n" + "\u0015\n" +
		"defrule type(class2)\n" +
		"\tpublic class [$static ]\n" + "\u0015";
	public static final String RULE_WITH_EVAL = "defrule type(Class) eval(Class == 'sasa')\n" +
		"public class [$static ]\n" + "\u0015\n" +
		"defrule type(class2)\n" +
		"\tpublic class [$static ]\n" + "\u0015";
	public static final String LITTLE_BIG_TEST = "" +
		"defrule type(Class)\n" +
		"public class [$static ][$final ]$name [extends $SuperClass ][implements $Interface...[, ]]{\n" +
		"\t$attribute+Const...[$NL]\n" +
		"\t$attribute+Field...[$NL]\n" +
		"\n" +
		"\t$attribute+Getter...[$NL]\n" +
		"\n" +
		"\tpublic $Name($attribute+Injection...[,]) {\n" +
		"\t\t$attribute+Initialize...[$NL]\n" +
		"\t}\n" +
		"}\n" +
		"\u0015";
	public static final String XML_TARA = "defrule type(Theasurus)\n" +
		"<thesaurus>\n" +
		"\t$terms...[$NL]\n" +
		"</thesaurus>\n" +
		"\u0015\n" +
		"defrule type(Term)\n" +
		"<term code=\"$code\" value=\"$value\">\n" +
		"\t$terms...[$NL]\n" +
		"</term>\n" +
		"\u0015";
	public static final String XML_SMALL =
		"defrule type(Class)\n" +
			"<class name=\"$Name\" type=\"$Type\">\n" +
			"\t$superclass+Superclass\n" +
			"\t$interface+Interface...[$NL]\n" +
			"\u0015\n" +
			"defrule type(String) trigger(String+Interface)\n" +
			"<interface name=\"$value\" />\n" +
			"\u0015";
	public static final String LARGE_XML = "defrule type(Class)\n" +
		"<class name=\"$Name\" type=\"$Type\">\n" +
		"\t$superclass+Superclass\n" +
		"\t$interface+Interface...[$NL]\n" +
		"\n" +
		"</class>\n" +
		"\u0015\n" +
		"\n" +
		"defrule trigger(String+Superclass)\n" +
		"<superclass name=\"$value\" />\n" +
		"\u0015\n" +
		"defrule trigger(String+Interface)\n" +
		"<interface name=\"$value\" />\n" +
		"\u0015";

	public static final String TARA = "defrule type(declarednode)\n" +
		"\n" +
		"\t[$aggregable\n" +
		"\tpublic Definition$[$] aggregables() {\n" +
		"        return definition().aggregables();\n" +
		"    }]\n" +
		"}\n" +
		"\n" +
		"\u0015";

	public static final String[] TEST_SOURCES = new String[]{NULL_FILE, MARK, MARK_WITH_FORMAT,
		MARK_WITH_MODIFIERS, MEDIUM_TEST, OTHER_WITH_MARK, RULE_BEGIN, RULE_WITH_MARKS, SCAPED_CHARACTERS, SIGNATURE,
		TWO_RULES, XML_TARA, LITTLE_BIG_TEST, LARGE_XML, LARGE_XML, TARA};

}
