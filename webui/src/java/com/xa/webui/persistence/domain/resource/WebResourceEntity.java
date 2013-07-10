package com.xa.webui.persistence.domain.resource;

import com.xa.webui.exception.NotImplementedException;
import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.service.api.WebObjectDependencyManager;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="web_resource")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WebResource<T extends ResolvableObject> extends WebObject<T> implements Resource<T> {

    @Override
    public T getValue() {
        throw new NotImplementedException("Method not supported on current level of hierarchy. Implementation in subclass required!");
    }

    @Override
    public WebObjectDependencyManager getDependencyManager() {
        if (dependencyManager == null) {
            dependencyManager = new WebObjectDependencyManager();
        }
        return dependencyManager;
    }

    @Transient
    protected WebObjectDependencyManager dependencyManager;
    
}
