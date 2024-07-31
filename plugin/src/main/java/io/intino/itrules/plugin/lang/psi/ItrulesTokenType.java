package io.intino.itrules.plugin.lang.psi;

import com.intellij.psi.tree.IElementType;
import io.intino.itrules.plugin.lang.ItrulesLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ItrulesTokenType extends IElementType {
	public ItrulesTokenType(@NotNull @NonNls String debugName) {
		super(debugName, ItrulesLanguage.INSTANCE);
	}

	@Override
	public String toString() {
		return "ItrulesTokenType." + super.toString();
	}
}