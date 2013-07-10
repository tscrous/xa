package com.xa.webui.persistence.domain.dependency;

import com.xa.webui.persistence.domain.SerializableEntity;
import com.xa.webui.persistence.domain.WebObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="dependency_mapping")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class WebObjectDependency implements SerializableEntity {
    
    public WebObjectDependency() {
        
    }

    public WebObjectDependency(WebObject dependant, WebObject parent) {
        dependantName = dependant.getName();
        parentName = parent.getName();
    }

    @Override
    public long getId() {
        return id;
    }

    public String getParentName() {
        return parentName;
    }
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getDependantName() {
        return dependantName;
    }
    public void setDependantName(String dependantName) {
        this.dependantName = dependantName;
    }

    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;
	
    @Column(name="parent_name", nullable=false)
    private String parentName;

    @Column(name="dependant_name", nullable=false)
    private String dependantName;

}
