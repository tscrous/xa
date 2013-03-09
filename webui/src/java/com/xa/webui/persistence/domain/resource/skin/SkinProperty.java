package com.xa.webui.persistence.domain.resource.skin;

import com.xa.webui.persistence.domain.IdentifiableEntity;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="skin_property")
public class SkinProperty extends IdentifiableEntity {
    
    public SkinProperty() {
    }

    public SkinPropertyType getType() {
        return type;
    }
    public void setType(SkinPropertyType type) {
        this.type = type;
    }

    public PathResource getValue() {
        return value;
    }
    public void setValue(PathResource value) {
        this.value = value;
    }

    public Skin getSkin() {
        return skin;
    }
    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="name")
    private SkinPropertyType type; 

    @ManyToOne
    @JoinColumn(name="value", referencedColumnName="id", nullable=false)
    private PathResource value;
    
    @ManyToOne
    @JoinColumn(name="skin", referencedColumnName="id", nullable=false)
    private Skin skin;
    
}
