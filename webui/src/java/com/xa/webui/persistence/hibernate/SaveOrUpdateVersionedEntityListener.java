package com.xa.webui.persistence.hibernate;

import com.xa.webui.persistence.domain.VersionedEntity;
import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

/**
 *
 * @author theo-alaganze
 */
public class SaveOrUpdateVersionedEntityListener extends DefaultSaveOrUpdateEventListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        if (event.getObject() instanceof VersionedEntity) {
            VersionedEntity entity = (VersionedEntity) event.getObject();
            entity.setLastModifiedDate(System.currentTimeMillis());
        }
        super.onSaveOrUpdate(event);
    }
    
}
