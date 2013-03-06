package com.xa.webui.system.utils;

import com.xa.webui.exception.system.SystemValidationException;
import java.util.Collection;

/**
 *
 * @author theo-alaganze
 */
public abstract class ValidationUtils {

    /* Enquiries */
    
    public static boolean isNull(Object obj) {
        return obj == null;
    }
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }
    
    public static boolean isEmpty(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).isEmpty();
        } else if (obj instanceof Collection<?>) {
            return ((Collection<?>) obj).isEmpty();
        }
        throw new SystemValidationException("Class type not supported by method!");
    }
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
    
    public static boolean isNullOrEmpty(Object obj) {
        return isNull(obj) || isEmpty(obj);
    }
    public static boolean isNotNullAndNotEmpty(Object obj) {
        return isNotNull(obj) && isNotEmpty(obj);
    }
    
    /* Validations */
    
    public static void ensureNull(String objName, Object obj) {
        if (isNotNull(obj)) {
            throw new SystemValidationException(objName +" should be (null) but isn't!");
        }
    }    
    public static void ensureNotNull(String objName, Object obj) {
        if (isNull(obj)) {
            throw new SystemValidationException(objName +" may not be (null) but is!");
        }
    }
    
    public static void ensureEmpty(String objName, Object obj) {
        if (isNotEmpty(obj)) {
            throw new SystemValidationException(objName +" should be (empty) but isn't!");
        }
    }    
    public static void ensureNotEmpty(String objName, Object obj) {
        if (isEmpty(obj)) {
            throw new SystemValidationException(objName +" may not be (empty) but is!");
        }
    }
    
    public static void ensureNullOrEmpty(String objName, Object obj) {
        if (isNotNullAndNotEmpty(obj)) {
            throw new SystemValidationException(objName +" should be either (null) or (empty) but isn't!");
        }
    }    
    public static void ensureNotNullAndNotEmpty(String objName, Object obj) {
        if (isNullOrEmpty(obj)) {
            throw new SystemValidationException(objName +" may not be (null) or (empty) but is!");
        }
    }
    
}
