package org.siani.itrules.cases.templates;

import org.siani.itrules.Encoding;
import org.siani.itrules.Formatter;
import org.siani.itrules.Template;
import org.siani.itrules.TemplateEngine;

import java.util.Locale;

import static org.siani.itrules.Encoding.LineSeparator.*;

public class RosterTemplate extends Template {

	public RosterTemplate(Locale locale, Encoding encoding) {
		super(locale, encoding);
	}

	public static String format(Object object) {
		return engine().render(object);
	}

	private static TemplateEngine engine() {
		return new TemplateEngine(Locale.ENGLISH, Encoding.with("UTF-8", LF));
	}

	@Override
	protected void definition() {
		add(
			rule().add(condition("type", "Roster")).add(literal("<roster>\n\t")).add(mark("Coach")).add(literal("\n\t<players>\n\t\t")).add(mark("Player", "").multiple("\n")).add(literal("\n\t</players>\n</roster>")),
			rule().add(condition("type", "Person")).add(condition("trigger", "Coach")).add(literal("<coach name=\"")).add(mark("name")).add(literal("\" year=\"")).add(mark("Birthday", "Century")).add(literal("\" country=\"")).add(mark("Country")).add(literal("\" />")),
			rule().add(condition("type", "Person")).add(condition("trigger", "Player")).add(literal("<player name=\"")).add(mark("name")).add(literal("\" year=\"")).add(mark("Birthday", "Year")).add(literal("\" country=\"")).add(mark("Country")).add(literal("\"")).add(expression().add(literal(" club=\"")).add(mark("Club")).add(literal("\""))).add(literal("/>"))
		);
		add("Age", new Formatter() {
			@Override
			public Object format(Object value) {
				return AgeTemplate.format(value);
			}
		});
	}

}
