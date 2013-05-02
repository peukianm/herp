package com.hosp.dao;

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
 * A data access object (DAO) providing persistence and search support for Icdiagnosis entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.Icdiagnosis
 * @author MyEclipse Persistence Tools
 */
public class IcdiagnosisDAO {
    // property constants

    public static final String REFERENCE_ID = "referenceId";
    public static final String DIAGNOSIS = "diagnosis";
    public static final String ICD10_CODE = "icd10Code";
    public static final String CATEGORY_ID = "categoryId";
    public static final String ENABLED = "enabled";
    public static final String ICD10DIAGNOSIS = "icd10diagnosis";
    public static final String USER_ID = "userId";
    public static final String PLACE_ID = "placeId";
    public static final String DEL_USER_ID = "delUserId";
    public static final String USERIDAGNOSIS = "useridagnosis";
    public static final String USERDIAGNOSIS = "userdiagnosis";
    public static final String TEMP = "temp";
    public static final String CATEGORY = "category";
    private static final Logger logger = Logger.getLogger(IcdiagnosisDAO.class);

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
     * Perform an initial save of a previously unsaved Icdiagnosis entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IcdiagnosisDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Icdiagnosis entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Icdiagnosis entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent Icdiagnosis entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * IcdiagnosisDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Icdiagnosis entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Icdiagnosis entity) {

        try {
            entity = getEntityManager().getReference(Icdiagnosis.class, entity.getDiagnosisId());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved Icdiagnosis entity and return it or a copy of it to the sender. A copy of the Icdiagnosis entity parameter is returned when
     * the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction
     * context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = IcdiagnosisDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Icdiagnosis entity to update
     * @return Icdiagnosis the persisted Icdiagnosis entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Icdiagnosis update(Icdiagnosis entity) {

        try {
            Icdiagnosis result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public Icdiagnosis findById(Long id) {

        try {
            Icdiagnosis instance = getEntityManager().find(Icdiagnosis.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all Icdiagnosis entities with a specific property value.
     *
     * @param propertyName the name of the Icdiagnosis property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Icdiagnosis> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Icdiagnosis> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Icdiagnosis model where model." + propertyName + "= :propertyValue";
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

    public List<Icdiagnosis> findByReferenceId(Object referenceId, int... rowStartIdxAndCount) {
        return findByProperty(REFERENCE_ID, referenceId, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByDiagnosis(Object diagnosis, int... rowStartIdxAndCount) {
        return findByProperty(DIAGNOSIS, diagnosis, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByIcd10Code(Object icd10Code, int... rowStartIdxAndCount) {
        return findByProperty(ICD10_CODE, icd10Code, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByCategoryId(Object categoryId, int... rowStartIdxAndCount) {
        return findByProperty(CATEGORY_ID, categoryId, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByEnabled(Object enabled, int... rowStartIdxAndCount) {
        return findByProperty(ENABLED, enabled, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByIcd10diagnosis(Object icd10diagnosis, int... rowStartIdxAndCount) {
        return findByProperty(ICD10DIAGNOSIS, icd10diagnosis, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByUserId(Object userId, int... rowStartIdxAndCount) {
        return findByProperty(USER_ID, userId, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByPlaceId(Object placeId, int... rowStartIdxAndCount) {
        return findByProperty(PLACE_ID, placeId, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByDelUserId(Object delUserId, int... rowStartIdxAndCount) {
        return findByProperty(DEL_USER_ID, delUserId, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByUseridagnosis(Object useridagnosis, int... rowStartIdxAndCount) {
        return findByProperty(USERIDAGNOSIS, useridagnosis, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByUserdiagnosis(Object userdiagnosis, int... rowStartIdxAndCount) {
        return findByProperty(USERDIAGNOSIS, userdiagnosis, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByTemp(Object temp, int... rowStartIdxAndCount) {
        return findByProperty(TEMP, temp, rowStartIdxAndCount);
    }

    public List<Icdiagnosis> findByCategory(Object category, int... rowStartIdxAndCount) {
        return findByProperty(CATEGORY, category, rowStartIdxAndCount);
    }

    /**
     * Find all Icdiagnosis entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Icdiagnosis> all Icdiagnosis entities
     */
    @SuppressWarnings("unchecked")
    public List<Icdiagnosis> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Icdiagnosis model";
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