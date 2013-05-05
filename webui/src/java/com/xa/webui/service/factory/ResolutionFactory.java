package com.xa.webui.service.factory;

import com.xa.webui.exception.service.ServiceEventException;
import com.xa.webui.persistence.domain.component.page.PageDescriptor;
import com.xa.webui.persistence.domain.resource.ResolvableObject;
import com.xa.webui.persistence.domain.resource.path.Path;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionDescriptor;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionType;
import com.xa.webui.system.Constants;
import com.xa.webui.system.SystemError;
import javax.enterprise.inject.ResolutionException;
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
    
    public static Resolution getResolution(ResolvableObject object) {
        if (object instanceof PageDescriptor) {
            ForwardResolution resolution = new ForwardResolution(Constants.PAGE_ACTION_BEAN_CLASS, null);
            resolution.addParameter(Constants.PAGE_DESCRIPTOR_NAME, ((PageDescriptor) object).getName());
            return resolution;
        } else if (object instanceof SystemError) {
            SystemError error = (SystemError) object;
            return new ErrorResolution(error.getCode(), error.getMessage());
        } else if (object instanceof Path) {
            String path = ((Path) object).getValue();
            return new ForwardResolution(path);
        } else if (object instanceof ResolutionDescriptor) {
            ResolutionDescriptor descriptor = (ResolutionDescriptor) object;
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
        throw new ResolutionException("Unable to determine resolution for object: "+ object.getClass());
    }
    
    private static Class<? extends ActionBean> getActionBeanClass(String className) {
        try {
            return (Class<ActionBean>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new ServiceEventException("The className for ActionBean: \""+ className +"\" could not be found in class path!", e.getException());
        }
    }
    
}
