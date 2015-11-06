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

package org.siani.itrules.readers;

import org.siani.itrules.RuleSetReader;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.parser.ITRulesSyntaxError;
import org.siani.itrules.parser.TemplateParser;

import java.io.InputStream;
import java.nio.charset.Charset;

public final class ItrRuleSetReader implements RuleSetReader {

    private InputStream inputStream;

    public ItrRuleSetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public RuleSet read(Charset charset) throws ITRulesSyntaxError {
        return new RuleSet(new TemplateParser().parse(inputStream, charset));
    }
}
