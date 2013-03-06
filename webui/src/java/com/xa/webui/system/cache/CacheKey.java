package com.xa.webui.system.cache;

/**
 *
 * @author theo-alaganze
 */
public abstract class CacheKey {

    public String getId() {
        return convertToValue(obj);
    }
    
    protected abstract String convertToValue(Object obj);
    
    protected void setObject(Object obj) {
        this.obj = obj;
    }

    private Object obj;
    
}
