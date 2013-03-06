package com.xa.webui.service.api;

import com.xa.webui.exception.service.AbstractEntityService;
import com.xa.webui.persistence.dao.CrudDao;
import com.xa.webui.persistence.dao.QueryParameters;
import com.xa.webui.persistence.domain.user.User;
import com.xa.webui.persistence.domain.user.UserSession;
import com.xa.webui.persistence.domain.user.UserSessionCache;
import com.xa.webui.persistence.domain.user.UserSessionSessionProperties;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author theo-alaganze
 */
public class UserManager extends AbstractEntityService {
    
    public UserManager() {
        userDao = new CrudDao(User.class);
        sessionDao = new CrudDao<UserSession>(UserSession.class);
    }
    
    public User getUserByUsername(String username) {
        /* retrieve user */
        QueryParameters parameters = createQueryParameters("username", username);
        User user = getSingle(userDao.getByValues(parameters));
        /* retrieve user's last session */
        parameters = createQueryParameters("user", user);
        user.setCurrentSession(getSingle(sessionDao.getByValues(parameters)));
        return user;
    }
    
    public void flush() {
        sessionCache.clear();
    }
    
    private void prepareSession(UserSession session, HttpServletRequest request) {
        loadSessionProperties(session, request);
    }
    
    /* utilities */
    
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
for (String headerName : headers.keySet()) {
    System.out.println(headerName +" = "+ headers.get(headerName));
}
        session.setSessionProperties(sessionProperties);
    }
    
    private CrudDao<User> userDao;
    private CrudDao<UserSession> sessionDao;
    private UserSessionCache sessionCache;
    
}
