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
 * A data access object (DAO) providing persistence and search support for Country entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @see com.hosp.dao.Country
 * @author MyEclipse Persistence Tools
 */
public class CountryDAO {
    // property constants

    public static final String NAME = "name";
    public static final String ABBREVATION = "abbrevation";
    private static final Logger logger = Logger.getLogger(CountryDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Country entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * CountryDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Country entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Country entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent Country entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * CountryDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Country entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Country entity) {

        try {
            entity = getEntityManager().getReference(Country.class, entity.getCountryid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Country entity and return it or a copy of it to the sender. A copy of the Country entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = CountryDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Country entity to update
     * @return Country the persisted Country entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Country update(Country entity) {

        try {
            Country result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public Country findById(BigDecimal id) {

        try {
            Country instance = getEntityManager().find(Country.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all Country entities with a specific property value.
     *
     * @param propertyName the name of the Country property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Country> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Country> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Country model where model." + propertyName + "= :propertyValue";
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

    public List<Country> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<Country> findByAbbrevation(Object abbrevation, int... rowStartIdxAndCount) {
        return findByProperty(ABBREVATION, abbrevation, rowStartIdxAndCount);
    }

    /**
     * Find all Country entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Country> all Country entities
     */
    @SuppressWarnings("unchecked")
    public List<Country> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Country model order by model.countryid";
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

    @SuppressWarnings("unchecked")
    public List<Country> fetchCountries() {

        try {
            String queryString = " select model from Country model "
                    + //(showOnlyEnabled ?  " where model.enabled=1  " : " ") +
                    " order by model.countryid ASC  ";

            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            //query.setParameter("assertion", assertion);
            return (List<Country>) query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on getParaTypes", re);
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