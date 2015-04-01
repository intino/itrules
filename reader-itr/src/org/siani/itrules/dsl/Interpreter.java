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

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.siani.itrules.engine.logger.Logger;
import org.siani.itrules.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.siani.itrules.dsl.ITRulesParser.*;

final class Interpreter extends ITRulesParserBaseListener {

	private static String NL_SEPARATOR = "$NL";
	private static String TAB_SEPARATOR = "$TAB";
	private final Logger logger;
	private List<Rule> rules;
	private Rule currentRule;

	public Interpreter(List<Rule> rules, Logger logger) {
		this.rules = rules;
		this.logger = logger;
	}

	@Override
	public void enterSignature(@NotNull SignatureContext ctx) {
		currentRule = new Rule();
	}

	@Override
	public void exitSignature(@NotNull SignatureContext ctx) {
		rules.add(currentRule);
	}

	@Override
	public void enterFunction(@NotNull FunctionContext ctx) {
		String conditions = ctx.CONDITIONS().getText();
		currentRule.add(new Condition(ctx.ID().getText(), conditions.substring(1, conditions.length() - 1)));
	}

	@Override
	public void enterText(@NotNull TextContext ctx) {
		if (BodyContext.class.isInstance(ctx.getParent()))
			currentRule.add(makeLiteral(ctx));
	}

	private Literal makeLiteral(TextContext ctx) {
		return ctx.SCAPED_CHAR() != null ? getToken(ctx) : getLiteral(ctx);
	}

	private Literal getLiteral(TextContext ctx) {
		return new Literal(ctx.getText());
	}

	private Literal getToken(TextContext ctx) {
		return new Literal(ctx.getText().substring(1));
	}

	@Override
	public void enterExpression(@NotNull ExpressionContext ctx) {
		Expression expression = new Expression();
		for (ParseTree child : ctx.children)
			if (child instanceof MarkContext) {
				if (child.getText().equals(NL_SEPARATOR)) expression.add(new Literal("\n"));
				else if (child.getText().equals(TAB_SEPARATOR)) expression.add(new Literal("\t"));
				else expression.add(processAsMark(((MarkContext) child)));
			} else if (child instanceof TextContext)
				expression.add(new Literal(child.getText()));
		currentRule.add(expression);
	}

	@Override
	public void enterMark(@NotNull MarkContext ctx) {
		if (!ExpressionContext.class.isInstance(ctx.getParent())) {
			if (ctx.getText().equals(NL_SEPARATOR)) currentRule.add(new Literal("\n"));
			else if (ctx.getText().equals(TAB_SEPARATOR)) currentRule.add(new Literal("\t"));
			currentRule.add(processAsMark(ctx));
		}
	}

	private AbstractMark processAsMark(MarkContext child) {
		String[] options = getOptions(child.option());
		String separator = (child.SEPARATOR() != null) ? child.SEPARATOR().getText() : null;
		if (separator != null) separator = format(separator);
		return new Mark(child.ID().getText(), options, child.LIST() != null, separator);
	}

	private String[] getOptions(List<OptionContext> option) {
		List<String> list = new ArrayList<>();
		for (OptionContext optionContext : option) {
			list.add(optionContext.getText().substring(1));
		}
		return list.toArray(new String[list.size()]);
	}

	private String format(String separator) {
		String s = separator.substring(1, separator.length() - 1);
		s = s.replace(NL_SEPARATOR, "\n");
		s = s.replace(TAB_SEPARATOR, "\t");
		return s;
	}

	@Override
	public void visitErrorNode(@NotNull ErrorNode node) {
		throwError(node.getText());
	}

	private void throwError(String textNode) {
		logger.debug("Error reading template. Template not well formed: " + textNode.replace("\u0015", "endrule") + "\n\n");
	}
}
