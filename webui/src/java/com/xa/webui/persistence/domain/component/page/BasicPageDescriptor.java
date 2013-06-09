package com.xa.webui.persistence.domain.component.page;

import com.xa.webui.persistence.domain.component.WebComponent;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import com.xa.webui.persistence.domain.user.RuntimeInfo;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class BasicPageDescriptor extends WebComponent<PathResource> implements PageDescriptor {

    /* Implementation for: PageDescriptor */

    @Override
    public PathResource getPage() {
        return page;
    }
    @Override
    public void setPage(PathResource page) {
        this.page = page;
    }

    @Override
    public PathResource getContent() {
        return content;
    }
    @Override
    public void setContent(PathResource content) {
        this.content = content;
    }

    public RuntimeInfo getRuntimeInfo() {
        return runtimeInfo;
    }
    public void setRuntimeInfo(RuntimeInfo runtimeInfo) {
        this.runtimeInfo = runtimeInfo;
    }
    
    /* Implementation for: WebComponent */

    @Override
    public PathResource getValue() {
        return getPage();
    }
    
    /* Properties */
    
    @ManyToOne
    @JoinColumn(name="page_id", referencedColumnName="id")
    protected PathResource page;

    @ManyToOne
    @JoinColumn(name="content_id", referencedColumnName="id")
    protected PathResource content;
    
    @Transient
    protected RuntimeInfo runtimeInfo;
    
}
