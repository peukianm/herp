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
 * A data access object (DAO) providing persistence and search support for Drugs entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually added to each of these methods for data to be persisted to the JPA datastore.
 *
 * @see com.hosp.dao.Drugs
 * @author MyEclipse Persistence Tools
 */
public class DrugsDAO {
    // property constants

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String CODE = "code";
    public static final String CTEAM = "cteam";
    public static final String ATOMORDER = "atomorder";
    public static final String ORIGINAL = "original";
    public static final String BARCODE = "barcode";
    public static final String ATC = "atc";
    public static final String EOF = "eof";
    private static final Logger logger = Logger.getLogger(DrugsDAO.class);

    private EntityManager getEntityManager() {
        PersistenceHelper persistenceHelper = EJBUtil.lookupPersistenceHelperBean();
        return persistenceHelper.getEntityManager();
    }

    /**
     * Perform an initial save of a previously unsaved Drugs entity. All subsequent persist actions of this entity should use the #update() method. This
     * operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e.,
     * database. This method uses the null     {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * DrugsDAO.save(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Drugs entity to persist
     * @throws RuntimeException when the operation fails
     */
    public void save(Drugs entity) {

        try {
            getEntityManager().persist(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Delete a persistent Drugs entity. This operation must be performed within the a database transaction context for the entity's data to be permanently
     * deleted from the persistence store, i.e., database. This method uses the {@link javax.persistence.EntityManager#remove(Object)
     * EntityManager#delete} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * DrugsDAO.delete(entity);
     * EntityManagerHelper.commit();
     * entity = null;
     * </pre>
     *
     * @param entity Drugs entity to delete
     * @throws RuntimeException when the operation fails
     */
    public void delete(Drugs entity) {

        try {
            entity = getEntityManager().getReference(Drugs.class, entity.getDrugid());
            getEntityManager().remove(entity);

        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Persist a previously saved Drugs entity and return it or a copy of it to the sender. A copy of the Drugs entity parameter is returned when the JPA
     * persistence mechanism has not previously been tracking the updated entity. This operation must be performed within the a database transaction context for
     * the entity's data to be permanently saved to the persistence store, i.e., database. This method uses the
     * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
     *
     * <pre>
     * EntityManagerHelper.beginTransaction();
     * entity = DrugsDAO.update(entity);
     * EntityManagerHelper.commit();
     * </pre>
     *
     * @param entity Drugs entity to update
     * @return Drugs the persisted Drugs entity instance, may not be the same
     * @throws RuntimeException if the operation fails
     */
    public Drugs update(Drugs entity) {

        try {
            Drugs result = getEntityManager().merge(entity);

            return result;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    public Drugs findById(BigDecimal id) {

        try {
            Drugs instance = getEntityManager().find(Drugs.class, id);
            return instance;
        } catch (RuntimeException re) {
            logger.error("Error on updating entity", re);


            throw re;
        }
    }

    /**
     * Find all Drugs entities with a specific property value.
     *
     * @param propertyName the name of the Drugs property to query
     * @param value the property value to match
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum number of results to return.
     * @return List<Drugs> found by query
     */
    @SuppressWarnings("unchecked")
    public List<Drugs> findByProperty(String propertyName, final Object value, final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Drugs model where model." + propertyName + "= :propertyValue";
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

    public List<Drugs> findByName(Object name, int... rowStartIdxAndCount) {
        return findByProperty(NAME, name, rowStartIdxAndCount);
    }

    public List<Drugs> findByDescription(Object description, int... rowStartIdxAndCount) {
        return findByProperty(DESCRIPTION, description, rowStartIdxAndCount);
    }

    public List<Drugs> findByCode(Object code, int... rowStartIdxAndCount) {
        return findByProperty(CODE, code, rowStartIdxAndCount);
    }

    public List<Drugs> findByCteam(Object cteam, int... rowStartIdxAndCount) {
        return findByProperty(CTEAM, cteam, rowStartIdxAndCount);
    }

    public List<Drugs> findByAtomorder(Object atomorder, int... rowStartIdxAndCount) {
        return findByProperty(ATOMORDER, atomorder, rowStartIdxAndCount);
    }

    public List<Drugs> findByOriginal(Object original, int... rowStartIdxAndCount) {
        return findByProperty(ORIGINAL, original, rowStartIdxAndCount);
    }

    public List<Drugs> findByBarcode(Object barcode, int... rowStartIdxAndCount) {
        return findByProperty(BARCODE, barcode, rowStartIdxAndCount);
    }

    public List<Drugs> findByAtc(Object atc, int... rowStartIdxAndCount) {
        return findByProperty(ATC, atc, rowStartIdxAndCount);
    }

    public List<Drugs> findByEof(Object eof, int... rowStartIdxAndCount) {
        return findByProperty(EOF, eof, rowStartIdxAndCount);
    }

    /**
     * Find all Drugs entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the row index in the query result-set to begin collecting the
     * results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.
     * @return List<Drugs> all Drugs entities
     */
    @SuppressWarnings("unchecked")
    public List<Drugs> findAll(final int... rowStartIdxAndCount) {

        try {
            final String queryString = "select model from Drugs model";
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

    public List<Drugs> searchDrug(String name, String code, String eof, String barcode,
            String atc, String enable, String closed, String daycharge,
            String original, String narcotic, String antibiotic) {
        try {



            EntityManager em = EntityManagerHelper.getEntityManager();
            String queryString = "Select d from Drugs d"
                    + " where d.drugid IS NOT NULL "
                    + (name != null ? " AND (LOWER(d.name) like '"+ name.toLowerCase() + "%'"+ " OR UPPER(d.name)  like '" + name.toUpperCase() + "%') " : " ")
                    + (code != null ? " and d.code like '" + code + "%' " : " ")
                    + (eof != null ? " and d.eof like '" + eof + "%' " : " ")
                    + (barcode != null ? " and d.barcode like '" + barcode + "%' " : " ")
                    + (atc != null ? " AND (LOWER(d.atc) like '"+ atc.toLowerCase() + "%'" + " OR UPPER(d.atc)  like '" + atc.toUpperCase() + "%') " : " ")
                    + (enable != null ? " and d.inuse=:enable " : " ")
                    + (closed != null ? " and d.closed=:closed " : " ")
                    + (daycharge != null ? " and d.daycharge=:daycharge " : " ")
                    + (original != null ? " and d.original=:original " : " ")
                    + (narcotic != null ? " and d.drug=:narcotic " : " ")
                    + (antibiotic != null ? " and d.antibiotic=:antibiotic " : " ")
                    + " order by d.name ASC";



            Query query = em.createQuery(queryString);
            if (enable != null) {
                query.setParameter("enable", new Double(enable));
            }
            if (closed != null) {
                query.setParameter("closed", new Double(closed));
            }
            if (daycharge != null) {
                query.setParameter("daycharge", new Double(daycharge));
            }
            if (original != null) {
                query.setParameter("original", new Double(original));
            }
            if (narcotic != null) {
                query.setParameter("narcotic", new Double(narcotic));
            }
            if (antibiotic != null) {
                query.setParameter("antibiotic", new Double(antibiotic));
            }


            return query.getResultList();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}