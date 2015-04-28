package org.siani.itrules.cases.templates;

import org.siani.itrules.*;

import java.util.Locale;

import static org.siani.itrules.Encoding.LineSeparator.LF;

public class RosterTemplate extends Template {

	public static final Template This = new RosterTemplate(Locale.ENGLISH, Encoding.with("UTF-8", LF));

	private RosterTemplate(Locale locale, Encoding encoding) {
		super(locale, encoding);
	}

	@Override
	protected void definition() {
		add(
			rule().add(condition("type", "Roster")).add(literal("<roster>\n\t")).add(mark("Coach")).add(literal("\n\t<players>\n\t\t")).add(mark("Player", "").multiple("\n")).add(literal("\n\t</players>\n</roster>")),
			rule().add(condition("type", "Person")).add(condition("trigger", "Coach")).add(literal("<coach name=\"")).add(mark("name")).add(literal("\" year=\"")).add(mark("Birthday", "Century")).add(literal("\" country=\"")).add(mark("Country")).add(literal("\" />")),
			rule().add(condition("type", "Person")).add(condition("trigger", "Player")).add(literal("<player name=\"")).add(mark("name")).add(literal("\" year=\"")).add(mark("Birthday", "Year")).add(literal("\" country=\"")).add(mark("Country")).add(literal("\"")).add(expression().add(literal(" club=\"")).add(mark("Club")).add(literal("\""))).add(literal("/>"))
		);
	}

}
