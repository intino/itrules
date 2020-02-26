package io.intino.itrules;

public class Logger {

	public void log(String message, Object... args) {
		System.out.printf(message + "\n\n", args);
	}

}
