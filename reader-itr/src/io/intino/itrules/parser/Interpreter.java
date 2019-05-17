/*
 * Copyright 2014
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

package io.intino.itrules.parser;

import io.intino.itrules.Logger;
import io.intino.itrules.Rule;
import io.intino.itrules.dsl.ItrParser;
import io.intino.itrules.dsl.ItrParser.*;
import io.intino.itrules.dsl.ItrParserBaseListener;
import io.intino.itrules.rules.conditions.AttributeCondition;
import io.intino.itrules.rules.conditions.NegatedCondition;
import io.intino.itrules.rules.conditions.TriggerCondition;
import io.intino.itrules.rules.conditions.TypeCondition;
import io.intino.itrules.rules.output.Expression;
import io.intino.itrules.rules.output.Literal;
import io.intino.itrules.rules.output.Mark;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

import static io.intino.itrules.Rule.Condition;
import static io.intino.itrules.rules.conditions.TypeCondition.Operator.All;
import static io.intino.itrules.rules.conditions.TypeCondition.Operator.Any;


public final class Interpreter extends ItrParserBaseListener {

	private static String NL_SEPARATOR = "$NL";
	private static String TAB_SEPARATOR = "$TAB";
	private final Logger logger;
	private ParsedTemplate template;
	private Rule currentRule;
	private StringBuilder currentText = new StringBuilder();

	public Interpreter(ParsedTemplate template, Logger logger) {
		this.template = template;
		this.logger = logger;
	}

	@Override
	public void enterSignature(SignatureContext ctx) {
		currentRule = new Rule();
		template.add(currentRule);
	}

	@Override
	public void exitDefinition(DefinitionContext ctx) {
		super.exitDefinition(ctx);
	}

	@Override
	public void enterCondition(ItrParser.ConditionContext ctx) {
		if (ctx.PARAMETERS() != null) {
			String parameters = ctx.PARAMETERS().getText();
//            Condition condition = new Rule.Condition(ctx.FUNCTION().getText(), , ctx.NOT() != null);
			Condition condition = null;
			String parameter = parameters.substring(1, parameters.length() - 1).replaceAll("\\s| ", "");
			if (ctx.FUNCTION().getText().equalsIgnoreCase("type"))
				condition = new TypeCondition(parameter.contains("|") ? Any : All, parameter.split("[|&]"));
			else if (ctx.FUNCTION().getText().equalsIgnoreCase("attribute"))
				condition = new AttributeCondition(parameter.contains(":") ? parameter.split(":")[0] : parameter, parameter.contains(":") ? parameter.split(":")[1] : null);
			else if (ctx.FUNCTION().getText().equalsIgnoreCase("trigger"))
				condition = new TriggerCondition(parameter);
			if (condition != null && ctx.NOT() != null) condition = new NegatedCondition(condition);
			if (condition != null) currentRule.condition(condition);
		}
	}

	@Override
	public void enterText(TextContext ctx) {
		if (ctx.getParent() instanceof BodyContext)
			currentText.append(ctx.getText());
	}

	@Override
	public void exitText(TextContext ctx) {
		if (ctx.getParent() instanceof BodyContext && isEndTextSequence(ctx)) {
			currentRule.output(new Literal(currentText.toString()));
			currentText = new StringBuilder();
		}
	}

	private boolean isEndTextSequence(TextContext ctx) {
		BodyContext parent = (BodyContext) ctx.getParent();
		List<ParseTree> children = parent.children;
		return !(children.indexOf(ctx) + 1 < children.size() && children.get(children.indexOf(ctx) + 1) instanceof TextContext);
	}

	@Override
	public void enterExpression(ExpressionContext ctx) {
		Expression expression = new Expression();
		Expression currentOr = null;
		boolean orMode = false;
		String indent = calculateExpressionIndent(ctx);
		for (ParseTree child : ctx.children)
			if (!orMode && child instanceof ExpressionBodyContext)
				fillExpression((ExpressionBodyContext) child, expression, indent);
			else if (child instanceof ExpressionBodyContext)
				fillExpression((ExpressionBodyContext) child, currentOr, indent);
			else if (child.getText().equals("?")) {
				if (currentOr != null) expression.next(currentOr);
				orMode = true;
				currentOr = new Expression();
			}
		if (currentOr != null) expression.next(currentOr);
		currentRule.output(expression);
	}

	private void fillExpression(ExpressionBodyContext body, Expression expression, String indent) {
		for (ParseTree token : body.children) {
			if (token instanceof MarkContext) {
				if (token.getText().equals(NL_SEPARATOR)) expression.output(new Literal("\n"));
				else if (token.getText().equals(TAB_SEPARATOR)) expression.output(new Literal("\t"));
				else expression.output(processAsMark(((MarkContext) token)));
			} else if (token instanceof TextContext)
				expression.output(new Literal(clean(token).replaceFirst(indent, "")));
		}
	}

	private String clean(ParseTree child) {
		return child.getText().startsWith("~") ? child.getText().substring(1) : child.getText();
	}

	@Override
	public void enterMark(MarkContext ctx) {
		if (!inExpression(ctx)) {
			if (ctx.getText().equals(NL_SEPARATOR)) currentRule.output(new Literal("\n"));
			else if (ctx.getText().equals(TAB_SEPARATOR)) currentRule.output(new Literal("\t"));
			else currentRule.output(processAsMark(ctx));
		}
	}

	private boolean inExpression(MarkContext ctx) {
		return ctx.getParent() instanceof ExpressionBodyContext;
	}

	private Mark processAsMark(MarkContext child) {
		String[] options = options(child.option());
		String separator = (child.SEPARATOR() != null) ? child.SEPARATOR().getText() : null;
		if (separator != null) separator = format(separator);
		return new Mark(child.ID().getText(), options).multiple(separator);
	}

	private String[] options(List<OptionContext> options) {
		return options.stream().map(o -> {
			if (o.lambda() != null) {
				String lambda = o.lambda().getText().substring(2, o.lambda().getText().length() - 1);
				return template.add(lambda);
			}
			return o.getText().substring(1);
		}).toArray(String[]::new);
	}

	private String calculateExpressionIndent(ExpressionContext ctx) {
		CharStream inputStream = ctx.start.getInputStream();
		int lnIndex = ctx.start.getStartIndex() - ctx.start.getCharPositionInLine();
		String text = inputStream.getText(new Interval(lnIndex, ctx.start.getStartIndex() - 1)).substring(1);
		int i = 0;
		if (text.isEmpty()) return "";
		StringBuilder indent = new StringBuilder();
		while (text.length() > i && text.charAt(i) == '\t') {
			indent.append("\t");
			i++;
		}
		return indent.toString();
	}

	private String format(String separator) {
		String s = separator.substring(1, separator.length() - 1);
		return s.replace(NL_SEPARATOR, "\n").replace(TAB_SEPARATOR, "\t").replace("~", "");
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		logger.log("Error reading template. Template not well formed: " + node.getText() + "\n\n");
	}
}
