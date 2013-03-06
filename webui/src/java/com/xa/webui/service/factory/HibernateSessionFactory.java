package com.xa.webui.service.factory;

import java.sql.Connection;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author theo-alaganze
 */
public class HibernateSessionFactory {

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public static Session openSession() {
        return sessionFactory.openSession();
    }
    public static Session openSession(Connection connection) {
        return sessionFactory.openSession(connection);
    }
    public static Session openSession(Interceptor interceptor) {
        return sessionFactory.openSession(interceptor);
    }
    public static Session openSession(Connection connection, Interceptor interceptor) {
        return sessionFactory.openSession(connection, interceptor);
    }
    
    public static StatelessSession openStatelessSession() {
        return sessionFactory.openStatelessSession();
    }
    public static StatelessSession openStatelessSession(Connection connection) {
        return sessionFactory.openStatelessSession(connection);
    }
    
    /* utilities */

    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
}
