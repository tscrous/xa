package com.xa.webui.presentation.action;

import com.xa.webui.exception.persistence.PersistenceWorkflowException;
import com.xa.webui.persistence.domain.component.page.PageDescriptor;
import com.xa.webui.persistence.domain.resource.ResolvableObject;
import com.xa.webui.persistence.domain.resource.WebResource;
import com.xa.webui.persistence.domain.system.SystemOrchestrator;
import com.xa.webui.persistence.domain.user.UserSession;
import com.xa.webui.persistence.domain.user.UserSessionRuntime;
import com.xa.webui.persistence.domain.workflow.Workflow;
import com.xa.webui.persistence.domain.workflow.WorkflowRule;
import com.xa.webui.service.api.SessionManager;
import com.xa.webui.service.api.WebComponentManager;
import com.xa.webui.service.api.WebResourceManager;
import com.xa.webui.service.api.WorkflowManager;
import com.xa.webui.service.factory.ResolutionFactory;
import com.xa.webui.system.Constants;
import com.xa.webui.system.SystemError;
import com.xa.webui.system.utils.ValidationUtils;
import java.util.List;
import javax.persistence.Transient;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author theo-alaganze
 */
public class WorkflowActionBean implements SessionActionBean {
    
    public WorkflowActionBean() {
        workflowManager = new WorkflowManager();
        webResourceManager = new WebResourceManager();
        webComponentManager = new WebComponentManager();
    }
    
    /* Implementation for: SessionActionBean */

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
        Resolution resolution = null;
        try {
            UserSessionRuntime runtime = getUserSession().getRuntime();
            WorkflowRule rule = determineRule(runtime.getCurrentWorkflow(), getWorkflowTriggerId());
            Object targetObject = getTargetObject(rule);
            if (targetObject instanceof PageDescriptor) {
                return ResolutionFactory.getResolution((PageDescriptor) targetObject);
            } else if (targetObject instanceof WebResource) {
                ResolvableObject resource = ((WebResource) targetObject).getValue();
                resolution = ResolutionFactory.getResolution(resource);
            }
            if (resolution == null) {
                resolution = ResolutionFactory.getResolution(SystemError.WORKFLOW_VIEW_RESOLUTION_ERROR);
            }
        } catch (Exception e) {
            resolution = ResolutionFactory.getResolution(SystemError.WORKFLOW_VIEW_EXECUTION_ERROR);
        }
        return resolution;
    }
    
    /* Utilities */
    
    protected Object getParm(String name) {
        try {
            return context.getRequest().getParameter(name);
        } catch (NullPointerException e) {
            return null;
        }
    }
    
    protected String getWorkflowTriggerId() {
        String triggerId = (String) getParm(Constants.PARM_WORKFLOW_TRIGGER_ID);
        return triggerId;
    }
    
    protected WorkflowRule determineRule(Workflow currentWorkflow, String trigger) {
        List<WorkflowRule> rules = workflowManager.getRulesByTrigger(trigger, currentWorkflow.getName());
        /* determine rule */
        if (rules.isEmpty()) {
            return getSystemDefinedRule(trigger);
        } else if (rules.size() == 1) {
            return rules.get(0);
        } else {
            throw new PersistenceWorkflowException(SystemError.WORKFLOW_VIEW_EXECUTION_ERROR);
        }
    }

    private WorkflowRule getSystemDefinedRule(String trigger) {
        WorkflowRule rule = new WorkflowRule();
        rule.setTrigger(SystemOrchestrator.getInstance().getName());
        rule.setTarget(Constants.HOME_PAGE_TARGET_ID);
        return rule;
    }
    
    private Object getTargetObject(WorkflowRule rule) {
        Object targetObject = null;
        if (ValidationUtils.isNotNull(rule) && ValidationUtils.isNotNullAndNotEmpty(rule.getTarget())) {
            targetObject = webComponentManager.getPageDescriptorByName(rule.getTarget());
            if (targetObject == null) {
                targetObject = webResourceManager.getResourceByName(rule.getTarget());
            }
        }
        return targetObject;
    }
    

    /* properties */

    @Transient
    private ActionBeanContext context;
    
    @Transient
    private WorkflowManager workflowManager;
    
    @Transient
    private WebResourceManager webResourceManager;
    
    @Transient
    private WebComponentManager webComponentManager;
    
}
