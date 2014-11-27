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

import org.siani.itrules.lang.TemplateCompiler;
import org.siani.itrules.model.Rule;

import java.io.*;

public final class TemplateReader implements RuleReader {

	private InputStream input;

	public TemplateReader(File file) throws FileNotFoundException {
		this(new FileInputStream(file));
	}

	public TemplateReader(String stream) {
		this(new ByteArrayInputStream(stream.getBytes()));
	}

	public TemplateReader(InputStream stream) {
		input = new DedentInputStream(new RuleSetInputStream(stream));
	}

	public Rule[] read() {
		return new TemplateCompiler().compile(input);
	}
}
