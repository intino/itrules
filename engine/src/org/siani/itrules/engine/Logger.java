package org.siani.itrules.engine;

public class Logger {

    private Logger() {}

    public static void debug(String message, Object... args) {
        System.out.printf(message, args);
    }
}
