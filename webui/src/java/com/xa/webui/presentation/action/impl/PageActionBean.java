package com.xa.webui.presentation.action.impl;

import com.xa.webui.persistence.domain.component.page.BasicPageDescriptor;
import com.xa.webui.persistence.domain.user.UserSession;
import com.xa.webui.presentation.action.SessionActionBean;
import com.xa.webui.service.api.SessionManager;
import com.xa.webui.service.api.WebComponentManager;
import com.xa.webui.service.factory.ResolutionFactory;
import com.xa.webui.system.Constants;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author theo-alaganze
 */
public class PageActionBean implements SessionActionBean {

    public PageActionBean() {
    }
    
    @Override
    public ActionBeanContext getContext() {
        return context;
    }    
    @Override
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }

    public BasicPageDescriptor getDescriptor() {
        return descriptor;
    }
    public void setDescriptor(BasicPageDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    @Override
    public UserSession getUserSession() {
        return SessionManager.getInstance().getSession(context.getRequest());
    }

    @Override
    public Resolution view() {
        descriptor = retrievePageDescriptor();
        return ResolutionFactory.getResolution(descriptor.getPage().getValue());
    }
    
    /* Utilities */
    
    protected BasicPageDescriptor retrievePageDescriptor() {
        WebComponentManager webComponentManager = new WebComponentManager();
        String name = context.getRequest().getParameter(Constants.PARM_PAGE_DESCRIPTOR_NAME);
        return (BasicPageDescriptor) webComponentManager.getPageDescriptorByName(name);
    }
    
    private ActionBeanContext context;
    private BasicPageDescriptor descriptor;
    
}
