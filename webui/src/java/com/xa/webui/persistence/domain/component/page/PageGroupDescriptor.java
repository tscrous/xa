package com.xa.webui.persistence.domain.component.page;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.persistence.domain.component.FooterMenu;
import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.component.WebComponent;
import com.xa.webui.persistence.domain.resource.path.PathResource;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class PageGroupDescriptor extends WebComponent<PathResource> implements PageDescriptor {

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
        throw new NotSupportedException("Not supported");
    }
    @Override
    public void setValue(PathResource value) {
        throw new NotSupportedException("Not supported");
    }
    
    public List<PageSingleDescriptor> getPages() {
        return pages;
    }
    public void setPages(List<PageSingleDescriptor> pages) {
        this.pages = pages;
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

    @ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="groups_pages_mapping",
        joinColumns={ @JoinColumn(name="page_group_id", nullable=false) },
        inverseJoinColumns={ @JoinColumn(name="page_id", nullable=false) }
    )
    protected List<PageSingleDescriptor> pages;

}
