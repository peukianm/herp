package com.hosp.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hosp.entities.ExTameioCounter;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A data access object (DAO) providing persistence and search support for ExTameioCounter entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.entities.ExTameioCounter
 * @author MyEclipse Persistence Tools
 */
public class ExTameioCounterDAO {
    // property constants

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved ExTameioCounter entity. All subsequent persist actions of this entity should use the #update() method.
     * This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExTameioCounterDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExTameioCounter entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExTameioCounter entity) {
        try {
            getEntityManager().persist(entity);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Delete a persistent ExTameioCounter entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the      {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExTameioCounterDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExTameioCounter entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExTameioCounter entity) {
        try {
            entity = getEntityManager().getReference(ExTameioCounter.class, entity.getCounterid());
            getEntityManager().remove(entity);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Persist a previously saved ExTameioCounter entity and return it or a copy of it to the sender. A copy of the ExTameioCounter entity parameter is returned
     * when the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExTameioCounterDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExTameioCounter entity to update
     * @return ExTameioCounter the persisted ExTameioCounter entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExTameioCounter update(ExTameioCounter entity) {
        try {
            ExTameioCounter result = getEntityManager().merge(entity);
            return result;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public ExTameioCounter findById(BigDecimal id) {
        try {
            ExTameioCounter instance = getEntityManager().find(ExTameioCounter.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Find all ExTameioCounter entities with a specific property value.
     *
     * @param propertyName the name of the ExTameioCounter property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExTameioCounter> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExTameioCounter> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {
        try {
            final String queryString = "select model from ExTameioCounter model where model." + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
                int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
                if (rowStartIdx > 0) {
                    query.setFirstResult(rowStartIdx);
                }

                if (rowStartIdxAndCount.length > 1) {
                    int rowCount = Math.max(0, rowStartIdxAndCount[1]);
                    if (rowCount > 0) {
                        query.setMaxResults(rowCount);
                    }
                }
            }
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Find all ExTameioCounter entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExTameioCounter> all ExTameioCounter entities
     */
    @SuppressWarnings("unchecked")
    public List<ExTameioCounter> findAll(final int... rowStartIdxAndCount) {
        try {
            final String queryString = "select model from ExTameioCounter model";
            Query query = getEntityManager().createQuery(queryString);
            if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
                int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
                if (rowStartIdx > 0) {
                    query.setFirstResult(rowStartIdx);
                }

                if (rowStartIdxAndCount.length > 1) {
                    int rowCount = Math.max(0, rowStartIdxAndCount[1]);
                    if (rowCount > 0) {
                        query.setMaxResults(rowCount);
                    }
                }
            }
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    private PersistenceHelper lookupPersistenceHelperBean() {
        try {
            Context c = new InitialContext();
            //return (PersistenceHelper) c.lookup("java:global/HERP/PersistenceHelper!com.hosp.util.PersistenceHelper");
            return (PersistenceHelper) c.lookup("java:module/PersistenceHelper");
        } catch (NamingException ne) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}