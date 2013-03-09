package com.xa.webui.persistence.domain;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.system.cache.Cache;
import com.xa.webui.system.cache.CacheKey;

/**
 *
 * @author theo-alaganze
 */
public class WebObjectCache extends Cache<WebObject> {

    public static WebObjectCache getInstance() {
        if (cache == null) {
            cache = new WebObjectCache();
        }
        return cache;
    }
    
    private WebObjectCache() {
    }
    
    @Override
    public CacheKey generateCacheKey(Object obj) {
        if (obj instanceof String) {
            return new WebObjectCacheKey((String) obj);
        } else if (obj instanceof WebObject) {
            WebObject webObject = (WebObject) obj;
            return new WebObjectCacheKey(webObject.getName());
        }
        throw new NotSupportedException("Object ("+ obj.getClass() +") not supported by CacheKey instance!");
    }
    
    private static WebObjectCache cache;

}
