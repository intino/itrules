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

import java.util.Iterator;

public interface AbstractFrame {

	public boolean is(String type);

	public boolean isPrimitive();

	public Iterator<AbstractFrame> getFrames(String slot);

	public Object value();

	public AbstractFrame findFrame(String path);

	public AbstractFrame searchByType(String type);

	public AbstractFrame deepSearchByType(String type);

	public AbstractFrame searchByName(String name);

	public AbstractFrame deepSearchByName(String name);
}