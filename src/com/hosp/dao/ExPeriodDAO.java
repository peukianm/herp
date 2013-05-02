package com.hosp.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hosp.entities.*;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A data access object (DAO) providing persistence and search support for ExPeriod entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.ExPeriod
 * @author MyEclipse Persistence Tools
 */
public class ExPeriodDAO {
    // property constants

    public static final String NAME = "name";
    private static final Logger logger = Logger.getLogger(ExPeriodDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved ExPeriod entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExPeriodDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExPeriod entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExPeriod entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent ExPeriod entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExPeriodDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExPeriod entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExPeriod entity) {

        try {
            entity = getEntityManager().getReference(ExPeriod.class, entity.getPeriodid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved ExPeriod entity and return it or a copy of it to the sender. A copy of the ExPeriod entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExPeriodDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExPeriod entity to update
     * @return ExPeriod the persisted ExPeriod entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExPeriod update(ExPeriod entity) {

        try {
            ExPeriod result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public ExPeriod findById(BigDecimal id) {

        try {
            ExPeriod instance = getEntityManager().find(ExPeriod.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all ExPeriod entities with a specific property value.
     *
     * @param propertyName the name of the ExPeriod property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExPeriod> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExPeriod> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExPeriod model where model." + propertyName + "= :propertyValue";
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

    public List<ExPeriod> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    /**
     * Find all ExPeriod entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExPeriod> all ExPeriod entities
     */
    @SuppressWarnings("unchecked")
    public List<ExPeriod> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExPeriod model";
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
            re.printStackTrace();
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<ExPeriod> fetchPeriods(Hospital hospital, Boolean showOnlyEnabled) {

        try {
            String queryString = "select model from ExPeriod model where "
                    + " model.hospital=:hospital "
                    + (showOnlyEnabled ? " AND model.enabled=1 " : " ")
                    + " order by model.exYear.yearid DESC, model.exMonth.monthid DESC";

            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("hospital", hospital);
//			query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");
            return query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public Boolean checkExistingPeriods(Hospital hospital, ExMonth month, ExYear year) {

        try {
            String queryString = "select model from ExPeriod model where "
                    + " model.hospital=:hospital "
                    + " AND model.exMonth= :month    "
                    + " AND model.exYear= :year    ";

            // " order by model.exYear.yearid DESC, model.exMonth.monthid DESC";

            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("hospital", hospital);
            query.setParameter("year", year);
            query.setParameter("month", month);

            ExPeriod period = (ExPeriod) query.getSingleResult();

            return true;
        } catch (NoResultException nre) {
            return false;
        } catch (NonUniqueResultException nure) {
            return true;
        } catch (Exception re) {
            re.printStackTrace();
            logger.error("Error on updating entity", re);
            return true;
            //throw re;
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