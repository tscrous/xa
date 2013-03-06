package com.xa.webui.service.factory;

import com.xa.webui.persistence.domain.resource.resolution.ResolutionDescriptor;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionType;
import net.sourceforge.stripes.action.ActionBean;

/**
 *
 * @author theo-alaganze
 */
public abstract class ResolutionDescriptorFactory {
    
    /* ErrorResolution */

    public static ResolutionDescriptor createErrorResolution(int errorCode) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.ERROR);
        descriptor.setErrorCode(errorCode);
        return descriptor;
    }
    public static ResolutionDescriptor createErrorResolution(int errorCode, String errorMessage) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.ERROR);
        descriptor.setErrorCode(errorCode);
        descriptor.setErrorMessage(errorMessage);
        return descriptor;
    }

    /* ForwardResolution */

    public static ResolutionDescriptor createForwardResolution(Class<? extends ActionBean> beanType) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.FORWARD);
        descriptor.setBeanType(beanType.getName());
        return descriptor;
    }
    public static ResolutionDescriptor createForwardResolution(Class<? extends ActionBean> beanType, String event) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.FORWARD);
        descriptor.setBeanType(beanType.getName());
        descriptor.setEvent(event);
        return descriptor;
    }
    public static ResolutionDescriptor createForwardResolution(String path) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.FORWARD);
        descriptor.setPath(path);
        return descriptor;
    }

    /* RedirectResolution */
    
    public static ResolutionDescriptor createRedirectResolution(Class<? extends ActionBean> beanType) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.REDIRECT);
        descriptor.setBeanType(beanType.getName());
        return descriptor;
    }
    public static ResolutionDescriptor createRedirectResolution(Class<? extends ActionBean> beanType, String event) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.REDIRECT);
        descriptor.setBeanType(beanType.getName());
        descriptor.setEvent(event);
        return descriptor;
    }
    public static ResolutionDescriptor createRedirectResolution(String url) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.REDIRECT);
        descriptor.setUrl(url);
        return descriptor;
    }
    public static ResolutionDescriptor createRedirectResolution(String url, boolean prependContext) {
        ResolutionDescriptor descriptor = new ResolutionDescriptor(ResolutionType.REDIRECT);
        descriptor.setUrl(url);
        descriptor.setPrependContext(prependContext);
        return descriptor;
    }    
     
}
