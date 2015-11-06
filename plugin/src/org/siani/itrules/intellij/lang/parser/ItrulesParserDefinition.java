package org.siani.itrules.intellij.lang.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.intellij.lang.ItrulesLanguage;
import org.siani.itrules.intellij.lang.lexer.ItrulesLexerAdapter;
import org.siani.itrules.intellij.lang.psi.ItrulesTemplateImpl;
import org.siani.itrules.intellij.lang.psi.ItrulesTypes;

public class ItrulesParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create();

    public static final IFileElementType FILE = new IFileElementType(Language.findInstance(ItrulesLanguage.class));

    @NotNull
    @Override
    public com.intellij.lexer.Lexer createLexer(Project project) {
        return new ItrulesLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public com.intellij.lang.PsiParser createParser(final Project project) {
        return new ItrulesParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ItrulesTemplateImpl(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public com.intellij.psi.PsiElement createElement(ASTNode node) {
        return ItrulesTypes.Factory.createElement(node);
    }
}