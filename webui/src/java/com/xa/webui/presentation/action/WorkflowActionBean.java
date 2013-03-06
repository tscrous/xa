package com.xa.webui.presentation.action;

import com.xa.webui.exception.persistence.PersistenceWorkflowException;
import com.xa.webui.persistence.domain.resource.WebResource;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionDescriptor;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionResource;
import com.xa.webui.persistence.domain.system.SystemOrchestrator;
import com.xa.webui.persistence.domain.user.UserSession;
import com.xa.webui.persistence.domain.user.UserSessionRuntime;
import com.xa.webui.persistence.domain.workflow.Workflow;
import com.xa.webui.persistence.domain.workflow.WorkflowRule;
import com.xa.webui.service.api.SessionManager;
import com.xa.webui.service.api.WebResourceManager;
import com.xa.webui.service.api.WorkflowManager;
import com.xa.webui.service.factory.ResolutionFactory;
import com.xa.webui.system.Constants;
import com.xa.webui.system.SystemError;
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
            WebResource<?> resource = webResourceManager.getResourceByName(rule.getTarget());
System.out.println("selected rule: id="+ rule.getId() +", trigger="+ rule.getTrigger() +", target="+ rule.getTarget() +" >> target resource="+ resource.getName());
            if (resource instanceof PathResource) {
                String path = ((PathResource) resource).getValue();
                resolution = ResolutionFactory.getResolution(path);
            } else if (resource instanceof ResolutionResource) {
                ResolutionDescriptor descriptor = ((ResolutionResource) resource).getValue();
                resolution = ResolutionFactory.getResolution(descriptor);
            }
            if (resolution == null) {
                resolution = ResolutionFactory.getResolution(SystemError.WORKFLOW_VIEW_RESOLUTION_ERROR);
            }
        } catch (Exception e) {
//            TODO: use proper logger for stack trace
            e.printStackTrace();
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
System.out.println("\ndetermine rule: workflow="+ currentWorkflow.getName() +", trigger="+ trigger +", rules found="+ rules.size());
        /* determine rule */
        if (rules.isEmpty()) {
            return getSystemDefinedRule(trigger);
        } else if (rules.size() == 1) {
            return rules.get(0);
        } else {
            throw new PersistenceWorkflowException(SystemError.WORKFLOW_VIEW_EXECUTION_ERROR);
        }
    }

    /* Utilities */
    
    private WorkflowRule getSystemDefinedRule(String trigger) {
        WorkflowRule rule = new WorkflowRule();
        rule.setTrigger(SystemOrchestrator.getInstance().getName());
        rule.setTarget(Constants.LANDING_PAGE_TARGET_ID);
        return rule;
    }
    

    /* properties */

    @Transient
    private ActionBeanContext context;
    
    @Transient
    private WorkflowManager workflowManager;
    
    @Transient
    private WebResourceManager webResourceManager;
    
}
