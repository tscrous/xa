package com.xa.webui.persistence.domain.component;

import com.xa.webui.system.Alignment;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FooterMenuItem extends Item {

    public FooterMenuItem() {
    }
    
    public FooterMenuItem(String name, String label, String description, int itemIndex, Alignment alignment) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.alignment = alignment;
    }
    
    public FooterMenuItem(String name, String label, String description, int itemIndex, Alignment alignment, FooterMenuItem parent) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.alignment = alignment;
        this.parent = parent;
    }
    
    public FooterMenuItem(String name, String label, String description, int itemIndex, Alignment alignment, boolean disabled) {
        this.name = name;
        this.label = label;
        this.description = description;
        this.itemIndex = itemIndex;
        this.alignment = alignment;
        this.disabled = disabled;
    }
    
    public FooterMenuItem(String name, String label, String description, int itemIndex, Alignment alignment, boolean disabled, FooterMenuItem parent) {
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

    public FooterMenuItem getParent() {
        return parent;
    }

    public void setParent(FooterMenuItem parent) {
        this.parent = parent;
    }

    @Column(name="item_index")
    private int itemIndex = 0;
    
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "alignment")
    private Alignment alignment = Alignment.LEFT;
    
    @ManyToOne
    @JoinColumn(name="parent_id", referencedColumnName="id")
    private FooterMenuItem parent;
	
}
