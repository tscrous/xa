package com.xa.webui.persistence.domain.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author theo-alaganze
 */
public class RuntimeInfo {
    
    public <T extends Object> void setValue(String key, T value) {
        map.put(key, value);
    }
    public <T extends Object> void setList(String key, List<T> valueList) {
        map.put(key, new ListWrapper(valueList));
    }
    
    public <T extends Object> T getValue(String key, Class<T> type) {
        return type.cast(getValue(key));
    }
    public Object getValue(String key) {
        if (map.get(key) instanceof ListWrapper) {
            throw new RuntimeException("Value of '"+ key +"' is a List but an Object was expected. Please use the getList() method instead!");
        }
        return map.get(key);
    }
    public List<? extends Object> getList(String key) {
        if (map.get(key) instanceof ListWrapper) {
            return ((ListWrapper) map.get(key)).list;
        } else {
            throw new RuntimeException("Value of '"+ key +"' is an Object but a List was expected. Please use the getValue() method instead!");
        }
    }
    
    public void flush() {
        map.clear();
    }
    
    /* utilities */
    
    private class ListWrapper {
        public ListWrapper(List<? extends Object> list) {
            this.list = list;
        }
        List<? extends Object> list;
    }

    public Map<String, Object> map = new HashMap<String, Object>();
    
}
