package com.xa.webui.persistence.domain.component;

import com.xa.webui.system.Alignment;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MenuItem extends Item {

    public MenuItem() {
    }
    
    public MenuItem(String name, String label, String description, int itemIndex, Alignment alignment) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.alignment = alignment;
    }
    
    public MenuItem(String name, String label, String description, int itemIndex, Alignment alignment, MenuItem parent) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.alignment = alignment;
        this.parent = parent;
    }
    
    public MenuItem(String name, String label, String description, int itemIndex, Alignment alignment, boolean disabled) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.alignment = alignment;
        this.disabled = disabled;
    }
    
    public MenuItem(String name, String label, String description, int itemIndex, Alignment alignment, boolean disabled, MenuItem parent) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.alignment = alignment;
        this.disabled = disabled;
        this.parent = parent;
    }

    public int getItemIndex() {
        return itemIndex;
    }
    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public Alignment getAlignment() {
        return alignment;
    }
    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent;
    }

    @Column(name="item_index")
    private int itemIndex = 0;
    
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "alignment")
    private Alignment alignment = Alignment.LEFT;
    
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="id")
    private MenuItem parent;

}
