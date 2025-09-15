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
			rule type(Class) \t \t   \t\t
			$mark ññ end
			""";

	public static final String MARK_WITH_TARGET = """
			rule type(Class)
				$<root>mark
			""";
	public static final String MARK_WITH_FORMAT = """
			rule type(Attribute) and trigger(attribute+Const) and type(Const)
				public static final $name+UPPERCASE;
			""";
	public static final String OTHER_WITH_MARK = """
			rule type(Class)
				public class $attri alalasda $other
			""";
	public static final String ESCAPED_CHARACTERS = """
			rule type(Class)\s
			\t \t   \t\t
			\t] $$\s
			""";

	public static final String FUNCTION_WITHOUT_PARAMETERS = """
			rule one() trigger(Age)
			    one year old
			""";

	public static final String EXPRESION_WITH_NEW_LINES = """
			rule type(nodeimpl)
			    public
			        <<$aggregable
			        public Definition[] aggregables() {
			        }>>
			""";
	public static final String SIGNATURE = """
			rule type(markca)


			""";
	public static final String SIGNATURE_WITH_ATTRIBUTES_1 = """
			rule type(markca) and attribute(a,b)


			""";
	public static final String SIGNATURE_WITH_ATTRIBUTES_2 = """
			rule type(markca) and attribute(a)


			""";
	public static final String RULE_BEGIN = "\n\nrule";
	public static final String RULE_WITH_MARKS = """
			rule type(Attribute) and trigger(attribute+Field) and type(Const) and type(readonly)
			public class $attri alalasda $other\s
			""";
	public static final String RULE_WITH_OR_EXPRESSIONS = """
			rule type(Attribute) and trigger(attribute+Field) and type(Const) and type(readonly)
			<coach name="$Name" <<<NotExist $NotExist>?$None !!!?/>~>>
			""";
	public static final String MARK_WITH_MODIFIERS = """
			rule type(Class)
			public class $attribute+Const...[$NL] alalasda $other\s
			""";
	public static final String CURL_SEPARATOR = """
			rule trigger(node)
			    $name+firstUpperCase~Intention<> a
			""";
	public static final String DOUBLE_CURL_SEPARATOR = """
			rule trigger(node)
			    $~ a
			""";

	public static final String MEDIUM_TEST = """
			rule type(Class)
				public class <<$static >>
			""";
	public static final String CONTAINER_TEST = """
			rule trigger(variable)
				$<container>name.create("$name")
			""";

	public static final String TWO_RULES = """
			rule type(Class)
				public class <<$static~A >>
			
			rule type(class2)
				public class <<$static >>
			""";
	public static final String RULE_WITH_EVAL = """
			rule type(Class) and eval(Class == 'sasa')
			public class <<$static >>
			
			rule type(class2)
				public class <<$static >>
			""";
	public static final String ITRULES_TEST = """
			rule type(token) and type(mark) and trigger(token)
				.add(mark("$name"<<, $options...[, ]>>)<<.multiple("$separator")>>)
			""";
	public static final String CONDITION_TEST = """
			rule type(attribute) and attribute(type, date) and trigger(checkFormat)
				java.text.DateFormat.getInstance().parse($name());
			""";
	public static final String CONDITION_2_TEST = """
			rule (attribute(in,path) or attribute(in, query)) and type(required) and trigger(parameter)
				ctx.$in~ParamAsClass("$name", $type.class).getOrThrow(e -> new io.javalin.http.BadRequestResponse("$name parameter not found"))
			""";
	public static final String LITTLE_BIG_TEST = """
			rule type(Class)
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
			""";


	public static final String LITTLE_BIG_TEST_2 = """
			rule type(Class)
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
			""";


	public static final String XML_TARA = """
			rule type(Theasurus)
			\t<thesaurus>
			\t\t$terms...[$NL]
			\t</thesaurus>
			
			rule type(Term)
			\t<term code="$code" value="$value">
			\t\t$terms...[$NL]
			\t</term>
			""";
	public static final String XML_SMALL = """
			rule type(Class)
			\t<class name="$Name" type="$Type">
			\t\t$superclass+Superclass
			\t\t$interface+Interface...[$NL]
			
			rule type(String) and trigger(String+Interface)
			\t<interface name="$value" />
			""";
	public static final String LARGE_XML = """
			rule type(Class)
			\t<class name="$Name" type="$Type">
			\t\t$superclass+Superclass
			\t\t$interface+Interface...[$NL]

			\t</class>

			rule trigger(String+Superclass)
			\t<superclass name="$value" />
			
			rule trigger(String+Interface)
			\t<interface name="$value" />
			""";
}