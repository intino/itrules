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

	public static final String MARK = "defrule type(Class) \t \t   \t\t\n$mark ññ\nendrule";
	public static final String MARK_WITH_FORMAT = "defrule type(Attribute) trigger(attribute+Const) type(Const)\n" +
		"\tpublic static final $name+UPPERCASE;\n" + "endrule";
	public static final String OTHER_WITH_MARK =
		"defrule type(Class)\n" +
			"\tpublic class $attri alalasda $other \n" +
			"endrule";
	public static final String ESCAPED_CHARACTERS =
		"defrule type(Class) \n" +
			"\t \t   \t\t\n" +
			"\t$] $$ \n" +
			"endrule";

	public static final String FUNCTION_WITHOUT_PARAMETERS = "defrule one() trigger(Age)\n" +
		"    one year old\n" +
		"endrule";

	public static final String EXPRESION_WITH_NEW_LINES = "defrule type(nodeimpl)\n" +
		"    public\n" +
		"        [$aggregable\n" +
		"        public Definition$[$] aggregables() {\n" +
		"        }]\n" +
		"endrule\n";
	public static final String SIGNATURE = "defrule type(markca)\n\n\nendrule";
	public static final String RULE_BEGIN = "\n\ndefrule";
	public static final String RULE_WITH_MARKS = "defrule type(Attribute) trigger(attribute+Field) type(!Const) type(readonly)\npublic class $attri alalasda $other \nendrule";
	public static final String MARK_WITH_MODIFIERS = "defrule type(Class)\npublic class $attribute+Const...[$NL] alalasda $other \nendrule";
	public static final String MEDIUM_TEST = "defrule type(Class)\n" +
		"\tpublic class [$static ]\nendrule";
	public static final String TWO_RULES = "defrule type(Class)\n" +
		"\tpublic class [$static~A ]\n" + "endrule\n" +
		"defrule type(class2)\n" +
		"\tpublic class [$static ]\n" + "endrule";
	public static final String RULE_WITH_EVAL = "defrule type(Class) eval(Class == 'sasa')\n" +
		"public class [$static ]\n" + "endrule\n" +
		"defrule type(class2)\n" +
		"\tpublic class [$static ]\n" + "endrule";
	public static final String ITRULES_TEST = "defrule type(token) type(mark) trigger(token)\n" +
		"\t.add(mark(\"$name\"[, $options...[, ]])[.multiple(\"$separator\")])\n" +
		"endrule";
	public static final String LITTLE_BIG_TEST = "" +
		"defrule type(Class)\n" +
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
		"endrule";


	public static final String XML_TARA = "defrule type(Theasurus)\n" +
		"\t<thesaurus>\n" +
		"\t\t$terms...[$NL]\n" +
		"\t</thesaurus>\n" +
		"endrule\n" +
		"defrule type(Term)\n" +
		"\t<term code=\"$code\" value=\"$value\">\n" +
		"\t\t$terms...[$NL]\n" +
		"\t</term>\n" +
		"endrule";
	public static final String XML_SMALL =
		"defrule type(Class)\n" +
			"\t<class name=\"$Name\" type=\"$Type\">\n" +
			"\t\t$superclass+Superclass\n" +
			"\t\t$interface+Interface...[$NL]\n" +
			"endrule\n" +
			"defrule type(String) trigger(String+Interface)\n" +
			"\t<interface name=\"$value\" />\n" +
			"endrule";
	public static final String LARGE_XML = "defrule type(Class)\n" +
		"\t<class name=\"$Name\" type=\"$Type\">\n" +
		"\t\t$superclass+Superclass\n" +
		"\t\t$interface+Interface...[$NL]\n" +
		"\n" +
		"\t</class>\n" +
		"endrule\n" +
		"\n" +
		"defrule trigger(String+Superclass)\n" +
		"\t<superclass name=\"$value\" />\n" +
		"endrule\n" +
		"defrule trigger(String+Interface)\n" +
		"\t<interface name=\"$value\" />\n" +
		"endrule";

}
