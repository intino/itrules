package org.siani.itrules.intellij.lang.psi;

import com.intellij.psi.tree.IElementType;

public interface ItrulesTypes {
	IElementType RULE_BEGIN = new ItrulesElementType("RULE_BEGIN");
	IElementType RULE_END = new ItrulesElementType("RULE_END");
	IElementType MARK = new ItrulesElementType("MARK");
	IElementType LEFT_SQUARE = new ItrulesElementType("LEFT_SQUARE");
	IElementType RIGHT_SQUARE = new ItrulesElementType("RIGHT_SQUARE");
	IElementType SCAPED_CHAR = new ItrulesElementType("SCAPED_CHAR");
}
