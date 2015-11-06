package org.siani.itrules.intellij.lang.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.siani.itrules.intellij.lang.ItrulesLanguage;

public class ItrulesTokenType extends IElementType {
    public ItrulesTokenType(@NotNull @NonNls String debugName) {
        super(debugName, ItrulesLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "ItrulesTokenType." + super.toString();
    }
}