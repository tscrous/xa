package com.xa.webui.exception.persistence;

public class PersistenceDataSourceException extends PersistenceException {

    public PersistenceDataSourceException() {
            super();
    }

    public PersistenceDataSourceException(String message, Throwable cause) {
            super(message, cause);
    }

    public PersistenceDataSourceException(String message) {
            super(message);
    }

    public PersistenceDataSourceException(Throwable cause) {
            super(cause);
    }

}
