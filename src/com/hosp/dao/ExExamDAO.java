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
 * A data access object (DAO) providing persistence and search support for ExExam entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @see com.hosp.dao.ExExam
 * @author MyEclipse Persistence Tools
 */
public class ExExamDAO {
    // property constants

    public static final String NAME = "name";
    public static final String CODE = "code";
    private static final Logger logger = Logger.getLogger(ExExamDAO.class);

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
     * Perform an initial save of a previously unsaved ExExam entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the      {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExExamDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExExam entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExExam entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent ExExam entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExExamDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExExam entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExExam entity) {

        try {
            entity = getEntityManager().getReference(ExExam.class, entity.getExamid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved ExExam entity and return it or a copy of it to the sender. A copy of the ExExam entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExExamDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExExam entity to update
     * @return ExExam the persisted ExExam entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExExam update(ExExam entity) {

        try {
            ExExam result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public ExExam findById(BigDecimal id) {

        try {
            ExExam instance = getEntityManager().find(ExExam.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all ExExam entities with a specific property value.
     *
     * @param propertyName the name of the ExExam property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExExam> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExExam> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExExam model where model." + propertyName + "= :propertyValue";
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

    public List<ExExam> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<ExExam> findByCode(Object code, int... rowStartIdxAndCount) {
        return findByProperty(CODE, code, rowStartIdxAndCount);
    }

    /**
     * Find all ExExam entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExExam> all ExExam entities
     */
    @SuppressWarnings("unchecked")
    public List<ExExam> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExExam model";
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
    public List<ExExam> fetchctxrays() {
        try {
            final String queryString = "select exam from ExExam exam "
                    + " where exam.exExamCat= :xrays "
                    + " and exam.ordered>=1 "
                    + " order by exam.ordered ASC";
            Query query = getEntityManager().createQuery(queryString);
            ExExamCat xrays = getEntityManager().find(ExExamCat.class, new BigDecimal(3));            
	    query.setParameter("xrays", xrays);			
            //query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public List<ExExam> fetchmts() {
        try {
            final String queryString = "select exam from ExExam exam "
                    + " where exam.exExamCat= :mt "
                    + " and exam.ordered>=1 "
                    + " order by exam.ordered ASC";
            Query query = getEntityManager().createQuery(queryString);
            ExExamCat xrays = getEntityManager().find(ExExamCat.class, new BigDecimal(20));            
	    query.setParameter("mt", xrays);			
            //query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<ExExam> fetchus() {
        try {
            final String queryString = "select exam from ExExam exam "
                    + " where exam.exExamCat= :us "
                    + " and exam.ordered>=1 "
                    + " order by exam.ordered ASC";
            Query query = getEntityManager().createQuery(queryString);
            ExExamCat xrays = getEntityManager().find(ExExamCat.class, new BigDecimal(34));            
	    query.setParameter("us", xrays);			
            //query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<ExExam> fetchBloodAnoso() {
        try {
            final String queryString = "select exam from ExExam exam "
                    + " where "
                    + " ( exam.exExamCat= :blood OR exam.exExamCat= :anoso ) "
                    + " and exam.ordered>=1 "
                    + " order by exam.exExamCat.examcategoryid,  exam.ordered  ";
            Query query = getEntityManager().createQuery(queryString);
            ExExamCat blood = getEntityManager().find(ExExamCat.class, new BigDecimal(9));
            ExExamCat anoso = getEntityManager().find(ExExamCat.class, new BigDecimal(10)); 
	    
            query.setParameter("blood", blood);
            query.setParameter("anoso", anoso);
            
            //query.setHint("eclipselink.cache-usage", "CheckCacheThenDatabase");
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    
    
    
        @SuppressWarnings("unchecked")
    public List<ExExam> fetchBio() {
        try {
            final String queryString = "select exam from ExExam exam "
                    + " where "
                    + " exam.exExamCat= :bio "
                    + " and exam.ordered>=1 "
                    + " order by exam.ordered  ";
            Query query = getEntityManager().createQuery(queryString);
            ExExamCat bio = getEntityManager().find(ExExamCat.class, new BigDecimal(11));
                       
            query.setParameter("bio", bio);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<ExExam> fetchMicroHormon() {
        try {
            final String queryString = "select exam from ExExam exam "
                    + " where "
                    + " ( exam.exExamCat= :micro OR exam.exExamCat= :hormon )"
                    + " and exam.ordered>=1 "
                    + " order by exam.exExamCat.examcategoryid,  exam.ordered  ";
            Query query = getEntityManager().createQuery(queryString);            
            ExExamCat micro = getEntityManager().find(ExExamCat.class, new BigDecimal(13)); 
	    ExExamCat hormon = getEntityManager().find(ExExamCat.class, new BigDecimal(14));            
            
            query.setParameter("micro", micro);
            query.setParameter("hormon", hormon);
            
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
    
    
}