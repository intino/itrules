package io.intino.itrules.template.verification;

import io.intino.itrules.Frame;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.verification.Issue.error;
import static io.intino.itrules.template.verification.VerificationReport.IssueCode.*;
import static io.intino.itrules.template.verification.VerificationReport.ofIssues;
import static io.intino.itrules.template.verification.VerificationReport.ok;

public interface Verifiable {
	default boolean checkTermination(Frame frame){
		return new TerminationChecker().check(frame);
	}

	boolean checkDeterminacy();

	boolean checkCompleteness(Frame frame);

	boolean checkReferentialConsistency(Frame frame);

	default VerificationReport verify(Frame frame) {
		List<Issue> issues = new ArrayList<>();
		if (!checkTermination(frame)) issues.add(error(FINITE_VIOLATION));
		if (!checkDeterminacy()) issues.add(error(STRATIFICATION_VIOLATION));
		if (!checkCompleteness(frame)) issues.add(error(PARTITION_VIOLATION));
		if (!checkReferentialConsistency(frame)) issues.add(error(REFERENTIAL_CONSISTENCY_VIOLATION));
		return issues.isEmpty() ? ok() : ofIssues(issues);
	}
}
