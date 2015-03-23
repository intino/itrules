package org.siani.itrules.logger;

public class DebugLogger implements Logger {
    @Override
    public void debug(String message, Object... args) {
        System.out.printf(message, args);
    }
}
