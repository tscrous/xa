package com.xa.webui.exception.persistence;

public class PersistenceDaoException extends RuntimeException {

    public PersistenceDaoException() {
    }

    public PersistenceDaoException(String string) {
        super(string);
    }

    public PersistenceDaoException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PersistenceDaoException(Throwable thrwbl) {
        super(thrwbl);
    }

}
