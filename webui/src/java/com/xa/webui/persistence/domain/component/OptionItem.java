package com.xa.webui.persistence.domain.component;

import com.xa.webui.persistence.domain.resource.WebResource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OptionItem extends Item {

    public OptionItem() {
    }
    
    public OptionItem(String name, String label, String description, int itemIndex) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
    }
    
    public OptionItem(String name, String label, String description, int itemIndex, boolean disabled) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.disabled = disabled;
    }

    public OptionItem(String name, String label, String description, WebResource<?> value, int itemIndex) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.value = value;
        this.itemIndex = itemIndex;
    }

    public OptionItem(String name, String label, String description, WebResource<?> value, int itemIndex, boolean disabled) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.value = value;
        this.itemIndex = itemIndex;
        this.disabled = disabled;
    }

    public int getItemIndex() {
        return itemIndex;
    }
    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    @Override
    public WebResource getValue() {
        return value;
    }
    public void setValue(WebResource value) {
        this.value = value;
    }

    @Column(name="item_index")
    private int itemIndex = 0;
    
    @ManyToOne
    @JoinColumn(name="content_resource_id", referencedColumnName="id")
    private WebResource value;
    
}
