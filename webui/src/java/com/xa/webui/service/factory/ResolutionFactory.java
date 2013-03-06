package com.xa.webui.service.factory;

import com.xa.webui.exception.service.ServiceEventException;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionDescriptor;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionType;
import com.xa.webui.system.SystemError;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author theo-alaganze
 */
public abstract class ResolutionFactory {
    
    public static Resolution getResolution(SystemError error) {
        return new ErrorResolution(error.getCode(), error.getMessage());
    }
    
    public static Resolution getResolution(String path) {
        return new ForwardResolution(path);
    }
    
    public static Resolution getResolution(ResolutionDescriptor descriptor) {
        if (descriptor.getType() == ResolutionType.ERROR) {
            return new ErrorResolution(descriptor.getErrorCode(), descriptor.getErrorMessage());
        } else if (descriptor.getType() == ResolutionType.REDIRECT) {
            if (descriptor.getBeanType() != null) {
                return new RedirectResolution(getActionBeanClass(descriptor.getBeanType()), descriptor.getEvent());
            } else if (descriptor.getUrl() != null) {
                return new RedirectResolution(descriptor.getUrl(), descriptor.isPrependContext());
            }
        } else if (descriptor.getType() == ResolutionType.FORWARD) {
            if (descriptor.getBeanType() != null) {
                return new ForwardResolution(getActionBeanClass(descriptor.getBeanType()), descriptor.getEvent());
            } else if (descriptor.getPath() != null) {
                return new ForwardResolution(descriptor.getPath());
            }
        }
        throw new ServiceEventException("Failed to create Resolution! The associated Resources my be invalid/corrupt!");
    }
    
    private static Class<? extends ActionBean> getActionBeanClass(String className) {
        try {
            return (Class<ActionBean>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ServiceEventException("The className for ActionBean: \""+ className +"\" could not be found in class path!", e.getException());
        }
    }
    
}
