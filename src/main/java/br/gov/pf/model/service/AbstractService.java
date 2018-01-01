package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.util.PredicateBuilder;

import java.io.Serializable;
import java.util.List;


public abstract class AbstractService<PK, T> implements Serializable {

    public abstract AbstractDAO<PK, T> getDAO();

    public T save(T entity) throws Exception {
        return this.getDAO().save(entity);
    }

    public T update(T entity) throws Exception {
        return this.getDAO().update(entity);
    }

    public T delete(T entity) throws Exception {
        return this.getDAO().delete(entity);
    }

    public T deleteById(PK pk) throws Exception {
        return this.getDAO().delete(this.getDAO().getById(pk));
    }

    public T getById(PK pk) {
        return this.getDAO().getById(pk);
    }

    public T getByProperty(String propertyName,
                           String propertyValue) {
        return this.getDAO().getByProperty(propertyName, propertyValue);
    }

    public T getByTwoProperties(String firstPropertyName,
                                String firstPropertyValue,
                                String secondPropertyName,
                                String secondPropertyValue) {
        T entity = null;
        try {
            entity = this.getDAO().getByTwoProperties(firstPropertyName,
                    firstPropertyValue,
                    secondPropertyName,
                    secondPropertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public List<T> listByProperty(String propertyName,
                                  String propertyValue) {
        List<T> entity = null;
        try {
            entity = this.getDAO().listByProperty(propertyName,
                    propertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public List<T> listByTwoProperties(String firstPropertyName,
                                       String firstPropertyValue,
                                       String secondPropertyName,
                                       String secondPropertyValue) {
        List<T> entity = null;
        try {
            entity = this.getDAO().listByTwoProperties(firstPropertyName,
                    firstPropertyValue,
                    secondPropertyName,
                    secondPropertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public List<T> findAll() {
        return this.getDAO().findAll();
    }

    public PredicateBuilder getPredicateBuilder() {
        return this.getDAO().getPredicateBuilder();
    }

    public T getByPredicate(PredicateBuilder predicate) {
        return this.getDAO().getByPredicate(predicate);
    }

    public List<T> findAll(PredicateBuilder predicate) {
        return this.getDAO().findAll(predicate);
    }

    public Long count(PredicateBuilder predicate) {
        return this.getDAO().count(predicate);
    }


}
