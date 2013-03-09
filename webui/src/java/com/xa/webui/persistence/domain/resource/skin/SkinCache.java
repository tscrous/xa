package com.xa.webui.persistence.domain.resource.skin;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.system.cache.Cache;
import com.xa.webui.system.cache.CacheKey;

/**
 *
 * @author theo-alaganze
 */
public class SkinCache extends Cache<WebObject> {

    public static SkinCache getInstance() {
        if (cache == null) {
            cache = new SkinCache();
        }
        return cache;
    }
    
    private SkinCache() {
    }
    
    @Override
    public CacheKey generateCacheKey(Object obj) {
        if (obj instanceof String) {
            return new SkinCacheKey((String) obj);
        } else if (obj instanceof Skin) {
            Skin skin = (Skin) obj;
            return new SkinCacheKey(skin.getName());
        }
        throw new NotSupportedException("Object ("+ obj.getClass() +") not supported by CacheKey instance!");
    }

    private static SkinCache cache;

}
