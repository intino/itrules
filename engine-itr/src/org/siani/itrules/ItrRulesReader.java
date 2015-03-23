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

package org.siani.itrules;

import org.siani.itrules.dsl.TemplateCompiler;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.model.Rule;
import org.siani.itrules.reader.DedentInputStream;
import org.siani.itrules.reader.RuleSetInputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ItrRulesReader implements RulesReader {

	private List<InputStream> inputs;

	public static RuleSet read(String rules) {
		return read(StringToInputStream(rules));
	}

	public static RuleSet read(InputStream inputStream) {
		return new ItrRulesReader(inputStream).read();
	}

	private static ByteArrayInputStream StringToInputStream(String rules) {
		return new ByteArrayInputStream(rules.getBytes(StandardCharsets.UTF_8));
	}

	public ItrRulesReader(InputStream... stream) {
		inputs = new ArrayList<>();
		for (InputStream input : stream)
			inputs.add(new DedentInputStream(new RuleSetInputStream(input)));
	}

	public RuleSet read() {
		List<Rule> rules = new ArrayList<>();
		for (InputStream inputStream : inputs)
			Collections.addAll(rules, new TemplateCompiler().compile(inputStream));
		return new RuleSet(rules.toArray(new Rule[rules.size()]));
	}
}
