package io.intino.itrules.intellij.lang.lexer;

import com.intellij.psi.tree.IElementType;
import io.intino.itrules.intellij.lang.psi.ItrulesTypes;

%%

%class ItrulesLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType


SCAPED_CHAR         = "$$"| "$[" | "$]"
DEFRULE             = "def"
ENDRULE             = "end"
DASH                = "-"
UNDERDASH           = "_"
MARK                = "$" {IDENTIFIER_KEY}
LEFT_SQUARE         = "["
RIGHT_SQUARE        = "]"
IDENTIFIER_KEY      = [:jletter:] ([:jletterdigit:] | {UNDERDASH} | {DASH})*

%%
<YYINITIAL> {
	{DEFRULE}                       {   return ItrulesTypes.DEFRULE; }
	{ENDRULE}                       {   return ItrulesTypes.ENDRULE; }
	{MARK}                          {   return ItrulesTypes.MARK; }
	{LEFT_SQUARE}                   {   return ItrulesTypes.LEFT_SQUARE; }
	{RIGHT_SQUARE}                  {   return ItrulesTypes.RIGHT_SQUARE; }
	{SCAPED_CHAR}                   {   return ItrulesTypes.SCAPED_CHAR; }
}

[^]                                 { return ItrulesTypes.TEXT;}
.                                   { return ItrulesTypes.TEXT;}