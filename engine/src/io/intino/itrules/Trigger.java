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

package io.intino.itrules;

import io.intino.itrules.template.condition.Predicate;
import io.intino.itrules.template.outputs.Placeholder;

import java.util.Iterator;

public class Trigger {
	private final String name;
	private Frame frame;

	public Trigger(String name) {
		this.name = name.toLowerCase();
	}

	public Trigger on(Frame frame) {
		this.frame = frame;
		return this;
	}

	public String name() {
		return name;
	}

	public Frame frame() {
		return frame;
	}

	Iterator<Frame> frames(String slot) {
		return frame.frames(slot.toLowerCase());
	}

	Iterator<Frame> frames(Placeholder placeholder) {
		Frame frame = Engine.resolve(this.frame, placeholder.targetPath());
		return frame.frames(placeholder.name().toLowerCase());
	}

	boolean check(Predicate condition) {
		return condition.evaluate(this);
	}
}
