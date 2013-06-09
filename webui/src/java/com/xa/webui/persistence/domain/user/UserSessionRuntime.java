package com.xa.webui.persistence.domain.user;

import com.xa.webui.persistence.domain.IdentifiableEntity;
import com.xa.webui.persistence.domain.workflow.Workflow;
import com.xa.webui.persistence.domain.workflow.WorkflowRule;
import com.xa.webui.system.Constants;
import com.xa.webui.system.Defaults;
import javax.servlet.http.HttpSession;

/**
 * This class manages all session parameters for a user
 * Instead of being a pure facade, it transforms the data to simplify its implementation
 * 
 * @author theo-alaganze
 */
public class UserSessionRuntime extends IdentifiableEntity {
    
    public UserSessionRuntime(UserSession userSession) {
        this.userSession = userSession;
    }

    public void reset() {
        setCurrentWorkflow(null);
        getEventLogFromSession().clear();
    }

    public Workflow getCurrentWorkflow() {
        HttpSession httpSession = userSession.getHttpSession();
        Workflow workflow = (Workflow) httpSession.getAttribute(Constants.PARM_SESSION_WORKFLOW);
        return workflow != null ? workflow : Defaults.getDefaultWorkflow();
    }
    public void setCurrentWorkflow(Workflow workflow) {
        HttpSession httpSession = userSession.getHttpSession();
        httpSession.setAttribute(Constants.PARM_SESSION_WORKFLOW, workflow);
    }
    
    protected UserSessionEventLog getEventLog() {
        return getEventLogFromSession();
    }
    public WorkflowRule getMostRecentEvent() {
        UserSessionEventLog eventLog = getEventLogFromSession();
        return eventLog.size() > 0 ? eventLog.get(eventLog.size()-1) : null;
    }
    public WorkflowRule getMostRecentEventByTrigger(String trigger) {
        UserSessionEventLog eventLog = getEventLogFromSession();
        for (int index=eventLog.size()-1; index >= 0; index--) {
            if (eventLog.get(index).getTrigger().equals(trigger)) {
                return eventLog.get(index);
            }
        }
        return null;
    }
    public WorkflowRule getMostRecentEventByTarget(String target) {
        UserSessionEventLog eventLog = getEventLogFromSession();
        for (int index=eventLog.size()-1; index >= 0; index--) {
            if (eventLog.get(index).getTarget().equals(target)) {
                return eventLog.get(index);
            }
        }
        return null;
    }
    public void addEvent(WorkflowRule event) {
        UserSessionEventLog eventLog = getEventLogFromSession();
        eventLog.add(event);
    }
    public WorkflowRule removeMostRecentEvent() {
        UserSessionEventLog eventLog = getEventLogFromSession();
        if (eventLog.size() > 0) {
            return eventLog.remove(eventLog.size()-1);
        }
        return null;
    }
   
    /* Utilities */
    
    private UserSessionEventLog getEventLogFromSession() {
        HttpSession httpSession = userSession.getHttpSession();
        UserSessionEventLog eventLog = (UserSessionEventLog) httpSession.getAttribute(Constants.PARM_SESSION_EVENT_LOG);
        if (eventLog == null) {
            eventLog = new UserSessionEventLog();
            httpSession.setAttribute(Constants.PARM_SESSION_EVENT_LOG, eventLog);
        }
        return eventLog;
    }
    
    /* properties */

    protected UserSession userSession;

}
