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
 * A data access object (DAO) providing persistence and search support for Hospital entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.Hospital
 * @author MyEclipse Persistence Tools
 */
public class HospitalDAO {
    // property constants

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String ADDRESS = "address";
    public static final String PHONE1 = "phone1";
    public static final String PHONE2 = "phone2";
    public static final String PREFECTURE = "prefecture";
    public static final String TOWN = "town";
    public static final String ADMIN = "admin";
    public static final String FINADMIN = "finadmin";
    private static final Logger logger = Logger.getLogger(HospitalDAO.class);

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
     * Perform an initial save of a previously unsaved Hospital entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * HospitalDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Hospital entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Hospital entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent Hospital entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * HospitalDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Hospital entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Hospital entity) {

        try {
            entity = getEntityManager().getReference(Hospital.class, entity.getHospitalid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Hospital entity and return it or a copy of it to the sender. A copy of the Hospital entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = HospitalDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Hospital entity to update
     * @return Hospital the persisted Hospital entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Hospital update(Hospital entity) {

        try {
            Hospital result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public Hospital findById(BigDecimal id) {

        try {
            Hospital instance = getEntityManager().find(Hospital.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all Hospital entities with a specific property value.
     *
     * @param propertyName the name of the Hospital property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Hospital> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Hospital> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Hospital model where model." + propertyName + "= :propertyValue";
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

    public List<Hospital> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<Hospital> findByDescription(Object description, int... rowStartIdxAndCount) {
        return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
    }

    public List<Hospital> findByAddress(Object address, int... rowStartIdxAndCount) {
        return findByProperty(ADDRESS, address, rowStartIdxAndCount);
    }

    public List<Hospital> findByPhone1(Object phone1, int... rowStartIdxAndCount) {
        return findByProperty(PHONE1, phone1, rowStartIdxAndCount);
    }

    public List<Hospital> findByPhone2(Object phone2, int... rowStartIdxAndCount) {
        return findByProperty(PHONE2, phone2, rowStartIdxAndCount);
    }

    public List<Hospital> findByPrefecture(Object prefecture, int... rowStartIdxAndCount) {
        return findByProperty(PREFECTURE, prefecture, rowStartIdxAndCount);
    }

    public List<Hospital> findByTown(Object town, int... rowStartIdxAndCount) {
        return findByProperty(TOWN, town, rowStartIdxAndCount);
    }

    public List<Hospital> findByAdmin(Object admin, int... rowStartIdxAndCount) {
        return findByProperty(ADMIN, admin, rowStartIdxAndCount);
    }

    public List<Hospital> findByFinadmin(Object finadmin, int... rowStartIdxAndCount) {
        return findByProperty(FINADMIN, finadmin, rowStartIdxAndCount);
    }

    /**
     * Find all Hospital entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Hospital> all Hospital entities
     */
    @SuppressWarnings("unchecked")
    public List<Hospital> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Hospital model";
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