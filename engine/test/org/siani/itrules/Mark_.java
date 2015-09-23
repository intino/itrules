package org.siani.itrules;

import org.junit.Test;
import org.siani.itrules.model.Frame;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class Mark_ {

	@Test
	public void accept_template_white_indentation_with_endline_literal() throws Exception {
		String expected = "package magritte.store;\n" +
			"\n" +
			"public class Monet extends magritte.editors.Box.Dsl {\n" +
			"    public static final magritte.editors.Box box = new Monet();\n" +
			"\n" +
			"    protected magritte.editors.Box[] includes() {\n" +
			"        return new magritte.editors.Box[]{\n" +
			"            Form,\n" +
			"            Field,\n" +
			"            Text};\n" +
			"    }\n" +
			"}";
		assertEquals(expected, EndingInNLTemplate.create().format(createFrame()));
	}

	@Test
	public void accept_white_indentation_in_mark() throws Exception {
		String expected2 = "package magritte.store;\n" +
			"\n" +
			"public class Monet extends magritte.editors.Box.Dsl {\n" +
			"    public static final magritte.editors.Box box = new Monet();\n" +
			"\n" +
			"    protected magritte.editors.Box[] includes() {\n" +
			"        return new magritte.editors.Box[]{Form,\n" +
			"        Field,\n" +
			"        Text};\n" +
			"    }\n" +
			"}";
		assertEquals(expected2, BoxDSLTemplate.create().format(createFrame()));
	}

	private Frame createFrame() {
		Frame frame = new Frame().addTypes("Box");
		frame.addFrame("name", "Monet");
		frame.addFrame("namebox", "Form", "Field", "Text");
		return frame;
	}


	public static class BoxDSLTemplate extends Template {

		protected BoxDSLTemplate(Locale locale, LineSeparator separator) {
			super(locale, separator);
		}

		public static Template create() {
			return new BoxDSLTemplate(Locale.ENGLISH, LineSeparator.LF).define();
		}

		public Template define() {
			add(
				rule().add((condition("type", "Box"))).add(literal("package magritte.store;\n\npublic class ")).add(mark("name", "firstUppercase"))
					.add(literal(" extends magritte.editors.Box.Dsl {\n    public static final magritte.editors.Box box = new "))
					.add(mark("name", "firstUppercase")).add(literal("();\n\n    protected magritte.editors.Box[] includes() {\n" +
					"        return new magritte.editors.Box[]{")).add(mark("namebox").multiple(",\n")).add(literal("};\n    }\n}"))
			);
			return this;
		}
	}

	public static class EndingInNLTemplate extends Template {

		protected EndingInNLTemplate(Locale locale, LineSeparator separator) {
			super(locale, separator);
		}

		public static Template create() {
			return new EndingInNLTemplate(Locale.ENGLISH, LineSeparator.LF).define();
		}

		public Template define() {
			add(
				rule().add((condition("type", "Box"))).add(literal("package magritte.store;\n\npublic class ")).add(mark("name", "firstUppercase"))
					.add(literal(" extends magritte.editors.Box.Dsl {\n    public static final magritte.editors.Box box = new "))
					.add(mark("name", "firstUppercase")).add(literal("();\n\n" +
					"    protected magritte.editors.Box[] includes() {\n" +
					"        return new magritte.editors.Box[]{\n            ")).add(mark
					("namebox").multiple(",\n")).add(literal("};\n    }\n}"))
			);
			return this;
		}
	}
}
