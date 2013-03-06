package com.xa.webui.exception.persistence;

/**
 *
 * @author theo-alaganze
 */
public class PersistenceResolutionException extends PersistenceException {

    public PersistenceResolutionException() {
    }

    public PersistenceResolutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceResolutionException(String message) {
        super(message);
    }

    public PersistenceResolutionException(Throwable cause) {
        super(cause);
    }
    
}
