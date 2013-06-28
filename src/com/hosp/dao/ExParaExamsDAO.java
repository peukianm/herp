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
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A data access object (DAO) providing persistence and search support for ExParaExams entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.ExParaExams
 * @author MyEclipse Persistence Tools
 */
public class ExParaExamsDAO {
    // property constants

    private static final Logger logger = Logger.getLogger(ExParaExamsDAO.class);

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
     * Perform an initial save of a previously unsaved ExParaExams entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExParaExamsDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExParaExams entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(ExParaExams entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent ExParaExams entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * ExParaExamsDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity ExParaExams entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(ExParaExams entity) {

        try {
            entity = getEntityManager().getReference(ExParaExams.class, entity.getParaexamid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved ExParaExams entity and return it or a copy of it to the sender. A copy of the ExParaExams entity parameter is returned when
     * the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction
     * context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = ExParaExamsDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity ExParaExams entity to update
     * @return ExParaExams the persisted ExParaExams entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public ExParaExams update(ExParaExams entity) {

        try {
            ExParaExams result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public ExParaExams findById(BigDecimal id) {

        try {
            ExParaExams instance = getEntityManager().find(ExParaExams.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all ExParaExams entities with a specific property value.
     *
     * @param propertyName the name of the ExParaExams property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<ExParaExams> found by query
     */
    @SuppressWarnings("unchecked")
    public List<ExParaExams> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExParaExams model where model." + propertyName + "= :propertyValue";
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

    /**
     * Find all ExParaExams entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<ExParaExams> all ExParaExams entities
     */
    @SuppressWarnings("unchecked")
    public List<ExParaExams> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from ExParaExams model";
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
    public List<ExParaExams> fetchParaExamsAutoCompleteCode(String value, ExPara para) {
        try {

//            Query query = getEntityManager().createQuery("Select pe from ExParaExams pe where pe.exExam.code like '" + value + "%' "
//                    + "  and pe.exExam.enabled=1 order by pe.exExam.code");

//            String sql = "select NEW com.hosp.entities.ExParaExams(exam,para,contract,ce.) from ExExam exam, ExContract contract, ExPara para, ExContractExams ce    "
//                    + " where e.code like '" + value + "%' "
//                    + " and contract= :contract " 
//                    + " and exam.enabled = 1 "   
//                    + " and ce.exContract= :contract "
//                    + " and ce.exExam=exam ";

//            System.out.println("VALUE=" + value);
//            System.out.println("PARA=" + para);
//            System.out.println("CONTRACT=" + para.getExContract());

            Query query = getEntityManager().createQuery("Select ce from ExContractExams ce where "
                    + " ce.exExam.code like '%" + value + "' "
                    + " AND ce.exContract= :contract ");
                    //+ " AND ce.exExam.enabled=1 "
                    //+ " order by ce.exExam.code");
            query.setMaxResults(20);
            query.setParameter("contract", para.getExAssertion().getExContract());
            List<ExContractExams> contractExams = query.getResultList();
            List<ExParaExams> paraExams = new ArrayList<ExParaExams>(contractExams.size());
            for (ExContractExams contractExam : contractExams) {
                paraExams.add(new ExParaExams(contractExam.getExExam(), para, new BigDecimal(contractExam.getPrice()), new BigDecimal(1), new BigDecimal(1),contractExam.getParticipation() ));
            }



            return paraExams;
        } catch (RuntimeException re) {
            throw re;
        }
    }   

    @SuppressWarnings("unchecked")
    public List<ExParaExams> fetchParaExamsAutoCompleteName(String value, ExPara para) {
        try {
            Query query = getEntityManager().createQuery("Select ce from ExContractExams ce where "
                    + "(LOWER(ce.exExam.name) like '%" + ((String) value).toLowerCase() + "%'"
                    + " OR UPPER(ce.exExam.name)  like '%" + ((String) value).toUpperCase() + "%') "
                    + " AND ce.exContract= :contract");
                    //+ " AND ce.exExam.enabled=1 order by ce.exExam.code");
            query.setMaxResults(20);
            
            query.setParameter("contract", para.getExAssertion().getExContract());
            
            List<ExContractExams> contractExams = query.getResultList();
            List<ExParaExams> paraExams = new ArrayList<ExParaExams>(contractExams.size());
            for (ExContractExams contractExam : contractExams) {
                paraExams.add(new ExParaExams(contractExam.getExExam(), para, new BigDecimal(contractExam.getPrice()), new BigDecimal(1), new BigDecimal(1),contractExam.getParticipation() ));
            }
            return paraExams;
        } catch (RuntimeException re) {
            throw re;
        }
    }
    
     @SuppressWarnings("unchecked")
    public List<ExExam> fetchExamsAutoCompleteName(String value) {
        try {
            Query query = getEntityManager().createQuery("Select ce from ExExam ce where "
                    + "(LOWER(ce.name) like '%" + ((String) value).toLowerCase() + "%'"
                    + " OR UPPER(ce.name)  like '%" + ((String) value).toUpperCase() + "%') "                    
                    + " AND ce.enabled=1 order by ce.code");
            query.setMaxResults(20);                        
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
     
     @SuppressWarnings("unchecked")
    public ExParaExams fetchParaExamFromExam(ExExam exam, ExPara para) {
        try {
            Query query = getEntityManager().createQuery("Select ce from ExContractExams ce where "
                    + " ce.exExam= :exam "
                    + " AND ce.exContract= :contract");                                
            
            query.setParameter("exam", exam);
            query.setParameter("contract", para.getExAssertion().getExContract());
            
            ExContractExams contractExam = (ExContractExams)query.getSingleResult();
            
            ExParaExams paraExam = new ExParaExams(contractExam.getExExam(), para, new BigDecimal(contractExam.getPrice()), new BigDecimal(1), new BigDecimal(1),contractExam.getParticipation() );            
            
            return paraExam;
        } catch (RuntimeException re) {
            throw re;
        }
    }
     
    
}