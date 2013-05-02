package com.hosp.dao;

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
 * A data access object (DAO) providing persistence and search support for Ken entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @see com.hosp.dao.Ken
 * @author MyEclipse Persistence Tools
 */
public class KenDAO {
    // property constants

    public static final String CODE = "code";
    public static final String DESCRIPTION = "description";
    public static final String CATEGORY_CODE = "categoryCode";
    public static final String PRICE = "price";
    public static final String DAYS = "days";
    public static final String SERVICE_ID = "serviceId";
    private static final Logger logger = Logger.getLogger(KenDAO.class);

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
     * Perform an initial save of a previously unsaved Ken entity. All subsequent persist actions of this entity should use the #update() method. This operation
     * must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. This
     * method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * KenDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Ken entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Ken entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent Ken entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * KenDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Ken entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Ken entity) {

        try {
            entity = getEntityManager().getReference(Ken.class, entity.getId());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved Ken entity and return it or a copy of it to the sender. A copy of the Ken entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = KenDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Ken entity to update
     * @return Ken the persisted Ken entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Ken update(Ken entity) {

        try {
            Ken result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public Ken findById(Long id) {

        try {
            Ken instance = getEntityManager().find(Ken.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all Ken entities with a specific property value.
     *
     * @param propertyName the name of the Ken property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Ken> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Ken> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Ken model where model." + propertyName + "= :propertyValue";
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

    public List<Ken> findByCode(Object code, int... rowStartIdxAndCount) {
        return findByProperty(CODE, code, rowStartIdxAndCount);
    }

    public List<Ken> findByDescription(Object description, int... rowStartIdxAndCount) {
        return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
    }

    public List<Ken> findByCategoryCode(Object categoryCode, int... rowStartIdxAndCount) {
        return findByProperty(CATEGORY_CODE, categoryCode, rowStartIdxAndCount);
    }

    public List<Ken> findByPrice(Object price, int... rowStartIdxAndCount) {
        return findByProperty(PRICE, price, rowStartIdxAndCount);
    }

    public List<Ken> findByDays(Object days, int... rowStartIdxAndCount) {
        return findByProperty(DAYS, days, rowStartIdxAndCount);
    }

    public List<Ken> findByServiceId(Object serviceId, int... rowStartIdxAndCount) {
        return findByProperty(SERVICE_ID, serviceId, rowStartIdxAndCount);
    }

    /**
     * Find all Ken entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Ken> all Ken entities
     */
    @SuppressWarnings("unchecked")
    public List<Ken> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Ken model";
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