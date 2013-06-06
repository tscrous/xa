package com.xa.webui.persistence.domain.component.page;

import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.persistence.domain.resource.ResolvableObject;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import java.util.List;

public interface PageDescriptor extends ResolvableObject {

    public String getName();

    public PathResource getPage();
    public void setPage(PathResource page);
    
    public PathResource getContent();
    public void setContent(PathResource content);
    
    public <T extends WebObject> T getDependency(Class<T> type);
    public List<WebObject> getDependencies();

}
