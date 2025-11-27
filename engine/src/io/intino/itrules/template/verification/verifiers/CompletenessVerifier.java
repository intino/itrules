package io.intino.itrules.template.verification.verifiers;

import io.intino.itrules.Frame;
import io.intino.itrules.Trigger;
import io.intino.itrules.formatters.DateFormatters;
import io.intino.itrules.formatters.NumberFormatters;
import io.intino.itrules.formatters.StringFormatters;
import io.intino.itrules.template.Output;
import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;
import io.intino.itrules.template.outputs.Expression;
import io.intino.itrules.template.outputs.Placeholder;
import io.intino.itrules.template.verification.VerificationException;

import java.util.*;
import java.util.stream.Collectors;

public class CompletenessVerifier implements Verifier<Frame> {
	private final Template template;
	private final Set<String> formatters;

	public CompletenessVerifier(Template template) {
		this.template = template;
		this.formatters = formatters(template.configuration());
	}

	@Override
	public boolean verify(Frame frame) throws VerificationException {
		evaluate(new Trigger("root").on(frame));
		return true;
	}

	private void evaluate(Trigger trigger) throws VerificationException {
		Rule rule = findRuleFor(trigger).orElseThrow(() -> new VerificationException("Rule not found for trigger " + trigger.name()));
		Frame frame = trigger.frame();
		evaluate(rule, frame);
	}

	private void evaluate(Rule rule, Frame frame) throws VerificationException {
		List<Placeholder> placeholders = placeholders(rule);
		for (Placeholder p : placeholders) {
			if (!p.isThis() && !frame.contains(p.name()))
				throw new VerificationException("Frame for placeholder " + p.name() + " not found");
			Iterator<Frame> frames = p.isThis() ? List.of(frame).iterator() : frame.frames(p.name());
			while (frames.hasNext()) {
				Frame next = frames.next();
				for (String formatter : p.formatters()) {
					Optional<Rule> ruleFor = findRuleFor(new Trigger(formatter).on(next));
					if (!ruleFor.isPresent() && !formatters.contains(formatter))
						throw new VerificationException("Formatter " + formatter + " not found");
					else if (ruleFor.isPresent()) evaluate(ruleFor.get(), next);
				}
			}
		}
	}

	private Optional<Rule> findRuleFor(Trigger trigger) {
		return template.ruleSet().stream()
				.filter(r -> r.condition().evaluate(trigger))
				.findFirst();
	}

	private static List<Placeholder> placeholders(Rule rule) {
		List<Output> outputs = rule.outputs().toList();
		List<Placeholder> placeholders = placeholders(outputs);
		placeholders.addAll(outputs.stream()
				.filter(o -> o instanceof Expression)
				.map(o -> placeholders(((Expression) o).outputs().toList()))
				.flatMap(Collection::stream)
				.toList());
		return placeholders;
	}

	private static List<Placeholder> placeholders(List<Output> outputs) {
		return outputs.stream()
				.filter(o -> o instanceof Placeholder)
				.map(p -> (Placeholder) p)
				.collect(Collectors.toList());
	}

	private Set<String> formatters(Template.Configuration configuration) {
		Set<String> map = new HashSet<>();
		map.addAll(StringFormatters.get(configuration.locale()).keySet());
		map.addAll(NumberFormatters.get(configuration.locale()).keySet());
		map.addAll(DateFormatters.get(configuration.locale()).keySet());
		return map;
	}
}
