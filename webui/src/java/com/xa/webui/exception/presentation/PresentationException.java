package com.xa.webui.exception.presentation;

public abstract class PresentationException extends RuntimeException {

    public PresentationException() {
        super();
    }

    public PresentationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PresentationException(String message) {
        super(message);
    }

    public PresentationException(Throwable cause) {
        super(cause);
    }

}
