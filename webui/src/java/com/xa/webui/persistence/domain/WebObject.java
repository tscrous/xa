package com.xa.webui.persistence.domain;

import com.xa.webui.service.api.WebObjectDependencyManager;
import java.util.List;
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
    
    public void setDependency(WebObject dependency) {
        getDependencyManager().setDependency(this, dependency);
    }
    public boolean hasDependencyOn(WebObject dependency) {
        return getDependencyManager().hasDependency(this, dependency);
    }
    public boolean hasDependencyOn(Class<? extends WebObject> type) {
        return getDependencyManager().hasDependency(this, type);
    }
    public void removeDependency(WebObject dependency) {
        getDependencyManager().removeDependency(this, dependency);
    }
    public List<WebObject> getDependencies() {
        return getDependencyManager().getDependenciesOn(this);
    }
    public void setDependencies(List<WebObject> dependencies) {
        getDependencyManager().setDependencies(this, dependencies);
    }

    public abstract T getValue();
    public abstract WebObjectDependencyManager getDependencyManager();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (this != null && o != null) {
            WebObject wo = (WebObject) o;
            return this.getId() == wo.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 9;
        hash = 32 * hash + (name != null ? name.hashCode() : 0);
        hash = 32 * hash + (description != null ? description.hashCode() : 0);
        return hash;
    }
    
    /* utilities */
    
    public <T extends WebObject> T getDependency(Class<T> type) {
        List<WebObject> dependencies = getDependencies();
        if (dependencies != null) {
            for (WebObject dependency : dependencies) {
                if (type.isInstance(dependency)) {
                    return (T) dependency;
                }
            }
        }
        return null;
    }
    
    @Column(name="name", unique=true, nullable=false)
    protected String name;
    
    @Column(name="description")
    protected String description;
    
}
