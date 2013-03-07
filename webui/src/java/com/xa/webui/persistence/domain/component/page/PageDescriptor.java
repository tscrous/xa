package com.xa.webui.persistence.domain.component;

import com.xa.webui.persistence.domain.resource.path.PathResource;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Page extends WebComponent {

    public Menu getTopMenu() {
        return topMenu;
    }
    public void setTopMenu(Menu topMenu) {
        this.topMenu = topMenu;
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
    public void setFooterMenu(FooterMenu footerMenu) {
        this.footerMenu = footerMenu;
    }

    @Override
    public PathResource getContent() {
        return content;
    }
    public void setContent(PathResource content) {
        this.content = content;
    }
    
    @ManyToOne
    @JoinColumn(name="top_menu_id", referencedColumnName="id")
    protected Menu topMenu;

    @ManyToOne
    @JoinColumn(name="footer_menu_id", referencedColumnName="id")
    protected FooterMenu footerMenu;

    @ManyToOne
    @JoinColumn(name="web_resource_id", referencedColumnName="id")
    protected PathResource content;

}
