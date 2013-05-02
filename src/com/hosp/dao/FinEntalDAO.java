package com.hosp.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
 * A data access object (DAO) providing persistence and search support for FinEntal entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.FinEntal
 * @author MyEclipse Persistence Tools
 */
public class FinEntalDAO {
    // property constants

    public static final String ARENTAL = "arental";
    public static final String AFM = "afm";
    public static final String LINE = "line";
    public static final String SETTLEMENT = "settlement";
    private static final Logger logger = Logger.getLogger(FinEntalDAO.class);

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
     * Perform an initial save of a previously unsaved FinEntal entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * FinEntalDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity FinEntal entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(FinEntal entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent FinEntal entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * FinEntalDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity FinEntal entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(FinEntal entity) {

        try {
            entity = getEntityManager().getReference(FinEntal.class, entity.getEntalid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved FinEntal entity and return it or a copy of it to the sender. A copy of the FinEntal entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = FinEntalDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity FinEntal entity to update
     * @return FinEntal the persisted FinEntal entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public FinEntal update(FinEntal entity) {

        try {
            FinEntal result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public FinEntal findById(BigDecimal id) {

        try {
            FinEntal instance = getEntityManager().find(FinEntal.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all FinEntal entities with a specific property value.
     *
     * @param propertyName the name of the FinEntal property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<FinEntal> found by query
     */
    @SuppressWarnings("unchecked")
    public List<FinEntal> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from FinEntal model where model." + propertyName + "= :propertyValue";
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

    public List<FinEntal> findByArental(Object arental, int... rowStartIdxAndCount) {
        return findByProperty(ARENTAL, arental, rowStartIdxAndCount);
    }

    public List<FinEntal> findByAfm(Object afm, int... rowStartIdxAndCount) {
        return findByProperty(AFM, afm, rowStartIdxAndCount);
    }

    public List<FinEntal> findByLine(Object line, int... rowStartIdxAndCount) {
        return findByProperty(LINE, line, rowStartIdxAndCount);
    }

    public List<FinEntal> findBySettlement(Object settlement, int... rowStartIdxAndCount) {
        return findByProperty(SETTLEMENT, settlement, rowStartIdxAndCount);
    }

    /**
     * Find all FinEntal entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<FinEntal> all FinEntal entities
     */
    @SuppressWarnings("unchecked")
    public List<FinEntal> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from FinEntal model";
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