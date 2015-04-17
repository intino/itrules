// This is a generated file. Not intended for manual editing.
package org.siani.itrules.intellij.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.siani.itrules.intellij.lang.psi.ItrulesTypes.*;
import static org.siani.itrules.intellij.lang.parser.ItrulesParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ItrulesParser implements PsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b, 0);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  /* ********************************************************** */
  // (SCAPED_CHAR
  //          | RULE_BEGIN
  //          | RULE_END
  //          | DASH
  //          | UNDERDASH
  //          | MARK
  //          | LEFT_SQUARE
  //          | RIGHT_SQUARE
  //          | IDENTIFIER_KEY
  //          | TEXT)*
  static boolean root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root")) return false;
    int c = current_position_(b);
    while (true) {
      if (!root_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "root", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // SCAPED_CHAR
  //          | RULE_BEGIN
  //          | RULE_END
  //          | DASH
  //          | UNDERDASH
  //          | MARK
  //          | LEFT_SQUARE
  //          | RIGHT_SQUARE
  //          | IDENTIFIER_KEY
  //          | TEXT
  private static boolean root_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCAPED_CHAR);
    if (!r) r = consumeToken(b, RULE_BEGIN);
    if (!r) r = consumeToken(b, RULE_END);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, UNDERDASH);
    if (!r) r = consumeToken(b, MARK);
    if (!r) r = consumeToken(b, LEFT_SQUARE);
    if (!r) r = consumeToken(b, RIGHT_SQUARE);
    if (!r) r = consumeToken(b, IDENTIFIER_KEY);
    if (!r) r = consumeToken(b, TEXT);
    exit_section_(b, m, null, r);
    return r;
  }

}
