package org.siani.itrules;

import org.siani.itrules.lang.model.*;

import java.io.InputStream;
import java.util.Stack;

import static org.siani.itrules.AbstractFrame.Attribute;

public final class RuleEngine {

	private final RuleSet ruleSet;
	private final Stack<Buffer> buffers;

	public RuleEngine(InputStream rules) {
		this.ruleSet = new RuleSet(rules);
		this.buffers = new Stack<>();
		this.buffers.push(new Buffer());
	}

	public void render(Document document, AbstractFrame frame) throws ITRulesException {
		write(new Trigger(frame));
		document.write(buffer());
	}

	private void write(Trigger trigger) throws ITRulesException {
		Rule rule = ruleSet.match(trigger);
		if (rule == null) write(trigger.toString());
		else render(rule, trigger.frame());
	}

	private void write(String text) {
		buffer().write(text);
	}

	private Buffer buffer() {
		return buffers.peek();
	}

	private void render(Rule rule, AbstractFrame frame) throws ITRulesException {
		for (Token token : rule.getTokens())
			render(token, frame);
	}

	private void render(Token token, AbstractFrame frame) throws ITRulesException {
		if (token instanceof Literal) write(token.toString());
		if (token instanceof Mark) render(token.as(Mark.class), frame.attributes(token.as(Mark.class).getName()));
		if (token instanceof Expression) render(token.as(Expression.class), frame);
	}

	private void render(Mark mark, Attribute[] attributes) throws ITRulesException {
		if (attributes.length == 0) return;
		Attribute last = attributes[attributes.length - 1];
		for (Attribute attribute : attributes) {
			if (attribute.isFrame())
				render(mark, (Frame) attribute);
			else
				render(attribute);
			if (attribute == last) return;
			write(mark.getSeparator());
		}
	}

	private void render(Mark mark, Frame frame) throws ITRulesException {
		if (!frame.has(mark.getName())) return;
		write(new Trigger(frame, mark));
		buffer().replaced();
	}

	private void render(Attribute attribute) throws ITRulesException {
		write(attribute.value().toString());
		buffer().replaced();
	}

	private void render(Expression expression, AbstractFrame frame) throws ITRulesException {
		initExpression();
		for (Token token : expression)
			render(token, frame);
		endExpression();
	}

	private void initExpression() {
		buffers.push(new Buffer());
	}

	private void endExpression() {
		Buffer result = buffers.pop();
		if (result.isReplaced())
			buffer().write(result);
	}

}