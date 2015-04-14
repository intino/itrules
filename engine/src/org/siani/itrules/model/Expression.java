/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of itrules Project
 *
 * itrules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * itrules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.siani.itrules.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Expression extends Token.Body implements Iterable<Token> {
	private List<Token> tokens;

	public Expression() {
		tokens = new ArrayList<>();
	}

	public Expression add(Body token) {
		if (!tokens.isEmpty())
			token.prevToken(tokens.get(tokens.size() - 1));
		tokens.add(token);
		return this;
	}

	@Override
	public Iterator<Token> iterator() {
		return tokens.iterator();
	}
}
