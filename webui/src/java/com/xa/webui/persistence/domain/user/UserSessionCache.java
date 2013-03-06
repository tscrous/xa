package com.xa.webui.persistence.domain.user;

import com.xa.webui.exception.NotSupportedException;
import com.xa.webui.system.cache.Cache;
import com.xa.webui.system.cache.CacheKey;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author theo-alaganze
 */
public class UserSessionCache extends Cache<UserSession> {

    @Override
    public CacheKey generateCacheKey(Object obj) {
        if (obj instanceof UserSession) {
            return new UserSessionCacheKey((UserSession) obj);
        } else if (obj instanceof HttpServletRequest) {
            return new UserSessionCacheKey((HttpServletRequest) obj);
        }
        throw new NotSupportedException("Object not supported by CacheKey instance!");
    }

}
