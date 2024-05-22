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

// Generated from /Users/oroncal/workspace/infrastructure/itrules/reader-itr/src/io/intino/itrules/dsl/ItrParser.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link ItrParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(ItrParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(ItrParser.RuleContext ctx);
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
	 * Enter a parse tree produced by {@link ItrParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ItrParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ItrParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(ItrParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(ItrParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(ItrParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(ItrParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link ItrParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(ItrParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(ItrParser.ParameterContext ctx);
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
	 * Enter a parse tree produced by {@link ItrParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void enterPlaceholder(ItrParser.PlaceholderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ItrParser#placeholder}.
	 * @param ctx the parse tree
	 */
	void exitPlaceholder(ItrParser.PlaceholderContext ctx);
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