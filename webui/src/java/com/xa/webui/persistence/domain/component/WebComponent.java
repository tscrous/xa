package com.xa.webui.persistence.domain.component;

import com.xa.webui.exception.NotImplementedException;
import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.persistence.domain.resource.WebResource;
import com.xa.webui.persistence.domain.resource.skin.Skin;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="web_component")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class WebComponent<T extends WebResource> extends WebObject<T> implements Component {
    
    public WebComponent() {
        
    }

    @Override
    public T getValue() {
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
    
    public Skin getSkin() {
        return skin;
    }
    public void setSkin(Skin skin) {
        this.skin = skin;
    }
    
    @Column(name="visible")
    protected boolean visible = true;
    
    @Column(name="disabled")
    protected boolean disabled;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinTable(name="components_skins_mapping",
        joinColumns={ @JoinColumn(name="web_component_id", nullable=true) },
        inverseJoinColumns={ @JoinColumn(name="skin_id", nullable=true) }
    )
    protected Skin skin;
    
}
