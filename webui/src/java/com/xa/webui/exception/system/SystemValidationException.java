package com.xa.webui.exception.system;

public class SystemValidationException extends SystemException {

    public SystemValidationException() {
        super();
    }

    public SystemValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemValidationException(String message) {
        super(message);
    }

    public SystemValidationException(Throwable cause) {
        super(cause);
    }

}
