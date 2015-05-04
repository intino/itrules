// This is a generated file. Not intended for manual editing.
package org.siani.itrules.intellij.lang.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface ItrulesTypes {


  IElementType DASH = new ItrulesTokenType("DASH");
  IElementType DEFRULE = new ItrulesTokenType("DEFRULE");
  IElementType ENDRULE = new ItrulesTokenType("ENDRULE");
  IElementType IDENTIFIER_KEY = new ItrulesTokenType("IDENTIFIER_KEY");
  IElementType LEFT_SQUARE = new ItrulesTokenType("LEFT_SQUARE");
  IElementType MARK = new ItrulesTokenType("MARK");
  IElementType RIGHT_SQUARE = new ItrulesTokenType("RIGHT_SQUARE");
  IElementType SCAPED_CHAR = new ItrulesTokenType("SCAPED_CHAR");
  IElementType TEXT = new ItrulesTokenType("TEXT");
  IElementType UNDERDASH = new ItrulesTokenType("UNDERDASH");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
