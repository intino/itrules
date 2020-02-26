package io.intino.itrules;

import io.intino.itrules.Rule.Output;
import io.intino.itrules.formatters.DateFormatters;
import io.intino.itrules.formatters.NumberFormatters;
import io.intino.itrules.formatters.StringFormatters;
import io.intino.itrules.rules.output.Expression;
import io.intino.itrules.rules.output.Literal;
import io.intino.itrules.rules.output.Mark;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator.CRLF;
import static io.intino.itrules.TemplateEngine.Configuration.LineSeparator.LF;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class TemplateEngine {
	private static final String Blanks = "  \t\n";
	private static final String NewLine = "\n";

	private final RuleSet ruleSet;
	private final Configuration configuration;
	private final Map<String, Formatter> formatters;
	private final Map<Class, Adapter> adapters;

	public TemplateEngine(RuleSet ruleSet) {
		this(ruleSet, new Configuration());
	}

	public TemplateEngine(RuleSet ruleSet, Configuration configuration) {
		this.ruleSet = ruleSet;
		this.configuration = configuration;
		this.formatters = formattersFor(configuration);
		this.adapters = new HashMap<>();
	}

	public TemplateEngine add(String name, Formatter formatter) {
		formatters.put(name.toLowerCase(), formatter);
		return this;
	}

	public <T> TemplateEngine add(Class<T> class_, Adapter<T> adapter) {
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
		map.putAll(StringFormatters.get(configuration.locale));
		map.putAll(NumberFormatters.get(configuration.locale));
		map.putAll(DateFormatters.get(configuration.locale));
		return map;
	}

	public static class Configuration {
		private Locale locale;
		private LineSeparator lineSeparator;

		public Configuration(Locale locale, LineSeparator lineSeparator) {
			this.locale = locale;
			this.lineSeparator = lineSeparator;
		}

		Configuration() {
			this(Locale.ENGLISH, LF);
		}

		boolean isCRLF() {
			return lineSeparator == CRLF;
		}

		public enum LineSeparator {
			LF, CRLF
		}
	}

	public static class Trigger {
		private final String name;
		private Frame frame;

		Trigger(String name) {
			this.name = name.toLowerCase();
		}

		Trigger on(Frame frame) {
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

		boolean check(Rule.Condition condition) {
			return condition.check(this);
		}

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
			for (Rule rule : ruleSet)
				if (rule.conditions().allMatch(trigger::check)) return rule;
			return defaultRule(trigger.frame);
		}

		private Rule defaultRule(Frame frame) {
			return hasValue(frame) ?
					new Rule().output(Mark.This) :
					new Rule().output();
		}

		private void write(Output output) {
			if (output instanceof Literal) write((Literal) output);
			if (output instanceof Mark) write((Mark) output);
			if (output instanceof Expression) write((Expression) output);
		}

		private void write(Literal literal) {
			append(canvas, literal.toString());
		}

		private void write(Mark mark) {
			append(canvas, mark.isThis() ? evaluateThis(trigger.frame, mark.formatters()) : evaluate(mark));
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

		private Canvas evaluate(Mark mark) {
			return hasContent(mark) ? evaluate(mark, trigger.frames(mark.name())) : new Canvas();
		}

		private Canvas evaluate(Mark mark, Iterator<Frame> frames) {
			Canvas canvas = new Canvas();
			while (frames.hasNext()) {
				Frame frame = frames.next();
				append(canvas, evaluate(mark, frame), mark.separator());
			}
			return canvas;
		}

		private Canvas evaluate(Mark mark, Frame frame) {
			Canvas canvas = new Display(new Trigger(mark.fullName()).on(format(frame, mark.formatters()))).generate();
			if (canvas.isNotEmpty()) canvas.touch();
			return canvas;
		}

		private boolean hasValue(Frame frame) {
			return frame.value() != null;
		}

		private boolean hasContent(Mark mark) {
			return trigger.frames(mark.name()).hasNext();
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
			return str.substring(first,last);
		}
	}

	private static class Canvas {
		private StringBuilder sb;
		private boolean touched;

		public Canvas() {
			this.sb = new StringBuilder();
			touched = false;
		}

		Canvas append(String s){
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


		Canvas 	touch() {
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
			return sb.length() == 0;
		}

		public boolean isNotEmpty() {
			return sb.length() > 0;
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
