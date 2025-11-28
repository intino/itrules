package io.intino.itrules.dsl.verification;

import io.intino.itrules.Engine;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.TemplateReader;
import io.intino.itrules.template.Template;
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
		boolean result = reader.read().checkDeterminacy();
		assertThat(result)
				.describedAs("Two rules with the same trigger and no additional constraints may overlap.")
				.isTrue();
	}

	@Test
	public void should_detect_templateWithSameTrigger_isNotDeterministic() throws Exception {
		TemplateReader reader = readerFor(notDeterministicTemplate());
		boolean result = reader.read().checkDeterminacy();
		assertThat(result)
				.describedAs("Two rules for the same attribute should be mutually exclusive.")
				.isFalse();
	}

	@Test
	public void should_Detect_Completeness_When_At_Least_One_Rule_Matches() throws Exception {
		String templateContent = """
				rule type(A)
					<div>$name+bold</div>
				
				rule trigger(bold)
					*$this*
				""";
		TemplateReader reader = new TemplateReader(new ByteArrayInputStream(templateContent.getBytes(UTF_8)));
		Frame frame = new FrameBuilder("A")
				.add("name", "Alice")
				.toFrame();
		Template template = reader.read();
		new Engine(template).render(frame);
		boolean result = template.checkCompleteness(frame);
		assertThat(result)
				.describedAs("Completeness should succeed when at least one rule predicate matches the frame")
				.isTrue();
	}

	private static TemplateReader readerFor(String notDeterministicTemplate) {
		return new TemplateReader(new ByteArrayInputStream(notDeterministicTemplate.getBytes(UTF_8)));
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
