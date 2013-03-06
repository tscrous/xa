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
        cache.put(generateCacheKey(object).getId(), object);
    }
    
    public void add(Object key, T value) {
        ValidationUtils.ensureNotNull("key", key);
        ValidationUtils.ensureNotNull("value", value);
        cache.put(generateCacheKey(key).getId(), value);
    }
    
    public void add(CacheKey key, T value) {
        ValidationUtils.ensureNotNull("key", key);
        ValidationUtils.ensureNotNull("value", value);
        cache.put(key.getId(), value);
    }
    
    public T get(Object key) {
        ValidationUtils.ensureNotNull("key", key);
        return cache.get(generateCacheKey(key).getId());
    }
    
    public T get(CacheKey key) {
        ValidationUtils.ensureNotNull("key", key);
        return cache.get(key.getId());
    }
    
    public List<T> getAll() {
        return new ArrayList<T>(cache.values());
    }
    
    public boolean isCached(CacheKey key) {
        return cache.containsKey(key);
    }
    
    public boolean isEmpty() {
        return cache.isEmpty();
    }
    
    public abstract CacheKey generateCacheKey(Object obj);
    
    /* utilities */
    
    public void clear() {
        cache = new HashMap<String, T>();
    }
        
    private Map<String, T> cache; 
    
}
