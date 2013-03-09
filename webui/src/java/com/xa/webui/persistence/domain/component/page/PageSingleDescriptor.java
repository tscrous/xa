package com.xa.webui.persistence.domain.component.page;

import com.xa.webui.persistence.domain.component.FooterMenu;
import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.WebComponent;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PageSingleDescriptor extends WebComponent<PathResource> implements PageDescriptor {

    @Override
    public Menu getTopMenu() {
        return topMenu;
    }
    @Override
    public void setTopMenu(Menu topMenu) {
        this.topMenu = topMenu;
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
    @Override
    public void setFooterMenu(FooterMenu footerMenu) {
        this.footerMenu = footerMenu;
    }

    @Override
    public PathResource getValue() {
        return value;
    }
    @Override
    public void setValue(PathResource value) {
        this.value = value;
    }
    
    @ManyToOne
    @JoinColumn(name="top_menu_id", referencedColumnName="id")
    protected Menu topMenu;

    @ManyToOne
    @JoinColumn(name="footer_menu_id", referencedColumnName="id")
    protected FooterMenu footerMenu;

    @ManyToOne
    @JoinColumn(name="web_resource_id", referencedColumnName="id")
    protected PathResource value;

}
