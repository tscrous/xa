package com.xa.webui.exception;

public class NotSupportedException extends RuntimeException {

    public NotSupportedException() {
        super();
    }

    public NotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedException(String message) {
        super(message);
    }

    public NotSupportedException(Throwable cause) {
        super(cause);
    }

}
