package com.xa.webui.presentation.action;

import com.xa.webui.persistence.domain.user.UserSession;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author theo-alaganze
 */
public interface SessionActionBean extends ActionBean {
    
    public UserSession getUserSession();
    public Resolution view();
    
}
