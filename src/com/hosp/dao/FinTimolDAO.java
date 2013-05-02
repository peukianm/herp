package com.hosp.dao;

import java.math.BigDecimal;
import java.util.Date;
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
 * A data access object (DAO) providing persistence and search support for FinTimol entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.FinTimol
 * @author MyEclipse Persistence Tools
 */
public class FinTimolDAO {
    // property constants

    public static final String ARTIMOL = "artimol";
    public static final String ORDERTIMOL = "ordertimol";
    public static final String AFM = "afm";
    public static final String SUPNAME = "supname";
    private static final Logger logger = Logger.getLogger(FinTimolDAO.class);

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
     * Perform an initial save of a previously unsaved FinTimol entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * FinTimolDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity FinTimol entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(FinTimol entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent FinTimol entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * FinTimolDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity FinTimol entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(FinTimol entity) {

        try {
            entity = getEntityManager().getReference(FinTimol.class, entity.getTimolid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved FinTimol entity and return it or a copy of it to the sender. A copy of the FinTimol entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = FinTimolDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity FinTimol entity to update
     * @return FinTimol the persisted FinTimol entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public FinTimol update(FinTimol entity) {

        try {
            FinTimol result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public FinTimol findById(BigDecimal id) {

        try {
            FinTimol instance = getEntityManager().find(FinTimol.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all FinTimol entities with a specific property value.
     *
     * @param propertyName the name of the FinTimol property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<FinTimol> found by query
     */
    @SuppressWarnings("unchecked")
    public List<FinTimol> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from FinTimol model where model." + propertyName + "= :propertyValue";
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

    public List<FinTimol> findByArtimol(Object artimol, int... rowStartIdxAndCount) {
        return findByProperty(ARTIMOL, artimol, rowStartIdxAndCount);
    }

    public List<FinTimol> findByOrdertimol(Object ordertimol, int... rowStartIdxAndCount) {
        return findByProperty(ORDERTIMOL, ordertimol, rowStartIdxAndCount);
    }

    public List<FinTimol> findByAfm(Object afm, int... rowStartIdxAndCount) {
        return findByProperty(AFM, afm, rowStartIdxAndCount);
    }

    public List<FinTimol> findBySupname(Object supname, int... rowStartIdxAndCount) {
        return findByProperty(SUPNAME, supname, rowStartIdxAndCount);
    }

    /**
     * Find all FinTimol entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<FinTimol> all FinTimol entities
     */
    @SuppressWarnings("unchecked")
    public List<FinTimol> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from FinTimol model";
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