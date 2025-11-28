package io.intino.itrules.dsl.verification;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.TemplateReader;
import io.intino.itrules.template.verification.Verifiable;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VerificationTest {

	@Test
	public void should_verify_termination_frame() {
		assertTrue(verifiable().checkTermination(acyclicFrame()));
		assertFalse(verifiable().checkTermination(cyclicFrame()));
	}

	@Test
	public void should_detect_templateWithContradictoryAttributeConditions_isDeterministic() throws Exception {
		TemplateReader reader = readerFor(deterministicTemplate());
		assertThat(reader.read().checkDeterminacy())
				.describedAs("Two rules with the same trigger and no additional constraints may overlap.")
				.isTrue();
	}

	@Test
	public void should_detect_templateWithSameTrigger_isNotDeterministic() throws Exception {
		TemplateReader reader = readerFor(notDeterministicTemplate());
		assertThat(reader.read().checkDeterminacy())
				.describedAs("Two rules for the same attribute should be mutually exclusive.")
				.isFalse();
	}

	@Test
	public void should_detect_completeness_when_at_least_one_rule_matches() throws Exception {
		Frame frame = new FrameBuilder("A").add("name", "Alice").toFrame();
		assertThat(readerFor(completeTemplate()).read().checkCompleteness(frame))
				.describedAs("Completeness should succeed when at least one rule predicate matches the frame")
				.isTrue();
	}

	@Test
	public void should_fail_when_not_completeness() throws Exception {
		Frame frame = new FrameBuilder("xml").add("name", "Charlie").toFrame();
		assertThat(readerFor(notCompleteTemplate()).read().checkCompleteness(frame))
				.describedAs("Completeness should fail when no rule predicate matches the frame")
				.isFalse();
	}

	@Test
	public void should_pass_referential_consistency_when_all_attributes_exist() throws Exception {
		Frame frame = new FrameBuilder("Person").add("name", "Alice").toFrame();
		assertThat(readerFor(consistentTemplate()).read().checkCompleteness(frame))
				.describedAs("Referential consistency should succeed when all referenced attributes exist")
				.isTrue();
	}

	@Test
	public void should_fail_referential_consistency_when_referenced_attributes_are_missing() throws Exception {
		Frame frame = new FrameBuilder("Person").add("name", "Bob").toFrame();
		assertThat(readerFor(inconsistentTemplate()).read().checkCompleteness(frame))
				.describedAs("Referential consistency should fail when the template references attributes not present in the frame")
				.isFalse();
	}

	private static TemplateReader readerFor(String template) {
		return new TemplateReader(new ByteArrayInputStream(template.getBytes(UTF_8)));
	}

	private static String consistentTemplate() {
		return """
			rule type(Person)
				<p>Name: $name</p>
			""";
	}

	private static String inconsistentTemplate() {
		return """
        rule type(Person)
        	<p>Email: $email</p>
        """;
	}

	private static String completeTemplate() {
		return """
			rule type(A)
				<div>$name+bold</div>
			
			rule trigger(bold)
				*$this*
			""";
	}

	private static String notCompleteTemplate() {
		return """
			rule type(html)
				<div>$name</div>
		
			rule type(json)
				<span>$code</span>
			""";
	}

	private static String notDeterministicTemplate() {
		return """
			rule trigger(html)
				<div>$name</div>
			
			rule not(type(A)) and trigger(html)
				<span>$code</span>
			""";
	}

	private static String deterministicTemplate() {
		return """
			rule attribute(status, PAID)
				PAID: $code
			
			rule attribute(status, CANCELLED)
				CANCELLED: $code
			""";
	}

	private Frame cyclicFrame() {
		FrameBuilder builderA = new FrameBuilder("A");
		FrameBuilder builderB = new FrameBuilder("B");
		Frame frameB = builderB.toFrame();
		builderB.add("next", builderA);
		builderA.add("next", frameB);
		return builderA.toFrame();
	}

	private static Frame acyclicFrame() {
		return new FrameBuilder("TypeA", "TypeB")
				.add("simple", 5.4)
				.add("array", new String[]{"A", "B"})
				.add("composite",
						new FrameBuilder("SubtypeA", "SubtypeB")
								.add("power", 500)
								.toFrame()
				).toFrame();
	}

	private Verifiable verifiable() {
		return new Verifiable() {
			@Override
			public boolean checkDeterminacy() {
				return false;
			}

			@Override
			public boolean checkCompleteness(Frame frame) {
				return false;
			}

			@Override
			public boolean checkReferentialConsistency(Frame frame) {
				return false;
			}
		};
	}
}
