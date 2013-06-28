package com.hosp.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hosp.bean.AssertionSearchResultBean;
import com.hosp.entities.ExAssertion;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExParaCounter;
import com.hosp.entities.ExTimol;
import com.hosp.entities.ExType;
import com.hosp.entities.Hospital;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

/**
 * A data access object (DAO) providing persistence and search support for ExAssertion entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.entities.ExAssertion
 * @author MyEclipse Persistence Tools
 */
public class ExAssertionDAO {
    // property constants

    public static final String NAME = "name";
    public static final String CODE = "code";
    public static final String SUBMISSION = "submission";
    private static final Logger logger = Logger.getLogger(ExAssertionDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved ExAssertion entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExAssertionDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExAssertion entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExAssertion entity) {
        try {
            getEntityManager().persist(entity);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Delete a persistent ExAssertion entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExAssertionDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExAssertion entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExAssertion entity) {
        try {
            entity = getEntityManager().getReference(ExAssertion.class, entity.getAssertionid());
            getEntityManager().remove(entity);
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Persist a previously saved ExAssertion entity and return it or a copy of it to the sender. A copy of the ExAssertion entity parameter is returned when
     * the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction
     * context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExAssertionDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExAssertion entity to update
     * @return ExAssertion the persisted ExAssertion entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExAssertion update(ExAssertion entity) {
        try {
            ExAssertion result = getEntityManager().merge(entity);
            return result;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public ExAssertion findById(BigDecimal id) {
        try {
            ExAssertion instance = getEntityManager().find(ExAssertion.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Find all ExAssertion entities with a specific property value.
     *
     * @param propertyName the name of the ExAssertion property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExAssertion> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExAssertion> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {
        try {
            final String queryString = "select model from ExAssertion model where model." + propertyName + "= :propertyValue";
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
            throw re;
        }
    }

    public List<ExAssertion> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<ExAssertion> findByCode(Object code, int... rowStartIdxAndCount) {
        return findByProperty(CODE, code, rowStartIdxAndCount);
    }

    public List<ExAssertion> findBySubmission(Object submission, int... rowStartIdxAndCount) {
        return findByProperty(SUBMISSION, submission, rowStartIdxAndCount);
    }

    /**
     * Find all ExAssertion entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExAssertion> all ExAssertion entities
     */
    @SuppressWarnings("unchecked")
    public List<ExAssertion> findAll(final int... rowStartIdxAndCount) {
        try {
            final String queryString = "select model from ExAssertion model";
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
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<ExType> findAllDateTypes() {
        try {
            final String queryString = "select model from ExType model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<AssertionSearchResultBean> assertionSearchResults(Hospital hospital, String open, String showDeleted, int... rowStartIdxAndCount) {
        try {
            //NEW com.hosp.bean.AssertionSearchResultBean	
//			String sql = " select NEW com.hosp.bean.AssertionSearchResultBean(sum(pe.cost*pe.quantity), count(pe), count(p), a)  " +
//					     " from ExParaExams pe LEFT JOIN pe.exPara p LEFT JOIN p.exAssertion a " +
//					     " where a.hospital= :hospital " +
//					     " and a.enabled=1 " +
//					     " and p.enabled=1 " +
//					     " and pe.enabled=1 " +
//					     " group by a"	;	
//			

            
            String sql = " select NEW com.hosp.bean.AssertionSearchResultBean( COALESCE(sum(pe.cost*pe.quantity),0), count(distinct p), sum(pe.quantity), a, COALESCE(sum((pe.cost-pe.cost*pe.participation)*pe.quantity),0)  )"
                    + " from ExAssertion a LEFT OUTER JOIN a.exParas p LEFT OUTER JOIN p.exParaExamses pe  "
                    + " where "
                    + " a.hospital= :hospital "
                    + ((showDeleted!=null && showDeleted.equals("0")) ?  " and a.enabled=1 ": " ")
                    + (open!=null ? " and a.opened="+open : " ") 
                    + //					     " and p.enabled<>0 " +
                    //					     " and pe.enabled<>0 " +
                    " group by a "
                    + " order by a.assertionid DESC";
            //" order by a.exPeriod.exYear.yearid DESC,a.exPeriod.exMonth.monthid DESC";	



//			sql = " select  NEW com.hosp.bean.AssertionSearchResultBean(sum(pe.cost*pe.quantity),  count(p.parpapemptikoid), count(pe.paraexamid))   " +
//			" from ex_assertion a, ex_para p, ex_para_exams pe " +
//			" where   P.PARPAPEMPTIKOID=PE.PARAID(+)  and A.ASSERTIONID = P.ASSERTIONID(+) " +
//			" group by (a.assertionid) ";


            Query query = getEntityManager().createQuery(sql);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("hospital", hospital);

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

            return (List<AssertionSearchResultBean>) query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on assertionSearchResults", re);
            throw re;
        }
    }

    
    
    @SuppressWarnings("unchecked")
    public AssertionSearchResultBean fetchAssertionData(ExAssertion assertion) {

        try {
            String sql = " select NEW com.hosp.bean.AssertionSearchResultBean(     COALESCE(sum(pe.cost*pe.quantity),0), count(distinct p), sum(pe.quantity), a)  "
                    + " from ExAssertion a LEFT OUTER JOIN a.exParas p LEFT OUTER JOIN p.exParaExamses pe  "
                    + " where "
                    + " a= :assertion "
                    +"  AND p.exAssertion= :assertion "
                    + " group by a " ;
                    

            Query query = getEntityManager().createQuery(sql);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("assertion", assertion);
            return  (AssertionSearchResultBean)query.getSingleResult();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on getAssertionData", re);
            throw re;
        }

    }
    
    
   
    
    @SuppressWarnings("unchecked")
    public List<ExTimol> getAssertionTimols(ExAssertion assertion, Boolean showOnlyEnabled) {

        try {
            String queryString = " select timol from ExTimol timol where "
                    + " timol.exAssertion= :assertion"
                    + (showOnlyEnabled ? " and timol.enabled=1  " : " ")
                    + " order by timol.timoldate DESC  ";

            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("assertion", assertion);
            return (List<ExTimol>) query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on getAssertionTimols", re);
            throw re;
        }

    }

    @SuppressWarnings("unchecked")
    public List<ExAssertion> getAssertions(Hospital hospital, Boolean showOnlyEnabled, Boolean showOnlyOpened) {

        try {
            String queryString = " select assertion from ExAssertion assertion where "
                    + " assertion.hospital= :hospital"
                    + (showOnlyEnabled ? " and assertion.enabled=1  " : " ")
                    + (showOnlyOpened ? " and assertion.opened=1  " : " ")
                    + " order by assertion.exYear.yearid DESC, assertion.exMonth.monthid DESC  ";

            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("hospital", hospital);
            return (List<ExAssertion>) query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on getAssertion", re);
            throw re;
        }
    }
    
    @SuppressWarnings("unchecked")
    public ExAssertion getSingleAssertion(Hospital hospital, Boolean showOnlyEnabled, Boolean showOnlyOpened) {

        try {
            String queryString = " select assertion from ExAssertion assertion where "
                    + " assertion.hospital= :hospital"
                    + (showOnlyEnabled ? " and assertion.enabled=1  " : " ")
                    + (showOnlyOpened ? " and assertion.opened=1  " : " ")
                    + " order by assertion.exYear.yearid DESC, assertion.exMonth.monthid DESC  ";

            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("hospital", hospital);
            return (ExAssertion)query.getResultList().get(0);
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on getAssertion", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public List<ExPara> getParas(ExAssertion assertion) {

        try {
            String queryString = " select para from ExPara para where "
                    + " para.exAssertion= :assertion "                    
                    + " order by para.parpapemptikoid";

            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("assertion", assertion);
            return query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on getAssertion", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public ExAssertion getCurrentNormalAssertion(Hospital hospital, String year, BigDecimal month) {

        try {
            String queryString = " select assertion from ExAssertion assertion where "
                    + " assertion.hospital= :hospital"
                    + " and assertion.enabled=1  "
                    + " and assertion.exAssertionType.assertiontypeid=1 "
                    + " and assertion.exYear.name= :year "
                    + " and assertion.exMonth.monthid= :monthid ";

            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("hospital", hospital);
            query.setParameter("year", year);
            query.setParameter("monthid", month);
            List<ExAssertion> assertions = (List<ExAssertion>) query.getResultList();
            if (assertions.size() > 0) {
                return assertions.get(0);
            } else {
                return null;
            }
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on get current Assertion", re);
            throw re;
        }

    }

    @SuppressWarnings("unchecked")
    public ExParaCounter getCurrentParaCounter(Hospital hospital, ExAssertion assertion) {

        try {

            Query query = getEntityManager().createNamedQuery("fetchParaCounter");
            query.setParameter("hospital", hospital);
            query.setParameter("assertion", assertion);
            ExParaCounter counter = (ExParaCounter) query.getSingleResult();
            //getEntityManager().lock(counter, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            return counter;
        } catch (NoResultException nre) {
            nre.printStackTrace();
            return null;
        } catch (NonUniqueResultException nure) {
            nure.printStackTrace();
            return null;
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on get current para counter", re);
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
    
    
    
    public void test() {
        try {
            //NEW com.hosp.bean.AssertionSearchResultBean	
//			String sql = " select NEW com.hosp.bean.AssertionSearchResultBean(sum(pe.cost*pe.quantity), count(pe), count(p), a)  " +
//					     " from ExParaExams pe LEFT JOIN pe.exPara p LEFT JOIN p.exAssertion a " +
//					     " where a.hospital= :hospital " +
//					     " and a.enabled=1 " +
//					     " and p.enabled=1 " +
//					     " and pe.enabled=1 " +
//					     " group by a"	;	
//			

            String sql = " select NEW com.hosp.bean.AssertionSearchResultBean(     COALESCE(sum(pe.cost*pe.quantity),0)    , count(pe), count(a.exPara), a)  "
                    + " from ExAssertion a LEFT OUTER JOIN a.exParas p LEFT OUTER JOIN p.exParaExamses pe  "
                    + " where "                   
                    + " a.enabled=1 "
                    + //					     " and p.enabled<>0 " +
                    //					     " and pe.enabled<>0 " +
                    " group by a "
                    + " order by a.assertionid DESC";
            //" order by a.exPeriod.exYear.yearid DESC,a.exPeriod.exMonth.monthid DESC";	

                    sql =" Select tt,a FROM ExAssertion a,"
                            + " (SELECT p.amount FROM ExPara p where p.exAssertion=a ) tt";


//			sql = " select  NEW com.hosp.bean.AssertionSearchResultBean(sum(pe.cost*pe.quantity),  count(p.parpapemptikoid), count(pe.paraexamid))   " +
//			" from ex_assertion a, ex_para p, ex_para_exams pe " +
//			" where   P.PARPAPEMPTIKOID=PE.PARAID(+)  and A.ASSERTIONID = P.ASSERTIONID(+) " +
//			" group by (a.assertionid) ";


            Query query = getEntityManager().createQuery(sql);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            List ids = query.getResultList();
            for(int i=0; i<ids.size(); i++) {
            }
            
           
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on assertionSearchResults", re);
            throw re;
        }
    }
}