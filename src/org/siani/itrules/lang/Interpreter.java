package org.siani.itrules.lang;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.siani.itrules.Function;
import org.siani.itrules.ITRulesLogger;
import org.siani.itrules.lang.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.siani.itrules.lang.ITRulesParser.*;

final class Interpreter extends ITRulesParserBaseListener {

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
			currentRule.add(new Condition(Function.TRIGGER, ctx.trigger(0).triggerValue().getText(), false));
		if (!ctx.attr().isEmpty())
			for (AttrContext attrContext : ctx.attr())
				currentRule.add(new Condition(Function.ATTR, attrContext.getText(), false));
		rules.add(currentRule);
	}

	private List<Condition> makeTypeFunctions(List<RuleTypeContext> ruleTypes) {
		List<Condition> conditions = new ArrayList<>();
		for (RuleTypeContext ruleType : ruleTypes)
			conditions.add(new Condition(Function.TYPE, ruleType.value().ID().getText(), ruleType.NOT() != null));
		return conditions;
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
