package org.siani.itrules;

public class TestSources {

	public static final String NULL_FILE = "\n\n    \n\n";
	public static final String MARK = "defrule type(Class) \t \t   \t\t\n$mark \n~";
	public static final String MARK_WITH_FORMAT = "defrule type(Attribute) trigger(attribute+Const) type(const)\n" +
		"public static final $name+format(UPPERCASE);\n" + "~";
	public static final String OTHER_WITH_MARK = "defrule type(Class)\npublic class $attri alalasda $other \n" + "~";
	public static final String SCAPED_CHARACTERS = "defrule type(Class) \t \t   \t\t\n$] $$ $~ asdas \n~\n";
	public static final String SIGNATURE = "defrule type(markca) \n~";
	public static final String RULE_BEGIN = "\n\ndefrule";
	public static final String RULE_WITH_MARKS = "defrule type(Attribute) trigger(attribute+Field) type(!const) type(readonly)\npublic class $attri alalasda $other \n~";
	public static final String MARK_WITH_MODIFIERS = "defrule type(Class)\npublic class $attribute+Const...[$NL] alalasda $other \n~";
	public static final String MEDIUM_TEST = "defrule type(Class)\n" +
		"public class [$static ]\n~";
	public static final String TWO_RULES = "defrule type(Class)\n" +
		"public class [$static ]\n" + "~\n" +
		"defrule type(class2)\n" +
		"\tpublic class [$static ]\n" + "~";
	public static final String LITTLE_BIG_TEST = "" +
		"defrule type(Class)\n" +
		"public class [$static ][$final ]$name [extends $SuperClass ][implements $Interface...[, ]]{\n" +
		"\t$attribute+const...[$NL]\n" +
		"\t$attribute+Field...[$NL]\n" +
		"\n" +
		"\t$attribute+Getter...[$NL]\n" +
		"\n" +
		"\tpublic $Name($attribute+Injection...[,]) {\n" +
		"\t\t$attribute+Initialize...[$NL]\n" +
		"\t}\n" +
		"}\n" +
		"~";
	public static final String XML_TARA = "defrule type(Theasurus)\n" +
		"<thesaurus>\n" +
		"\t$terms...[$NL]\n" +
		"</thesaurus>\n" +
		"~\n" +
		"defrule type(Term)\n" +
		"<term code=\"$code\" value=\"$value\">\n" +
		"\t$terms...[$NL]\n" +
		"</term>\n" +
		"~";
	public static final String XML_SMALL =
		"defrule type(Class)\n" +
			"<class name=\"$Name\" type=\"$Type\">\n" +
			"\t$superclass+Superclass\n" +
			"\t$interface+Interface...[$NL]\n" +
			"~\n" +
			"defrule type(String) trigger(String+Interface)\n" +
			"<interface name=\"$value\" />\n" +
			"~";
	public static final String LARGE_XML = "defrule type(Class)\n" +
		"<class name=\"$Name\" type=\"$Type\">\n" +
		"\t$superclass+Superclass\n" +
		"\t$interface+Interface...[$NL]\n" +
		"\n" +
		"</class>\n" +
		"~\n" +
		"\n" +
		"defrule trigger(String+Superclass)\n" +
		"<superclass name=\"$value\" />\n" +
		"~\n" +
		"defrule trigger(String+Interface)\n" +
		"<interface name=\"$value\" />\n" +
		"~";

	public static final String JAVA_COMPLETE = "defrule type(Class)\n" +
		"public class [$static ][$final ]$Name [extends $SuperClass][implements $Interface...[, ]]{\n" +
		"\t$attribute+Const...[$NL]\n" +
		"\t$attribute+Field...[$NL]\n" +
		"\n" +
		"\t$attribute+Getter...[$NL]\n" +
		"\t$attribute+Setter...[$NL]\n" +
		"\n" +
		"\tpublic $Name($attribute+Injection...[,]) {\n" +
		"\t\t$attribute:Initialize...[$NL]\n" +
		"\t}\n" +
		"}\n" +
		"endrule\n" +
		"\n" +
		"defrule type(Attribute) trigger(attribute+Const) type(const)\n" +
		"public static final $type $name+format(UPPERCASE) = $default;\n" +
		"endrule\n" +
		"\n" +
		"defrule type(Attribute) trigger(attribute+Field) !type(const) type(readonly)\n" +
		"private final $type $name[ = $default];\n" +
		"endrule\n" +
		"\n" +
		"defrule type(Attribute) !type(const) !type(readOnly) trigger(attribute+Field)\n" +
		"private $type $name[ = $default];\n" +
		"endrule\n" +
		"\n" +
		"defrule type(Attribute) type(const) type(field) trigger(attribute+Getter)\n" +
		"public $type get$name+format(ProperCase)() {\n" +
		"\treturn $name;\n" +
		"}\n" +
		"endrule\n" +
		"\n" +
		"defrule type(Attribute) !type(const) trigger(attribute+Setter)\n" +
		"public void set$Name($type value) {\n" +
		"\t$name = value;\n" +
		"}\n" +
		"endrule\n" +
		"\n" +
		"defrule type(Attribute) !type(readOnly) trigger(attribute+Injection)\n" +
		"$type $name\n" +
		"endrule\n" +
		"\n" +
		"defrule type(Attribute) type(Initialize) type(readOnly)\n" +
		"this.$name = $name;\n" +
		"endrule\n";

	public static final String[] TEST_SOURCES = new String[]{NULL_FILE, MARK, MARK_WITH_FORMAT,
		MARK_WITH_MODIFIERS, MEDIUM_TEST, OTHER_WITH_MARK, RULE_BEGIN, RULE_WITH_MARKS, SCAPED_CHARACTERS, SIGNATURE,
		TWO_RULES, XML_TARA, LITTLE_BIG_TEST, LARGE_XML, LARGE_XML};
}
