package org.siani.itrules.intellij.lang.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class LexerAdapter extends FlexAdapter {
	public LexerAdapter() {
		super(new ItrulesLexer((Reader)null));
	}


}
