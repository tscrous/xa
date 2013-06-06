package com.xa.webui.persistence.domain.component;

import com.xa.webui.persistence.domain.resource.WebResource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 *
 * @author theo-alaganze
 */
@Entity
public abstract class Item extends WebComponent<WebResource> {
    
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public WebResource getValue() {
        throw new UnsupportedOperationException("Not supported!");
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    @Column(name="label")
    protected String label;
    
    @Transient
    protected boolean active;
    
}
