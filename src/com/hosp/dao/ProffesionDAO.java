package com.hosp.dao;

import java.math.BigDecimal;
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
 * A data access object (DAO) providing persistence and search support for Proffesion entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.Proffesion
 * @author MyEclipse Persistence Tools
 */
public class ProffesionDAO {
    // property constants

    public static final String NAME = "name";
    private static final Logger logger = Logger.getLogger(ProffesionDAO.class);

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
     * Perform an initial save of a previously unsaved Proffesion entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ProffesionDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Proffesion entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Proffesion entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent Proffesion entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ProffesionDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Proffesion entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Proffesion entity) {

        try {
            entity = getEntityManager().getReference(Proffesion.class, entity.getProffesionid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved Proffesion entity and return it or a copy of it to the sender. A copy of the Proffesion entity parameter is returned when the
     * JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context
     * for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ProffesionDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Proffesion entity to update
     * @return Proffesion the persisted Proffesion entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Proffesion update(Proffesion entity) {

        try {
            Proffesion result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public Proffesion findById(BigDecimal id) {

        try {
            Proffesion instance = getEntityManager().find(Proffesion.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all Proffesion entities with a specific property value.
     *
     * @param propertyName the name of the Proffesion property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Proffesion> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Proffesion> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Proffesion model where model." + propertyName + "= :propertyValue";
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

    public List<Proffesion> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    /**
     * Find all Proffesion entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Proffesion> all Proffesion entities
     */
    @SuppressWarnings("unchecked")
    public List<Proffesion> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Proffesion model order by model.name ";
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