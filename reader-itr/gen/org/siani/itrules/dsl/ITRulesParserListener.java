// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ITRulesParser.g4 by ANTLR 4.5
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
	 * Enter a parse tree produced by {@link ITRulesParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull ITRulesParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ITRulesParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull ITRulesParser.FunctionContext ctx);
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