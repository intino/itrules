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
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ItrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ItrParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ItrParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(ItrParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(ItrParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(ItrParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ItrParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ItrParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(ItrParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(ItrParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(ItrParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ItrParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ItrParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#expressionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBody(ItrParser.ExpressionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(ItrParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#placeholder}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaceholder(ItrParser.PlaceholderContext ctx);
	/**
	 * Visit a parse tree produced by {@link ItrParser#option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOption(ItrParser.OptionContext ctx);
}