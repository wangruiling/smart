package org.smart.framework.exception;

/**
 * Created by wangrl on 2016/3/30.
 */
public class InitializationError extends Error {
    public InitializationError() {
        super();
    }

    public InitializationError(String message) {
        super(message);
    }

    public InitializationError(String message, Throwable cause) {
        super(message, cause);
    }

    public InitializationError(Throwable cause) {
        super(cause);
    }
}
