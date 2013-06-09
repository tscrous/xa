package com.xa.webui.system.cache;

import com.xa.webui.system.utils.ValidationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author theo-alaganze
 */
public abstract class Cache<T extends Object> {
    
    public Cache() {
        clear();
    }
    
    public void add(T object) {
        ValidationUtils.ensureNotNull("object", object);
        if (object instanceof CacheKey) {
            add((CacheKey) object, object);
        } else {
            cache.put(generateCacheKey(object).getId(), object);
        }
    }    
    public void add(Object key, T value) {
        ValidationUtils.ensureNotNull("key", key);
        ValidationUtils.ensureNotNull("value", value);
        if (key instanceof CacheKey) {
            add((CacheKey) key, value);
        } else {
            cache.put(generateCacheKey(key).getId(), value);
        }
    }    
    public void add(CacheKey key, T value) {
        ValidationUtils.ensureNotNull("key", key);
        ValidationUtils.ensureNotNull("value", value);
        cache.put(key.getId(), value);
    }
    
    public boolean isCached(CacheKey key) {
        return cache.containsKey(key.getId());
    }
    public boolean isEmpty() {
        return cache.isEmpty();
    }
    
    public T get(Object key) {
        ValidationUtils.ensureNotNull("key", key);
        CacheKey cacheKey = key instanceof CacheKey ? (CacheKey) key : generateCacheKey(key);
        return cache.get(cacheKey.getId());
    }
    public T get(CacheKey key) {
        ValidationUtils.ensureNotNull("key", key);
        return cache.get(key.getId());
    }
    public List<T> getAll() {
        return new ArrayList<T>(cache.values());
    }
    
    public abstract CacheKey generateCacheKey(Object obj);
    
    /* utilities */
    
    public void clear() {
        cache = new HashMap<String, T>();
    }
        
    private Map<String, T> cache; 
    
}
