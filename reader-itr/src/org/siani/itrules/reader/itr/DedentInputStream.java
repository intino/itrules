/*
 * Copyright 2014 SIANI - ULPGC
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 * Ronni Ancorini
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

import java.io.IOException;
import java.io.InputStream;

class DedentInputStream extends InputStream {

    private final byte[] content;
    private int index = 0;

    public DedentInputStream(InputStream inputStream) {
        content = container(inputStream).content();
    }

    private DedentContainer container(InputStream inputStream)  {
        DedentContainer container = new DedentContainer("defrule", "endrule");
        try {
            return container.load(inputStream);
        } catch (IOException e) {
            return container;
        }
    }

    @Override
    public int read() throws IOException {
        return index >= content.length ? -1 : content[index++];
    }


}