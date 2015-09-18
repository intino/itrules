// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ItrParser.g4 by ANTLR 4.5.1
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ItrParser}.
 */
public interface ItrParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ItrParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(ItrParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(ItrParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(ItrParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(ItrParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(ItrParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(ItrParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ItrParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ItrParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ItrParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ItrParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ItrParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ItrParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#expressionBody}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBody(ItrParser.ExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#expressionBody}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBody(ItrParser.ExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(ItrParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(ItrParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#mark}.
	 * @param ctx the parse tree
	 */
	void enterMark(ItrParser.MarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#mark}.
	 * @param ctx the parse tree
	 */
	void exitMark(ItrParser.MarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(ItrParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(ItrParser.OptionContext ctx);
}