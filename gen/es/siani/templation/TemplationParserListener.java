// Generated from /Users/oroncal/workspace/sandbox/templation/src/es/siani/templation/TemplationParser.g4 by ANTLR 4.4.1-dev
package es.siani.templation;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TemplationParser}.
 */
public interface TemplationParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TemplationParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(@NotNull TemplationParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplationParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(@NotNull TemplationParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplationParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(@NotNull TemplationParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplationParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(@NotNull TemplationParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplationParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull TemplationParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplationParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull TemplationParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplationParser#blockID}.
	 * @param ctx the parse tree
	 */
	void enterBlockID(@NotNull TemplationParser.BlockIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplationParser#blockID}.
	 * @param ctx the parse tree
	 */
	void exitBlockID(@NotNull TemplationParser.BlockIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplationParser#mark}.
	 * @param ctx the parse tree
	 */
	void enterMark(@NotNull TemplationParser.MarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplationParser#mark}.
	 * @param ctx the parse tree
	 */
	void exitMark(@NotNull TemplationParser.MarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplationParser#separator}.
	 * @param ctx the parse tree
	 */
	void enterSeparator(@NotNull TemplationParser.SeparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplationParser#separator}.
	 * @param ctx the parse tree
	 */
	void exitSeparator(@NotNull TemplationParser.SeparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplationParser#blockBody}.
	 * @param ctx the parse tree
	 */
	void enterBlockBody(@NotNull TemplationParser.BlockBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplationParser#blockBody}.
	 * @param ctx the parse tree
	 */
	void exitBlockBody(@NotNull TemplationParser.BlockBodyContext ctx);
}