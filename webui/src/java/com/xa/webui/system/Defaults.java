package com.xa.webui.system;

import com.xa.webui.persistence.domain.workflow.Workflow;

/**
 *
 * @author theo-alaganze
 */
public abstract class Defaults {
    
    public static Workflow getDefaultWorkflow() {
        return new Workflow("default.workflow");
    }
    
}
