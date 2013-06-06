package com.xa.webui.persistence.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class VersionedEntity implements SerializableEntity {

    public long getVersion() {
        return version;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    /* properties */
    
    @Version
    @Column(name="version")
    protected long version;

    @Column(name="last_modified_date")
    protected long lastModifiedDate = System.currentTimeMillis();
	
}
