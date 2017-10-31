package br.gov.pf.model.dao;

import br.gov.pf.util.JPAUtil;

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

    /**
     * Retorna uma entidade pelo seu ID
     *
     * @param pk
     *            id da entidade
     * @return
     */
    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }

    /**
     * Retorna a entidade pelo atributo �nico, ou seja, assumir� que h� apenas
     * uma entidade com este atributo, retornando apenas um elemento.
     *
     * @param propertyName
     *            nome do atributo
     * @param propertyValue
     *            valor do atributo
     * @return
     */
    public T getByProperty(String propertyName, String propertyValue) {
        String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("param", propertyValue);

        List<T> queryResult = query.getResultList();

        T returnObject = null;

        if (!queryResult.isEmpty()) {
            returnObject = queryResult.get(0);
        }

        return returnObject;
    }

    public T getByTwoProperties(String firstPropertyName, String firstPropertyValue, String secondPropertyName,
                                String secondPropertyValue) {

        String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + firstPropertyName
                + " = :param AND o." + secondPropertyName + " = :param2";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("param", firstPropertyValue);
        query.setParameter("param2", secondPropertyValue);

        List<T> queryResult = query.getResultList();

        T returnObject = null;

        if (!queryResult.isEmpty()) {
            returnObject = queryResult.get(0);
        }

        return returnObject;
    }

    public List<T> listByProperty(String propertyName, String propertyValue) {

        String queryString = "SELECT o FROM " + getTypeClass().getName() + " o where o." + propertyName + " = :param";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("param", propertyValue);

        List<T> queryResult = query.getResultList();

        return queryResult;
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
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
        return clazz;
    }
}

