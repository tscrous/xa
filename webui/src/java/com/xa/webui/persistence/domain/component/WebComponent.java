package com.xa.webui.persistence.domain.component;

import com.xa.webui.exception.NotImplementedException;
import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.persistence.domain.resource.WebResource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="web_component")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class WebComponent extends WebObject implements Component {
    
    public WebComponent() {
        
    }

    public WebResource<?> getContent() {
        throw new NotImplementedException("Method not supported on current level of hierarchy. Implementation in subclass required!");
    }

    @Override
    public boolean isVisible() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean isDisabled() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    
    @Column(name="visible")
    protected boolean visible = true;
    
    @Column(name="disabled")
    protected boolean disabled;
    
}
