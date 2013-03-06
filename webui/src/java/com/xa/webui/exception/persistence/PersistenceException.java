package com.xa.webui.exception.persistence;

public abstract class PersistenceException extends RuntimeException {

    public PersistenceException() {
    }

    public PersistenceException(String string) {
        super(string);
    }

    public PersistenceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PersistenceException(Throwable thrwbl) {
        super(thrwbl);
    }

}
