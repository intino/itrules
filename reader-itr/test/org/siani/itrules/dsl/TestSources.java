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

package org.siani.itrules.dsl;

public class TestSources {

	public static final String MARK = "def type(Class) \t \t   \t\t\n$mark ññ\nend";
	public static final String MARK_WITH_FORMAT = "def type(Attribute) trigger(attribute+Const) type(Const)\n" +
		"\tpublic static final $name+UPPERCASE;\n" + "end";
	public static final String OTHER_WITH_MARK =
		"def type(Class)\n" +
			"\tpublic class $attri alalasda $other \n" +
			"end";
	public static final String ESCAPED_CHARACTERS =
		"def type(Class) \n" +
			"\t \t   \t\t\n" +
			"\t$] $$ \n" +
			"end";

	public static final String FUNCTION_WITHOUT_PARAMETERS = "def one() trigger(Age)\n" +
		"    one year old\n" +
		"end";

	public static final String EXPRESION_WITH_NEW_LINES = "def type(nodeimpl)\n" +
		"    public\n" +
		"        [$aggregable\n" +
		"        public Definition$[$] aggregables() {\n" +
		"        }]\n" +
		"end\n";
	public static final String SIGNATURE = "def type(markca)\n\n\nend";
	public static final String RULE_BEGIN = "\n\ndef";
	public static final String RULE_WITH_MARKS = "def type(Attribute) trigger(attribute+Field) type(!Const) type(readonly)\npublic class $attri alalasda $other \nend";
	public static final String RULE_WITH_OR_EXPRESSIONS = "def type(Attribute) trigger(attribute+Field) type(!Const) type(readonly)\n" +
		"<coach name=\"$Name\" [<NotExist $NotExist>?$None !!!?/>]\nend";
	public static final String MARK_WITH_MODIFIERS = "def type(Class)\npublic class $attribute+Const...[$NL] alalasda $other \nend";
	public static final String CURL_SEPARATOR = "def trigger(node)\n" +
		"    $name+firstUpperCase~Intention$[] a\n" +
		"end";
	public static final String MEDIUM_TEST = "def type(Class)\n" +
		"\tpublic class [$static ]\nend";
	public static final String TWO_RULES = "def type(Class)\n" +
		"\tpublic class [$static~A ]\n" + "end\n" +
		"def type(class2)\n" +
		"\tpublic class [$static ]\n" + "end";
	public static final String RULE_WITH_EVAL = "def type(Class) eval(Class == 'sasa')\n" +
		"public class [$static ]\n" + "end\n" +
		"def type(class2)\n" +
		"\tpublic class [$static ]\n" + "end";
	public static final String ITRULES_TEST = "def type(token) type(mark) trigger(token)\n" +
		"\t.add(mark(\"$name\"[, $options...[, ]])[.multiple(\"$separator\")])\n" +
		"end";
	public static final String LITTLE_BIG_TEST = "" +
		"def type(Class)\n" +
		"\tpublic class [$static ][$final ]$name [extends $SuperClass ][implements $Interface...[, ]]{\n" +
		"\t\t$attribute+Const...[$NL]\n" +
		"\t\t$attribute+Field...[$NL]\n" +
		"\t\n" +
		"\t\t$attribute+Getter...[$NL]\n" +
		"\t\n" +
		"\t\tpublic $Name($attribute+Injection...[,]) {\n" +
		"\t\t\t$attribute+Initialize...[$NL]\n" +
		"\t\t}\n" +
		"\t}\n" +
		"end";


	public static final String XML_TARA = "def type(Theasurus)\n" +
		"\t<thesaurus>\n" +
		"\t\t$terms...[$NL]\n" +
		"\t</thesaurus>\n" +
		"end\n" +
		"def type(Term)\n" +
		"\t<term code=\"$code\" value=\"$value\">\n" +
		"\t\t$terms...[$NL]\n" +
		"\t</term>\n" +
		"end";
	public static final String XML_SMALL =
		"def type(Class)\n" +
			"\t<class name=\"$Name\" type=\"$Type\">\n" +
			"\t\t$superclass+Superclass\n" +
			"\t\t$interface+Interface...[$NL]\n" +
			"end\n" +
			"def type(String) trigger(String+Interface)\n" +
			"\t<interface name=\"$value\" />\n" +
			"end";
	public static final String LARGE_XML = "def type(Class)\n" +
		"\t<class name=\"$Name\" type=\"$Type\">\n" +
		"\t\t$superclass+Superclass\n" +
		"\t\t$interface+Interface...[$NL]\n" +
		"\n" +
		"\t</class>\n" +
		"end\n" +
		"\n" +
		"def trigger(String+Superclass)\n" +
		"\t<superclass name=\"$value\" />\n" +
		"end\n" +
		"def trigger(String+Interface)\n" +
		"\t<interface name=\"$value\" />\n" +
		"end";

}
