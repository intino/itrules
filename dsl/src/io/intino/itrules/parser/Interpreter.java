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
package io.intino.itrules.parser;

import io.intino.itrules.Logger;
import io.intino.itrules.dsl.ItrParser.*;
import io.intino.itrules.dsl.ItrParserBaseListener;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.condition.BinaryExpression;
import io.intino.itrules.template.condition.LogicalExpression;
import io.intino.itrules.template.condition.NotExpression;
import io.intino.itrules.template.condition.predicates.AttributePredicate;
import io.intino.itrules.template.condition.predicates.TriggerPredicate;
import io.intino.itrules.template.condition.predicates.TypePredicate;
import io.intino.itrules.template.outputs.Expression;
import io.intino.itrules.template.outputs.Literal;
import io.intino.itrules.template.outputs.Placeholder;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

import static io.intino.itrules.template.condition.BinaryOperator.AND;
import static io.intino.itrules.template.condition.BinaryOperator.OR;

public final class Interpreter extends ItrParserBaseListener {
	private static final String NL_SEPARATOR = "$NL";
	private static final String TAB_SEPARATOR = "$TAB";
	private final Logger logger;
	private final Template template;
	private Rule currentRule;
	private StringBuilder currentText = new StringBuilder();

	public Interpreter(Template template, Logger logger) {
		this.template = template;
		this.logger = logger;
	}

	@Override
	public void enterSignature(SignatureContext ctx) {
		currentRule = new Rule();
		template.add(currentRule);
		currentRule.condition(process(ctx.condition()));
	}

	private LogicalExpression process(ConditionContext condition) {
		List<LogicalExpression> terms = condition.term().stream().map(this::process).toList();
		if (terms.isEmpty()) return null;
		if (terms.size() == 1) return terms.get(0);
		LogicalExpression root = terms.get(0);
		List<OperatorContext> operators = condition.operator();
		for (int i = 0; i < operators.size(); i++) {
			root = new BinaryExpression(root, operators.get(i).AND() != null ? AND : OR, terms.get(i + 1));
		}
		return root;
	}

	private LogicalExpression process(TermContext term) {
		LogicalExpression result;
		if (term.predicate() != null)
			result = predicateOf(term.predicate().NAME().getText(), term.predicate().parameters());
		else result = process(term.condition());
		return term.NOT() != null ? new NotExpression(result) : result;
	}

	private LogicalExpression predicateOf(String name, ParametersContext parameters) {
		String[] params = parameters.parameter().stream().map(RuleContext::getText).map(p -> p.replaceAll("\\s| ", "")).toArray(String[]::new);
		if (name.equalsIgnoreCase("type")) {
			return new TypePredicate(params);
		} else if (name.equalsIgnoreCase("attribute"))
			return new AttributePredicate(params[0], params.length > 1 ? params[1] : null);
		else if (name.equalsIgnoreCase("trigger"))
			return new TriggerPredicate(params[0]);
		return null;
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
			if (token instanceof PlaceholderContext) {
				if (token.getText().equals(NL_SEPARATOR)) expression.output(new Literal("\n"));
				else if (token.getText().equals(TAB_SEPARATOR)) expression.output(new Literal("\t"));
				else expression.output(processPlaceHolder(((PlaceholderContext) token)));
			} else if (token instanceof TextContext)
				expression.output(new Literal(clean(token).replaceFirst(indent, "")));
		}
	}

	private String clean(ParseTree child) {
		return child.getText().startsWith("~") ? child.getText().substring(1) : child.getText();
	}

	@Override
	public void enterPlaceholder(PlaceholderContext ctx) {
		if (!inExpression(ctx)) {
			if (ctx.getText().equals(NL_SEPARATOR)) currentRule.output(new Literal("\n"));
			else if (ctx.getText().equals(TAB_SEPARATOR)) currentRule.output(new Literal("\t"));
			else currentRule.output(processPlaceHolder(ctx));
		}
	}

	private boolean inExpression(PlaceholderContext ctx) {
		return ctx.getParent() instanceof ExpressionBodyContext;
	}

	private Placeholder processPlaceHolder(PlaceholderContext ctx) {
		TerminalNode target = ctx.TARGET();
		String[] options = options(ctx.option());
		String separator = (ctx.SEPARATOR() != null) ? ctx.SEPARATOR().getText() : null;
		if (separator != null) separator = format(separator);
		return new Placeholder(ctx.ID().getText(), target != null ? clean(target.getText()) : null, options).multiple(separator);
	}

	private String[] options(List<OptionContext> options) {
		return options.stream().map(o -> o.getText().substring(1)).toArray(String[]::new);
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

	private String[] clean(String text) {
		return text.substring(1, text.length() - 1).split("\\.");
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