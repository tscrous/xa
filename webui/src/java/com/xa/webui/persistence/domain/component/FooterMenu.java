package com.xa.webui.persistence.domain.component;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class FooterMenu extends ItemGroup<FooterMenuItem> {

    public FooterMenu() {
    }
    
    public FooterMenu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public FooterMenu(String name, String description, List<FooterMenuItem> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }
    
}
