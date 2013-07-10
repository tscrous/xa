package com.xa.webui.persistence.domain;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.system.cache.CacheKey;

/**
 *
 * @author theo-alaganze
 */
public class WebObjectCacheKey extends CacheKey {

    public WebObjectCacheKey(String name) {
        setObject(name);
    }
    
    @Override
    protected String convertToValue(Object obj) {
        if (obj instanceof String) {
            return obj.toString();
        }
        throw new NotSupportedException("Object not supported by CacheKey instance!");
    }

}
