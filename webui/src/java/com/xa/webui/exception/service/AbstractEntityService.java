package com.xa.webui.exception.service;

import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.IdentifiableEntity;
import com.xa.webui.system.utils.ValidationUtils;
import java.util.List;

/**
 *
 * @author theo-alaganze
 */
public class AbstractEntityService {
    
    protected QueryParameters createQueryParameters() {
        return new QueryParameters();
    }
    protected QueryParameters createQueryParameters(String name, Object value) {
        QueryParameters parameters = new QueryParameters();
        parameters.put(name, value);
        return parameters;
    }
    
    protected <T extends IdentifiableEntity> T getSingle(List<T> list) {
        if (ValidationUtils.isNullOrEmpty(list)) {
            return null;
        } else if (list.size() > 1) {
            throw new ServiceManagementException("Single value expected, yet multiple values were found!");
        }
        return list.get(0);
    }
    protected <T extends IdentifiableEntity> T getFirst(List<T> list) {
        if (ValidationUtils.isNullOrEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
    protected <T extends IdentifiableEntity> T getLast(List<T> list) {
        if (ValidationUtils.isNullOrEmpty(list)) {
            return null;
        }
        return list.get(list.size()-1);
    }
    
}
