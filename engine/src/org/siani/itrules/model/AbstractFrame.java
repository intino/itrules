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

import java.util.*;

public abstract class AbstractFrame {

    protected static Map<String, List<AbstractFrame>> commonSlots = createCommonSlotMap();

	public abstract boolean is(String type);

    public abstract boolean isPrimitive();

    public abstract Iterator<AbstractFrame> frames(String slot);

    public abstract Object value();

    private static Map<String, List<AbstractFrame>> createCommonSlotMap() {
        Map<String, List<AbstractFrame>> slotMap = createSlotMap();
        slotMap.get("tab").add(new PrimitiveFrame("\t"));
        slotMap.get("nl").add(new PrimitiveFrame("\t"));
        return slotMap;
    }

    protected static Map<String, List<AbstractFrame>> createSlotMap() {
        return new LinkedHashMap<String, List<AbstractFrame>>() {

            @Override
            public List<AbstractFrame> put(String key, List<AbstractFrame> value) {
                return super.put(key.toLowerCase(), value);
            }

            @Override
            public List<AbstractFrame> get(Object key) {
                if (!containsKey(key)) put(key.toString(), new ArrayList<>());
                return super.get(key.toString().toLowerCase());
            }

            @Override
            public boolean containsKey(Object key) {
                return super.containsKey(key.toString().toLowerCase());
            }
        };
    }
}
