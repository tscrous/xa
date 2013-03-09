package com.xa.webui.persistence.domain.resource.path;

import com.xa.webui.persistence.domain.resource.WebResource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 *
 * @author theo-alaganze
 */
@Entity
public class PathResource extends WebResource<Path> {

    public PathResource() {
    }
    
    public PathResource(PathResourceType type, String name, Path path) {
        this.type = type;
        this.name = name;
        this.path = path.getValue();
    }
    
    @Override
    public Path getValue() {
        return new Path(path);
    }
    public void setValue(Path path) {
        this.path = path.getValue();
    }

    public PathResourceType getType() {
        return type;
    }
    public void setType(PathResourceType type) {
        this.type = type;
    }

    @Column(name="resource_path")
    private String path;
    
    @Enumerated(EnumType.STRING)
    @Column(name="type")
    private PathResourceType type;
    
}
