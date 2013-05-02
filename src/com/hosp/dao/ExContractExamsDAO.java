package com.hosp.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hosp.entities.*;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A data access object (DAO) providing persistence and search support for ExContractExams entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.ExContractExams
 * @author MyEclipse Persistence Tools
 */
public class ExContractExamsDAO {
    // property constants

    public static final String CODE = "code";
    public static final String PRICE = "price";
    private static final Logger logger = Logger.getLogger(ExContractExamsDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
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

    /**
     * Perform an initial save of a previously unsaved ExContractExams entity. All subsequent persist actions of this entity should use the #update() method.
     * This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExContractExamsDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExContractExams entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExContractExams entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent ExContractExams entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the      {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExContractExamsDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExContractExams entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExContractExams entity) {

        try {
            entity = getEntityManager().getReference(ExContractExams.class, entity.getId());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved ExContractExams entity and return it or a copy of it to the sender. A copy of the ExContractExams entity parameter is returned
     * when the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExContractExamsDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExContractExams entity to update
     * @return ExContractExams the persisted ExContractExams entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExContractExams update(ExContractExams entity) {

        try {
            ExContractExams result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public ExContractExams findById(BigDecimal id) {

        try {
            ExContractExams instance = getEntityManager().find(ExContractExams.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all ExContractExams entities with a specific property value.
     *
     * @param propertyName the name of the ExContractExams property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExContractExams> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExContractExams> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExContractExams model where model." + propertyName + "= :propertyValue";
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
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public List<ExContractExams> findByCode(Object code, int... rowStartIdxAndCount) {
        return findByProperty(CODE, code, rowStartIdxAndCount);
    }

    public List<ExContractExams> findByPrice(Object price, int... rowStartIdxAndCount) {
        return findByProperty(PRICE, price, rowStartIdxAndCount);
    }

    /**
     * Find all ExContractExams entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExContractExams> all ExContractExams entities
     */
    @SuppressWarnings("unchecked")
    public List<ExContractExams> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExContractExams model";
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
            logger.error("Error on updating entity", re);
            throw re;
        }
    }
}