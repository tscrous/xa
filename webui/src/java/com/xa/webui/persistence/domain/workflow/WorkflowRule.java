package com.xa.webui.persistence.domain.workflow;

import com.xa.webui.persistence.domain.IdentifiableEntity;
import com.xa.webui.persistence.domain.WebObject;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="workflow_rule")
public class WorkflowRule extends IdentifiableEntity {

    public WorkflowRule() {
    }
    
    public WorkflowRule(WebObject trigger, WebObject target) {
        this.trigger = trigger.getName();
        this.target = target.getName();
    }

    public String getTrigger() {
        return trigger;
    }
    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getTarget() {
        return target;
    }
    public void setTarget(String target) {
        this.target = target;
    }

    public List<Workflow> getWorkflows() {
        return workflows;
    }

    public void setWorkflows(List<Workflow> workflows) {
        this.workflows = workflows;
    }

    @Column(name="trigger_id", nullable=false)
    private String trigger;

    @Column(name="target_id", nullable=false)
    private String target;
    
    @ManyToMany(mappedBy="rules")
    private List<Workflow> workflows;
    
}
