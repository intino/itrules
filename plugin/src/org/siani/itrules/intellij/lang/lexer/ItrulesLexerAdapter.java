package org.siani.itrules.intellij.lang.lexer;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class ItrulesLexerAdapter extends FlexAdapter {
	public ItrulesLexerAdapter() {
		super(new ItrulesLexer((Reader) null));
	}


}
