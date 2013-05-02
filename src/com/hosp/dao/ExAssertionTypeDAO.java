package com.hosp.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hosp.entities.ExAssertionType;
import com.hosp.entities.ExMonth;
import com.hosp.entities.ExYear;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A data access object (DAO) providing persistence and search support for ExAssertionType entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.entities.ExAssertionType
 * @author MyEclipse Persistence Tools
 */
public class ExAssertionTypeDAO {
    // property constants

    public static final String NAME = "name";

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved ExAssertionType entity. All subsequent persist actions of this entity should use the #update() method.
     * This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExAssertionTypeDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExAssertionType entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExAssertionType entity) {
        try {
            getEntityManager().persist(entity);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Delete a persistent ExAssertionType entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the null     {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExAssertionTypeDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExAssertionType entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExAssertionType entity) {
        try {
            entity = getEntityManager().getReference(ExAssertionType.class, entity.getAssertiontypeid());
            getEntityManager().remove(entity);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Persist a previously saved ExAssertionType entity and return it or a copy of it to the sender. A copy of the ExAssertionType entity parameter is returned
     * when the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExAssertionTypeDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExAssertionType entity to update
     * @return ExAssertionType the persisted ExAssertionType entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExAssertionType update(ExAssertionType entity) {

        try {
            ExAssertionType result = getEntityManager().merge(entity);
            return result;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public ExAssertionType findById(BigDecimal id) {
        try {
            ExAssertionType instance = getEntityManager().find(ExAssertionType.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Find all ExAssertionType entities with a specific property value.
     *
     * @param propertyName the name of the ExAssertionType property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExAssertionType> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExAssertionType> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {
        try {
            final String queryString = "select model from ExAssertionType model where model." + propertyName + "= :propertyValue";
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

    public List<ExAssertionType> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    /**
     * Find all ExAssertionType entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExAssertionType> all ExAssertionType entities
     */
    @SuppressWarnings("unchecked")
    public List<ExAssertionType> findAll(final int... rowStartIdxAndCount) {
        try {
            final String queryString = "select model from ExAssertionType model";
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

    @SuppressWarnings("unchecked")
    public List<ExAssertionType> findAssertionTypes() {
        try {
            final String queryString = "select model from ExAssertionType model";
            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");			
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<ExMonth> fetchMonths() {
        try {
            final String queryString = "select model from ExMonth model";
            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<ExYear> fetchYears() {
        try {
            final String queryString = "select model from ExYear model";
            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");
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