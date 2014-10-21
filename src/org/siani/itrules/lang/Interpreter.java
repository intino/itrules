package org.siani.itrules.lang;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.siani.itrules.Function;
import org.siani.itrules.Logger;
import org.siani.itrules.lang.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.siani.itrules.lang.ITRulesParser.*;

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
		currentRule.addAll(makeTypeFunctions(ctx.ruleType()));
		if (!ctx.trigger().isEmpty())
			currentRule.add(new Condition(Function.TRIGGER, new String[]{ctx.trigger(0).triggerValue().getText()}, false));
		if (!ctx.slotName().isEmpty())
			for (SlotNameContext slotContext : ctx.slotName())
				currentRule.add(new Condition(Function.SLOT_NAME, getParameters(slotContext.slotParm()), false));
		if (!ctx.slotType().isEmpty())
			for (SlotTypeContext slotContext : ctx.slotType())
				currentRule.add(new Condition(Function.SLOT_TYPE, getParameters(slotContext.slotParm()), false));
		if (!ctx.eval().isEmpty())
			for (EvalContext eval : ctx.eval())
				currentRule.add(new Condition(Function.EVAL, getParameters(eval.evalExpression()), false));
		rules.add(currentRule);
	}

	private String[] getParameters(ParserRuleContext ruleContext) {
		String minorTokens = "(),";
		List<String> result = new ArrayList<>();
		for (ParseTree child : ruleContext.children)
			if (!minorTokens.contains(child.getText()))
				result.add(child.getText());
		return result.toArray(new String[result.size()]);
	}

	private List<Condition> makeTypeFunctions(List<RuleTypeContext> ruleTypes) {
		List<Condition> conditions = new ArrayList<>();
		for (RuleTypeContext ruleType : ruleTypes)
			conditions.add(new Condition(Function.TYPE, new String[]{ruleType.value().ID().getText()}, ruleType.NOT() != null));
		return conditions;
	}

	@Override
	public void enterText(@NotNull TextContext ctx) {
		if (BodyContext.class.isInstance(ctx.getParent())) {
			if (ctx.SCAPED_CHAR() != null) {
				currentRule.add(new Literal(ctx.getText().substring(1)));
			} else
				currentRule.add(new Literal(ctx.getText()));
		}
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
		logger.debug("Error reading template. Template not well formed: " + textNode.replace(RuleSetInputStream.ENDRULE_FOR_LEXER, "endrule") + "\n\n");
	}
}
