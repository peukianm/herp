package com.hosp.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.hosp.entities.*;
import com.hosp.util.EJBUtil;
import com.hosp.util.FacesUtils;
import com.hosp.util.FormatUtils;
import com.hosp.util.PersistenceHelper;
import java.util.ArrayList;
import java.util.Date;

/**
 * A data access object (DAO) providing persistence and search support for Admission entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.Admission
 * @author MyEclipse Persistence Tools
 */
public class AdmissionDAO {
    // property constants

    public static final String INSIDE = "inside";
    public static final String SYMPTOMS = "symptoms";
    public static final String COMMENTS = "comments";
    public static final String BED = "bed";
    public static final String ROOM = "room";
    public static final String ICD = "icd";
    public static final String ICDNAME = "icdname";
    public static final String KEN = "ken";
    public static final String KENNAME = "kenname";
    public static final String INSTRUCTIONS = "instructions";
    public static final String ADMISSIONTIME = "admissiontime";
    private static final Logger logger = Logger.getLogger(AdmissionDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Admission entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * AdmissionDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Admission entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Admission entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent Admission entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * AdmissionDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Admission entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Admission entity) {

        try {
            entity = getEntityManager().getReference(Admission.class, entity.getAdmissionid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved Admission entity and return it or a copy of it to the sender. A copy of the Admission entity parameter is returned when the
     * JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context
     * for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = AdmissionDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Admission entity to update
     * @return Admission the persisted Admission entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Admission update(Admission entity) {

        try {
            Admission result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public Admission findById(BigDecimal id) {

        try {
            Admission instance = getEntityManager().find(Admission.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all Admission entities with a specific property value.
     *
     * @param propertyName the name of the Admission property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Admission> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Admission> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Admission model where model." + propertyName + "= :propertyValue";
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

    public List<Admission> findByInside(Object inside, int... rowStartIdxAndCount) {
        return findByProperty(INSIDE, inside, rowStartIdxAndCount);
    }

    public List<Admission> findBySymptoms(Object symptoms, int... rowStartIdxAndCount) {
        return findByProperty(SYMPTOMS, symptoms, rowStartIdxAndCount);
    }

    public List<Admission> findByComments(Object comments, int... rowStartIdxAndCount) {
        return findByProperty(COMMENTS, comments, rowStartIdxAndCount);
    }

    public List<Admission> findByBed(Object bed, int... rowStartIdxAndCount) {
        return findByProperty(BED, bed, rowStartIdxAndCount);
    }

    public List<Admission> findByRoom(Object room, int... rowStartIdxAndCount) {
        return findByProperty(ROOM, room, rowStartIdxAndCount);
    }

    public List<Admission> findByIcd(Object icd, int... rowStartIdxAndCount) {
        return findByProperty(ICD, icd, rowStartIdxAndCount);
    }

    public List<Admission> findByIcdname(Object icdname, int... rowStartIdxAndCount) {
        return findByProperty(ICDNAME, icdname, rowStartIdxAndCount);
    }

    public List<Admission> findByKen(Object ken, int... rowStartIdxAndCount) {
        return findByProperty(KEN, ken, rowStartIdxAndCount);
    }

    public List<Admission> findByKenname(Object kenname, int... rowStartIdxAndCount) {
        return findByProperty(KENNAME, kenname, rowStartIdxAndCount);
    }

    public List<Admission> findByInstructions(Object instructions, int... rowStartIdxAndCount) {
        return findByProperty(INSTRUCTIONS, instructions, rowStartIdxAndCount);
    }

    public List<Admission> findByAdmissiontime(Object admissiontime, int... rowStartIdxAndCount) {
        return findByProperty(ADMISSIONTIME, admissiontime, rowStartIdxAndCount);
    }

    /**
     * Find all Admission entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Admission> all Admission entities
     */
    @SuppressWarnings("unchecked")
    public List<Admission> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Admission model";
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
    public List<Admission> findUserAdmissions(Patients patient) {
        try {
            final String queryString = "select model from Admission model where model.patients= :propertyValue order by model.startdate DESC";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", patient);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public Admission findUserActiveAdmissions(Patients patient) {
        try {
            final String queryString = " select model from Admission model where model.inside='" + FacesUtils.INSIDE + "' "
                    + " AND model.patients= :propertyValue "
                    + " order by model.room ASC, model.bed ASC ";
//			getEntityManager().clear();
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", patient);

            return (Admission) (query.getSingleResult());
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Admission> findUserInactiveAdmissions(Patients patient) {
        try {
            final String queryString = "select model from Admission model where model.inside='" + FacesUtils.OUTSIDE + "' AND model.patients= :propertyValue  order by model.startdate DESC";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", patient);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Admission> findClinicDayPlan(Department department) {
        try {
            final String queryString = "select model from Admission model where model.inside='" + FacesUtils.INSIDE
                    + "' AND model.department= :department   order by model.room, model.bed ASC";
            //getEntityManager().clear();
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("department", department);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findClinicStatusAdmissions(Hospital hospital, String[] departments, java.util.Date from, java.util.Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departments.length; i++) {

                Query query = getEntityManager().createQuery(" select count(*) from Admission a "
                        + " where a.startdate>=:from AND a.startdate<=:to "
                        + " AND a.department=:department AND a.hospital=:hospital ");

                query.setParameter("from", from);
                query.setParameter("to", to);
                query.setParameter("department", departments[i]);
                query.setParameter("hospital", hospital);

                retVal.add(new Object[]{departments[i], query.getResultList()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findClinicStatusDischarge(Hospital hospital, String[] departments, java.util.Date from, java.util.Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departments.length; i++) {
                Query query = getEntityManager().createQuery(" select count(*) from Admission a "
                        + " where a.enddate>=:from AND a.enddate<=:to "
                        + " AND a.department=:department AND a.hospital=:hospital ");

                query.setParameter("from", from);
                query.setParameter("to", to);
                query.setParameter("department", departments[i]);
                query.setParameter("hospital", hospital);

                retVal.add(new Object[]{departments[i], query.getResultList()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findAverageTimeAdmission(Hospital hospital, String[] departments, java.util.Date from, java.util.Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departments.length; i++) {
                Query query = getEntityManager().createQuery(" select avg(a.enddate-a.startdate) from Admission a "
                        + " where a.startdate>=:from AND a.startdate<=:to "
                        + " AND a.department=:department AND a.hospital=:hospital "
                        + " AND a.enddate IS NOT NULL");

                query.setParameter("from", from);
                query.setParameter("to", to);
                query.setParameter("department", departments[i]);
                query.setParameter("hospital", hospital);

                retVal.add(new Object[]{departments[i], query.getResultList()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Object[]> findTotalDaysOfAdmission(Hospital hospital, String[] departments, java.util.Date from, java.util.Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departments.length; i++) {

                Query query = getEntityManager().createQuery(" select sum(a.enddate-a.startdate) from Admission a "
                        + " where a.startdate>=:from AND a.startdate<=:to "
                        + " AND a.department=:department AND a.hospital=:hospital "
                        + " AND a.enddate IS NOT NULL");

                query.setParameter("from", from);
                query.setParameter("to", to);
                query.setParameter("department", departments[i]);
                query.setParameter("hospital", hospital);

                retVal.add(new Object[]{departments[i], query.getSingleResult()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Object[]> findAllClinicData(Double hospitalid, String[] departmentIDs, java.util.Date from, java.util.Date to) {
        try {

            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departmentIDs.length; i++) {

                Query query = getEntityManager().createNativeQuery(" select dis1.dis, adm1.adm, avg1.avg, total.tot1  from "
                        + " (select count(*) as dis  from admission a  "
                        + "                         where a.ENDDATE>='" + FormatUtils.formatDate(from) + "' and a.ENDdate<='" + FormatUtils.formatDate(to) + "'"
                        + "                         AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid + " ) dis1,  "
                        + " (select count(*) as adm  from admission a  "
                        + "                         where a.STARTDATE>='" + FormatUtils.formatDate(from) + "' and a.STARTdate<='" + FormatUtils.formatDate(to) + "' "
                        + "                         AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid + " "
                        + "                         ) adm1, "
                        + " (select round(avg(a.enddate-a.startdate),2) as avg from Admission a "
                        + " 						 where a.startdate>='" + FormatUtils.formatDate(from) + "' AND a.startdate<='" + FormatUtils.formatDate(to) + "'  "
                        + " 						 AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid + "  "
                        + " 						 AND a.enddate IS NOT NULL) avg1, "
                        + " (select round(sum(a.enddate-a.startdate),0) as tot1 from Admission a  "
                        + " 						 where a.startdate>='" + FormatUtils.formatDate(from) + "' AND a.startdate<='" + FormatUtils.formatDate(to) + "' "
                        + " 						 AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid + " "
                        + " 						 AND a.enddate IS NOT NULL) total  	 ");

                retVal.add(new Object[]{getEntityManager().find(Department.class, new Double(departmentIDs[i])), query.getSingleResult()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Object[]> findAllClinicDataPerInsurance(Double hospitalid, String[] departmentIDs, String[] insuranceIDs, java.util.Date from, java.util.Date to) {
        try {

            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departmentIDs.length; i++) {
                java.util.Hashtable table = new java.util.Hashtable();
                for (int j = 0; j < insuranceIDs.length; j++) {
                    Query query = getEntityManager().createNativeQuery(" select dis1.dis, adm1.adm, avg1.avg, total.tot1  from "
                            + " (select count(*) as dis  from admission a, patients p  "
                            + "                         where a.ENDDATE>='" + FormatUtils.formatDate(from) + "' and a.ENDdate<='" + FormatUtils.formatDate(to) + "'"
                            + "                         AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid
                            + "                         AND a.patientid=p.patientid and p.insuranceid=" + insuranceIDs[j] + ") dis1,"
                            + " (select count(*) as adm  from admission a, patients p    "
                            + "                         where a.STARTDATE>='" + FormatUtils.formatDate(from) + "' and a.STARTdate<='" + FormatUtils.formatDate(to) + "' "
                            + "                         AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid + " "
                            + "                         AND a.patientid=p.patientid and p.insuranceid=" + insuranceIDs[j]
                            + "                         ) adm1, "
                            + " (select round(avg(a.enddate-a.startdate),2) as avg from Admission a, patients p   "
                            + " 						 where a.startdate>='" + FormatUtils.formatDate(from) + "' AND a.startdate<='" + FormatUtils.formatDate(to) + "'  "
                            + " 						 AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid + "  "
                            + "                         AND a.patientid=p.patientid and p.insuranceid=" + insuranceIDs[j]
                            + " 						 AND a.enddate IS NOT NULL) avg1, "
                            + " (select round(sum(a.enddate-a.startdate),0) as tot1 from Admission a, patients p    "
                            + " 						 where a.startdate>='" + FormatUtils.formatDate(from) + "' AND a.startdate<='" + FormatUtils.formatDate(to) + "' "
                            + " 						 AND a.departmentid=" + departmentIDs[i] + " AND a.hospitalid=" + hospitalid + " "
                            + "                         AND a.patientid=p.patientid and p.insuranceid=" + insuranceIDs[j]
                            + " 						 AND a.enddate IS NOT NULL) total  	 ");
                    List dat = (List) query.getSingleResult();
                    if (dat != null && (((BigDecimal) dat.get(0)).doubleValue() > 0)) {
                        table.put(getEntityManager().find(Insurance.class, new Double(insuranceIDs[j])), dat);
                    }
                }

                retVal.add(new Object[]{getEntityManager().find(Department.class, new Double(departmentIDs[i])), table});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Object[]> findAdmissionsByOutcome(Double hospitalid, String[] departmentIDs, Date from, Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int j = 0; j < departmentIDs.length; j++) {
                Query query = getEntityManager().createQuery(" select count(a.outcome), a.outcome "
                        + " from Admission a where a.enddate is not null  "
                        + " AND a.department.departmentid=:department AND a.hospital.hospitalid=:hospital "
                        + " AND a.startdate>=:from AND a.startdate<=:to"
                        + " group by a.outcome order by   a.outcome.outcomeid ");;

                query.setParameter("department", new Double(departmentIDs[j]));
                query.setParameter("hospital", hospitalid);
                query.setParameter("from", from);
                query.setParameter("to", to);
                retVal.add(new Object[]{getEntityManager().find(Department.class, new Double(departmentIDs[j])), query.getResultList()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }

    }

    public List<Object[]> insertAdmissionList(Double hospitalid, String[] departmentIDs, Date from, Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int j = 0; j < departmentIDs.length; j++) {
                Query query = getEntityManager().createQuery(" select a "
                        + " from Admission a where  "
                        + " a.department.departmentid=:department AND a.hospital.hospitalid=:hospital "
                        + " AND a.startdate>=:from AND a.startdate<=:to"
                        + " order by  a.patients.surname ");

                query.setParameter("department", new Double(departmentIDs[j]));
                query.setParameter("hospital", hospitalid);
                query.setParameter("from", from);
                query.setParameter("to", to);
                retVal.add(new Object[]{getEntityManager().find(Department.class, new Double(departmentIDs[j])), query.getResultList()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Object[]> insertExitAdmissionList(Double hospitalid, String[] departmentIDs, Date from,
            Date to, String amka, String surname, Boolean showAdmission, Boolean showDischarge) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int j = 0; j < departmentIDs.length; j++) {

                String qr = "";
                if (showAdmission && showDischarge) {
                    qr = " select a "
                            + " from Admission a where  "
                            + " a.department.departmentid=:department AND a.hospital.hospitalid=:hospital "
                            + " AND a.startdate>=:from AND a.startdate<=:to "
                            + (surname != null ? " AND (LOWER(a.patients.surname) like '" + surname.toLowerCase() + "%'"
                            + " OR UPPER(a.patients.surname)  like '" + surname.toUpperCase() + "%')" : " ")
                            + (amka != null ? " and a.patients.amka like '" + amka + "%' " : " ")
                            + " order by  a.patients.surname ";
                } else if (!showAdmission && showDischarge) {

                    qr = " select a "
                            + " from Admission a where  "
                            + " a.department.departmentid=:department AND a.hospital.hospitalid=:hospital "
                            + " AND a.enddate>=:from AND a.enddate<=:to "
                            + (surname != null ? " AND (LOWER(a.patients.surname) like '" + surname.toLowerCase() + "%'"
                            + " OR UPPER(a.patients.surname)  like '" + surname.toUpperCase() + "%')" : " ")
                            + (amka != null ? " and a.patients.amka like '" + amka + "%' " : " ")
                            + " order by  a.patients.surname ";


                } else if (showAdmission && !showDischarge) {
                    qr = " select a "
                            + " from Admission a where  "
                            + " a.department.departmentid=:department AND a.hospital.hospitalid=:hospital "
                            + " AND a.startdate>=:from AND a.startdate<=:to "
                            + " AND a.inside like '1'  "
                            + (surname != null ? " AND (LOWER(a.patients.surname) like '" + surname.toLowerCase() + "%'"
                            + " OR UPPER(a.patients.surname)  like '" + surname.toUpperCase() + "%')" : " ")
                            + (amka != null ? " and a.patients.amka like '" + amka + "%' " : " ")
                            + " order by  a.patients.surname ";
                } else {
                    qr = " select a "
                            + " from Admission a where  "
                            + " a.department.departmentid=:department AND a.hospital.hospitalid=:hospital "
                            + " AND a.startdate>=:from AND a.startdate<=:to "
                            + " AND a.inside like '2'  "
                            + (surname != null ? " AND (LOWER(a.patients.surname) like '" + surname.toLowerCase() + "%'"
                            + " OR UPPER(a.patients.surname)  like '" + surname.toUpperCase() + "%')" : " ")
                            + (amka != null ? " and a.patients.amka like '" + amka + "%' " : " ")
                            + " order by  a.patients.surname ";
                }


                Query query = getEntityManager().createQuery(qr);
                query.setParameter("department", new Double(departmentIDs[j]));
                query.setParameter("hospital", hospitalid);
                query.setParameter("from", from);
                query.setParameter("to", to);
                retVal.add(new Object[]{getEntityManager().find(Department.class, new Double(departmentIDs[j])), query.getResultList()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Object[]> exitAdmissionList(Double hospitalid, String[] departmentIDs, Date from, Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int j = 0; j < departmentIDs.length; j++) {
                Query query = getEntityManager().createQuery(" select a "
                        + " from Admission a where  "
                        + " a.department.departmentid=:department AND a.hospital.hospitalid=:hospital "
                        + " AND a.enddate>=:from AND a.enddate<=:to"
                        + " order by  a.patients.surname ");

                query.setParameter("department", new Double(departmentIDs[j]));
                query.setParameter("hospital", hospitalid);
                query.setParameter("from", from);
                query.setParameter("to", to);
                retVal.add(new Object[]{getEntityManager().find(Department.class, new Double(departmentIDs[j])), query.getResultList()});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Object[]> findLabs(Double hospitalid, String[] departmentIDs, String[] categoryIDs, Date from, Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departmentIDs.length; i++) {
                java.util.Hashtable table = new java.util.Hashtable();
                for (int j = 0; j < categoryIDs.length; j++) {
                    Query query = getEntityManager().createQuery(" select count(le.id)  "
                            + " from LabExams le where  "
                            + " le.lab.admission.department.departmentid=:department "
                            + " AND le.lab.admission.hospital.hospitalid=:hospital "
                            + " AND le.lab.labdate>=:from AND le.lab.labdate<=:to "
                            + " AND le.exam.examcategory.examcategoryid=" + categoryIDs[j]);
                    //" group by l.labExams.examid order by  l.labExams.examid");;

                    query.setParameter("department", new Double(departmentIDs[i]));
                    query.setParameter("hospital", hospitalid);
                    query.setParameter("from", from);
                    query.setParameter("to", to);

                    Long dat = (Long) query.getSingleResult();


                    if (dat != null && (dat > 0)) {
                        table.put(getEntityManager().find(Examcategory.class, new Double(categoryIDs[j])), dat);
                    }
                }
                retVal.add(new Object[]{getEntityManager().find(Department.class, new Double(departmentIDs[i])), table});
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }

    }

    public List<Recipe> findUnorderRecipes(Admission admission) {
        try {
            Query query = getEntityManager().createQuery(" Select r from Recipe r "
                    + " where r.admission=:admission AND r.ordered IS NULL ");

            query.setParameter("admission", admission);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }

    }
}