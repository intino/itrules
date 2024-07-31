package io.intino.itrules.plugin.lang.lexer;

import com.intellij.lexer.FlexAdapter;

public class ItrulesLexerAdapter extends FlexAdapter {
	public ItrulesLexerAdapter() {
		super(new ItrulesLexer(null));
	}


}
