package com.xa.webui.persistence.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author theo-alaganze
 */
@MappedSuperclass
public abstract class WebObject<T extends Object> extends IdentifiableEntity {
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public abstract T getValue();

    @Column(name="name", unique=true, nullable=false)
    protected String name;
    
    @Column(name="description")
    protected String description;
    
}
