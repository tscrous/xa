package com.xa.webui.persistence.domain.component.page;

import com.xa.webui.persistence.domain.component.FooterMenu;
import com.xa.webui.persistence.domain.component.Menu;
import com.xa.webui.persistence.domain.resource.ResolvableObject;
import com.xa.webui.persistence.domain.resource.path.PathResource;

public interface PageDescriptor extends ResolvableObject {

    public String getName();

    public Menu getTopMenu();
    public void setTopMenu(Menu topMenu);

    public FooterMenu getFooterMenu();
    public void setFooterMenu(FooterMenu footerMenu);

    public PathResource getValue();
    public void setValue(PathResource value);
    
}
