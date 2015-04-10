package org.siani.itrules.cases.templates;

import org.siani.itrules.*;


public class RosterTemplate extends Template {

	@Override
	public void definition() {
		add(rule().add(condition("type", "Roster")).add(literal("<roster>\n\t")).add(mark("Coach")).add(literal("\n\t<players>\n\t\t")).add(mark("Player", "").multiple("\n")).add(literal("\n\t</players>\n</roster>"))).
		add(rule().add(condition("type", "Person")).add(condition("trigger", "Coach")).add(literal("<coach name=\"")).add(mark("name")).add(literal("\" year=\"")).add(mark("Birthday", "Century")).add(literal("\" country=\"")).add(mark("Country")).add(literal("\" />"))).add(rule().add(condition("type", "Person")).add(condition("trigger", "Player")).add(literal("<player name=\"")).add(mark("name")).add(literal("\" year=\"")).add(mark("Birthday", "Year")).add(literal("\" country=\"")).add(mark("Country")).add(literal("\"")).add(expression().add(literal(" club=\"")).add(mark("Club")).add(literal("\""))).add(literal("/>")));
	}

}
