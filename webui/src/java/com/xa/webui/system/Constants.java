package com.xa.webui.system;

import com.xa.webui.presentation.action.impl.PageActionBean;

/**
 *
 * @author theo-alaganze
 */
public abstract class Constants {
    
    /* workflow parameters */
    public static final String PARM_WORKFLOW_TRIGGER_ID = "mediate";
    
    
    /* session parameters */
    public static final String PARM_SESSION_WORKFLOW = "session.workflow";
    public static final String PARM_SESSION_EVENT_LOG = "session.event.log";
    
    
    /* pages */
    public static final String BASIC_PAGE_ID = "template.page.basic";
    public static final String CANVAS_PAGE_ID = "template.page.canvas";
    public static final String CLEAR_CANVAS_PAGE_ID = "template.page.clear.canvas";

    public static final String HOME_PAGE_TARGET_ID = "page.home";
    public static final String ABOUT_XA_PAGE_TARGET_ID = "page.about";
    public static final String OPEN_CASES_PAGE_TARGET_ID = "page.open_cases";
    public static final String CONTACT_US_PAGE_TARGET_ID = "page.contact";
    
    /* -----> home\questions */
    public static final String Q_COMPETITION_TRIGGER_ID = "page.q_competition";
    public static final String Q_DUTY_INCREASE_TRIGGER_ID = "page.q_duty_increase";
    public static final String Q_COMPETITIVENESS_TRIGGER_ID = "page.q_competitiveness";
    public static final String Q_INCENTIVES_TRIGGER_ID = "page.q_competitiveness";
    
    public static final String Q_COMPETITION_PAGE_TARGET_ID = "page.q_competition";
    public static final String Q_DUTY_INCREASE_PAGE_TARGET_ID = "page.q_duty_increase";
    public static final String Q_COMPETITIVENESS_PAGE_TARGET_ID = "page.q_competitiveness";
    public static final String Q_INCENTIVES_PAGE_TARGET_ID = "page.q_incentives";

    
    public static final String PAGE_DESCRIPTOR_NAME = "parm.page.descriptor.name";
    public static final Class<PageActionBean> PAGE_ACTION_BEAN_CLASS = PageActionBean.class;
    
    /* runtime info */
    public static final String WORKFLOW_LATEST_TRIGGER = "parm.workflow.trigger.latest";
    
    
    /* other parameters */    
    public static final String SKIN_DEFAULT_NAME = "skin.default.name";
    
}
