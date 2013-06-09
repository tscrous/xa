package com.xa.webui.service.api;

import com.xa.webui.exception.service.AbstractEntityService;
import com.xa.webui.persistence.dao.CrudDao;
import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.user.User;
import com.xa.webui.persistence.domain.user.UserSession;
import com.xa.webui.persistence.domain.user.UserSessionCache;
import com.xa.webui.persistence.domain.user.UserSessionRuntime;
import com.xa.webui.persistence.domain.user.UserSessionSessionProperties;
import com.xa.webui.system.cache.CacheKey;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author theo-alaganze
 */
public class SessionManager extends AbstractEntityService {
    
    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }
    
    public SessionManager() {
        userDao = new CrudDao<User>(User.class);
        sessionDao = new CrudDao<UserSession>(UserSession.class);
        sessionCache = new UserSessionCache();
    }
    
    public UserSession getSession(HttpServletRequest request) {
        UserSession userSession;
        /* create userSession & cache (if not found) */
        CacheKey key = sessionCache.generateCacheKey(request);
        if (!sessionCache.isCached(key)) {
            User user = getUserByUsername(request.getRemoteUser());
            if (user != null) {
                /* create & persist new user session */
                userSession = getSessionByServletRequest(user.getUsername(), request);
                if (userSession == null) {
                    userSession = new UserSession(user.getUsername(), request);
                    sessionDao.save(userSession);
                }
                return userSession;
            } else {
                String guestUsername = getGuestUsername(request);
                /* create temporary session */
                userSession = new UserSession(guestUsername, request);
                sessionDao.save(userSession);
                userSession.setRuntime(new UserSessionRuntime(userSession));
            }
            prepareSession(userSession, request);
            key = sessionCache.generateCacheKey(userSession);
            sessionCache.add(key, userSession);
        }
        /* 
         * retrieve userSession from cache & renewed HttpSession 
         * ...the "true" parameter will ensure that a new session is created if one doesn't exist already...
         */
        userSession = sessionCache.get(key);
        userSession.setHttpSession(request.getSession(true));
        return userSession;
    }
    
    private void prepareSession(UserSession session, HttpServletRequest request) {
        loadSessionProperties(session, request);
    }
    
    public void flush() {
        sessionCache.clear();
    }

    /* utilities */
    
    private String getGuestUsername(HttpServletRequest request) {
        return request.getRemoteHost() +"/"+ request.getRemoteAddr();
    }
    
    private User getUserByUsername(String username) {
        QueryParameters parameters = createQueryParameters("username", username);
        return getSingle(userDao.getByValues(parameters));
    }
    
    private UserSession getSessionByServletRequest(String username, HttpServletRequest request) {
        QueryParameters parameters = createQueryParameters();
        parameters.put("ip", request.getRemoteAddr());
        parameters.put("host", request.getRemoteHost());
        parameters.put("port", request.getRemotePort());
        return getLast(sessionDao.getByValues(parameters));
    }
    
    private void loadSessionProperties(UserSession session, HttpServletRequest request) {
        UserSessionSessionProperties sessionProperties = new UserSessionSessionProperties();
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headers = new HashMap<String, String>();
        String name;
        while (headerNames.hasMoreElements()) {
            name = headerNames.nextElement();
            headers.put(name, request.getHeader(name));
        }
// TODO: set headers as SessionProperties...
        session.setSessionProperties(sessionProperties);
    }
    
    private CrudDao<User> userDao;
    private CrudDao<UserSession> sessionDao;
    private UserSessionCache sessionCache;
    private static SessionManager sessionManager;

}
