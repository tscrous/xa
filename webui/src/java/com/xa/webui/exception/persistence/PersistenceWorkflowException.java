package com.xa.webui.exception.persistence;

import com.xa.webui.system.SystemError;

public class PersistenceWorkflowException extends PersistenceException {

    public PersistenceWorkflowException() {
        super();
    }

    public PersistenceWorkflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceWorkflowException(String message) {
        super(message);
    }

    public PersistenceWorkflowException(Throwable cause) {
        super(cause);
    }

    public PersistenceWorkflowException(SystemError error) {
        super(error.getMessage() +" - SystemError.code="+ error.getCode());
    }

}
