package siani.itrules.intellij.lang.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import siani.itrules.intellij.lang.ItrulesLanguage;

public class ItrulesElementType extends IElementType {

	public ItrulesElementType(@NotNull @NonNls String name) {
		super(name, ItrulesLanguage.INSTANCE);
	}
}
