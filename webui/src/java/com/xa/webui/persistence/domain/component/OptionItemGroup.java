package com.xa.webui.persistence.domain.component;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class OptionItemGroup extends ItemGroup<OptionItem> {

    public OptionItemGroup() {
    }
    
    public OptionItemGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public OptionItemGroup(String name, String description, List<OptionItem> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }
    
}
