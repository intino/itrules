package io.intino.itrules.template.verification.verifiers;

import io.intino.itrules.Frame;
import io.intino.itrules.template.Template;
import io.intino.itrules.template.verification.VerificationException;

public class ReferenceConsistencyVerifier implements Verifier<Frame> {
	private final Template template;

	public ReferenceConsistencyVerifier(Template template) {
		this.template = template;
	}

	@Override
	public boolean verify(Frame frame) throws VerificationException {
		return false;
	}
}
