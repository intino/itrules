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

package org.siani.itrules.reader.itr;

import org.siani.itrules.dsl.TemplateCompiler;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.model.Rule;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RuleSetReader implements org.siani.itrules.RuleSetReader {

    private InputStream inputStream;

    public RuleSetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    private InputStream stream(InputStream stream) {
        return new RuleSetInputStream(new DedentInputStream(stream));
    }

	public RuleSet read() {
        return new RuleSet(new TemplateCompiler().compile(stream(inputStream)));
	}
}
