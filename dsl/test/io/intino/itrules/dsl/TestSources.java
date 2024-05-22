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

public class TestSources {
	public static final String MARK = """
			def type(Class) \t \t   \t\t
			$mark ññ end
			end""";

	public static final String MARK_WITH_TARGET = """
			def type(Class)
				$<root>mark
			~end
			end
			""";
	public static final String MARK_WITH_FORMAT = """
			def type(Attribute) AND trigger(attribute+Const) AND type(Const)
				public static final $name+UPPERCASE;
			end""";
	public static final String OTHER_WITH_MARK = """
			def type(Class)
				public class $attri alalasda $other
			end
			""";
	public static final String ESCAPED_CHARACTERS = """
			def type(Class)\s
			\t \t   \t\t
			\t] $$\s
			end
			""";

	public static final String FUNCTION_WITHOUT_PARAMETERS = "def one() trigger(Age)\n" +
			"    one year old\n" +
			"end";

	public static final String EXPRESION_WITH_NEW_LINES = """
			def type(nodeimpl)
			    public
			        <<$aggregable
			        public Definition[] aggregables() {
			        }>>
			end
			""";
	public static final String SIGNATURE = """
			def type(markca)


			end""";
	public static final String SIGNATURE_WITH_ATTRIBUTES_1 = """
			def type(markca) AND attribute(a,b)


			end""";
	public static final String SIGNATURE_WITH_ATTRIBUTES_2 = """
			def type(markca) AND attribute(a)


			end""";
	public static final String RULE_BEGIN = "\n\ndef";
	public static final String RULE_WITH_MARKS = """
			def type(Attribute) AND trigger(attribute+Field) AND type(Const) AND type(readonly)
			public class $attri alalasda $other\s
			end""";
	public static final String RULE_WITH_OR_EXPRESSIONS = """
			def type(Attribute) AND trigger(attribute+Field) AND type(Const) AND type(readonly)
			<coach name="$Name" <<<NotExist $NotExist>?$None !!!?/>~>>
			end""";
	public static final String MARK_WITH_MODIFIERS = """
			def type(Class)
			public class $attribute+Const...[$NL] alalasda $other\s
			end""";
	public static final String CURL_SEPARATOR = """
			def trigger(node)
			    $name+firstUpperCase~Intention<> a
			end
			""";
	public static final String MEDIUM_TEST = """
			def type(Class)
				public class <<$static >>
			end""";
	public static final String TWO_RULES = """
			def type(Class)
				public class <<$static~A >>
			end
			def type(class2)
				public class <<$static >>
			end""";
	public static final String RULE_WITH_EVAL = """
			def type(Class) AND eval(Class == 'sasa')
			public class <<$static >>
			end
			def type(class2)
				public class <<$static >>
			end""";
	public static final String ITRULES_TEST = """
			def type(token) AND type(mark) AND trigger(token)
				.add(mark("$name"<<, $options...[, ]>>)<<.multiple("$separator")>>)
			end""";
	public static final String CONDITION_TEST = """
			def type(attribute) AND attribute(type, date) AND trigger(checkFormat)
				java.text.DateFormat.getInstance().parse($name());
			end
			""";
	public static final String CONDITION_2_TEST = """
			def (attribute(in,path) OR attribute(in, query)) AND type(required) AND trigger(parameter)
				ctx.$in~ParamAsClass("$name", $type.class).getOrThrow(e -> new io.javalin.http.BadRequestResponse("$name parameter not found"))
			end

			""";
	public static final String LITTLE_BIG_TEST = """
			def type(Class)
			\tpublic class <<$static >><<$final >>$name <<extends $SuperClass >><<implements $Interface...[, ]>>{
			\t\t$attribute+Const...[$NL]
			\t\t$attribute+Field...[$NL]
			\t
			\t\t$attribute+Getter...[$NL]
			\t
			\t\tpublic $Name($attribute+Injection...[,]) {
			\t\t\t$attribute+Initialize...[$NL]
			\t\t}
			\t}
			end""";


	public static final String LITTLE_BIG_TEST_2 = """
			def type(Class)
			\tpublic class <<$static >><<$final >>$name <<extends $SuperClass >><<implements $Interface...[, ]>>{
			\t\t<<//attributes:
			\t\t\t$attribute+Const...[$NL]
			\t\t\t$attribute+Field...[$NL]
			\t\t//end_ttributes>>
			\t\t$attribute+Getter...[$NL]
			\t
			\t\tpublic $Name($attribute+Injection...[,]) {
			\t\t\t$attribute+Initialize...[$NL]
			\t\t}
			\t}
			end""";


	public static final String XML_TARA = """
			def type(Theasurus)
			\t<thesaurus>
			\t\t$terms...[$NL]
			\t</thesaurus>
			end
			def type(Term)
			\t<term code="$code" value="$value">
			\t\t$terms...[$NL]
			\t</term>
			end""";
	public static final String XML_SMALL = """
			def type(Class)
			\t<class name="$Name" type="$Type">
			\t\t$superclass+Superclass
			\t\t$interface+Interface...[$NL]
			end
			def type(String) AND trigger(String+Interface)
			\t<interface name="$value" />
			end""";
	public static final String LARGE_XML = """
			def type(Class)
			\t<class name="$Name" type="$Type">
			\t\t$superclass+Superclass
			\t\t$interface+Interface...[$NL]

			\t</class>
			end

			def trigger(String+Superclass)
			\t<superclass name="$value" />
			end
			def trigger(String+Interface)
			\t<interface name="$value" />
			end""";
}