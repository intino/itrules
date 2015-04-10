package org.siani.itrules.intellij.highlighting;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.siani.itrules.intellij.lang.psi.ItrulesTypes;

public class ItrulesBraceMatcher implements PairedBraceMatcher {
	private final BracePair[] pairs;

	public ItrulesBraceMatcher() {
		pairs = new BracePair[]{
			new BracePair(ItrulesTypes.LEFT_SQUARE, ItrulesTypes.RIGHT_SQUARE, false),
		};
	}

	public BracePair[] getPairs() {
		return pairs;
	}

	public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType braceType, @Nullable IElementType tokenType) {
		return true;
	}

	public int getCodeConstructStart(final PsiFile file, int openingBraceOffset) {
		return openingBraceOffset;
	}
}