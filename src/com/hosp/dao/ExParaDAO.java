package com.hosp.dao;

import com.hosp.bean.AssertionSearchResultBean;
import com.hosp.bean.ParaSearchResultBean;
import com.hosp.bean.StatisticsParaResultBean;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hosp.entities.*;
import com.hosp.util.EJBUtil;
import com.hosp.util.PersistenceHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A data access object (DAO) providing persistence and search support for ExPara entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @see com.hosp.dao.ExPara
 * @author MyEclipse Persistence Tools
 */
public class ExParaDAO {
    // property constants

    public static final String DOCTORCODE = "doctorcode";
    public static final String DOCTORNAME = "doctorname";
    public static final String DOCTORSURNAME = "doctorsurname";
    public static final String CODCTORCODE = "codctorcode";
    public static final String CDOCTORNAME = "cdoctorname";
    public static final String CDOCTORSURNAME = "cdoctorsurname";
    public static final String RECEIPTNUMBER = "receiptnumber";
    public static final String CODEHEALTHUNIT = "codehealthunit";
    private static final Logger logger = Logger.getLogger(ExParaDAO.class);

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
     * Perform an initial save of a previously unsaved ExPara entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null null null null null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExParaDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExPara entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExPara entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent ExPara entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExParaDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExPara entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExPara entity) {

        try {
            entity = getEntityManager().getReference(ExPara.class, entity.getParpapemptikoid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved ExPara entity and return it or a copy of it to the sender. A copy of the ExPara entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExParaDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExPara entity to update
     * @return ExPara the persisted ExPara entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExPara update(ExPara entity) {

        try {
            ExPara result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public ExPara findById(BigDecimal id) {

        try {
            ExPara instance = getEntityManager().find(ExPara.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all ExPara entities with a specific property value.
     *
     * @param propertyName the name of the ExPara property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExPara> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExPara> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExPara model where model." + propertyName + "= :propertyValue";
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

    public List<ExPara> findByDoctorcode(Object doctorcode, int... rowStartIdxAndCount) {
        return findByProperty(DOCTORCODE, doctorcode, rowStartIdxAndCount);
    }

    public List<ExPara> findByDoctorname(Object doctorname, int... rowStartIdxAndCount) {
        return findByProperty(DOCTORNAME, doctorname, rowStartIdxAndCount);
    }

    public List<ExPara> findByDoctorsurname(Object doctorsurname, int... rowStartIdxAndCount) {
        return findByProperty(DOCTORSURNAME, doctorsurname, rowStartIdxAndCount);
    }

    public List<ExPara> findByCodctorcode(Object codctorcode, int... rowStartIdxAndCount) {
        return findByProperty(CODCTORCODE, codctorcode, rowStartIdxAndCount);
    }

    public List<ExPara> findByCdoctorname(Object cdoctorname, int... rowStartIdxAndCount) {
        return findByProperty(CDOCTORNAME, cdoctorname, rowStartIdxAndCount);
    }

    public List<ExPara> findByCdoctorsurname(Object cdoctorsurname, int... rowStartIdxAndCount) {
        return findByProperty(CDOCTORSURNAME, cdoctorsurname, rowStartIdxAndCount);
    }

    public List<ExPara> findByReceiptnumber(Object receiptnumber, int... rowStartIdxAndCount) {
        return findByProperty(RECEIPTNUMBER, receiptnumber, rowStartIdxAndCount);
    }

    public List<ExPara> findByCodehealthunit(Object codehealthunit, int... rowStartIdxAndCount) {
        return findByProperty(CODEHEALTHUNIT, codehealthunit, rowStartIdxAndCount);
    }

    /**
     * Find all ExPara entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExPara> all ExPara entities
     */
    @SuppressWarnings("unchecked")
    public List<ExPara> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExPara model";
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

    public List<ExPara> getSearchParaResultSet(Hospital hospital, ExAssertion assertion, ExAssertionType assertionType, ExPeriod period, ExType type, Date fromExecutionDate,
            Date toExecutionDate, Date fromIssueDate, Date toIssueDate, String paraCode, Patients patient, String orderBy, final int... rowStartIdxAndCount) {

        try {
//            System.out.println(assertion + " " + period + " " + type + " " + fromExecutionDate + " " + toExecutionDate + " " + fromIssueDate + " " + toExecutionDate + " " + paraCode + " " + patient);
            final String queryString = "select para from ExPara para where "
                    + " para.hospital= :hospital "
                    + (assertion != null ? " and para.exAssertion=:assertion " : " ")
                    + (assertionType != null ? " and para.exAssertion.exAssertionType=:assertionType " : " ")
                    + (period != null ? " and para.exAssertion.exPeriod=:period " : " ")
                    + (type != null ? " and para.exType=:type " : " ")
                    + (fromExecutionDate != null ? " and para.executiondate>= :fromExecutionDate " : " ")
                    + (toExecutionDate != null ? " and para.executiondate<= :toExecutionDate " : " ")
                    + (fromIssueDate != null ? " and para.issuedate>= :fromIssueDate " : " ")
                    + (toIssueDate != null ? " and para.issuedate<= :toIssueDate " : " ")
                    //+ (paraCode != null ? " and para.paracode like '%"+paraCode+"' " : " ")
                    + (paraCode != null ? " and para.paranumber =" + paraCode + " " : " ")
                    + (patient != null ? " and para.patients=:patient " : " ")                    
                    //+  " and  para.patients.amka REGEXP '(\\d){11}' "                   
                    + (orderBy != null ? orderBy : " ");
            Query query = getEntityManager().createQuery(queryString);
//            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("hospital", hospital);
            if (assertion != null) {
                query.setParameter("assertion", assertion);
            }
             if (assertionType != null) {
                query.setParameter("assertionType", assertionType);
            }
            if (period != null) {
                query.setParameter("period", period);
            }
            if (type != null) {
                query.setParameter("type", type);
            }
            if (fromExecutionDate != null) {
                query.setParameter("fromExecutionDate", fromExecutionDate);
            }
            if (toExecutionDate != null) {
                query.setParameter("toExecutionDate", toExecutionDate);
            }
            if (fromIssueDate != null) {
                query.setParameter("fromIssueDate", fromIssueDate);
            }
            if (toIssueDate != null) {
                query.setParameter("toIssueDate", toIssueDate);
            }
//            if (paraCode != null) {
//                query.setParameter("paraCode", paraCode);
//            }
            if (patient != null) {
                query.setParameter("patient", patient);
            }

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
            logger.error("Error on searching paras", re);
            throw re;
        }
    }

    public Long getSearchParaResultSet(Hospital hospital, ExAssertion assertion, ExAssertionType assertionType, ExPeriod period, ExType type, Date fromExecutionDate,
            Date toExecutionDate, Date fromIssueDate, Date toIssueDate, String paraCode, Patients patient) {

        try {

            final String queryString = "select count(para) from ExPara para where "
                    + " para.hospital= :hospital "
                    + (assertion != null ? " and para.exAssertion=:assertion " : " ")
                    + (assertionType != null ? " and para.exAssertion.exAssertionType=:assertionType " : " ")
                    + (period != null ? " and para.exAssertion.exPeriod=:period " : " ")
                    + (type != null ? " and para.exType=:type " : " ")
                    + (fromExecutionDate != null ? " and para.executiondate>= :fromExecutionDate " : " ")
                    + (toExecutionDate != null ? " and para.executiondate<= :toExecutionDate " : " ")
                    + (fromIssueDate != null ? " and para.issuedate>= :fromIssueDate " : " ")
                    + (toIssueDate != null ? " and para.issuedate<= :toIssueDate " : " ")
                    //+ (paraCode != null ? " and para.paracode like '%"+paraCode+"' " : " ")
                    + (paraCode != null ? " and para.paranumber =" + paraCode + " " : " ")                    
                    //+ " and  para.patients.amka REGEXP '(\\d){11}' "                    
                    + (patient != null ? " and para.patients=:patient " : " ");



            Query query = getEntityManager().createQuery(queryString);
//            query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("hospital", hospital);
            if (assertion != null) {
                query.setParameter("assertion", assertion);
            }
             if (assertionType != null) {
                query.setParameter("assertionType", assertionType);
            }
            if (period != null) {
                query.setParameter("period", period);
            }
            if (type != null) {
                query.setParameter("type", type);
            }
            if (fromExecutionDate != null) {
                query.setParameter("fromExecutionDate", fromExecutionDate);
            }
            if (toExecutionDate != null) {
                query.setParameter("toExecutionDate", toExecutionDate);
            }
            if (fromIssueDate != null) {
                query.setParameter("fromIssueDate", fromIssueDate);
            }
            if (toIssueDate != null) {
                query.setParameter("toIssueDate", toIssueDate);
            }
//            if (paraCode != null) {
//                query.setParameter("paraCode", paraCode);
//            }
            if (patient != null) {
                query.setParameter("patient", patient);
            }

            return (Long) query.getSingleResult();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on searching paras", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public ParaSearchResultBean fetchParaExams(ExPara para) {

        try {
            //, COALESCE(sum(pe.cost-pe.cost*pe.quantity)) COALESCE(sum(pe.cost*pe.quantity)) 
            String sql = " select NEW com.hosp.bean.ParaSearchResultBean( pe.exPara, count(pe), COALESCE(sum(pe.cost*pe.quantity),0), COALESCE(sum(pe.cost-pe.cost*pe.participation),0)     )  "
                    + " from ExParaExams pe  "
                    + " where pe.exPara = :para"
                    + " group by pe.exPara ";

            Query query = getEntityManager().createQuery(sql);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("para", para);
            return (ParaSearchResultBean) query.getSingleResult();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on getAssertionData", re);
            throw re;
        }

    }

    public List<ExPara> getSearchParaResultList(Hospital hospital, ExAssertion assertion, ExPeriod period, ExType type, Date fromExecutionDate,
            Date toExecutionDate, Date fromIssueDate, Date toIssueDate, String paraCode, Patients patient, final int... rowStartIdxAndCount) {

        try {
//            System.out.println(assertion + " " + period + " " + type + " " + fromExecutionDate + " " + toExecutionDate + " " + fromIssueDate + " " + toExecutionDate + " " + paraCode + " " + patient);
            final String queryString = "select para from ExPara para where "
                    + " para.hospital= :hospital "
                    + assertion != null ? " and para.exAssertion=:assertion " : " "
                    + period != null ? " and para.exAssertion.exPeriod=:period " : " "
                    + type != null ? " and para.exType=:type " : " "
                    + fromExecutionDate != null ? " and para.executiondate>= :fromExecutionDate " : " "
                    + toExecutionDate != null ? " and para.executiondate<= :toExecutionDate " : " "
                    + fromIssueDate != null ? " and para.issuedate>= :fromIssueDate " : " "
                    + toIssueDate != null ? " and para.issuedate<= :toIssueDate " : " "
                    + paraCode != null ? " and para.paracode like '%:paraCode' " : " "
                    + patient != null ? " and para.patients=:patient " : " ";

            Query query = getEntityManager().createQuery(queryString);


            //query.setMaxResults(1500);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            query.setParameter("hospital", hospital);
            if (assertion != null) {
                query.setParameter("assertion", assertion);
            }
            if (period != null) {
                query.setParameter("period", period);
            }
            if (type != null) {
                query.setParameter("type", type);
            }
            if (fromExecutionDate != null) {
                query.setParameter("fromExecutionDate", fromExecutionDate);
            }
            if (toExecutionDate != null) {
                query.setParameter("toExecutionDate", toExecutionDate);
            }
            if (fromIssueDate != null) {
                query.setParameter("fromIssueDate", fromIssueDate);
            }
            if (toIssueDate != null) {
                query.setParameter("toIssueDate", toIssueDate);
            }
            if (paraCode != null) {
                query.setParameter("paraCode", paraCode);
            }
            if (patient != null) {
                query.setParameter("patient", patient);
            }

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
            logger.error("Error on searching paras", re);
            throw re;
        }

    }

    public List<StatisticsParaResultBean> statisticsPara(Hospital hospital, ExAssertion assertion, ExAssertionType assertionType, ExPeriod period, ExType type, Date fromExecutionDate,
            Date toExecutionDate, ExExam exam) {
        try {
//            System.out.println(assertion + " " + period + " " + type + " " + fromExecutionDate + " " + toExecutionDate + " " + toExecutionDate + " " + exam);

            String sql = " select NEW com.hosp.bean.StatisticsParaResultBean(pe.exExam, sum(pe.quantity),  "
                    + " sum(pe.cost*pe.quantity),     sum((pe.cost-pe.cost*pe.participation)*pe.quantity)   )  "
                    + " from ExPara p LEFT OUTER JOIN p.exParaExamses pe  "
                    + " where p.hospital= :hospital " 
                    + (assertion != null ? " and p.exAssertion= :assertion " : " ") 
                    + (assertionType != null ? " and p.exAssertion.exAssertionType= :assertionType " : " ") 
                    + (period != null ? " and p.exAssertion.exPeriod= :period " : " ")
                    + (type != null ? " and p.exType=:type " : " ")
                    + (fromExecutionDate != null ? " and p.executiondate>= :fromExecutionDate " : " ")
                    + (toExecutionDate != null ? " and p.executiondate<= :toExecutionDate " : " ")
                    + (exam != null ? " and pe.exExam= :exam " : " ")
                    + " group by pe.exExam";
           
            
            Query query = getEntityManager().createQuery(sql);

            query.setParameter("hospital", hospital);
            if (assertion != null) {
                query.setParameter("assertion", assertion);
            }
            
            if (assertionType != null) {
                query.setParameter("assertionType", assertionType);
            }
            if (period != null) {
                query.setParameter("period", period);
            }
            if (type != null) {
                query.setParameter("type", type);
            }
            if (fromExecutionDate != null) {
                query.setParameter("fromExecutionDate", fromExecutionDate);
            }
            if (toExecutionDate != null) {
                query.setParameter("toExecutionDate", toExecutionDate);
            }
            if (exam != null) {
                query.setParameter("exam", exam);
            }
            
            
            return query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on searching paras", re);
            throw re;
        }
    }
}