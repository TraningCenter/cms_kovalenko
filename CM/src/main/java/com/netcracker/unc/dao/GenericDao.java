package com.netcracker.unc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public class GenericDao<T, PK extends Serializable> {

    @PersistenceContext
    private EntityManager manager;

    private Class<T> entityClass;

    public GenericDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T get(PK pk) {
        return manager.find(entityClass, pk);
    }

    public List<T> getAll() {
        return manager.createQuery("from " + entityClass.getSimpleName()).getResultList();
    }

    public void create(T entity) {
        manager.persist(entity);
    }

    public void update(T entity) {
        manager.merge(entity);
    }

    public void delete(PK pk) {
        manager.remove(manager.find(entityClass, pk));
    }

    protected EntityManager getManager() {
        return manager;
    }
}