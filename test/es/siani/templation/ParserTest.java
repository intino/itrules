package es.siani.templation;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.junit.Assert;
import org.junit.Test;

public class ParserTest {

	@Test
	public void nullFileTest() {
		TemplationParser parser = init("\n\n    \n\n");
		Assert.assertFalse(parse(parser));
	}

	@Test
	public void templateTest() {
		TemplationParser parser = init(
			"public class $name [extends $superclass] [implements $interface[, $interface]] {\n" +
				"\n" +
				"#attribute\n" +
				"  $type $name;\n" +
				"#end\n" +
				"\n" +
				"#attribute\n" +
				"  public $type get$Name() {\n" +
				"      return #name;\n" +
				"  }\n" +
				"\n" +
				"#end\n" +
				"\n" +
				"#attribute\n" +
				"  public void set$Name($type $name) {\n" +
				"      this.$name = $name;\n" +
				"  }\n" +
				"\n" +
				"#end\n" +
				"\n" +
				"}\n"
		);
		Assert.assertTrue(parse(parser));
	}


	private TemplationParser init(String query) {
		CharStream stream = new ANTLRInputStream(query);
		TemplationLexer lexer = new TemplationLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		return new TemplationParser(tokens);
	}

	private boolean parse(TemplationParser parser) {
		try {
			parser.root();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	private boolean parse(ParserRuleContext parser) {
		try {
			System.out.println(parser.toStringTree());
		} catch (RuntimeException error) {
			return false;
		}
		return true;
	}

	@Test
	public void parse() throws RuntimeException {
//		TemplationParser parser = new TemplationParser(new File("res/goros.m2"));
	}
}