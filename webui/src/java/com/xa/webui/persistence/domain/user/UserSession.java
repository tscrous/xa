package com.xa.webui.persistence.domain.user;

import com.xa.webui.persistence.domain.IdentifiableEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author theo-alaganze
 */
@Entity
@Table(name="user_session")
public class UserSession extends IdentifiableEntity {

    public UserSession() {
    }
    
    public UserSession(String username, HttpServletRequest request) {
        ip = request.getRemoteAddr();
        host = request.getRemoteHost();
        port = request.getRemotePort();
        httpSession = request.getSession();
    }
    
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public UserSessionSessionProperties getSessionProperties() {
        return sessionProperties;
    }
    public void setSessionProperties(UserSessionSessionProperties sessionProperties) {
        this.sessionProperties = sessionProperties;
    }

    public RuntimeInfo getRuntimeInfo() {
        return runtimeInfo;
    }

    public UserSessionRuntime getRuntime() {
        return runtime;
    }

    public void setRuntime(UserSessionRuntime runtime) {
        this.runtime = runtime;
    }

    public HttpSession getHttpSession() {
        return httpSession;
    }
    public void setHttpSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    
    @Column(name="session_ip", nullable=false)
    private String ip;

    @Column(name="session_host", nullable=false)
    private String host;
    
    @Column(name="session_port", nullable=false)
    private int port;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="user_id", referencedColumnName="id")
    private User user;
    

    @Transient
    private UserSessionSessionProperties sessionProperties;

    @Transient
    private RuntimeInfo runtimeInfo = new RuntimeInfo();
    
    @Transient
    private UserSessionRuntime runtime;
    
    @Transient
    private HttpSession httpSession;
    
}
