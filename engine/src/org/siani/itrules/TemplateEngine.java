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

package org.siani.itrules;

import org.siani.itrules.engine.*;
import org.siani.itrules.model.*;
import org.siani.itrules.model.marks.AbstractMark;
import org.siani.itrules.model.marks.DelegateMark;
import org.siani.itrules.model.marks.Mark;

import java.util.*;

import static org.siani.itrules.LineSeparator.CRLF;
import static org.siani.itrules.LineSeparator.LF;

public class TemplateEngine {

	public static final String CutLine = "|:";
	private final LineSeparator lineSeparator;
	private final RuleSet ruleSet = new RuleSet();
	private final Stack<Buffer> buffers = new Stack<>();
	private final FormatterStore formatterStore;
	private final FunctionStore functionStore;
	private final FrameBuilder frameBuilder;

	public TemplateEngine() {
		this(Locale.getDefault(), LF);
	}

	public TemplateEngine(Locale locale, LineSeparator lineSeparator) {
		this.lineSeparator = lineSeparator;
		this.ruleSet.add(defaultRule());
		this.formatterStore = new FormatterStore(locale);
		this.functionStore = new FunctionStore();
		this.frameBuilder = new FrameBuilder();
	}

	private TemplateEngine(TemplateEngine engine) {
		this.lineSeparator = engine.lineSeparator;
		this.ruleSet.add(defaultRule());
		this.formatterStore = engine.formatterStore;
		this.functionStore = engine.functionStore;
		this.frameBuilder = engine.frameBuilder;
	}

	public TemplateEngine use(String pathname) {
		return use(new Source(pathname));
	}

	public TemplateEngine use(Source source) {
		this.ruleSet.add(RuleSetLoader.load(source));
		return this;
	}

	TemplateEngine add(Rule... rules) {
		return add(Arrays.asList(rules));
	}

	TemplateEngine add(List<Rule> rules) {
		this.ruleSet.add(rules);
		return this;
	}

	RuleSet ruleSet() {
		return ruleSet;
	}

	public TemplateEngine add(String format, Formatter formatter) {
		formatterStore.add(format, formatter);
		return this;
	}

	public TemplateEngine add(String format, final TemplateEngine engine) {
		add(format, engine::render);
		return this;
	}

	public TemplateEngine add(String format, final String pathname) {
		add(format, new TemplateEngine(this).use(pathname));
		return this;
	}

	public TemplateEngine add(String format, final Source source) {
		add(format, new TemplateEngine(this).use(source));
		return this;
	}

	public TemplateEngine add(String name, Function function) {
		functionStore.add(name, function);
		return this;
	}

	public <T> TemplateEngine add(final Class<T> class_, final Adapter<T> adapter) {
		frameBuilder.register(class_, adapter);
		return this;
	}

	public String render(Object object) {
		return render(frameBuilder.build(object));
	}

	private Rule defaultRule() {
		return new Rule().add(new Condition("Slot", "value")).add(new Mark("value"));
	}

	private String render(AbstractFrame frame) {
		initBuffer();
		execute(new Trigger(frame, new Mark("root")));
		return documentOf(buffer());
	}

	private String documentOf(Buffer buffer) {
		return encode(cleanEmptyLines(textOf(buffer)));
	}

	private String textOf(Buffer buffer) {
		return String.valueOf(buffer);
	}

	private String cleanEmptyLines(String text) {
		String[] lines = text.concat("\n" + "EOF").split("\n");
		String result = "";
		for (String line : lines) result += clean(line);
		return result.endsWith("\n") ? result.substring(0, result.lastIndexOf("\n")) : result;
	}

	private String clean(String line) {
		return
			line.equals("EOF") ? "" :
				line.trim().isEmpty() ? "\n" :
					line.endsWith(CutLine) ? process(trim(line, CutLine)) :
						line + "\n";
	}

	private String trim(String line, String cutLine) {
		while (line.contains(CutLine)) line = line.substring(0, line.length() - cutLine.length());
		return line;
	}

	private String process(String line) {
		return line.matches("^\\s*$") ? "" : line + "\n";
	}

	private String encode(String string) {
		return lineSeparator == CRLF ? toCRLF(string) : string;
	}

	private String toCRLF(String string) {
		return string.replace("\n", "\r\n");
	}

	private void initBuffer() {
		this.buffers.clear();
		pushBuffer("");
	}

	private boolean execute(Trigger trigger) {
		Rule rule = ruleFor(trigger);
		return rule != null && execute(trigger, rule);
	}

	private Rule ruleFor(Trigger trigger) {
		for (Rule rule : ruleSet)
			if (match(rule, trigger)) return rule;
		return null;
	}

	private boolean match(Rule rule, Trigger trigger) {
		for (Condition condition : rule.conditions())
			if (!conditionMatchTrigger(trigger, condition)) return false;
		return true;
	}

	private boolean conditionMatchTrigger(Trigger trigger, Condition condition) {
		return functionStore.get(condition).match(trigger, condition.parameter());
	}

	private Buffer buffer() {
		return buffers.peek();
	}

	private boolean execute(Trigger trigger, Rule rule) {
		for (Token token : rule.tokens())
			execute(trigger, token);
		return true;
	}

	private boolean execute(Trigger trigger, Token token) {
		if (token instanceof AbstractMark) return execute(trigger, token.as(AbstractMark.class));
		if (token instanceof Expression) return execute(trigger, token.as(Expression.class));
		write(token.toString());
		return true;
	}

	private void write(String text) {
		buffer().write(text);
	}

	private boolean execute(Trigger trigger, AbstractMark mark) {
		return renderFrame(trigger.frame(), composeMark(trigger, mark));
	}

	private AbstractMark composeMark(Trigger trigger, AbstractMark mark) {
		return trigger.frame().isPrimitive() ? new CompositeMark(mark, trigger.mark().options()) : mark;
	}

	private boolean renderFrame(AbstractFrame frame, AbstractMark mark) {
		return frame.isPrimitive() ?
			renderPrimitiveFrame(frame, mark) :
			renderCompositeFrame(frame, mark);
	}

	private boolean renderPrimitiveFrame(AbstractFrame frame, AbstractMark mark) {
		if (!mark.name().equalsIgnoreCase("value")) return false;
		write(format(frame, mark).toString());
		buffer().used();
		return true;
	}

	private boolean renderCompositeFrame(AbstractFrame frame, AbstractMark mark) {
		Iterator<AbstractFrame> frames = frame.frames(mark.name());
		return frames != null && renderFrames(frames, mark);
	}

	private boolean renderFrames(Iterator<AbstractFrame> frames, AbstractMark mark) {
		boolean rendered = false;
		while (frames.hasNext()) {
			pushBuffer(mark.indentation());
			if (rendered && mark.isMultiple()) writeSeparator(mark);
			rendered = rendered | trigger(format(frames.next(), mark), new NonFormattingMark(mark));
			popBuffer();
		}
		return rendered;
	}

	private boolean trigger(Object value, AbstractMark mark) {
		if (!execute(new Trigger(frame(value), mark))) return false;
		buffer().used();
		return true;
	}

	private Object format(Object value, AbstractMark mark) {
		if (value instanceof PrimitiveFrame) value = ((PrimitiveFrame) value).value();
		for (String option : mark.options())
			value = format(value, formatterStore.get(option));
		return value;
	}

	private AbstractFrame frame(Object value) {
		return value instanceof AbstractFrame ? (AbstractFrame) value : new PrimitiveFrame(value);
	}

	private Object format(Object value, Formatter formatter) {
		return formatter.format(value);
	}

	private boolean execute(Trigger trigger, Expression expression) {
		boolean result = true;
		while (expression != null) {
			pushBuffer("");
			if (isConstant(expression))
				buffer().used();
			for (Token token : expression)
				result &= execute(trigger, token);
			expression = expression.or();
			if (popBuffer()) break;
		}
		return result;
	}

	private boolean isConstant(Expression expression) {
		for (Token token : expression)
			if (token instanceof Mark) return false;
		return true;
	}

	private void writeSeparator(AbstractMark mark) {
		write(mark.separator());
	}

	private void pushBuffer(String indentation) {
		buffers.push(new Buffer(indentation));
	}

	private boolean popBuffer() {
		Buffer pop = buffers.pop();
		if (pop.isUsed()) {
			buffer().write(pop);
			buffer().used();
		}
		return pop.isUsed();
	}


	private static class CompositeMark extends DelegateMark {
		private String[] options;

		public CompositeMark(AbstractMark mark, String[] options) {
			super(mark);
			this.options = options;
		}

		@Override
		public String[] options() {
			String[] result = new String[mark.options().length + options.length];
			System.arraycopy(mark.options(), 0, result, 0, mark.options().length);
			System.arraycopy(options, 0, result, mark.options().length, options.length);
			return result;
		}

	}

	private class NonFormattingMark extends DelegateMark {
		public NonFormattingMark(AbstractMark mark) {
			super(mark);
		}

		@Override
		public String[] options() {
			List<String> result = new ArrayList<>();
			for (String option : mark.options())
				if (!formatterStore.exists(option)) result.add(option);
			return result.toArray(new String[result.size()]);
		}


	}


}