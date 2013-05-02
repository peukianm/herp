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
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * A data access object (DAO) providing persistence and search support for Patients entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.Patients
 * @author MyEclipse Persistence Tools
 */
public class PatientsDAO {
    // property constants
     
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String AMKA = "amka";
    public static final String ADDRESS = "address";
    public static final String FATHERNAME = "fathername";
    public static final String IDNUMBER = "idnumber";
    public static final String MOBILE = "mobile";
    public static final String PHONE = "phone";
    public static final String CITY_1 = "city_1";
    public static final String JOB = "job";
    public static final String PERSONALHISTORY = "personalhistory";
    public static final String FAMILYHISTORY = "familyhistory";
    public static final String PREVIOUSADMISSIONS = "previousadmissions";
    public static final String COMMENTS = "comments";
    public static final String INSIDE = "inside";
    public static final String INSURANCENUMBER = "insurancenumber";
    private static final Logger logger = Logger.getLogger(PatientsDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Patients entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * PatientsDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Patients entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Patients entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Delete a persistent Patients entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * PatientsDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Patients entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Patients entity) {

        try {
            entity = getEntityManager().getReference(Patients.class, entity.getPatientid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Persist a previously saved Patients entity and return it or a copy of it to the sender. A copy of the Patients entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = PatientsDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Patients entity to update
     * @return Patients the persisted Patients entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Patients update(Patients entity) {

        try {
            Patients result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    public Patients findById(BigDecimal id) {

        try {
            Patients instance = getEntityManager().find(Patients.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);
            throw re;
        }
    }

    /**
     * Find all Patients entities with a specific property value.
     *
     * @param propertyName the name of the Patients property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Patients> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Patients> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Patients model where model." + propertyName + "= :propertyValue";
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

    public List<Patients> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<Patients> findBySurname(Object surname, int... rowStartIdxAndCount) {
        return findByProperty(SURNAME, surname, rowStartIdxAndCount);
    }

    public List<Patients> findByAmka(Object amka, int... rowStartIdxAndCount) {
        return findByProperty(AMKA, amka, rowStartIdxAndCount);
    }

    public List<Patients> findByAddress(Object address, int... rowStartIdxAndCount) {
        return findByProperty(ADDRESS, address, rowStartIdxAndCount);
    }

    public List<Patients> findByFathername(Object fathername, int... rowStartIdxAndCount) {
        return findByProperty(FATHERNAME, fathername, rowStartIdxAndCount);
    }

    public List<Patients> findByIdnumber(Object idnumber, int... rowStartIdxAndCount) {
        return findByProperty(IDNUMBER, idnumber, rowStartIdxAndCount);
    }

    public List<Patients> findByMobile(Object mobile, int... rowStartIdxAndCount) {
        return findByProperty(MOBILE, mobile, rowStartIdxAndCount);
    }

    public List<Patients> findByPhone(Object phone, int... rowStartIdxAndCount) {
        return findByProperty(PHONE, phone, rowStartIdxAndCount);
    }

    public List<Patients> findByCity_1(Object city_1, int... rowStartIdxAndCount) {
        return findByProperty(CITY_1, city_1, rowStartIdxAndCount);
    }

    public List<Patients> findByJob(Object job, int... rowStartIdxAndCount) {
        return findByProperty(JOB, job, rowStartIdxAndCount);
    }

    public List<Patients> findByPersonalhistory(Object personalhistory, int... rowStartIdxAndCount) {
        return findByProperty(PERSONALHISTORY, personalhistory, rowStartIdxAndCount);
    }

    public List<Patients> findByFamilyhistory(Object familyhistory, int... rowStartIdxAndCount) {
        return findByProperty(FAMILYHISTORY, familyhistory, rowStartIdxAndCount);
    }

    public List<Patients> findByPreviousadmissions(Object previousadmissions, int... rowStartIdxAndCount) {
        return findByProperty(PREVIOUSADMISSIONS, previousadmissions, rowStartIdxAndCount);
    }

    public List<Patients> findByComments(Object comments, int... rowStartIdxAndCount) {
        return findByProperty(COMMENTS, comments, rowStartIdxAndCount);
    }

    public List<Patients> findByInside(Object inside, int... rowStartIdxAndCount) {
        return findByProperty(INSIDE, inside, rowStartIdxAndCount);
    }

    public List<Patients> findByInsurancenumber(Object insurancenumber, int... rowStartIdxAndCount) {
        return findByProperty(INSURANCENUMBER, insurancenumber, rowStartIdxAndCount);
    }

    /**
     * Find all Patients entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Patients> all Patients entities
     */
    @SuppressWarnings("unchecked")
    public List<Patients> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Patients model";
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
    public List<Patients> fetchPatientAutoCompleteSurname(String value) {
        try {
            value = value.trim();
            
            Query query = getEntityManager().createQuery("Select c from Patients c  where (LOWER(c.surname) like '" + ((String) value).toLowerCase() + "%'"
                    + " OR UPPER(c.surname)  like '" + ((String) value).toUpperCase() + "%') "
                    + " and c.enable<>0 "
                    + " order by c.surname, c.name");

            query.setMaxResults(50);
            return query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on fetching patient", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Patients> fetchPatientAutoCompleteAMKA(String value) {
        try {
           
            Query query = getEntityManager().createQuery("Select c from Patients c where c.amka like '" + value + "%' "
                    + "  and c.enable<>0 order by c.amka");

            query.setMaxResults(50);
            return query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on fetcing patient", re);
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
    
    
    public Boolean checkAMKA(String amka) {		
        try {
                
                String sql = "Select p " +
                " from Patients p where p.amka like '" + amka + "'  ";

                Query query = getEntityManager().createQuery(sql);
                if (query.getResultList().size()>0) {
                        return true;
                }
                else {
                        return false;
                }
        } catch (RuntimeException re) {
                re.printStackTrace();
                return null;
                //throw re;

        }
    }
    
    
    
    public List<Patients> getSearchPatientResultSet(String name, String surname, String amka, Date fromBirthDate,
            Date toBirthDate, Insurance insurance, String orderBy, final int... rowStartIdxAndCount) {

        try {            
            final String queryString = "select patient from Patients patient where "
                    + " patient.enable= 1 "
                    + (name != null ? " and patient.name like '"+name+"%'" : " ")
                    + (surname != null ? " and patient.surname like '"+surname+"%'" : " ")
                    + (amka != null ? " and patient.amka like '"+amka+"%'" : " ")                    
                    + (fromBirthDate != null ? " and patient.dateofbirth>= :fromBirthDate " : " ")
                    + (toBirthDate != null ? " and patient.dateofbirth<= :toBirthDate " : " ")                    
                    + (insurance != null ? " and patient.insurance=:insurance " : " ")
                    + (orderBy != null ? orderBy : " ");
            
            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            
           
            if (fromBirthDate != null) {
                query.setParameter("fromBirthDate", fromBirthDate);
            }
            if (toBirthDate != null) {
                query.setParameter("toBirthDate", toBirthDate);
            }                        
            if (insurance != null) {
                query.setParameter("insurance", insurance);
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
    
    
    
    public Patients fetchPatientFromDB (Patients patient) {
        try {
            
            final String queryString = "select patient from Patients patient where "
                    + " patient.amka='"+patient.getAmka()+"'";                                
            Query query = getEntityManager().createQuery(queryString);            
            return (Patients)query.getSingleResult();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on searching paras", re);
            throw re;
        }
    }
    
    public Long getSearchPatientResultSet(String name, String surname, String amka, Date fromBirthDate,
            Date toBirthDate, Insurance insurance) {

        try {
            
            final String queryString = "select count(patient) from Patients patient where "
                    + " patient.enable= 1 "
                    + (name != null ? " and patient.name like '"+name+"%'" : " ")
                    + (surname != null ? " and patient.surname like '"+surname+"%'" : " ")
                    + (amka != null ? " and patient.amka like '"+amka+"%'" : " ")                    
                    + (fromBirthDate != null ? " and patient.dateofbirth>= :fromBirthDate " : " ")
                    + (toBirthDate != null ? " and patient.dateofbirth<= :toBirthDate " : " ")                    
                    + (insurance != null ? " and patient.insurance=:insurance " : " ");
                    
            
            Query query = getEntityManager().createQuery(queryString);
            //query.setHint("javax.persistence.cache.storeMode", "REFRESH");
            
           
            if (fromBirthDate != null) {
                query.setParameter("fromBirthDate", fromBirthDate);
            }
            if (toBirthDate != null) {
                query.setParameter("toBirthDate", toBirthDate);
            }                        
            if (insurance != null) {
                query.setParameter("insurance", insurance);
            }

            return (Long)query.getSingleResult();
        } catch (RuntimeException re) {
            re.printStackTrace();
            logger.error("Error on searching paras", re);
            throw re;
        }
    }
    
    
    @SuppressWarnings("unchecked")
	public List<Admission> fetchAdmittedPatients(Department department, Hospital hospital, String inside) {		
		try {
			EntityManager em = getEntityManager();
			String queryStr ;
			
			if (department.getType()!=null && department.getType().equals("TEP") ){
				if (inside !=null) 
					queryStr= "Select a from Admission a where" +
						" a.department= :depValue AND a.hospital= :hospValue AND a.inside LIKE '"+inside+"' order by a.startdate ASC, a.admissiontime ASC";
				else
					queryStr= "Select a from Admission a where" +
					" a.department= :depValue AND a.hospital= :hospValue order by a.startdate ASC, a.admissiontime ASC";

			} else {
				if (inside !=null) 
					queryStr= "Select a from Admission a where" +
						" a.department= :depValue AND a.hospital= :hospValue AND a.inside LIKE '"+inside+"' order by a.room ASC, a.bed ASC";
				else
					queryStr= "Select a from Admission a where" +
					" a.department= :depValue AND a.hospital= :hospValue order by a.room ASC, a.bed ASC ";
			}
			
			Query query = em.createQuery(queryStr);
						
			query.setParameter("depValue", department);
			query.setParameter("hospValue", hospital);

			return query.getResultList();
		} catch (RuntimeException re) {
			re.printStackTrace();
                        logger.error("Error on fetchinh admissions", re);
			throw re;
		}
	}
    
    
}