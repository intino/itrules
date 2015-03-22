// Generated from /Users/JJ/IdeaProjects/itrules/rule-engine-itr/src/org/siani/itrules/dsl/ITRulesParser.g4 by ANTLR 4.5
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ITRulesParser}.
 */
public interface ITRulesParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(@NotNull ITRulesParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull ITRulesParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#itrule}.
	 * @param ctx the parse tree
	 */
	void enterItrule(@NotNull ITRulesParser.ItruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#itrule}.
	 * @param ctx the parse tree
	 */
	void exitItrule(@NotNull ITRulesParser.ItruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(@NotNull ITRulesParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(@NotNull ITRulesParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#ruleType}.
	 * @param ctx the parse tree
	 */
	void enterRuleType(@NotNull ITRulesParser.RuleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#ruleType}.
	 * @param ctx the parse tree
	 */
	void exitRuleType(@NotNull ITRulesParser.RuleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ITRulesParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ITRulesParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(@NotNull ITRulesParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(@NotNull ITRulesParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#evalExpression}.
	 * @param ctx the parse tree
	 */
	void enterEvalExpression(@NotNull ITRulesParser.EvalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#evalExpression}.
	 * @param ctx the parse tree
	 */
	void exitEvalExpression(@NotNull ITRulesParser.EvalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#composedID}.
	 * @param ctx the parse tree
	 */
	void enterComposedID(@NotNull ITRulesParser.ComposedIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#composedID}.
	 * @param ctx the parse tree
	 */
	void exitComposedID(@NotNull ITRulesParser.ComposedIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#trigger}.
	 * @param ctx the parse tree
	 */
	void enterTrigger(@NotNull ITRulesParser.TriggerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#trigger}.
	 * @param ctx the parse tree
	 */
	void exitTrigger(@NotNull ITRulesParser.TriggerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#triggerValue}.
	 * @param ctx the parse tree
	 */
	void enterTriggerValue(@NotNull ITRulesParser.TriggerValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#triggerValue}.
	 * @param ctx the parse tree
	 */
	void exitTriggerValue(@NotNull ITRulesParser.TriggerValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#slotName}.
	 * @param ctx the parse tree
	 */
	void enterSlotName(@NotNull ITRulesParser.SlotNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#slotName}.
	 * @param ctx the parse tree
	 */
	void exitSlotName(@NotNull ITRulesParser.SlotNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#slotType}.
	 * @param ctx the parse tree
	 */
	void enterSlotType(@NotNull ITRulesParser.SlotTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#slotType}.
	 * @param ctx the parse tree
	 */
	void exitSlotType(@NotNull ITRulesParser.SlotTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#slotParm}.
	 * @param ctx the parse tree
	 */
	void enterSlotParm(@NotNull ITRulesParser.SlotParmContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#slotParm}.
	 * @param ctx the parse tree
	 */
	void exitSlotParm(@NotNull ITRulesParser.SlotParmContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ITRulesParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ITRulesParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull ITRulesParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull ITRulesParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull ITRulesParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull ITRulesParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#mark}.
	 * @param ctx the parse tree
	 */
	void enterMark(@NotNull ITRulesParser.MarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#mark}.
	 * @param ctx the parse tree
	 */
	void exitMark(@NotNull ITRulesParser.MarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link ITRulesParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(@NotNull ITRulesParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(@NotNull ITRulesParser.OptionContext ctx);
}