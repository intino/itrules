package org.siani.itrules.engine.logger;

public class Logger {

	public void log(String message, Object... args) {
		System.out.printf(message + "\n\n", args);
	}
}
