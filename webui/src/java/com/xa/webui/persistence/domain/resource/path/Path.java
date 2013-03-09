package com.xa.webui.persistence.domain.resource.path;

import com.xa.webui.persistence.domain.resource.ResolvableObject;

/**
 *
 * @author theo-alaganze
 */
public class Path implements ResolvableObject {

    public Path(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    private String value;
    
}
