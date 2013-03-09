package com.xa.webui.persistence.domain.resource.resolution;

import com.xa.webui.persistence.domain.IdentifiableEntity;
import com.xa.webui.persistence.domain.resource.ResolvableObject;
import java.util.Arrays;
import javax.enterprise.inject.ResolutionException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="resolution_descriptor")
public class ResolutionDescriptor extends IdentifiableEntity implements ResolvableObject {
    
    public ResolutionDescriptor() {
    }

    public ResolutionDescriptor(ResolutionType type) {
        this.type = type;
    }

    /* Getters & Setters */
    
    public ResolutionType getType() {
        return type;
    }
    protected void setType(ResolutionType type) {
        this.type = type;
    }

    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        ensureResolutionType(ResolutionType.ERROR);
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        ensureResolutionType(ResolutionType.ERROR);
        this.errorMessage = errorMessage;
    }

    public String getBeanType() {
        return beanType;
    }
    public void setBeanType(String beanType) {
        ensureResolutionType(ResolutionType.FORWARD, ResolutionType.REDIRECT);
        this.beanType = beanType;
    }

    public String getEvent() {
        return event;
    }
    public void setEvent(String event) {
        ensureResolutionType(ResolutionType.FORWARD, ResolutionType.REDIRECT);
        this.event = event;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        ensureResolutionType(ResolutionType.FORWARD);
        this.path = path;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        ensureResolutionType(ResolutionType.REDIRECT);
        this.url = url;
    }

    public boolean isPrependContext() {
        return prependContext;
    }
    public void setPrependContext(boolean prependContext) {
        ensureResolutionType(ResolutionType.REDIRECT);
        this.prependContext = prependContext;
    }

    /* utilities */

    private void ensureResolutionType(ResolutionType...types) {
        if (!Arrays.asList(types).contains(type)) {
            throw new ResolutionException("Method call not allowed for a descriptor of type "+ this.type +"!");
        }
    }
    
    /* properties */

    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private ResolutionType type; 

    @Column(name="error_code")
    private int errorCode;
    
    @Column(name="error_message")
    private String errorMessage;
    
    @Column(name="bean_type")
    private String beanType;
    
    @Column(name="event")
    private String event;
    
    @Column(name="resource_path")
    private String path;
    
    @Column(name="url")
    private String url;
    
    @Column(name="prepend_context")
    private boolean prependContext;
    
}
