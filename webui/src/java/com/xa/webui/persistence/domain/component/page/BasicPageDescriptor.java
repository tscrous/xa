package com.xa.webui.persistence.domain.component.page;

import com.xa.webui.persistence.domain.component.FooterMenu;
import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.WebComponent;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
    public Menu getTopMenu() {
        return topMenu;
    }
    @Override
    public void setTopMenu(Menu topMenu) {
        this.topMenu = topMenu;
    }

    @Override
    public PathResource getContent() {
        return content;
    }
    @Override
    public void setContent(PathResource content) {
        this.content = content;
    }
    
    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
    @Override
    public void setFooterMenu(FooterMenu footerMenu) {
        this.footerMenu = footerMenu;
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
    @JoinColumn(name="top_menu_id", referencedColumnName="id")
    protected Menu topMenu;

    @ManyToOne
    @JoinColumn(name="content_id", referencedColumnName="id")
    protected PathResource content;

    @ManyToOne
    @JoinColumn(name="footer_menu_id", referencedColumnName="id")
    protected FooterMenu footerMenu;

}
