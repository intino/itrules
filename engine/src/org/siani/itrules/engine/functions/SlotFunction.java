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

package org.siani.itrules.engine.functions;

import org.siani.itrules.Function;
import org.siani.itrules.engine.FunctionEvaluator;
import org.siani.itrules.engine.Trigger;
import org.siani.itrules.model.AbstractFrame;

import java.util.Iterator;

public final class SlotFunction implements Function {

    @Override
    public boolean match(Trigger trigger, String parameter) {
        return new FunctionEvaluator(parameter).evaluate(v-> matchSlot(trigger, v));
    }

    private boolean matchSlot(Trigger trigger, String condition) {
        return condition.contains(":") ?  match(trigger.frame(), condition.split(":")) : hasSlot(trigger.frame(), condition);
    }

    private boolean match(AbstractFrame frame, String[] condition) {
        return hasSlotValue(frame, condition[0], condition[1]);
    }

    private boolean hasSlot(AbstractFrame frame, String slot) {
        return frame.isPrimitive() ? slot.equalsIgnoreCase("value") : frame.frames(slot).hasNext();
    }

    private boolean hasSlotValue(AbstractFrame frame, String slot, String value) {
        return frame.isPrimitive() ? value.equalsIgnoreCase(frame.value().toString()) : checkAny(frame.frames(slot),value);
    }

    private boolean checkAny(Iterator<AbstractFrame> frames, String value) {
        while (frames.hasNext()) {
            AbstractFrame frame = frames.next();
            if (frame.isPrimitive() && value.equalsIgnoreCase(frame.value().toString())) return true;
        }
        return false;
    }



}
