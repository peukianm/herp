package com.hosp.entities;

import org.apache.log4j.Logger;

import com.hosp.bean.SessionBean;
import com.hosp.util.FacesUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author MyEclipse Persistence Tools
 */
public class EntityManagerHelper {
	
	private static final EntityManagerFactory emf; 
	private static final Logger logger = Logger.getLogger(EntityManagerHelper.class) ; 
	
	/** The instance of the singleton */
    private static EntityManagerHelper _instance = null ;
    
    /** Persistence Context */
    private static EntityManager em = null;

	
	static {
		emf = Persistence.createEntityManagerFactory("HERP"); 		
	}
	
	
	
	public static synchronized EntityManagerHelper getInstance(){        
		if ( _instance == null ) {                           
			//System.out.println("*********************** INSTASIATING ENTITY MANAGER HELPER*************************************************");
			_instance = new EntityManagerHelper() ;
//            logger.info("Instasiating EntityManagerHelper!!!!!");
        }                
		return _instance ; 
	}
	
	public static synchronized EntityManagerHelper getInstance(boolean refresh){        	        
		if ( ( _instance == null ) || refresh )   {
//			System.out.println("*********************** INSTASIATING ENTITY MANAGER HELPER (with refresh)*************************************************");
			_instance = new EntityManagerHelper() ; 
        }			
		return _instance ; 
	}
	
	
//	public static EntityManager getEntityManager() {
//		SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
//		EntityManager manager = sessionBean.getManager();
//	    			
//		if (manager == null || !manager.isOpen()) {
//			System.out.println("*********************** CREATING ENTITY MANAGER *************************************************");			
//			manager = emf.createEntityManager();
//			sessionBean.setManager(manager);
//			logger.info("*********************** CREATING ENTITY MANAGER *************************************************");
//		}
//		return manager;
//	}
//	
//	public static void closeEntityManager() {
//		 SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
//		 EntityManager manager = sessionBean.getManager();
//		
//		 if (manager!=null){
//			 manager.close();			 
//			 System.out.println("*********************** DESTROYING ENTITY MANAGER*************************************************");
//			 logger.info("*********************** DESTROYING ENTITY MANAGER*************************************************");
//		 }
//		 
//   }
	
	public static EntityManager getEntityManager() {			      			
		if (em == null || !em.isOpen()) {
			System.out.println("*********************** CREATING ENTITY MANAGER *************************************************");			
			em = emf.createEntityManager();			
//			logger.info("*********************** CREATING ENTITY MANAGER *************************************************");
		}
		return em;
	}
	
	public static void closeEntityManager() {		 
		 if (em!=null && em.isOpen()){
			 em.close();			 
			 System.out.println("*********************** DESTROYING ENTITY MANAGER*************************************************");
//			 logger.info("*********************** DESTROYING ENTITY MANAGER*************************************************");
		 }
		 
   }
	

    public static synchronized void  beginTransaction() {    	
    	if (!getEntityManager().getTransaction().isActive()) {
    		System.out.println("*********************** BEGINNIG TRANSACTION*************************************************");
    		getEntityManager().getTransaction().begin();
    	}
    }
    
    public static void beginTransaction(EntityManager em) {    	
    	if (!getEntityManager().getTransaction().isActive()) {
    		em.getTransaction().begin();
    	}
    }
		      
    
    public static void commit() {
    	System.out.println("*********************** COMMITING TRANSACTION*************************************************");
    	getEntityManager().getTransaction().commit();
    }  
    
    public static void commit(EntityManager em) {
    	em.getTransaction().commit();
    }
    
    public static void rollback() {
    	getEntityManager().getTransaction().rollback();
    } 
    
    public static Query createQuery(String query) {
		return getEntityManager().createQuery(query);
	}
    
    
    
    
    
//    public static void beginTransaction() {
//    	getEntityManager().getTransaction().begin();
//    }
    
//	public static EntityManager getEntityManager() {
//	EntityManager manager = threadLocal.get();		
//	if (manager == null || !manager.isOpen()) {
//		manager = emf.createEntityManager();
//		threadLocal.set(manager);
//	}
//	return manager;
//}

// public static void closeEntityManager() {
//    EntityManager em = threadLocal.get();
//    threadLocal.set(null);
//    if (em != null) em.close();
//}
	
//	public static void log(String info, Level level, Throwable ex) {
//    	logger.log(level, info, ex);
//    }
    
}
