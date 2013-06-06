package com.xa.webui.persistence.domain.system;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.service.api.WebObjectDependencyManager;

/**
 *
 * @author theo-alaganze
 */
public class SystemOrchestrator extends WebObject {

    public static SystemOrchestrator getInstance() {
        if (systemOrchestrator == null) {
            systemOrchestrator = new SystemOrchestrator();
        }
        return systemOrchestrator;
    }
    
    private SystemOrchestrator() {
        
    }
    
    @Override
    public WebObjectDependencyManager getDependencyManager() {
        return null;
    }

    @Override
    public String getName() {
        return "system.orchestrator";
    }

    @Override
    public String getDescription() {
        return "System's representative for orchestrating events.";
    }

    @Override
    public Object getValue() {
        throw new NotSupportedException("Not supported!");
    }
    
    private static SystemOrchestrator systemOrchestrator;
    
}
