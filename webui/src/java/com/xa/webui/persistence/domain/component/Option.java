package com.xa.webui.persistence.domain.component;

import com.xa.webui.persistence.domain.resource.WebResource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Option extends Item {

    public Option() {
    }
    
    public Option(String name, String label, String description, int itemIndex) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
    }
    
    public Option(String name, String label, String description, int itemIndex, boolean disabled) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.disabled = disabled;
    }

    public Option(String name, String label, String description, WebResource<?> content, int itemIndex) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.content = content;
        this.itemIndex = itemIndex;
    }

    public Option(String name, String label, String description, WebResource<?> content, int itemIndex, boolean disabled) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.content = content;
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
    public WebResource<?> getContent() {
        return content;
    }
    public void setContent(WebResource<?> content) {
        this.content = content;
    }

    @Column(name="item_index")
    private int itemIndex = 0;
    
    @ManyToOne
    @JoinColumn(name="content_resource_id", referencedColumnName="id")
    private WebResource<?> content;
    
}
