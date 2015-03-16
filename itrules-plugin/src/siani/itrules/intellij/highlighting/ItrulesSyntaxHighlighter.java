package siani.itrules.intellij.highlighting;

import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import siani.itrules.intellij.lang.lexer.LexerAdapter;
import siani.itrules.intellij.lang.psi.ItrulesTypes;

import java.util.HashMap;
import java.util.Map;

public class ItrulesSyntaxHighlighter extends SyntaxHighlighterBase implements ItrulesTypes {
	public static final Map<TextAttributesKey, Pair<String, HighlightSeverity>> DISPLAY_NAMES = new HashMap<>();
	private static final Map<IElementType, TextAttributesKey> KEYS;
	public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("Itrules_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey IDENTIFIER = TextAttributesKey.createTextAttributesKey("Itrules_IDENTIFIER", DefaultLanguageHighlighterColors.STATIC_METHOD);

	static {
		KEYS = new HashMap<>();
		DISPLAY_NAMES.put(IDENTIFIER, Pair.<String, HighlightSeverity>create("Identifier", null));
		DISPLAY_NAMES.put(KEYWORD, Pair.<String, HighlightSeverity>create("Keyword", null));

		KEYS.put(ItrulesTypes.RULE_BEGIN, KEYWORD);
		KEYS.put(ItrulesTypes.RULE_END, KEYWORD);
		KEYS.put(ItrulesTypes.MARK, IDENTIFIER);
		KEYS.put(ItrulesTypes.SCAPED_CHAR, IDENTIFIER);
		KEYS.put(ItrulesTypes.EXPRESSION, KEYWORD);
	}

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new LexerAdapter();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
		return SyntaxHighlighterBase.pack(KEYS.get(tokenType));
	}
}
