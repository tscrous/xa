package com.xa.webui.service.api;

import com.xa.webui.exception.service.AbstractEntityService;
import com.xa.webui.persistence.dao.CrudDao;
import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.resource.skin.Skin;
import com.xa.webui.persistence.domain.resource.skin.SkinCache;
import com.xa.webui.system.Constants;

/**
 *
 * @author theo-alaganze
 */
public class SkinManager extends AbstractEntityService {
    
    public SkinManager() {
        skinCache = SkinCache.getInstance();
        skinDao = new CrudDao(Skin.class);
    }
    
    public Skin getDefaultSkin() {
        return getSkinByName(Constants.SKIN_DEFAULT_NAME);
    }
    
    public Skin getSkinByName(String name) {
        QueryParameters parameters = createQueryParameters("name", name);
        return getSingle(skinDao.getByValues(parameters));
    }
    
    public void flush() {
        skinCache.clear();
    }
    
    private SkinCache skinCache;
    private CrudDao<Skin> skinDao;
    
}
