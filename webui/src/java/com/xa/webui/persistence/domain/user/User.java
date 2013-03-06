package com.xa.webui.persistence.domain.user;

import com.xa.webui.persistence.domain.IdentifiableEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="users")
public class User extends IdentifiableEntity {

    public User() {
    }
    
    public User(String name, String surname, String username) {
        this.name = name;
        this.surname = surname;
        this.username = username;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public UserSession getCurrentSession() {
        return currentSession;
    }
    public void setCurrentSession(UserSession currentSession) {
        this.currentSession = currentSession;
    }

    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="surname", nullable=false)
    private String surname;
    
    @Column(name="username", nullable=false)
    private String username;
    
    @Transient
    private UserSession currentSession;
    
}
