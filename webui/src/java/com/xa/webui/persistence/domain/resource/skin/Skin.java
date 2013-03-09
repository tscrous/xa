package com.xa.webui.persistence.domain.resource.resolution;

import com.xa.webui.persistence.domain.resource.WebResource;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author theo-alaganze
 */
@Entity
public class ResolutionResource extends WebResource<ResolutionDescriptor> {

    public ResolutionResource() {
    }
    
    public ResolutionResource(String name, ResolutionDescriptor descriptor) {
        this.name = name;
        this.descriptor = descriptor;
    }
    
    @Override
    public ResolutionDescriptor getValue() {
        return descriptor;
    }
    public void setValue(ResolutionDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="resolution_descriptor_id", referencedColumnName="id")
    private ResolutionDescriptor descriptor;

}
