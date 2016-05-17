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

package org.siani.itrules.engine;

import org.siani.itrules.model.AbstractFrame;
import org.siani.itrules.model.marks.AbstractMark;

public final class Trigger {
    private final AbstractFrame frame;
    private AbstractMark mark;


    public Trigger(AbstractFrame frame, AbstractMark mark) {
        this.frame = frame;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark.toString();
    }

    public AbstractFrame frame() {
        return frame;
    }

    public AbstractMark mark() {
        return mark;
    }
}
