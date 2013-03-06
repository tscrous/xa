package com.xa.webui.system;

/**
 *
 * @author theo-alaganze
 */
public enum SystemError {
    
    WORKFLOW_VIEW_RESOLUTION_ERROR (1001, "Workflow was unable to create resolution!"),
    WORKFLOW_VIEW_EXECUTION_ERROR (1002, "Workflow encountered an unexpected error while creating a resolution!"),
    ;
    
    private SystemError(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getMessage() {
        return message;
    }
    
    private int code;
    private String message;
    
}
