package com.xa.webui.persistence.domain.workflow;

import com.xa.webui.persistence.domain.IdentifiableEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="workflow")
public class Workflow extends IdentifiableEntity {

    public Workflow() {
    }

    public Workflow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<WorkflowRule> getRules() {
        return rules;
    }
    public void setRules(List<WorkflowRule> rules) {
        this.rules = rules;
    }

    @Column(name="name", nullable=false)
    private String name;
    
    @ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="workflows_rules_mapping", joinColumns={@JoinColumn(name="workflow_id")}, inverseJoinColumns={@JoinColumn(name="rule_id")})
    private List<WorkflowRule> rules;
    
}
