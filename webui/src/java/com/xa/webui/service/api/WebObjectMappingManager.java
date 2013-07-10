package com.xa.webui.service.api;

import com.xa.webui.exception.service.AbstractEntityService;
import com.xa.webui.persistence.dao.CrudDao;
import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.WebObject;
import com.xa.webui.persistence.domain.dependency.WebObjectDependency;
import com.xa.webui.system.utils.ValidationUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author theo-alaganze
 */
public class WebObjectDependencyManager extends AbstractEntityService {
    
    public WebObjectDependencyManager() {
        resourceManager = new WebResourceManager();
        componentManager = new WebComponentManager();
        dependencyDao = new CrudDao<WebObjectDependency>(WebObjectDependency.class);
        refreshObjectDependencyCache();
    }
    
    public void refreshObjectDependencyCache() {
        valueMap = new HashMap<String, List<String>>();
        classMap = new HashMap<String, Class<? extends WebObject>>();
        List<String> parents;
        for (WebObjectDependency dependency : dependencyDao.getAll()) {
            parents = valueMap.get(dependency.getDependantName());
            /* create bucket (if not exist) */
            if (parents == null) {
                parents = new LinkedList<String>();
                valueMap.put(dependency.getDependantName(), parents);
                if (!classMap.containsKey(dependency.getDependantName())) {
                    classMap.put(dependency.getDependantName(), getDependencyClassByName(dependency.getDependantName()));
                }
            }
            /* add NON-DUPLICATE child */
            if (!parents.contains(dependency.getParentName())) {
                parents.add(dependency.getParentName());
                if (!classMap.containsKey(dependency.getParentName())) {
                    classMap.put(dependency.getParentName(), getDependencyClassByName(dependency.getParentName()));
                }
            }
        }
    }
    
    /* Dependency */
    
    public void setDependency(WebObject dependant, WebObject parent) {
        ensureNamedObject("dependant", dependant);
        ensureNamedObject("parent", parent);
        /* check if persisted instance exist */
        QueryParameters parameters = createQueryParameters();
        parameters.put("dependantName", dependant.getName());
        parameters.put("parentName", parent.getName());
        WebObjectDependency dependecy = getSingle(dependencyDao.getByValues(parameters));
        /* persist dependency (if NOT exist) */
        if (dependecy == null) {
            dependecy = new WebObjectDependency(dependant, parent);
            dependencyDao.save(dependecy);
        }
    }
    
    public boolean hasDependency(WebObject dependant, Class<? extends WebObject> type) {
        ensureNamedObject("dependant", dependant);
        ValidationUtils.ensureNotNull("type", type);
        for (WebObject parent : getDependenciesOn(dependant)) {
            if (getDependencyClassByName(parent.getName()) == type) {
                return true;
            }
        }
        return false;
    }
    public boolean hasDependency(WebObject dependant, WebObject parent) {
        ensureNamedObject("dependant", dependant);
        ensureNamedObject("parent", parent);
        return valueMap.containsKey(dependant.getName()) && valueMap.get(dependant.getName()).contains(parent.getName());
    }
    
    public void removeDependency(WebObject dependant, WebObject parent) {
        ensureNamedObject("dependant", dependant);
        ensureNamedObject("parent", parent);
        /* get & remove persisted instance */
        QueryParameters parameters = createQueryParameters();
        parameters.put("dependantName", dependant.getName());
        parameters.put("parentName", parent.getName());
        WebObjectDependency dependecy = getSingle(dependencyDao.getByValues(parameters));
        if (dependecy != null) {
            dependencyDao.delete(dependecy);
        }
    }
    
    /* Dependencies */
    
    public List<WebObject> getDependenciesOn(WebObject dependant) {
        ensureNamedObject("dependant", dependant);
        List<WebObject> parents = new ArrayList<WebObject>();
        WebObject parent;
        if (valueMap.containsKey(dependant.getName())) {
            for (String dependantName : valueMap.get(dependant.getName())) {
                /* get object by assuming it's a RESOURCE */
                parent = resourceManager.getByName(dependantName);
                /* if not a RESOURCE, get object by assuming it's a COMPONENT */
                if (parent == null) {
                    parent = componentManager.getByName(dependantName);
                }
                if (parent != null) {
                    parents.add(parent);
                }
            }
        }
        return parents;
    }
    
    public void setDependencies(WebObject dependant, List<WebObject> parents) {
        ensureNamedObject("dependant", dependant);
        ValidationUtils.ensureNotNull("parents", parents);
        removeDependencies(dependant);
        for (WebObject parent : parents) {
            setDependency(dependant, parent);
        }
    }
    
    public void removeDependencies(WebObject dependant) {
        ensureNamedObject("dependant", dependant);
        for (WebObject dependency : getDependenciesOn(dependant)) {
            removeDependency(dependant, dependency);
        }
    }
    
    /** List all WebObjects that have a dependency on the specified object (parent) */
    public List<WebObject> getDependantsOf(WebObject parent) {
        ensureNamedObject("parent", parent);
        List<WebObject> dependants = new ArrayList<WebObject>();
        boolean found;
        WebObject dependant;
        for (String dependantName : valueMap.keySet()) {
            found = false;
            for (String parentName : valueMap.get(dependantName)) {
                if (parentName.equals(parent.getName())) {
                    found = true;
                    break;
                }
            }
            if (found) {
                /* get object by assuming it's a COMPONENT */
                dependant = componentManager.getByName(dependantName);
                /* if not a RESOURCE, get object by assuming it's a RESOURCE */
                if (dependant == null) {
                    dependant = resourceManager.getByName(dependantName);
                }
                if (dependant != null) {
                    dependants.add(dependant);
                }
            }
        }
        return dependants;
    }
    
    /* Utilities */
    
    protected void ensureNamedObject(String name, WebObject webObject) {
        ValidationUtils.ensureNotNull(name, webObject);
        ValidationUtils.ensureNotNull(name, webObject.getName());
    }
    
    protected Class<? extends WebObject> getDependencyClassByName(String name) {
        WebObject object = componentManager.getByName(name);
        if (object == null) {
            object = resourceManager.getByName(name);
        }
        return object != null ? object.getClass() : null;
    }
    
    private WebComponentManager componentManager;
    private WebResourceManager resourceManager;
    private CrudDao<WebObjectDependency> dependencyDao;
    private Map<String, List<String>> valueMap;
    private Map<String, Class<? extends WebObject>> classMap;

}
