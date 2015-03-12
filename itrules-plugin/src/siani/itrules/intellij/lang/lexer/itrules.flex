package siani.tara.intellij.lang.lexer;


import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import siani.tara.intellij.lang.psi.TaraTypes;
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
	{RULE_BEGIN}                        {   return TaraTypes.RULE_BEGIN; }
	{RULE_END}                          {   return TaraTypes.RULE_END; }
	{MARK}                              {   return TaraTypes.MARK; }
	{EXPRESSION}                        {   return TaraTypes.EXPRESSION; }
	{SCAPED_CHAR}                       {   return TaraTypes.SCAPED_CHAR; }
}

[^]                                 { return TokenType.BAD_CHARACTER;}
.                                   { return TokenType.BAD_CHARACTER;}