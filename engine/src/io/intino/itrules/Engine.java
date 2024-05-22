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

import io.intino.itrules.formatters.DateFormatters;
import io.intino.itrules.formatters.NumberFormatters;
import io.intino.itrules.formatters.StringFormatters;
import io.intino.itrules.template.Output;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;
import io.intino.itrules.template.Template.Configuration;
import io.intino.itrules.template.outputs.Expression;
import io.intino.itrules.template.outputs.Literal;
import io.intino.itrules.template.outputs.Placeholder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class Engine {
	private static final String Blanks = "  \t\n";
	private static final String NewLine = "\n";
	private final Iterable<Rule> ruleSet;
	private final Configuration configuration;
	private final Map<String, Formatter> formatters;
	private final Map<Class<?>, Adapter> adapters;

	public Engine(Template template) {
		this(template.ruleSet(), template.configuration());
	}

	public Engine(Iterable<Rule> ruleSet) {
		this(ruleSet, new Configuration());
	}

	public Engine(Iterable<Rule> ruleSet, Configuration configuration) {
		this.ruleSet = ruleSet;
		this.configuration = configuration;
		this.formatters = formattersFor(configuration);
		this.adapters = new HashMap<>();
	}

	public Engine add(String name, Formatter formatter) {
		formatters.put(name.toLowerCase(), formatter);
		return this;
	}

	public <T> Engine add(Class<T> class_, Adapter<T> adapter) {
		adapters.put(class_, adapter);
		return this;
	}

	public String render(Object object) {
		return generate(new Trigger("root").on(frameOf(object)));
	}

	private String generate(Trigger trigger) {
		return write(new Display(trigger).generate());
	}

	private String write(Canvas canvas) {
		return canvas.contentWith(configuration);
	}

	private Frame frameOf(Object object) {
		if (object instanceof Frame) return (Frame) object;
		if (object instanceof FrameBuilder) return ((FrameBuilder) object).toFrame();
		return new FrameBuilder().put(adapters).append(object).toFrame();
	}

	private Map<String, Formatter> formattersFor(Configuration configuration) {
		Map<String, Formatter> map = new HashMap<>();
		map.putAll(StringFormatters.get(configuration.locale()));
		map.putAll(NumberFormatters.get(configuration.locale()));
		map.putAll(DateFormatters.get(configuration.locale()));
		return map;
	}

	static Frame resolve(Frame frame, String[] path) {
		if (path == null || path.length == 0) return frame;
		Frame current = frame;
		for (String step : path)
			if (step.equalsIgnoreCase("container")) current = current.container();
			else if (step.equalsIgnoreCase("root")) current = root(current);
			else {
				Iterator<Frame> frames = frame.frames(step.toLowerCase());
				if (frames.hasNext()) current = frames.next();
				else return frame;
			}
		return current;
	}

	private static Frame root(Frame frame) {
		Frame current = frame;
		while (current != null) {
			if (current.container() == null) return current;
			current = current.container();
		}
		return current;
	}

	private class Display {
		private final Trigger trigger;
		private final Canvas canvas;

		Display(Trigger trigger) {
			this.trigger = trigger;
			this.canvas = new Canvas();
		}

		private Display set(boolean constant) {
			if (constant) canvas.touch();
			return this;
		}

		Canvas generate() {
			return generate(ruleFor(trigger).outputs());
		}

		private Canvas generate(Stream<Output> outputs) {
			outputs.forEach(this::write);
			return canvas;
		}

		private Rule ruleFor(Trigger trigger) {
			for (Rule rule : ruleSet) if (rule.condition().evaluate(trigger)) return rule;
			return defaultRule(trigger.frame());
		}

		private Rule defaultRule(Frame frame) {
			return hasValue(frame) ?
					new Rule().output(Placeholder.This) :
					new Rule().output();
		}

		private void write(Output output) {
			if (output instanceof Literal) write((Literal) output);
			if (output instanceof Placeholder) write((Placeholder) output);
			if (output instanceof Expression) write((Expression) output);
		}

		private void write(Literal literal) {
			append(canvas, literal.toString());
		}

		private void write(Placeholder placeholder) {
			append(canvas, placeholder.isThis() ? evaluateThis(trigger.frame(), placeholder.formatters()) : evaluate(placeholder));
		}

		private void write(Expression expression) {
			Canvas o = evaluate(expression);
			if (o.isNotTouched() || o.isEmpty()) canvas.backSpaces();
			append(canvas, o);
		}

		private Canvas evaluateThis(Frame frame, String[] formatters) {
			return hasValue(frame) ? evaluateThis(format(frame, formatters)) : new Canvas();
		}

		private Frame format(Frame frame, String[] formatters) {
			if (formatters.length == 0) return frame;
			Object object = frame.value() != null ? frame.value() : frame;
			for (String name : formatters)
				object = formatter(name).format(object);
			return frameOf(object);
		}

		private Formatter formatter(String name) {
			name = name.trim().toLowerCase();
			return formatters.getOrDefault(name, Formatter.Null);
		}

		private Canvas evaluateThis(Frame frame) {
			return new Canvas().append(valueOf(frame)).touch();
		}

		private Canvas evaluate(Placeholder placeholder) {
			return hasContent(placeholder) ? evaluate(placeholder, trigger.frames(placeholder)) : new Canvas();
		}

		private Canvas evaluate(Placeholder placeholder, Iterator<Frame> frames) {
			Canvas canvas = new Canvas();
			while (frames.hasNext()) {
				Frame frame = frames.next();
				append(canvas, evaluate(placeholder, frame), placeholder.separator());
			}
			return canvas;
		}

		private Canvas evaluate(Placeholder placeholder, Frame frame) {
			Canvas canvas = new Display(new Trigger(placeholder.fullName()).on(format(frame, placeholder.formatters()))).generate();
			if (canvas.isNotEmpty()) canvas.touch();
			return canvas;
		}

		private boolean hasValue(Frame frame) {
			return frame.value() != null;
		}

		private boolean hasContent(Placeholder placeholder) {
			Frame frame = resolve(trigger.frame(), placeholder.targetPath());
			return frame.frames(placeholder.name()).hasNext();
		}

		private Canvas evaluate(Expression expression) {
			Canvas canvas = new Display(trigger)
					.set(expression.isConstant())
					.generate(expression.outputs());
			return canvas.isTouched() ? canvas.stake() : validate(expression.next());
		}

		private Canvas validate(Expression expression) {
			return expression != null ? evaluate(expression) : new Canvas();
		}

		private void append(Canvas canvas, String str) {
			canvas.append(str);
		}

		private void append(Canvas canvas, Canvas o, String separator) {
			if (o.isNotTouched()) return;
			if (canvas.isNotEmpty()) canvas.append(separator);
			canvas.append(o.toString()).touch();
		}

		private void append(Canvas canvas, Canvas o) {
			if (o.isNotTouched()) return;
			canvas.append(indent(o.toString())).touch();
		}

		private String valueOf(Frame frame) {
			return frame.value().toString();
		}

		private String indent(String str) {
			return canvas.hasNewLines() ? replaceNewLines(str) : str;
		}

		private String replaceNewLines(String str) {
			return str.replace(NewLine, NewLine + indentOf(canvas.toString()));
		}

		private String indentOf(String str) {
			return onlyBlanks(str.substring(lastNewLine(str) + 1));
		}

		private int lastNewLine(String str) {
			return str.lastIndexOf(NewLine);
		}

		private String onlyBlanks(String str) {
			if (str.isEmpty()) return "";
			int first = str.charAt(0) == '\uFFFF' ? 1 : 0;
			int last = first;
			while ((last < str.length()) && isBlank(str.charAt(last))) last++;
			return str.substring(first, last);
		}
	}

	private static class Canvas {
		private final StringBuilder sb;
		private boolean touched;

		public Canvas() {
			this.sb = new StringBuilder();
			touched = false;
		}

		Canvas append(String s) {
			sb.append(s);
			return this;
		}

		String contentWith(Configuration configuration) {
			return clean(withoutStakes(sb)
					.toString())
					.collect(joining(configuration.isCRLF() ? "\r\n" : "\n"));
		}

		private Stream<String> clean(String str) {
			return clean(str.split(NewLine));
		}

		private Stream<String> clean(String[] lines) {
			return stream(lines).map(this::cleanLine);
		}

		private String cleanLine(String line) {
			return line.replaceAll("^\\s*$", "");
		}


		Canvas touch() {
			this.touched = true;
			return this;
		}

		boolean isTouched() {
			return touched;
		}

		boolean isNotTouched() {
			return !isTouched();
		}

		Canvas stake() {
			sb.appendCodePoint(0xFFFF);
			return this;
		}

		private StringBuilder withoutStakes(StringBuilder sb) {
			return sb.codePoints()
					.filter(c -> c != 0xFFFF)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
		}

		public boolean isEmpty() {
			return sb.isEmpty();
		}

		public boolean isNotEmpty() {
			return !sb.isEmpty();
		}

		private void backSpaces() {
			int index = sb.length() - 1;
			while ((index >= 0) && isBlank(sb.charAt(index))) index--;
			sb.delete(index + 1, sb.length());
		}

		public boolean hasNewLines() {
			return sb.indexOf(NewLine) >= 0;
		}

		@Override
		public String toString() {
			return sb.toString();
		}
	}

	private static boolean isBlank(char c) {
		return Blanks.indexOf(c) >= 0;
	}
}