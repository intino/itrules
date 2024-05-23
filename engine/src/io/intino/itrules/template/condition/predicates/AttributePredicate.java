/*
 * Copyright 2024
 * Octavio Roncal Andrés
 * José Juan Hernández Cabrera
 * José Évora Gomez
 *
 * This File is Part of ItRules Project
 *
 * ItRules Project is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ItRules Project is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with itrules Library.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.intino.itrules.template.condition.predicates;

import io.intino.itrules.Frame;
import io.intino.itrules.Trigger;
import io.intino.itrules.template.condition.Predicate;
import io.intino.itrules.template.outputs.Placeholder;

import java.util.Iterator;

public class AttributePredicate implements Predicate {
	private final String attribute;
	private final boolean isThis;
	private final Object value;

	public AttributePredicate(String attribute) {
		this(attribute, null);
	}

	public AttributePredicate(String attribute, Object value) {
		this.isThis = attribute.equals(Placeholder.THIS) || attribute.isEmpty();
		this.attribute = this.isThis ? "" : attribute.toLowerCase();
		this.value = value;
	}

	public String attribute() {
		return attribute;
	}

	public Object value() {
		return value;
	}

	@Override
	public boolean evaluate(Trigger trigger) {
		return checkAttribute(trigger.frame()) && checkValue(trigger.frame());
	}

	private boolean checkAttribute(Frame frame) {
		return isThis ? frame != null : frame.contains(attribute);
	}

	private boolean checkValue(Frame frame) {
		if (value == null) return true;
		return isThis ? equalTo(frame.value()) : isIn(frame);
	}

	private boolean isIn(Frame frame) {
		Iterator<Frame> frames = frame.frames(attribute);
		while (frames.hasNext())
			if (equalTo(frames.next().value())) return true;
		return false;
	}

	private boolean equalTo(Object o) {
		if (o == null) return false;
		return this == o || o.toString().equalsIgnoreCase(value.toString());
	}

	@Override
	public String toString() {
		return "attribute(" + attribute + (value != null ? ", " + value : "") + ")";
	}
}