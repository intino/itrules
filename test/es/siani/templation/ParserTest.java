package es.siani.templation;

import org.antlr.v4.runtime.*;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

	@Test
	public void nullFileTest() throws Exception {
		TemplationParser parser = init("\n\n    \n\n");
		Assert.assertTrue(parse(parser));
	}

	@Test
	public void littleTest() throws Exception {
		TemplationParser parser = init(
			":Class+Const if Const\n" +
				"public class [$static ][$final ]$Name [extends $Superclass ][implements $Interface...[, ]]{\n"
		);
		Assert.assertTrue(parse(parser));
	}

	@Test
	public void mediumTest() throws Exception {
		TemplationParser parser = init(
			":Class\n" +
				"public class [$static ][$final ]$Name [extends $Superclass ][implements $Interface...[, ]]{\n" +
				"\t$attribute+Const...[$NL]\n" +
				"\t$attribute+Field...[$NL]\n" +
				"\n" +
				":Attribute+Const if Const\n" +
				"\t\t\t\tpublic static final $type $NAME = $default;\n"
		);
		Assert.assertTrue(parse(parser));
	}

	@Test
	public void bigTest() throws Exception {
		TemplationParser parser = init(
			":Class\n" +
				"public class [$static ][$final ]$Name [extends $Superclass ][implements $Interface...[, ]]{\n" +
				"\t$attribute+Const...[$NL]\n" +
				"\t$attribute+Field...[$NL]\n" +
				"\n" +
				"\t$attribute+Getter...[$NL]\n" +
				"\n" +
				"\tpublic $Name($attribute+Injection...[,]) {\n" +
				"\t\t$attribute+Initialize...[$NL]\n" +
				"\t}\n" +
				"}"
		);
		Assert.assertTrue(parse(parser));
	}

	@Test
	public void completeTest() throws Exception {
		TemplationParser parser = init(
			":Class\n" +
				"public class [$static ][$final ]$Name [extends $Superclass ][implements $Interface...[, ]]{\n" +
				"\t$attribute+Const...[$NL]\n" +
				"\t$attribute+Field...[$NL]\n" +
				"\n" +
				"\t$attribute+Getter...[$NL]\n" +
				"\n" +
				"\tpublic $Name($attribute+Injection...[,]) {\n" +
				"\t\t$attribute+Initialize...[$NL]\n" +
				"\t}\n" +
				"}\n" +
				"\n" +
				"\n" +
				":Attribute+Const if Const\n" +
				"public static final $type $NAME = $default;\n" +
				"\n" +
				":Attribute+Field if ReadOnly\n" +
				"private final $type $name[ = $default];\n" +
				"\n" +
				":Attribute+Field if !ReadOnly\n" +
				"private $type $name[ = $default];\n" +
				"\n" +
				":Attribute+Getter\n" +
				"public $type get$Name() {\n" +
				"\treturn $name;\n" +
				"}\n" +
				"\n" +
				":Attribute+Setter if !ReadOnly\n" +
				"public void set$Name($type value) {\n" +
				"\t$name = value;\n" +
				"}\n" +
				"\n" +
				":Attribute+Injection if ReadOnly\n" +
				"$type $name\n" +
				"\n" +
				":Attribute+Initialize if ReadOnly\n" +
				"this.$name = $name;\n"
		);
		Assert.assertTrue(parse(parser));
	}


	private TemplationParser init(String query) {
		CharStream stream = new ANTLRInputStream(query);
		TemplationLexer lexer = new TemplationLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TemplationParser parser = new TemplationParser(tokens);
		parser.setErrorHandler(new TemplationErrorStrategy());
		return parser;
	}


	private boolean parse(TemplationParser parser) throws Exception {
		try {
			TemplationParser.RootContext rootContext = parser.root();
			return true;
		} catch (RecognitionException e) {
			Token token = ((org.antlr.v4.runtime.Parser) e.getRecognizer()).getCurrentToken();
			throw new Exception("Syntax error in line" + token.getLine() + "at" + token.getCharPositionInLine());
		}
	}

	@Test
	public void parseFile() throws RuntimeException {
//		TemplationParser parser = new TemplationParser(new File("res/goros.m2"));
	}
}