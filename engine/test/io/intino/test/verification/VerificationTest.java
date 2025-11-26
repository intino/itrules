package io.intino.test.verification;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;
import io.intino.itrules.template.verification.Verifiable;
import org.junit.Assert;
import org.junit.Test;

public class VerificationTest {

	@Test
	public void should_detect_termination_on_cyclic_frame() {
		Assert.assertTrue(verifiable().checkTermination(acyclicFrame()));
		Assert.assertFalse(verifiable().checkTermination(cyclicFrame()));

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
