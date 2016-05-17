package org.siani.itrules;

import org.junit.Assert;
import org.junit.Test;
import org.siani.itrules.engine.FunctionIndex;
import org.siani.itrules.engine.Trigger;
import org.siani.itrules.engine.functions.TypeFunction;
import org.siani.itrules.model.Condition;
import org.siani.itrules.model.Frame;
import org.siani.itrules.model.marks.Mark;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.siani.itrules.LineSeparator.LF;

public class TypeFunction_ {

	@Test
	public void should_check_types_in_frame() throws Exception {
		TypeFunction function = new TypeFunction();

		Assert.assertThat("Matching a single type exists", function.match(trigger(), "Y"), is(true));
		Assert.assertThat("Matching a single type does not exist", function.match(trigger(), "T"), is(false));
		Assert.assertThat("Matching all types without spaces exists", function.match(trigger(), "X&Y&Z"), is(true));
		Assert.assertThat("Matching all types with blank spaces exists", function.match(trigger(), "X & Y & Z"), is(true));
		Assert.assertThat("Matching all types with blank spaces does not exist", function.match(trigger(), "X & Y & T"), is(false));
		Assert.assertThat("Matching any type exists", function.match(trigger(), "A|Y|T"), is(true));
		Assert.assertThat("Matching any type with blank spaces exists", function.match(trigger(), "A | Y | T"), is(true));
		Assert.assertThat("Matching any type does not exist", function.match(trigger(), "A|S|T"), is(false));
		Assert.assertThat("Matching any type with blank spaces does not exist", function.match(trigger(), "A | S | T"), is(false));

	}

	@Test
	public void should_be_used_as_condition() throws Exception {
		FunctionIndex functionStore = new FunctionIndex();
		Condition condition1 = new Condition.Negated(new Condition("type", "A | S | T"));
		Condition condition2 = new Condition.Negated(new Condition("type", "R"));
		Condition condition3 = new Condition.Negated(new Condition("type", "A | S | T | R"));
		Condition condition4 = new Condition.Negated(new Condition("type", "X | T"));
		Assert.assertThat("Matching any type does not exist", functionStore.get(condition1).match(trigger(), condition1.parameter()), is(true));
		Assert.assertThat("Matching any type does not exist", functionStore.get(condition2).match(trigger(), condition2.parameter()), is(true));
		Assert.assertThat("Matching any type does not exist", functionStore.get(condition1).match(trigger(), condition1.parameter()) && functionStore.get(condition2).match(trigger(), condition2.parameter()), is(true));
		Assert.assertThat("Matching any type does not exist", functionStore.get(condition3).match(trigger(), condition3.parameter()), is(true));
		Assert.assertThat("Matching any type does not exist", functionStore.get(condition4).match(trigger(), condition4.parameter()), is(false));
	}

	@Test
	public void should_be_used_with_template() {
		FunctionIndex functionStore = new FunctionIndex();
		TestTemplate testTemplate = (TestTemplate) new TestTemplate(Locale.ENGLISH, LF).create();
		final Condition condition1 = testTemplate.rules()[0].conditions().iterator().next();
		Assert.assertThat("Matching any type does not exist", functionStore.get(condition1).match(trigger(), condition1.parameter()), is(false));
	}

	private class TestTemplate extends Template {

		TestTemplate(Locale locale, LineSeparator separator) {
			super(locale, separator);
		}

		Template create() {
			return new TestTemplate(Locale.ENGLISH, LF).define();
		}

		Template define() {
			add(
				rule().add(not(condition("type", "A | B | Z"))).add(literal("entry"))
			);
			return this;
		}
	}

	private Trigger trigger() {
		Frame frame = new Frame();
		frame.addTypes("X", "Y", "Z");
		return new Trigger(frame, new Mark("f"));
	}
}
