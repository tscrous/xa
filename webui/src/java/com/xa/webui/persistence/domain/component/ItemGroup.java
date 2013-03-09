package com.xa.webui.persistence.domain.component;

import com.xa.webui.persistence.domain.resource.WebResource;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author theo-alaganze
 */
@Entity
public abstract class ItemGroup<T extends Item> extends WebComponent<WebResource> {

    public List<T> getItems() {
        return items;
    }
    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public WebResource getValue() {
        throw new UnsupportedOperationException("Not supported!");
    }

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="groups_items_mapping",
        joinColumns={ @JoinColumn(name="group_id", nullable=false) },
        inverseJoinColumns={ @JoinColumn(name="item_id", nullable=false) }
    )
    protected List<T> items;
	
}
