package com.xa.webui.system;

import com.xa.webui.persistence.domain.WebObject;

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
    public String getName() {
        return "system.orchestrator";
    }

    @Override
    public String getDescription() {
        return "System's representative for orchestrating events.";
    }
    
    private static SystemOrchestrator systemOrchestrator;
    
}
