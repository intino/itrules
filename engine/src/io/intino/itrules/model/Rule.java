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

package io.intino.itrules.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rule extends Token {

	private List<Token> tokens;
	private List<Condition> conditions;

	public Rule() {
		tokens = new ArrayList<>();
		conditions = new ArrayList<>();
	}

	public Rule add(Condition... conditions) {
		Collections.addAll(this.conditions, conditions);
		return this;
	}

	public Rule add(Body token) {
		if (!tokens.isEmpty())
			token.previous(tokens.get(tokens.size() - 1));
		tokens.add(token);
		return this;
	}

	public Rule add(Body... tokens) {
		for (Body token : tokens) add(token);
		return this;
	}

	public Iterable<Condition> conditions() {
		return conditions;
	}

	public Iterable<Token> tokens() {
		return tokens;
	}
}
