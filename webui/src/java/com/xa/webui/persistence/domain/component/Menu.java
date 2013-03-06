package com.xa.webui.persistence.domain.component;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Menu extends ItemGroup<MenuItem> {

    public Menu() {
    }
    
    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Menu(String name, String description, List<MenuItem> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }
    
}
