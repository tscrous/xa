package com.xa.webui.persistence.domain.resource;

import com.xa.webui.exception.NotImplementedException;
import com.xa.webui.persistence.domain.WebObject;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="web_resource")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class WebResource<T extends Object> extends WebObject implements Resource<T> {

    public WebResource() {
        
    }
    
    @Override
    public T getValue() {
        throw new NotImplementedException("Method not supported on current level of hierarchy. Implementation in subclass required!");
    }

}
