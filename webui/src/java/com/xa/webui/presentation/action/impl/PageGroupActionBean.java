package com.xa.webui.presentation.action.impl;

import com.xa.webui.exception.ResolutionException;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionResource;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author theo-alaganze
 */
public class PageGroupActionBean extends PageActionBean {

    public PageGroupActionBean() {
        
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
