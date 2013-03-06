package com.xa.webui.presentation.action.impl;

import com.xa.webui.persistence.domain.resource.resolution.ResolutionResource;
import javax.enterprise.inject.ResolutionException;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author theo-alaganze
 */
public class MultiplePageActionBean extends PageActionBean {

    public MultiplePageActionBean() {
        
    }
    
//    TODO: keep list of all possible tab resources
    
    @Override
    public Resolution view() {
        throw new ResolutionException("Failed to execute @DefaultHandler for ActionBean: "+ this.getClass());
    }
    
    @ManyToOne
    @JoinColumn(name="resolution_resource_id", referencedColumnName="id")
    protected ResolutionResource resource;

}
