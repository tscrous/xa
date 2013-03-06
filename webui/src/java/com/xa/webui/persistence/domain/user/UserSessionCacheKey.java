package com.xa.webui.persistence.domain.user;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.system.cache.CacheKey;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author theo-alaganze
 */
public class UserSessionCacheKey extends CacheKey {

    public UserSessionCacheKey(UserSession session) {
        setObject(session);
    }
    
    public UserSessionCacheKey(HttpServletRequest request) {
        setObject(request);
    }
    
    @Override
    protected String convertToValue(Object obj) {
        if (obj instanceof UserSession) {
            return getSessionId((UserSession) obj);
        } else if (obj instanceof HttpServletRequest) {
            return getSessionId((HttpServletRequest) obj);
        }
        throw new NotSupportedException("Object not supported by CacheKey instance!");
    }

    private String getSessionId(UserSession session) {
        StringBuilder sessionId = new StringBuilder();
        if (session.getUser() != null && session.getUser().getUsername() != null) {
            sessionId.append(session.getUser().getUsername());
        } else {
            if (session.getHost() != null) {
                sessionId.append(session.getHost()).append("/");
            }
            if (session.getIp() != null) {
                sessionId.append(session.getIp()).append(":");
            }
            if (session.getPort() > 0) {
                sessionId.append(session.getPort());
            }
        }
        return sessionId.length() > 0 ? sessionId.toString() : null;
    }
    
    private String getSessionId(HttpServletRequest request) {
        StringBuilder sessionId = new StringBuilder();
        if (request.getRemoteUser() != null) {
            sessionId.append(request.getRemoteUser());
        } else {
            if (request.getRemoteHost() != null) {
                sessionId.append(request.getRemoteHost()).append("/");
            }
            if (request.getRemoteAddr() != null) {
                sessionId.append(request.getRemoteAddr()).append(":");
            }
            if (request.getRemotePort() > 0) {
                sessionId.append(request.getRemotePort());
            }
        }
        return sessionId.length() > 0 ? sessionId.toString() : null;
    }
    
}
