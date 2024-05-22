/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.formatters.inflectors;

import io.intino.itrules.formatters.StringFormatters;

public class SpanishPluralInflector extends StringFormatters.PluralInflector {

	@Override
	public String plural(String word) {
		if (isIrregular(word)) return irregularPlural(word);
		return doReplaces(word + "es");
	}

	@Override
	protected void setReplaces() {
		addReplace("zes", "ces");
		addReplace("xes", "x");
		addReplace("ses", "s");
		addReplace("aes", "as");
		addReplace("ees", "es");
		addReplace("ies", "is");
		addReplace("oes", "os");
		addReplace("ues", "us");
	}

	@Override
	protected void setIrregulars() {

	}

}
