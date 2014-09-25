package org.siani.itrules.lang;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.siani.itrules.ITRulesLogger;
import org.siani.itrules.lang.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.siani.itrules.lang.ITRulesParser.*;

public class Interpreter extends ITRulesParserBaseListener {

	private static String NL_SEPARATOR = "\\$NL";
	private static String TAB_SEPARATOR = "\\$TAB";
	private List<Rule> rules;
	private Rule currentRule;
	private final ITRulesLogger logger;

	public Interpreter(List<Rule> rules, ITRulesLogger logger) {
		this.rules = rules;
		this.logger = logger;
	}

	@Override
	public void enterSignature(@NotNull SignatureContext ctx) {
		if (ctx.ruleType().isEmpty()) throwError(ctx.getText());
		currentRule = new Rule();
		currentRule.addAll(makeTypeFunctions(ctx.ruleType()));
		if (!ctx.trigger().isEmpty())
			currentRule.add(new Function(Function.TRIGGER, ctx.trigger(0).triggerValue().getText(), true));
		if (!ctx.attr().isEmpty())
			for (AttrContext attrContext : ctx.attr())
				currentRule.add(new Function(Function.ATTR, attrContext.getText(), true));
		rules.add(currentRule);
	}

	private List<Function> makeTypeFunctions(List<RuleTypeContext> ruleTypes) {
		List<Function> functions = new ArrayList<>();
		for (RuleTypeContext ruleType : ruleTypes)
			functions.add(new Function(Function.TYPE, ruleType.value().ID().getText(), ruleType.NOT() == null));
		return functions;
	}

	@Override
	public void enterText(@NotNull TextContext ctx) {
		if (BodyContext.class.isInstance(ctx.getParent()))
			currentRule.add(new Literal(ctx.getText()));
	}

	@Override
	public void enterExpression(@NotNull ExpressionContext ctx) {
		Expression expression = new Expression();
		for (ParseTree child : ctx.children)
			if (child instanceof MarkContext)
				expression.add(processAsMark(((MarkContext) child)));
			else if (child instanceof TextContext)
				expression.add(new Literal(child.getText()));
		currentRule.add(expression);
	}

	private Mark processAsMark(MarkContext child) {
		String option = child.ID().size() > 1 ? child.OPTION().getText() + child.ID(1).getText() : "";
		String separator = (child.SEPARATOR() != null) ? child.SEPARATOR().getText() : null;
		if (separator != null) separator = format(separator);
		Mark mark = new Mark(child.ID(0).getText() + option, child.LIST() != null, separator);
		if (child.format() != null) {
			String format = child.format().FORMAT_REGEX() != null ?
				child.format().FORMAT_REGEX().getText() : child.format().ID().getText();
			mark.setFormat(format);
		}
		return mark;
	}

	private String format(String separator) {
		String s = separator.substring(1, separator.length() - 1);
		s = s.replaceAll(NL_SEPARATOR, "\n");
		s = s.replaceAll(TAB_SEPARATOR, "\t");
		return s;
	}

	@Override
	public void enterMark(@NotNull MarkContext ctx) {
		if (!ExpressionContext.class.isInstance(ctx.getParent()))
			currentRule.add(processAsMark(ctx));
	}

	@Override
	public void visitErrorNode(@NotNull ErrorNode node) {
		throwError(node.getText());
	}

	private void throwError(String textNode) {
		logger.debug("Error reading template. Template not well formed. Node: " + textNode);
	}
}
