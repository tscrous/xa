package com.xa.webui.persistence.dao;

import com.xa.webui.exception.persistence.PersistenceDaoException;
import com.xa.webui.persistence.domain.SerializableEntity;
import com.xa.webui.service.factory.HibernateSessionFactory;
import com.xa.webui.system.utils.ValidationUtils;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrudDao<T extends SerializableEntity> {

    public CrudDao(Class<T> typeClass) {
        this.typeClass = typeClass;
    }
    
    /* create */
    
    public T save(final T entity){
        Session session = null;
        try {
            session = startTransaction();
            session.save(entity);
            endTransaction(session);
            return entity;
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
                System.err.println("OPEN session found after task completion. Session forced to close!");
            }
        }
    }
    public void saveOrUpdate(final T entity){
        Session session = null;
        try {
            session = HibernateSessionFactory.getCurrentSession();
            session.saveOrUpdate(entity);
            endTransaction(session);
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
                System.err.println("OPEN session found after task completion. Session forced to close!");
            }
        }
    }

    /* read */
    
    public T getById(final long id){
        Session session = null;
        try {
            session = startTransaction();
            T persistedEntity = (T) session.get(typeClass, id);
            endTransaction(session);
            return persistedEntity;
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    public List<T> getByValues(final QueryParameters parameters){
        String query = prepareQuery(typeClass, parameters);
        return getList(query.toString(), parameters);
    }
    public List<T> getAll() {
        Session session = null;
        try {
            List<T> items = null;
            session = startTransaction();
            if (session.getTransaction() != null) {
                Criteria criteria = session.createCriteria(typeClass);
                items = criteria.list();
                if (items != null) {
                    endTransaction(session);
                } else {
                    cancelTransaction(session);
                }
            }
            return items;
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
    
    /* update */
    
    public T merge(final T entity) {
        Session session = startTransaction();
        try {
            T persistedEntity = (T) session.merge(entity);
            endTransaction(session);
            return persistedEntity;
        } catch (Exception e) {
            cancelTransaction(session);
            throw new PersistenceDaoException("Unable to merge entity.", e);
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /* delte */
    
    public void delete(final T entity){
        Session session = null;
        try {
            session = startTransaction();
            session.delete(entity);
            endTransaction(session);
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /* Utilities */
    
    protected Session startTransaction() {
        Session session = HibernateSessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }
    protected void endTransaction(Session session) {
        session.getTransaction().commit();
    }
    protected void cancelTransaction(Session session) {
        session.getTransaction().rollback();
    }
    
    /**
     * @return Returns exactly one object of type T, but returns null if list is empty.
     * A PersistenceException is thrown if the query returns more than one object
     */
    protected T get(String hibernateQuery, QueryParameters parameters) {
        List<T> list = getList(hibernateQuery, parameters);
        if (list.isEmpty()) {
            return null;
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            throw new PersistenceDaoException("Single value expected, yet multiple values were found!");
        }
    }
    /**
     * @return Returns the first object in a list (which was returned by the query), but returns null if list is empty.
     */
    protected T getFirst(String hibernateQuery, QueryParameters parameters) {
        List<T> list = getList(hibernateQuery, parameters);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }
    /**
     * @return Returns the last object in a list (which was returned by the query), but returns null if list is empty.
     */
    protected T getLast(String hibernateQuery, QueryParameters parameters) {
        List<T> list = getList(hibernateQuery, parameters);
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(list.size()-1);
        }
    }
    /**
     * @return a list of type T
     */
    protected List<T> getList(String hibernateQuery, QueryParameters parameters) {
        Session session = null;
        try {
            List<T> list;
            session = HibernateSessionFactory.getCurrentSession();
            /* prepare query */
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(hibernateQuery);
            int index = 0;
            for (String namedParameter : query.getNamedParameters()) {
                query.setParameter(namedParameter, parameters.get(namedParameter));
                index++;
            }
            /* retrieve data */
            list = query.list();
            if (ValidationUtils.isNotNullAndNotEmpty(list)) {
                transaction.commit();
            } else {
                transaction.rollback();
            }
            /* return result */
            return list != null ? list : new LinkedList<T>();
        }
        finally {
            if (session != null && session.isOpen()) {
                session.close();
                System.err.println("OPEN session found after task completion. Session forced to close!");
            }
        }
    }
    
    protected String prepareQuery(Class<T> type, QueryParameters parameters) {
        StringBuilder query = new StringBuilder("from "+ typeClass.getSimpleName() +" o");
        if (parameters != null) {
            int index = 0;
            for (String key : parameters.keySet()) {
                if (index == 0) {
                    query.append(" where ");
                } else {
                    query.append(" and ");
                }
                if (parameters.get(key) instanceof String) {
                    query.append("o.").append(key).append(" like :").append(key);
                } else {
                    query.append("o.").append(key).append(" = :").append(key);
                }
                index++;
            }
        }
        return query.toString();
    }
    
    protected final Class<T> typeClass;
    
}