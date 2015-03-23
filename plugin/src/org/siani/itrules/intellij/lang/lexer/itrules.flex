package org.siani.itrules.intellij.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.siani.itrules.intellij.lang.psi.ItrulesTypes;
import com.intellij.psi.TokenType;
import java.util.LinkedList;

%%

%class ItrulesLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType


SCAPED_CHAR         = "$$"| "$[" | "$]"
RULE_BEGIN          = "defrule"
RULE_END            = "endrule"
DASH                = "-"
UNDERDASH           = "_"
MARK                = "$" {IDENTIFIER_KEY}
EXPRESSION           = "[" | "]"
IDENTIFIER_KEY      = [:jletter:] ([:jletterdigit:] | {UNDERDASH} | {DASH})*

%%
<YYINITIAL> {
	{RULE_BEGIN}                        {   return ItrulesTypes.RULE_BEGIN; }
	{RULE_END}                          {   return ItrulesTypes.RULE_END; }
	{MARK}                              {   return ItrulesTypes.MARK; }
	{EXPRESSION}                        {   return ItrulesTypes.EXPRESSION; }
	{SCAPED_CHAR}                       {   return ItrulesTypes.SCAPED_CHAR; }
}

[^]                                 { return TokenType.BAD_CHARACTER;}
.                                   { return TokenType.BAD_CHARACTER;}