package com.xa.webui.service.api;

import com.xa.webui.exception.service.AbstractEntityService;
import com.xa.webui.persistence.dao.CrudDao;
import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.WebObjectCache;
import com.xa.webui.persistence.domain.component.FooterMenu;
import com.xa.webui.persistence.domain.component.ItemGroup;
import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.OptionItemGroup;
import com.xa.webui.persistence.domain.component.page.BasicPageDescriptor;
import com.xa.webui.persistence.domain.component.page.PageDescriptor;

/**
 *
 * @author theo-alaganze
 */
public class WebComponentManager extends AbstractEntityService {
    
    public WebComponentManager() {
        webObjectCache = WebObjectCache.getInstance();
        pageDao = new CrudDao<BasicPageDescriptor>(BasicPageDescriptor.class);
        menuDao = new CrudDao<Menu>(Menu.class);
        footerMenuDao = new CrudDao<FooterMenu>(FooterMenu.class);
        optionsDao = new CrudDao<OptionItemGroup>(OptionItemGroup.class);
    }
    
    /* PathResource */
    
    public PageDescriptor getPageDescriptorByName(String name) {
        QueryParameters parameters = createQueryParameters("name", name);
        PageDescriptor page;
        try {
            page = (BasicPageDescriptor) webObjectCache.get(name);
        } catch (ClassCastException e) {
            page = null;
        }
        /* get component from DB */
        if (page == null) {
            page = getSingle(pageDao.getByValues(parameters));
            /* update cache & return */
            if (page != null) {
                webObjectCache.add((BasicPageDescriptor) page);
            }
        }
        return page;
    }
    
    public ItemGroup getItemGroupByName(String name) {
        QueryParameters parameters = createQueryParameters("name", name);
        ItemGroup itemGroup;
        try {
            itemGroup = (ItemGroup) webObjectCache.get(name);
        } catch (ClassCastException e) {
            itemGroup = null;
        }
        /* get resource from DB */
        if (itemGroup == null) {
            itemGroup = getSingle(menuDao.getByValues(parameters));
        }
        if (itemGroup == null) {
            itemGroup = getSingle(footerMenuDao.getByValues(parameters));
        }
        if (itemGroup == null) {
            itemGroup = getSingle(optionsDao.getByValues(parameters));
        }
        /* update cache & return */
        if (itemGroup != null) {
            webObjectCache.add(itemGroup);
        }
        return itemGroup;
    }
    
    private WebObjectCache webObjectCache;
    
    private CrudDao<BasicPageDescriptor> pageDao;
    
    private CrudDao<Menu> menuDao;
    private CrudDao<FooterMenu> footerMenuDao;
    private CrudDao<OptionItemGroup> optionsDao;

}
