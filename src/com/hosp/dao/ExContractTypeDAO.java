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
 * A data access object (DAO) providing persistence and search support for ExContractType entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.ExContractType
 * @author MyEclipse Persistence Tools
 */
public class ExContractTypeDAO {
    // property constants

    public static final String NAME = "name";
    private static final Logger logger = Logger.getLogger(ExContractTypeDAO.class);

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
     * Perform an initial save of a previously unsaved ExContractType entity. All subsequent persist actions of this entity should use the #update() method.
     * This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExContractTypeDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExContractType entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExContractType entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent ExContractType entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the      {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExContractTypeDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExContractType entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExContractType entity) {

        try {
            entity = getEntityManager().getReference(ExContractType.class, entity.getContracttypeid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved ExContractType entity and return it or a copy of it to the sender. A copy of the ExContractType entity parameter is returned
     * when the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database
     * transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExContractTypeDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExContractType entity to update
     * @return ExContractType the persisted ExContractType entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExContractType update(ExContractType entity) {

        try {
            ExContractType result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public ExContractType findById(BigDecimal id) {

        try {
            ExContractType instance = getEntityManager().find(ExContractType.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all ExContractType entities with a specific property value.
     *
     * @param propertyName the name of the ExContractType property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExContractType> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExContractType> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExContractType model where model." + propertyName + "= :propertyValue";
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

    public List<ExContractType> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    /**
     * Find all ExContractType entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExContractType> all ExContractType entities
     */
    @SuppressWarnings("unchecked")
    public List<ExContractType> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExContractType model";
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