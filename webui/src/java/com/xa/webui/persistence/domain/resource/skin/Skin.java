package com.xa.webui.persistence.domain.resource.skin;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.persistence.domain.IdentifiableEntity;
import com.xa.webui.persistence.domain.resource.Resource;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="skin")
public class Skin extends IdentifiableEntity implements Resource {

    public Skin() {
    }
    
    public Skin(String name) {
        this.name = name;
    }
    
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getValue() {
        throw new NotSupportedException();
    }
    
    public PathResource getProperty(SkinPropertyType type) {
        for (SkinProperty property : properties) {
            if (property.getType() == type) {
                return property.getValue();
            }
        }
        return null;
    }
    
    @Column(name="name", unique=true)
    private String name;

    @OneToMany(fetch= FetchType.EAGER, mappedBy="skin")
    private List<SkinProperty> properties;

}
