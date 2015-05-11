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

import java.util.*;

import static org.siani.itrules.LineSeparator.*;
import static org.siani.itrules.LineSeparator.CRLF;

public class TemplateEngine {

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

	public TemplateEngine use(String pathname, String format) {
		return use(new Source(pathname), format);
	}

	public TemplateEngine use(Source source) {
		this.ruleSet.add(RuleSetLoader.load(source));
		return this;
	}

	public TemplateEngine use(final Source source, String format) {
		formatterStore.add(format, new Formatter() {
			@Override
			public Object format(Object value) {
				return new TemplateEngine(TemplateEngine.this).use(source).render(value);
			}
		});
		return this;
	}

	TemplateEngine add(Rule... rules) {
		return add(Arrays.asList(rules));
	}

	TemplateEngine add(List<Rule> rules) {
		this.ruleSet.add(rules);
		return this;
	}

	public TemplateEngine add(String name, Formatter formatter) {
		formatterStore.add(name, formatter);
		return this;
	}

	public TemplateEngine add(String name, Function function) {
		functionStore.add(name, function);
		return this;
	}

	public TemplateEngine add(Class class_, Adapter adapter) {
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
		StringBuilder document = new StringBuilder();
		document.append(buffer);
		return document.toString();
	}

	private String cleanEmptyLines(String text) {
		String[] lines = text.split("\n");
		String result = "";
		for (String line : lines) result += cleanEmptyLine(line + "\n");
		return result.isEmpty() ? "" : result.substring(0, result.lastIndexOf("\n"));
	}

	private String cleanEmptyLine(String line) {
		return line.replaceAll("^\\s*\\\\\n", "");
	}

	private String encode(String string) {
		return lineSeparator == CRLF ? toCRLF(string) : string;
	}

	private String toCRLF(String string) {
		return string.replace("\n", "\r\n");
	}

	private void initBuffer() {
		this.buffers.clear();
		this.buffers.push(new Buffer());
	}

	private boolean execute(Trigger trigger) {
		Rule rule = match(trigger);
		return rule != null ? executeRule(trigger, rule) : executeRuleNotFound(trigger);
	}

	private boolean executeRule(Trigger trigger, Rule rule) {
		boolean executed = execute(trigger, rule);
		buffer().dedent();
		return executed;
	}

	private boolean executeRuleNotFound(Trigger trigger) {
		buffer().write("...no rule for " + trigger.frame() + " with trigger " + trigger.mark());
		buffer().dedent();
		return true;
	}

	private Rule match(Trigger trigger) {
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
		if (frame.isPrimitive())
			return renderPrimitiveFrame(frame, mark);
		return renderCompositeFrame(frame, mark);
	}

	private boolean renderPrimitiveFrame(AbstractFrame frame, AbstractMark mark) {
		if (!mark.name().equalsIgnoreCase("value")) return false;
		write(options(frame.value(), mark).toString());
		buffer().used();
		return false;
	}

	private Object options(Object value, AbstractMark mark) {
		for (String option : mark.options())
			value = format(value, formatterStore.get(option));
		return value;
	}

	private Object format(Object value, Formatter formatter) {
		return formatter.format(value);
	}

	private boolean renderCompositeFrame(AbstractFrame frame, AbstractMark mark) {
		Iterator<AbstractFrame> frames = frame.frames(mark.name());
		boolean rendered = false;
		while (frames != null && frames.hasNext()) {
			pushBuffer(mark.indentation());
			if (rendered && mark.isMultiple())
				writeSeparator(mark);
			if (execute(new Trigger(frames.next(), mark))) {
				buffer().used();
				rendered = true;
			}
			popBuffer();
		}
		return rendered;
	}

	private boolean execute(Trigger trigger, Expression expression) {
		boolean result = true;
		pushBuffer(trigger.mark().indentation());
		for (Token token : expression)
			result &= execute(trigger, token);
		popBuffer();
		return result;
	}

	private void writeSeparator(AbstractMark mark) {
		write(mark.separator());
	}

	private void pushBuffer(String indentation) {
		Buffer newBuffer = new Buffer();
		for (String indent : buffer().getIndentation()) newBuffer.indent(indent);
		buffers.push(newBuffer);
		buffer().indent(indentation);
	}

	private void popBuffer() {
		Buffer result = buffers.pop();
		if (result.isUsed()) {
			buffer().write(result);
			buffer().used();
		}
	}



	private static class CompositeMark extends AbstractMark {
		private final AbstractMark mark;
		private final String[] inheritedOptions;


		public CompositeMark(AbstractMark mark, String[] inheritedOptions) {
			this.mark = mark;
			this.inheritedOptions = inheritedOptions;
		}

		@Override
		public String fullName() {
			return mark.fullName();
		}

		@Override
		public String name() {
			return mark.name();
		}

		@Override
		public String separator() {
			return mark.separator();
		}

		@Override
		public boolean isMultiple() {
			return mark.isMultiple();
		}

		@Override
		public String[] options() {
			String[] result = new String[mark.options().length + inheritedOptions.length];
			System.arraycopy(mark.options(), 0, result, 0, mark.options().length);
			System.arraycopy(inheritedOptions, 0, result, mark.options().length, inheritedOptions.length);
			return result;
		}

		@Override
		public String indentation() {
			return mark.indentation();
		}


	}


}