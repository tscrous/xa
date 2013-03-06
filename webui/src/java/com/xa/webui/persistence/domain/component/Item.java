package com.xa.webui.persistence.domain.component;

import com.xa.webui.persistence.domain.resource.WebResource;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author theo-alaganze
 */
@Entity
public abstract class Item extends WebComponent {
    
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    
    @Override
    public WebResource<?> getContent() {
        throw new UnsupportedOperationException("Not supported!");
    }

    @Column(name="label")
    protected String label;
    
}
