package com.hosp.dao;

import java.math.BigDecimal;
import java.util.Date;
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
 * A data access object (DAO) providing persistence and search support for RecipeDrugs entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 *
 * @see com.hosp.dao.RecipeDrugs
 * @author MyEclipse Persistence Tools
 */
public class RecipeDrugsDAO {
    // property constants

    private static final Logger logger = Logger.getLogger(RecipeDrugsDAO.class);

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
     * Perform an initial save of a previously unsaved RecipeDrugs entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * RecipeDrugsDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity RecipeDrugs entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(RecipeDrugs entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Delete a persistent RecipeDrugs entity. This operation must be performed within the a database transaction context for the entity's data to be
     * permanently deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * RecipeDrugsDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity RecipeDrugs entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(RecipeDrugs entity) {

        try {
            entity = getEntityManager().getReference(RecipeDrugs.class, entity.getId());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Persist a previously saved RecipeDrugs entity and return it or a copy of it to the sender. A copy of the RecipeDrugs entity parameter is returned when
     * the JPA persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction
     * context for the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = RecipeDrugsDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity RecipeDrugs entity to update
     * @return RecipeDrugs the persisted RecipeDrugs entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public RecipeDrugs update(RecipeDrugs entity) {

        try {
            RecipeDrugs result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public RecipeDrugs findById(BigDecimal id) {

        try {
            RecipeDrugs instance = getEntityManager().find(RecipeDrugs.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    /**
     * Find all RecipeDrugs entities with a specific property value.
     *
     * @param propertyName the name of the RecipeDrugs property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<RecipeDrugs> found by query
     */
    @SuppressWarnings("unchecked")
    public List<RecipeDrugs> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from RecipeDrugs model where model." + propertyName + "= :propertyValue";
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

    /**
     * Find all RecipeDrugs entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<RecipeDrugs> all RecipeDrugs entities
     */
    @SuppressWarnings("unchecked")
    public List<RecipeDrugs> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from RecipeDrugs model";
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
    public List<Object[]> findDrugConsumption(String hospitalid, String[] departments, java.util.Date from, java.util.Date to) {
        try {
            List<Object[]> retVal = new ArrayList<Object[]>();
            for (int i = 0; i < departments.length; i++) {
                Query query = getEntityManager().createQuery("select r.department.name, d.name, sum(rd.quantity)  "
                        + " from RecipeDrugs rd JOIN rd.drugs d "
                        + " JOIN rd.recipe r "
                        + " where r.dateofrecipe >:from AND r.dateofrecipe<:to "
                        + " AND r.department.departmentid=:departmentid AND r.hospital.hospitalid=:hospitalid "
                        + " group by r.department.name, d.name order by d.name");

                query.setParameter("from", from);
                query.setParameter("to", to);
                query.setParameter("departmentid", new Double(departments[i]));
                query.setParameter("hospitalid", new Double(hospitalid));

                if (query.getResultList().size() > 0) {
                    retVal.add(new Object[]{((Object[]) query.getResultList().get(0))[0], query.getResultList()});
                } else {
                    DepartmentDAO departmentDAO = new DepartmentDAO();
                    retVal.add(new Object[]{departmentDAO.findById(new BigDecimal(departments[i])).getName(), query.getResultList()});
                }
            }
            return retVal;
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<RecipeDrugs> dayDrugOrder(Hospital hospital, Department department, java.util.Date today) {
        try {
            Query query = getEntityManager().createQuery("select rd "
                    + " from RecipeDrugs rd JOIN rd.drugs d "
                    + " JOIN rd.recipe r "
                    + " where r.dateofrecipe =:today "
                    + " AND r.department=:department AND r.hospital=:hospital "
                    + //					" order by r.patients.surname");
                    " order by rd.drugs.name");

            query.setParameter("today", today);
            query.setParameter("department", department);
            query.setParameter("hospital", hospital);


            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    public List<RecipeDrugs> findUnOrderedRecipes(Hospital hospital, Department department, java.util.Date today) {
        try {
            Query query = getEntityManager().createQuery("select rd "
                    + " from RecipeDrugs rd JOIN rd.drugs d "
                    + " JOIN rd.recipe r "
                    + " where r.dateofrecipe =:today "
                    + " AND r.department=:department AND r.hospital=:hospital AND r.ordered IS NULL"
                    + " order by r.patients.surname");

            query.setParameter("today", today);
            query.setParameter("department", department);
            query.setParameter("hospital", hospital);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}