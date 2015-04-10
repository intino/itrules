package org.siani.itrules.engine.logger;

public class DebugLogger implements Logger {
    @Override
    public void debug(String message, Object... args) {
        System.out.printf(message, args);
    }
}
