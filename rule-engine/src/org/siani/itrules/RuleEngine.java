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

import org.siani.itrules.engine.Buffer;
import org.siani.itrules.engine.RuleSet;
import org.siani.itrules.formatter.SystemFormatterRepository;
import org.siani.itrules.framebuilder.FrameBuilder;
import org.siani.itrules.model.*;
import org.siani.itrules.formatter.Formatter;

import java.util.*;

public final class RuleEngine {

	private final RuleSet ruleSet;
	private final Stack<Buffer> buffers = new Stack<>();
	private final Map<String, Formatter> formatters = new HashMap<>();

	public RuleEngine(RulesReader reader, Locale locale) {
		this(reader.read(), locale);
	}

	public RuleEngine(RulesReader reader) {
		this(reader.read(), Locale.getDefault());
	}

	public RuleEngine(RuleSet rules) {
		this(rules, Locale.getDefault());
	}

	public RuleEngine(RuleSet rules, Locale locale) {
		this.ruleSet = rules;
		this.formatters.putAll(SystemFormatterRepository.formatters(locale));
	}

	public void register(String name, Formatter formatter) {
		formatters.put(name.toLowerCase(), formatter);
	}

	public void render(Object object, Document document) {
		render(new FrameBuilder().createFrame(object), document);
	}

	public void render(AbstractFrame frame, Document document) {
		buffers.clear();
		this.buffers.push(new Buffer());
		execute(new Trigger(frame, new Mark("root")));
		document.write(buffer());
	}

	private boolean execute(Trigger trigger) {
		Rule rule = ruleSet.match(trigger);
		if (rule == null) return false;
		boolean execute = execute(trigger, rule);
		buffer().dedent();
		return execute;
	}

	private Buffer buffer() {
		return buffers.peek();
	}

	private boolean execute(Trigger trigger, Rule rule) {
		for (Token token : rule.getTokens())
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
		return renderFrame(trigger.frame(), new TriggerMark(mark, trigger.mark()));
	}

	private boolean renderFrame(AbstractFrame frame, AbstractMark mark) {
		if (frame.isPrimitive())
			return renderPrimitiveFrame(frame, mark);
		return renderCompositeFrame(frame, mark);
	}

	private boolean renderPrimitiveFrame(AbstractFrame frame, AbstractMark mark) {
		if (!mark.getName().equalsIgnoreCase("value")) return false;
		Object value = frame.value();
		for (String option : mark.getOptions()) {
			Formatter formatter = formatters.get(option.toLowerCase());
			if (formatter == null) continue;
			value = formatter.format(value);
		}
		write(value.toString());
		buffer().used();
		return false;
	}

	private boolean renderCompositeFrame(AbstractFrame frame, AbstractMark mark) {
		Iterator<AbstractFrame> frames = frame.getFrames(mark.getName());
		boolean rendered = false;
		while (frames != null && frames.hasNext()) {
			pushBuffer(mark.getIndentation());
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
		pushBuffer(trigger.mark().getIndentation());
		for (Token token : expression)
			result &= execute(trigger, token);
		popBuffer();
		return result;
	}

	private void writeSeparator(AbstractMark mark) {
		write(mark.getSeparator());
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

	private static class TriggerMark extends AbstractMark {

		private final AbstractMark mark;
		private final AbstractMark heritage;

		public TriggerMark(AbstractMark mark, AbstractMark heritage) {
			this.mark = mark;
			this.heritage = heritage;
		}

		@Override
		public String getFullName() {
			return this.mark.getFullName();
		}

		@Override
		public String getName() {
			return mark.getName();
		}

		@Override
		public String getSeparator() {
			return mark.getSeparator();
		}

		@Override
		public boolean isMultiple() {
			return mark.isMultiple();
		}

		@Override
		public String[] getOptions() {
			return join(mark.getOptions(), heritage.getOptions());
		}

		@Override
		public String getIndentation() {
			return mark.getIndentation();
		}

		private static String[] join(String[] a, String[] b) {
			String[] result = new String[a.length + b.length];
			System.arraycopy(a, 0, result, 0, a.length);
			System.arraycopy(b, 0, result, a.length, b.length);
			return result;
		}

		@Override
		public <Type> Type as(Class<Type> type) {
			return mark.as(type);
		}

		@Override
		public Token prevToken() {
			return mark.prevToken();
		}

		@Override
		public void prevToken(Token previous) {
			mark.prevToken(previous);
		}
	}

}