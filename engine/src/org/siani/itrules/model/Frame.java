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

import org.siani.itrules.engine.SlotSet;

import java.util.*;

public class Frame implements AbstractFrame {

    private final Set<String> types;
    private final SlotSet slots;

    public Frame() {
        this.types = createTypeSet();
        this.slots = SlotSet.create();
    }


    private static Set<String> createTypeSet() {
        HashSet<String> result = new HashSet<String>() {
            @Override
            public boolean contains(Object o) {
                return super.contains(o.toString().toLowerCase());
            }

            @Override
            public boolean add(String s) {
                return super.add(s.toLowerCase());
            }
        };
        return result;
    }

    public boolean is(String type) {
        return this.types.contains(type);
    }

    public String[] types() {
        return types.toArray(new String[types.size()]);
    }

    public String[] slots() {
        return slots.names();
    }

    public Iterator<AbstractFrame> frames(String slot) {
        return (slots.get(slot) != null) ? slots.get(slot).iterator() : Collections.<AbstractFrame>emptyList().iterator();
    }

    public Frame addTypes(List<String> types) {
        return addTypes(types.toArray(new String[types.size()]));
    }

    public Frame addTypes(String... types) {
        Collections.addAll(this.types, types);
        return this;
    }

    public Frame addSlots(SlotSet slots) {
        this.slots.add(slots);
        return this;
    }

    public Frame addSlot(String slot, AbstractFrame... frames) {
        for (AbstractFrame frame : frames) slots.get(slot).add(frame);
        return this;
    }

    public Frame addSlot(String slot, Object... values) {
        for (Object value : values) createSlot(slot, value.toString());
        return this;
    }

    public Frame addSlot(String slot, String... values) {
        for (String value : values) createSlot(slot, value);
        return this;
    }

    public Frame addSlot(String slot, Integer... values) {
        for (Integer value : values) createSlot(slot, value);
        return this;
    }

    public Frame addSlot(String slot, Boolean... values) {
        for (Boolean value : values) createSlot(slot, value);
        return this;
    }

    public Frame addSlot(String slot, Long... values) {
        for (Long value : values) createSlot(slot, value);
        return this;
    }

    public Frame addSlot(String slot, Double... values) {
        for (Double value : values) createSlot(slot, value);
        return this;
    }

    public Frame addSlot(String slot, Date... values) {
        for (Date value : values) createSlot(slot, value);
        return this;
    }

    private Frame createSlot(String slot, Object value) {
        slots.get(slot).add(new PrimitiveFrame(value));
        return this;
    }

    public boolean isPrimitive() {
        return false;
    }

    public Object value() {
        return null;
    }

    @Override
    public String toString() {
        return types.toString().replace(", object", "");
    }

}
