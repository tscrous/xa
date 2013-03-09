package com.xa.webui.system;

import com.xa.webui.presentation.action.impl.PageActionBean;

/**
 *
 * @author theo-alaganze
 */
public abstract class Constants {
    
    /* workflow parameters */
    public static final String PARM_WORKFLOW_TRIGGER_ID = "parm.trigger.workflow";
    
    /* session parameters */
    public static final String PARM_SESSION_WORKFLOW = "session.workflow";
    public static final String PARM_SESSION_EVENT_LOG = "session.event.log";
    
    /* pages */
    public static final String PARM_PAGE_DESCRIPTOR_NAME = "parm.page.descriptor.name";
    public static final Class<PageActionBean> PAGE_ACTION_BEAN_CLASS = PageActionBean.class;
    
    /* other parameters */
    public static final String LANDING_PAGE_TARGET_ID = "target.landing_page";
    public static final String SKIN_DEFAULT_NAME = "skin.default.name";
    
}
