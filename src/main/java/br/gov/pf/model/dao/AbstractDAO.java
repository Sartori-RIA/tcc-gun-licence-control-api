package br.gov.pf.model.dao;

import br.gov.pf.util.Parameter;
import br.gov.pf.util.PredicateBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractDAO<PK, T> implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    public T getByProperty(String propertyName, String propertyValue) {
        Query query = getQueryOneProperty(propertyName, propertyValue);
        List<T> queryResult = query.getResultList();
        T returnObject = null;
        if (!queryResult.isEmpty())
            returnObject = queryResult.get(0);
        return returnObject;
    }

    public T getByTwoProperties(String firstPropertyName, String firstPropertyValue, String secondPropertyName,
                                String secondPropertyValue) {
        Query query = getQueryTwoProperty(firstPropertyName, firstPropertyValue, secondPropertyName, secondPropertyValue);
        List<T> queryResult = query.getResultList();
        T returnObject = null;
        if (!queryResult.isEmpty())
            returnObject = queryResult.get(0);
        return returnObject;
    }

    public List<T> listByProperty(String propertyName, String propertyValue) {
        Query query = getQueryOneProperty(propertyName, propertyValue);
        return (List<T>) query.getResultList();
    }

    public List<T> listByTwoProperties(String firstPropertyName,
                                       String firstPropertyValue,
                                       String secondPropertyName,
                                       String secondPropertyValue) {
        Query query = getQueryTwoProperty(firstPropertyName, firstPropertyValue, secondPropertyName, secondPropertyValue);
        return (List<T>) query.getResultList();
    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public T update(T entity) {
        entityManager.merge(entity);
        return entity;
    }

    public T delete(T entity) {
        entityManager.remove(entity);
        return entity;
    }

    public List<T> findAll() {
        return entityManager.createQuery(("SELECT o FROM " + getTypeClass().getName() + " o")).getResultList();
    }

    private Class<?> getTypeClass() {
        return (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    public T getByPredicate(PredicateBuilder predicate) {
        predicate.limit(0, 1);
        List<T> entities = findAll(predicate);
        if (!entities.isEmpty())
            return entities.get(0);
        return null;
    }

    public List<T> findAll(PredicateBuilder predicate) {
        Query query = entityManager.createQuery(predicate.getQuery().toString());
        if (!predicate.getParams().isEmpty())
            for (Parameter param : predicate.getParams())
                query.setParameter(param.getName(), param.getValue());

        if (predicate.getMaxResult() != null && predicate.getStartPosition() != null) {
            query.setMaxResults(predicate.getMaxResult());
            query.setFirstResult(predicate.getStartPosition());
        }
        return (List<T>) query.getResultList();
    }

    public Long count(PredicateBuilder predicate) {
        Query query = entityManager.createQuery(predicate.getQueryCount().toString());
        if (!predicate.getParams().isEmpty()) {
            for (Parameter param : predicate.getParams()) {
                query.setParameter(param.getName(), param.getValue());
            }
        }
        return (Long) query.getSingleResult();
    }

    public PredicateBuilder getPredicateBuilder() {
        return new PredicateBuilder(getTypeClass());
    }

    private Query getQueryOneProperty(String propertyName, String propertyValue) {
        String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";
        Query query = entityManager.createQuery(queryString);
        try {
            query.setParameter("param", propertyValue);
            return query;
        } catch (IllegalArgumentException e) {
            query.setParameter("param", Long.valueOf(propertyValue));
            return query;
        }
    }

    private Query getQueryTwoProperty(String firstPropertyName, String firstPropertyValue, String secondPropertyName, String secondPropertyValue) {
        String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + firstPropertyName
                + " = :param AND o." + secondPropertyName + " = :param2";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("param", firstPropertyValue);
        query.setParameter("param2", secondPropertyValue);
        return query;
    }
}

