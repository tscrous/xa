package com.xa.webui.persistence.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdentifiableEntity extends VersionedEntity implements SerializableEntity {

    public long getId() {
        return id;
    }

    /* properties */
    
    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy= GenerationType.TABLE)
    protected long id;
	
}
