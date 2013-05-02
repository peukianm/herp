package com.hosp.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;
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
 * A data access object (DAO) providing persistence and search support for Recipe entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @see com.hosp.dao.Recipe
 * @author MyEclipse Persistence Tools
 */
public class RecipeDAO {
    // property constants

    private static final Logger logger = Logger.getLogger(RecipeDAO.class);

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
     * Perform an initial save of a previously unsaved Recipe entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * RecipeDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Recipe entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Recipe entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent Recipe entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * RecipeDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Recipe entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Recipe entity) {

        try {
            entity = getEntityManager().getReference(Recipe.class, entity.getRecipeid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved Recipe entity and return it or a copy of it to the sender. A copy of the Recipe entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = RecipeDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Recipe entity to update
     * @return Recipe the persisted Recipe entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Recipe update(Recipe entity) {

        try {
            Recipe result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public Recipe findById(BigDecimal id) {

        try {
            Recipe instance = getEntityManager().find(Recipe.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all Recipe entities with a specific property value.
     *
     * @param propertyName the name of the Recipe property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Recipe> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Recipe> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Recipe model where model." + propertyName + "= :propertyValue";
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
     * Find all Recipe entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Recipe> all Recipe entities
     */
    @SuppressWarnings("unchecked")
    public List<Recipe> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Recipe model";
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

    public List<Recipe> findAdmissionRecipes(Admission admission) {
        try {
            EntityManager em = getEntityManager();
            final String queryString = "Select r from Recipe r "
                    + "    where r.admission=:propertyValue order by r.recipeid DESC";

            Query query = em.createQuery(queryString);
            query.setParameter("propertyValue", admission);            
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Recipe> findOrderRecipes(Hospital hospital, Department department, Date date) {
        try {

            EntityManager em = getEntityManager();

            final String queryString = "Select r from Recipe r "
                    + "    where r.department=:department and r.hospital=:hospital and "
                    + "         r.dateofrecipe=:date and r.ordered IS NULL  ";

            Query query = em.createQuery(queryString);
            query.setParameter("department", department);
            query.setParameter("hospital", hospital);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public List<Recipe> findPatientRecipes(Patients patient) {
        try {

            EntityManager em = getEntityManager();

            final String queryString = "Select r from Recipe r "
                    + "    where r.patients=:patient order by r.dateofrecipe DESC ";

            Query query = em.createQuery(queryString);
            query.setParameter("patient", patient);
            query.setMaxResults(40);

            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }

    public Recipe findPatientLastRecipes(Admission admission) {
        try {

            EntityManager em = getEntityManager();

            final String queryString = "Select r from Recipe r "
                    + "    where r.admission=:admission order by r.recipeid DESC ";

            Query query = em.createQuery(queryString);
            query.setParameter("admission", admission);
            query.setMaxResults(1);

            if (query.getResultList().size() > 0) {                
                return (Recipe) query.getResultList().get(0);
            } else {
                return null;
            }

        } catch (RuntimeException re) {
            re.printStackTrace();
            throw re;
        }
    }
}