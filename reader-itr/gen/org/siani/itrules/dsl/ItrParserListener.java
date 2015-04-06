// Generated from /Users/oroncal/workspace/itrules/reader-itr/src/org/siani/itrules/dsl/ItrParser.g4 by ANTLR 4.5
package org.siani.itrules.dsl;
import org.antlr.v4.runtime.misc.NotNull;
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
	void enterRoot(@NotNull ItrParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull ItrParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#defintion}.
	 * @param ctx the parse tree
	 */
	void enterDefintion(@NotNull ItrParser.DefintionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#defintion}.
	 * @param ctx the parse tree
	 */
	void exitDefintion(@NotNull ItrParser.DefintionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(@NotNull ItrParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(@NotNull ItrParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(@NotNull ItrParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(@NotNull ItrParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ItrParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ItrParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(@NotNull ItrParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(@NotNull ItrParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull ItrParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull ItrParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull ItrParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull ItrParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#mark}.
	 * @param ctx the parse tree
	 */
	void enterMark(@NotNull ItrParser.MarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#mark}.
	 * @param ctx the parse tree
	 */
	void exitMark(@NotNull ItrParser.MarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(@NotNull ItrParser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(@NotNull ItrParser.OptionContext ctx);
}