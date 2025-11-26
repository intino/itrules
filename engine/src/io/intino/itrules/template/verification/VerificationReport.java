package io.intino.itrules.template.verification;

import java.util.List;
import java.util.stream.Collectors;

public final class VerificationReport {

	public enum Status {OK, FAILED}

	public enum IssueCode {
		FINITE_VIOLATION("Termination (finiteness) check failed"),
		STRATIFICATION_VIOLATION("Determinacy/stratification check failed"),
		PARTITION_VIOLATION("Completeness/partition check failed"),
		REFERENTIAL_CONSISTENCY_VIOLATION("Referential consistency check failed");
		private final String message;

		IssueCode(String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}
	}

	private final Status status;
	private final List<Issue> issues;

	private VerificationReport(List<Issue> issues) {
		this.issues = List.copyOf(issues);
		this.status = issues.isEmpty() ? Status.FAILED : Status.OK;
	}

	public static VerificationReport ok() {
		return new VerificationReport(List.of());
	}

	public static VerificationReport ofIssues(List<Issue> issues) {
		return new VerificationReport(issues);
	}

	public Status getStatus() {
		return status;
	}

	public boolean isOk() {
		return status == Status.OK;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	@Override
	public String toString() {
		String header = "VerificationReport{status=" + status + ", issues=" + issues.size() + "}";
		if (issues.isEmpty()) return header;
		String details = issues.stream()
				.map(Issue::toString)
				.collect(Collectors.joining("\n  - ", "\n  - ", ""));
		return header + details;
	}
}
