package com.xa.webui.service.api;

import com.xa.webui.exception.service.AbstractEntityService;
import com.xa.webui.exception.service.ServiceWorkflowException;
import com.xa.webui.persistence.dao.CrudDao;
import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.workflow.Workflow;
import com.xa.webui.persistence.domain.workflow.WorkflowRule;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author theo-alaganze
 */
public class WorkflowManager extends AbstractEntityService {
    
    public static WorkflowManager getInstance() {
        if (workflowManager == null) {
            workflowManager = new WorkflowManager();
        }
        return workflowManager;
    }
    
    public WorkflowManager() {
        workflowDao = new CrudDao<Workflow>(Workflow.class);
        workflowRuleDao = new CrudDao<WorkflowRule>(WorkflowRule.class);
    }
    
    /* Workflow */
    
    public Workflow getWorkflowById(long id) {
        return workflowDao.getById(id);
    } 
    
    public Workflow getWorkflowByName(String name) {
        QueryParameters parameters = createQueryParameters("name", name);
        return getFirst(workflowDao.getByValues(parameters));
    }
    
    /* WorkflowRule */
    
    public WorkflowRule getRuleByTrigger(String trigger, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTrigger().equals(trigger)) {
                filteredRules.add(rule);
            }
        }
        return getSingle(filteredRules);
    } 
    public WorkflowRule getFirstRuleByTrigger(String trigger, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTrigger().equals(trigger)) {
                filteredRules.add(rule);
            }
        }
        return getFirst(filteredRules);
    } 
    public WorkflowRule getLastRuleByTrigger(String trigger, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTrigger().equals(trigger)) {
                filteredRules.add(rule);
            }
        }
        return getLast(filteredRules);
    } 
    public List<WorkflowRule> getRulesByTrigger(String trigger, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTrigger().equals(trigger)) {
                filteredRules.add(rule);
            }
        }
        return filteredRules;
    } 
    
    
    public WorkflowRule getRuleByTarget(String target, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTarget().equals(target)) {
                filteredRules.add(rule);
            }
        }
        return getSingle(filteredRules);
    }
    public WorkflowRule getFirstRuleByTarget(String target, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTarget().equals(target)) {
                filteredRules.add(rule);
            }
        }
        return getFirst(filteredRules);
    }
    public WorkflowRule getLastRuleByTarget(String target, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTarget().equals(target)) {
                filteredRules.add(rule);
            }
        }
        return getLast(filteredRules);
    }
    public List<WorkflowRule> getRulesByTarget(String target, String...workflowNames) {
        List<WorkflowRule> filteredRules = new LinkedList<WorkflowRule>();
        for (WorkflowRule rule : getAllowedRules(workflowNames)) {
            if (rule.getTarget().equals(target)) {
                filteredRules.add(rule);
            }
        }
        return filteredRules;
    }
    
    /* Utilities */
    
    private List<WorkflowRule> getAllowedRules(String...workflowNames) {
        List<WorkflowRule> allowedRules = new LinkedList<WorkflowRule>();
        Workflow workflow;
        for (String name : workflowNames) {
            workflow = getWorkflowByName(name);
            if (workflow == null) {
                throw new ServiceWorkflowException("Workflow (with name: \""+ name +"\") not found!");
            }
            allowedRules.addAll(workflow.getRules());
        }
        return allowedRules;
    }
    
    private CrudDao<Workflow> workflowDao;
    private CrudDao<WorkflowRule> workflowRuleDao;
    private static WorkflowManager workflowManager;

}
