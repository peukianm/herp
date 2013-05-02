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
 * A data access object (DAO) providing persistence and search support for ExContract entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.ExContract
 * @author MyEclipse Persistence Tools
 */
public class ExContractDAO {
    // property constants

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String CONTRACTNUMBER = "contractnumber";
    private static final Logger logger = Logger.getLogger(ExContractDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved ExContract entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExContractDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExContract entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExContract entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent ExContract entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExContractDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExContract entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExContract entity) {

        try {
            entity = getEntityManager().getReference(ExContract.class, entity.getContractid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved ExContract entity and return it or a copy of it to the sender. A copy of the ExContract entity parameter is returned when the
     * JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context
     * for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExContractDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExContract entity to update
     * @return ExContract the persisted ExContract entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExContract update(ExContract entity) {

        try {
            ExContract result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public ExContract findById(BigDecimal id) {

        try {
            ExContract instance = getEntityManager().find(ExContract.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all ExContract entities with a specific property value.
     *
     * @param propertyName the name of the ExContract property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExContract> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExContract> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExContract model where model." + propertyName + "= :propertyValue";
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

    public List<ExContract> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<ExContract> findByDescription(Object description, int... rowStartIdxAndCount) {
        return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
    }

    public List<ExContract> findByContractnumber(Object contractnumber, int... rowStartIdxAndCount) {
        return findByProperty(CONTRACTNUMBER, contractnumber, rowStartIdxAndCount);
    }

    /**
     * Find all ExContract entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExContract> all ExContract entities
     */
    @SuppressWarnings("unchecked")
    public List<ExContract> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExContract model";
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

    public List<ExContract> fetchContract(Hospital hospital) {

        try {
            final String queryString = "select model from ExContract model where model.hospital= :hospital";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("hospital", hospital);
            return (List<ExContract>) query.getResultList();
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
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