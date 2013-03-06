package com.xa.webui.persistence.domain.component;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Options extends ItemGroup<Option> {

    public Options() {
    }
    
    public Options(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public Options(String name, String description, List<Option> items) {
        this.name = name;
        this.description = description;
        this.items = items;
    }
    
}
