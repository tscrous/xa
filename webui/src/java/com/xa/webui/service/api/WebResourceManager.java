package com.xa.webui.service.api;

import com.xa.webui.exception.service.AbstractEntityService;
import com.xa.webui.persistence.dao.CrudDao;
import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.WebObjectCache;
import com.xa.webui.persistence.domain.resource.WebResource;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import com.xa.webui.persistence.domain.resource.resolution.ResolutionResource;

/**
 *
 * @author theo-alaganze
 */
public class WebResourceManager extends AbstractEntityService {
    
    public WebResourceManager() {
        webObjectCache = WebObjectCache.getInstance();
        pathResourceDao = new CrudDao<PathResource>(PathResource.class);
        resolutionResourceDao = new CrudDao<ResolutionResource>(ResolutionResource.class);
    }
    
    /* PathResource */
    
    public WebResource<?> getResourceByName(String name) {
        QueryParameters parameters = createQueryParameters("name", name);
        WebResource<?> resource;
        try {
            resource = (WebResource) webObjectCache.get(name);
        } catch (ClassCastException e) {
            resource = null;
        }
        /* get resource from DB */
        if (resource == null) {
            resource = getSingle(pathResourceDao.getByValues(parameters));
        }
        if (resource == null) {
            resource = getSingle(resolutionResourceDao.getByValues(parameters));
        }
        /* update cache & return */
        if (resource != null) {
            webObjectCache.add(resource);
        }
System.out.println("lookup resource: "+ name +" => "+ resource);
        return resource;
    }
    
    private WebObjectCache webObjectCache;
    private CrudDao<PathResource> pathResourceDao;
    private CrudDao<ResolutionResource> resolutionResourceDao;

}
