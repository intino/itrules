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
	private static final int Flag = 0xFFF1;
	private static final String Blanks = "  \t\n";
	private final RuleSet ruleSet;
	private final Writer writer;
	private final Map<String, Formatter> formatters;
	private final Map<Class, Adapter> adapters;

	public TemplateEngine(RuleSet ruleSet) {
		this(ruleSet, new Configuration());
	}

	public TemplateEngine(RuleSet ruleSet, Configuration configuration) {
		this.ruleSet = ruleSet;
		this.writer = writerFor(configuration);
		this.formatters = formattersFor(configuration);
		this.adapters = new HashMap<>();
	}

	private static String indentOf(StringBuilder sb) {
		int index = sb.lastIndexOf("\n");
		return index >= 0 && index < sb.length() - 1 ? sb.substring(index + 1, sb.length()) : "";
	}

	private static boolean hasFlag(StringBuilder sb) {
		return sb.codePoints().anyMatch(c -> c == Flag);
	}

	private static String withoutFlags(StringBuilder sb) {
		return sb.codePoints().filter(c -> c < Flag)
				.collect(StringBuilder::new,
						StringBuilder::appendCodePoint,
						StringBuilder::append)
				.toString();
	}

	public TemplateEngine add(String name, Formatter formatter) {
		formatters.put(name, formatter);
		return this;
	}

	public <T> TemplateEngine add(Class<T> class_, Adapter<T> adapter) {
		adapters.put(class_, adapter);
		return this;
	}

	public String render(Object object) {
		return start(new Trigger("root").on(frameOf(object)));
	}

	private String start(Trigger trigger) {
		return write(new Display(trigger).generate());
	}

	private String write(StringBuilder sb) {
		return writer.write(sb);
	}

	private Frame frameOf(Object object) {
		if (object instanceof Frame) return (Frame) object;
		return new FrameBuilder().put(adapters).append(object).toFrame();
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

	private Writer writerFor(Configuration configuration) {
		return new Writer(configuration);
	}

	private Map<String, Formatter> formattersFor(Configuration configuration) {
		Map<String, Formatter> map = new HashMap<>();
		map.putAll(StringFormatters.get(configuration.locale));
		map.putAll(NumberFormatters.get(configuration.locale));
		map.putAll(DateFormatters.get(configuration.locale));
		return map;
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

	private static class Writer {
		private Configuration configuration;

		Writer(Configuration configuration) {
			this.configuration = configuration;
		}

		private String write(StringBuilder sb) {
			return encode(clean(withoutFlags(sb)));
		}

		private String encode(String str) {
			return configuration.isCRLF() ? toCRLF(str) : str;
		}

		private String clean(String str) {
			return clean(str.split("\n"));
		}

		private String clean(String[] lines) {
			return stream(lines).map(this::cleanLine).collect(joining("\n"));
		}

		private String toCRLF(String str) {
			return str.replace("\n", "\r\n");
		}

		private String cleanLine(String line) {
			return line.replaceAll("^\\s*$", "");
		}

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

	private class Display {
		private final Trigger trigger;
		private final StringBuilder sb;

		Display(Trigger trigger) {
			this.trigger = trigger;
			this.sb = new StringBuilder();
		}

		StringBuilder generate() {
			return generate(ruleFor(trigger).outputs());
		}

		private StringBuilder generate(Stream<Output> outputs) {
			outputs.forEach(this::write);
			return sb;
		}

		private Rule ruleFor(Trigger trigger) {
			for (Rule rule : ruleSet)
				if (rule.conditions().allMatch(trigger::check)) return rule;
			return defaultRule(trigger.frame);
		}

		private Rule defaultRule(Frame frame) {
			return frame.value() != null ?
					new Rule().output(Mark.This) :
					new Rule().output();
		}

		private void write(Output output) {
			if (output instanceof Literal) write((Literal) output);
			if (output instanceof Mark) write((Mark) output);
			if (output instanceof Expression) write((Expression) output);
		}

		private void write(Literal literal) {
			append(sb, literal.toString());
		}

		private void write(Mark mark) {
			append(sb, mark.isThis() ? evaluateThis(trigger.frame) : evaluate(mark));
		}

		private void write(Expression expression) {
			append(sb, evaluate(expression));
		}

		private StringBuilder evaluateThis(Frame frame) {
			return new StringBuilder(valueOf(frame));
		}

		private StringBuilder evaluate(Mark mark) {
			return evaluate(mark, trigger.frames(mark.name()));
		}

		private StringBuilder evaluate(Mark mark, Iterator<Frame> frames) {
			StringBuilder sb = new StringBuilder();
			while (frames.hasNext())
				append(sb, evaluate(mark, frames.next()), mark.separator());
			return sb;
		}

		private StringBuilder evaluate(Mark mark, Frame frame) {
			return new Display(new Trigger(mark.fullName()).on(format(frame, mark.formatters()))).generate();

		}

		private StringBuilder evaluate(Expression expression) {
			StringBuilder sb = new Display(trigger).generate(expression.outputs());
			if (expression.isConstant()) sb.appendCodePoint(Flag);
			return hasFlag(sb) ? sb : validate(expression.next());
		}

		private StringBuilder validate(Expression expression) {
			if (expression != null) return evaluate(expression);
			backSpaces(sb);
			return new StringBuilder();
		}

		private void append(StringBuilder sb, String str) {
			sb.append(str);
		}

		private void append(StringBuilder sb, StringBuilder o, String separator) {
			if (o.length() == 0) return;
			if (sb.length() > 0) sb.append(separator);
			sb.append(o).appendCodePoint(Flag);
		}

		private void append(StringBuilder sb, StringBuilder o) {
			if (o.length() == 0) return;
			sb.append(indent(withoutFlags(o)));
			if (hasFlag(o)) sb.appendCodePoint(Flag);
		}

		private String valueOf(Frame frame) {
			return frame.value() != null ? frame.value().toString() : "";
		}

		private void backSpaces(StringBuilder sb) {
			int index = sb.length() - 1;
			while (index >= 0) {
				if (Blanks.indexOf(sb.charAt(index)) < 0) break;
				index--;
			}
			sb.delete(index + 1, sb.length());
		}

		private String indent(String str) {
			return str.replace("\n", "\n" + indentOf(this.sb));
		}
	}
}
