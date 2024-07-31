package io.intino.itrules.plugin.lang.psi;

import com.intellij.psi.tree.IElementType;
import io.intino.itrules.plugin.lang.ItrulesLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ItrulesElementType extends IElementType {

    public ItrulesElementType(@NotNull @NonNls String name) {
        super(name, ItrulesLanguage.INSTANCE);
    }
}
