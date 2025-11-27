package io.intino.itrules.template.verification.verifiers;

import io.intino.itrules.template.verification.VerificationException;

public interface Verifier<T> {
	boolean verify(T object) throws VerificationException;
}
