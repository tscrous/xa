package com.xa.webui.presentation.action.impl;

import com.xa.webui.persistence.domain.component.Page;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionResource;
import com.xa.webui.persistence.domain.user.UserSession;
import com.xa.webui.presentation.action.SessionActionBean;
import com.xa.webui.service.api.SessionManager;
import com.xa.webui.service.factory.ResolutionFactory;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author theo-alaganze
 */
@Entity
public class PageActionBean extends Page implements SessionActionBean {

    public PageActionBean() {
    }
    
    public ResolutionResource getResource() {
        return resource;
    }
    private void setResource(ResolutionResource resource) {
        this.resource = resource;
    }

    @Override
    public ActionBeanContext getContext() {
        return context;
    }    
    @Override
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }
    
    @Override
    public UserSession getUserSession() {
        return SessionManager.getInstance().getSession(context.getRequest());
    }

    @Override
    public Resolution view() {
        return ResolutionFactory.getResolution(resource.getValue());
    }
    
    @Transient
    protected ActionBeanContext context;
    
    @ManyToOne
    @JoinColumn(name="resolution_resource_id", referencedColumnName="id")
    protected ResolutionResource resource;
    
}
