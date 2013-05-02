package com.hosp.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hosp.entities.*;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;

/**
 * A data access object (DAO) providing persistence and search support for Exam entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @see com.hosp.dao.Exam
 * @author MyEclipse Persistence Tools
 */
public class ExamDAO {
    // property constants

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String ABREV = "abrev";
    public static final String UNIT = "unit";
    public static final String NRM = "nrm";
    public static final String NRW = "nrw";
    public static final String NRC = "nrc";
    public static final String NRMF = "nrmf";
    public static final String NRMT = "nrmt";
    public static final String NRWF = "nrwf";
    public static final String NRWT = "nrwt";
    public static final String NRCF = "nrcf";
    public static final String NRCT = "nrct";
    private static final Logger logger = Logger.getLogger(ExamDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Exam entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExamDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Exam entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Exam entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent Exam entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExamDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Exam entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Exam entity) {

        try {
            entity = getEntityManager().getReference(Exam.class, entity.getExamid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved Exam entity and return it or a copy of it to the sender. A copy of the Exam entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExamDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Exam entity to update
     * @return Exam the persisted Exam entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Exam update(Exam entity) {

        try {
            Exam result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public Exam findById(BigDecimal id) {

        try {
            Exam instance = getEntityManager().find(Exam.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all Exam entities with a specific property value.
     *
     * @param propertyName the name of the Exam property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Exam> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Exam> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Exam model where model." + propertyName + "= :propertyValue";
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

    public List<Exam> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<Exam> findByDescription(Object description, int... rowStartIdxAndCount) {
        return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
    }

    public List<Exam> findByAbrev(Object abrev, int... rowStartIdxAndCount) {
        return findByProperty(ABREV, abrev, rowStartIdxAndCount);
    }

    public List<Exam> findByUnit(Object unit, int... rowStartIdxAndCount) {
        return findByProperty(UNIT, unit, rowStartIdxAndCount);
    }

    public List<Exam> findByNrm(Object nrm, int... rowStartIdxAndCount) {
        return findByProperty(NRM, nrm, rowStartIdxAndCount);
    }

    public List<Exam> findByNrw(Object nrw, int... rowStartIdxAndCount) {
        return findByProperty(NRW, nrw, rowStartIdxAndCount);
    }

    public List<Exam> findByNrc(Object nrc, int... rowStartIdxAndCount) {
        return findByProperty(NRC, nrc, rowStartIdxAndCount);
    }

    public List<Exam> findByNrmf(Object nrmf, int... rowStartIdxAndCount) {
        return findByProperty(NRMF, nrmf, rowStartIdxAndCount);
    }

    public List<Exam> findByNrmt(Object nrmt, int... rowStartIdxAndCount) {
        return findByProperty(NRMT, nrmt, rowStartIdxAndCount);
    }

    public List<Exam> findByNrwf(Object nrwf, int... rowStartIdxAndCount) {
        return findByProperty(NRWF, nrwf, rowStartIdxAndCount);
    }

    public List<Exam> findByNrwt(Object nrwt, int... rowStartIdxAndCount) {
        return findByProperty(NRWT, nrwt, rowStartIdxAndCount);
    }

    public List<Exam> findByNrcf(Object nrcf, int... rowStartIdxAndCount) {
        return findByProperty(NRCF, nrcf, rowStartIdxAndCount);
    }

    public List<Exam> findByNrct(Object nrct, int... rowStartIdxAndCount) {
        return findByProperty(NRCT, nrct, rowStartIdxAndCount);
    }

    /**
     * Find all Exam entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Exam> all Exam entities
     */
    @SuppressWarnings("unchecked")
    public List<Exam> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Exam model";
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