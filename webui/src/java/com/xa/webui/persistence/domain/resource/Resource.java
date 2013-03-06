package com.xa.webui.persistence.domain.resource;

/**
 *
 * @author theo-alaganze
 */
public interface Resource<T extends Object> {
    
    public String getName();
    public T getValue();
    
}
