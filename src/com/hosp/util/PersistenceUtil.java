package com.hosp.util;

import com.hosp.entities.Action;
import com.hosp.entities.Auditing;
import com.hosp.entities.Patients;
import com.hosp.entities.Users;
import com.hosp.exception.HerpRollbackException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PersistenceUtil {

    @EJB
    private PersistenceHelper persistenceHelper;

    public void audit(Users user, BigDecimal actionID, Patients patient, String comments) throws Exception {
        try {

            Action action = (Action) persistenceHelper.find(Action.class, actionID);

            Auditing auditing = new Auditing();
            auditing.setUsers(user);

            auditing.setActiondate(FormatUtils.formatDateToTimestamp(new Date(), FormatUtils.FULLDATEPATTERN));
            auditing.setHospital(user.getHospital());
            auditing.setDepartment(user.getDepartment());
            auditing.setAction(action);
            auditing.setComments(comments);

            if (patient != null) {
                auditing.setPatients(patient);
            }
            persistenceHelper.create(auditing);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public String getReportDataSQL1(String katastasiID) {
        String sql =
                "SELECT   A.*, "
                + "B.ADMISSION_NUMBER, "
                + "TRUNC (B.DISCHARGED_ON) \"DISCHARGED_ON\", "
                + "TRUNC (B.ADMISSION_ON) \"ADMISSION_ON\", "
                + "B.ADMISSION_ON, "
                + "B.DISCHARGED_ON, "
                + "B.INSERTED_ON, "
                + "B.ADMISSION_NOTES, "
                + "--R.INSERTED_ON "
                + "1 \"REGISTRY_INSERTED_ON\", "
                + "2 \"DESCRIPTION\", "
                + "--E.DESCRIPTION, "
                + "P.FATHER_NAME, "
                + "R.DESCRIPTION \"BATHMOS\", "
                + "L.DESCRIPTION \"SXESH\", "
                + "IH.INSURANCE_STATUS, "
                + "P.HOME_PHONE, "
                + "P.ID, "
                + "P.BIRTH_DATE, "
                + "PT.EXPIRATIONDATE, "
                + "PT.OGA_AM, "
                + "PT.OGA_AM_CODE, "
                + "P.AMKA,T.DESCRIPTION AS PERISTATIKO, "
                + "reg.get_formated_am (A.ADMISSION_ID) \"AR.MHTR\", "
                + "(select ken.code from ken where ken.service_id = A.SERVICE_ID) AS KEN, "
                + " N.CLINIC_DESC, "
                + " DECODE(A.SERVICE_ID,NULL,0,1)AS SERVICE_FLAG, "
                + " PT.INSURANCEBOOK_ID, "
                + "              ( "
                + "    trunc(B.discharged_on) "
                + "    - "
                + "   (trunc(B.admission_on) + "
                + " ( select sum(ken_pak.kenDays(ken_id, trunc(B.discharged_on))) from ken_admission where admission_id = B.admission_sn ) "
                + " ) "
                + " )AS HMERES_PERA_KEN "
                + "   FROM   INS_TEMP A, "
                + "          ADMISSIONS B, "
                + "          INS_KATASTASI_HEADER IH, "
                + "          PATIENTS P, "
                + "          ARMY_BATHMOI R, "
                + "          ARMY_INFO RI, "
                + "          ARMY_RELATION L,"
                + "          INSURANCE_TRANS IT, "
                + "          PAT_TRANS_INS PT, "
                + "          PERISTATIKA T, "
                + "          BCLINICS N "
                + "  WHERE   A.ADMISSION_ID = B.ADMISSION_SN AND B.PATIENT_ID = P.PATIENT_SN "
                + "          AND IT.INSURE_SN = "
                + "                (SELECT   MAX (Q.INSURE_SN) "
                + "                   FROM   INSURANCE_TRANS Q "
                + "                  WHERE   Q.FIRST = 1 AND Q.ADMISSION_ID = B.ADMISSION_SN) "
                + "          AND RI.ADMISSION_ID(+) = b.ADMISSION_SN "
                + "          AND RI.BATHMOS = R.SN(+) "
                + "          AND RI.RELATION = L.SN(+) "
                + "          AND A.KATASTASI_ID = IH.KATASTASI_ID "
                + "          AND IT.PAT_TRANS_INS_ID = PT.PAT_TRANS_INS_SN "
                + "          AND B.PERISTATIKO=T.PERISTATIKO_SN(+) "
                + "          AND IT.CLINIC_ID=N.BCLINIC_ID(+) "
                + "          AND A.KATASTASI_ID=" + katastasiID
                + "          --and B.DISCHARGED_ON>='01/07/2013' AND B.DISCHARGED_ON <='01/07/2013' "
                + "          ORDER BY A.A_A,A.SN,A.ADMISSION_ID ";


        return sql;

    }

    public String getReportDataSQL2(String katastasiID) {
        String sql =
                "  select   "
                //+ "      --ADM.ADMISSION_SN,  "
                + "      P.PATIENT_SN,      P.FIRST_NAME,           P.LAST_NAME,         P.FATHER_NAME,    P.BIRTH_DATE,         P.AMKA,               P.SEX,                P.ID,               P.STREET,               C.CITY,  "
                + "      P.COUNTRY,         P.POSTAL_CODE,         INS.EDAPY_CODE,       P.HOME_PHONE,     PT.insure_type_id,    PT.INSURE_STATUS_ID,  PT.INSURANCEBOOK_ID,  PT.OGA_AM,          PT.OGABOOKID,           PT.EXPIRATIONDATE,  "
                + "      ADM.ADMISSION_SN, ADM.ADMISSION_NUMBER,   ADM.ADMISSION_NOTES, ADM.ADMISSION_ON,  ADM.DISCHARGED_ON,    EKV.EDAPY_CODE,       DIAG.DIAG_CODE,       DIAG.DESCRIPTION,   S1.EDAPY_CODE as seat,  PT.INSURE_TYPE_ID AS DIRECT,  "
                + "      B.SERVICE_ID,      B.DATE_FROM,            B.DATE_TO,          B.REASON,          B.quantity,           B.FINAL_PRICE,        B.FPA_AMOUNT,         B.UNIT_PRICE,       B.TOTAL,                B.CLINIC_ID,   "
                + "      CLI.CLINIC_DESC,    CLI.SECTOR,            B.SEAT_ID,          doct.doc_lname,    doct.doc_fname,       doct.amka,            PT.INSURANCE_ID,      pref.prefecture, "
                + "      reg.get_formated_am (B.ADMISSION_ID) \"AR.MHTR\",  "
                + "      (select ken.code from ken where ken.service_id = B.SERVICE_ID) AS KEN,  "
                + "      ( trunc(adm.discharged_on) -(trunc(adm.admission_on) +( select sum(ken_pak.kenDays(ken_id, trunc(adm.discharged_on))) from ken_admission where admission_id = adm.admission_sn ) ) )AS HMERES_PERA_KEN  "
                + " from  "
                + "     bills b, admissions adm, patients p, INSURANCE_TRANS IT, PAT_TRANS_INS PT,  PERISTATIKA T,  BCLINICS N, INSURANCE INS,  "
                + "     cities c,  "
                + "     DIAGNOSIS diag,  "
                + "     seats s1,  "
                + "     EKVASI_NOSILIAS ekv,  "
                + "     bclinics cli,  "
                + "     docsperadmission da,  "
                + "     doctors doct,  "
                + "     prefectures pref  "
                + " where  "
                + "   B.ADMISSION_ID IN (select  unique A.ADMISSION_ID from INS_TEMP A  where A.KATASTASI_ID =" + katastasiID + ")  "
                + "   and total!=0  "
                + "   and B.ADMISSION_ID = ADM.ADMISSION_SN  "
                + "   and P.PATIENT_SN = ADM.PATIENT_ID  "
                + "   and PT.INSURANCE_ID = INS.INSURANCE_SN  "
                + "   and P.CITY = C.CITY_SN(+)  "
                + "   and EKV.EKVASI_SN = ADM.EKVASI_ID  "
                + "   and ADM.DIAGNOSIS_OUT_ID=DIAG.DIAGNOSI_SN(+)  "
                + "   and  B.SEAT_ID=S1.SEAT_SN(+)   "
                + "   and B.ADMISSION_ID = da.admission_id(+)  "
                + "   and da.doctor_ID = doct.doctor_sn(+)  "
                + "   and B.CLINIC_ID = CLI.BCLINIC_ID(+)  "
                + "   and P.PREFECTURE = pref.prefecture_SN(+)  "
                + "   and IT.INSURE_SN =  "
                + "                     (SELECT   MAX (Q.INSURE_SN)  "
                + "                        FROM   INSURANCE_TRANS Q  "
                + "                       WHERE   Q.FIRST = 1 AND Q.ADMISSION_ID = adm.ADMISSION_SN)         "
                + "   and IT.PAT_TRANS_INS_ID = PT.PAT_TRANS_INS_SN  "
                + "   and adm.PERISTATIKO=T.PERISTATIKO_SN(+)  "
                + "   and IT.CLINIC_ID=N.BCLINIC_ID(+)  "
                + " order by b.admission_id asc, KEN desc NULLS LAST  ";


        return sql;
    }

    public Connection getConnection() {//throws Exception {    	
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@" + SystemParameters.getInstance().getProperty("cteamip") + ":"
                    + SystemParameters.getInstance().getProperty("cteamport") + ":" + SystemParameters.getInstance().getProperty("cteamsid"),
                    SystemParameters.getInstance().getProperty("cteamusername"),
                    SystemParameters.getInstance().getProperty("cteampassword"));
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /*	public static Double getUniqueOrderID(){
     try {
     EntityManager em = EntityManagerHelper.getEntityManager();
     String queryString = "select ORDERS_SEQ.nextval from dual";
     Query query = em.createNativeQuery(queryString);


     return new Double(((Vector)query.getSingleResult()).get(0).toString());
     } catch (RuntimeException re) {			
     throw re;
     }
     }

     public static Double getUniqueRecipeID(){
     try {
     EntityManager em = EntityManagerHelper.getEntityManager();
     String queryString = "select RECIPE_SEQ.nextval from dual";
     Query query = em.createNativeQuery(queryString);

     return new Double(((Vector)query.getSingleResult()).get(0).toString());
     } catch (RuntimeException re) {
     throw re;
     }
     }
    
     public static Double getUniqueLabID(){
     try {
     EntityManager em = EntityManagerHelper.getEntityManager();
     String queryString = "select LAB_SEQ.nextval from dual";
     Query query = em.createNativeQuery(queryString);

     return new Double(((Vector)query.getSingleResult()).get(0).toString());
     } catch (RuntimeException re) {
     throw re;
     }
     }
    
     public static Double getUniqueEntalID(){
     try {
     EntityManager em = EntityManagerHelper.getEntityManager();
     String queryString = "select FIN_ENTAL_SEQ.nextval from dual";
     Query query = em.createNativeQuery(queryString);

     return new Double(((Vector)query.getSingleResult()).get(0).toString());
     } catch (RuntimeException re) {
     throw re;
     }
     }
    
     public static FinYear getCurrentYear(){    	
     List<FinYear> year = new FinYearDAO().findByProperty("name", (new Integer( Calendar.getInstance().get(Calendar.YEAR))).toString()) ;     	
     if (year!=null && year.size()>0)
     return year.get(0);
     else
     return null;
     }
    
     public static Double getInitialBudget(Hospital hospital, Double kaeID, Double yearID, Double foreasID){
    	
     FinBudgetDAO budgetDAO = new FinBudgetDAO();
     EntityManager em = EntityManagerHelper.getEntityManager();
		
     FinYear year = em.find(FinYear.class, new Double(yearID));	
     FinKae kae = null;
     if (kaeID!=null)
     kae = em.find(FinKae.class, new Double(kaeID));	
    	
     Foreas foreas = null;
     if (foreasID!=null)
     foreas = em.find(Foreas.class, new Double(foreasID));
    	
     Double init = budgetDAO.findInitialBudget(hospital, kae, year, foreas  );
     return init;
     }
    
     public static Double getKaeBalance(Hospital hospital, Double kaeID, Double yearID, Double foreasID, Timestamp referenceDate){
    	
     FinBudgetDAO budgetDAO = new FinBudgetDAO();
     EntityManager em = EntityManagerHelper.getEntityManager();
		
     FinYear year = em.find(FinYear.class, new Double(yearID));	
     FinKae kae = null;
     if (kaeID!=null)
     kae = em.find(FinKae.class, new Double(kaeID));	
    	
     Foreas foreas = null;
     if (foreasID!=null)
     foreas = em.find(Foreas.class, new Double(foreasID));
    	
     Double init = budgetDAO.findInitialBudget(hospital, kae, year, foreas  );     	
     Double totalDesm = budgetDAO.findTotalUnCoverDesm(hospital, kae, year, foreas, referenceDate); 		
     Double totalTimol = budgetDAO.findTotalTimolForCoveredDesm(hospital, kae, year, foreas, referenceDate); 		 		 		
     return new Double((init.doubleValue() - (totalDesm.doubleValue()+totalTimol.doubleValue())));
     }
    
     public static String getDesmSumForEsyNet(Hospital hospital,Double from, Double to, FinYear year, Foreas foreas, Timestamp referenceDate){
     String retValue = null;
     FinBudgetDAO budgetDAO = new FinBudgetDAO();
    	
     retValue = budgetDAO.findAmountDesmForEsyNet(hospital, null, year, foreas, from, to, null, referenceDate);
    	
     return retValue;
     }
    
    
     public static Double getPendingDesm(Hospital hospital, FinYear year, FinKae kae, Foreas foreas, Timestamp referenceDate){
    	
     FinBudgetDAO budgetDAO = new FinBudgetDAO();
     EntityManager em = EntityManagerHelper.getEntityManager();
		
    	
     Double totalDesm = budgetDAO.findTotalDesm(hospital, kae, year, foreas, referenceDate); 		 		
     Double totalTimol = budgetDAO.findTotalCoverTimol(hospital, kae, year, foreas, referenceDate) ;
 		
     return new Double((totalDesm.doubleValue()- totalTimol.doubleValue()));
     }
    
     public static Double getPendingDesm(Hospital hospital, FinYear year, FinKae kae, Foreas foreas, int days, Timestamp referenceDate){
    	
     FinBudgetDAO budgetDAO = new FinBudgetDAO();
     EntityManager em = EntityManagerHelper.getEntityManager();
		
    	
     Double totalDesm = budgetDAO.findTotalDesm(hospital, kae, year, foreas, referenceDate); 		 		
     Double totalTimol = budgetDAO.findTotalCoverTimol(hospital, kae, year, foreas, referenceDate) ;
 		
     return new Double((totalDesm.doubleValue()- totalTimol.doubleValue()));
     }
    
    
    
     public static Connection getConnection() {//throws Exception {    	
     try {
     Class.forName ("oracle.jdbc.driver.OracleDriver");
     Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@"+SystemParameters.getInstance().getProperty("cteamip")+":"+
     SystemParameters.getInstance().getProperty("cteamport")+":"+SystemParameters.getInstance().getProperty("cteamsid"), 
     SystemParameters.getInstance().getProperty("cteamusername"), 
     SystemParameters.getInstance().getProperty("cteampassword"));
     return conn;
     } catch (Exception e) {			
     //			e.printStackTrace();
     //			throw e;
     SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
     sessionBean.setErrorMsgKey("errMsg_GeneralError");
     FacesUtils.redirectWithNavigationID("error");
     AppUtil.goError(e, logger, sessionBean);
     return null;
     }
     }
    
    
     public static List<FinTimol> getTimolsFromCteam(FinKae finKae, String fromDate, String toDate, String afm){
    	
     String kae = null;
     if (finKae!=null)
     kae = finKae.getName();
    	
     //getTimolsFromCteam(kae, fromDate, toDate);
     Connection conn = null;
     Statement stmt = null;
     ResultSet rset = null;	    
     List<FinTimol> retVal = new ArrayList<FinTimol>(0);
     try {
     String sql = " SELECT  a.supplier_date, b.poso, e.afm, e.eponimia, a.code_parast, b.CODEPROYP, " +
     " a.supplier_ref "+
     //			" b.codeproyp, c.record_sn AS kodproyp_sn, " +
     //			"  c.shortname, " +
     //			" d.perigrafh, d.record_sn AS foreas_record_sn, " +
     //			" a.par_katastash, a.hmer_plhromhs, a.code_parast, a.suppliersn, " +
     //			" f.perigrafh,  a.supplier_date, a.hmeromhnia, " +
     //			" a.suppliersn AS supplier_sn, a.supplier_ref, c.kodikos AS kodproyp, " +
     //			" e.record_sn AS supplier_record_sn " +
     " FROM shdl_parastatika_master a, " +
     " shdl_parastatika_detail b, " +
     //			" shdl_logsxedio c, " +
     //			" shdl_kefalaiaproyp d, " +
     " shdl_synalassomenoi e " +
     //			" shdl_katastaseisparastatikon f " +
     " WHERE a.record_sn = b.master_record_sn " +
     //			" AND b.codeproyp = c.kodikos " +
     //			" AND b.kefalaio = c.kefalaio " +
     //			" AND b.kefalaio = d.record_sn " +
     " AND a.suppliersn = e.record_sn " +
     //			" AND c.kathgoria = 102 " +
     //			" AND f.record_sn = a.par_katastash " +
     (fromDate!=null ? " and a.supplier_date>='"+fromDate+"' " : " ") +
     (toDate!=null ? " and a.supplier_date<='"+toDate+"' " : " ") +			
     (kae!=null ? " and b.CODEPROYP like '"+kae+"%' " : " " ) +
     (afm!=null ? " and e.afm like '"+afm+"%' " : " " ) +
     " order by e.eponimia " ;
						
     conn = getConnection();
     if (conn==null) 
     throw new Exception("No Connection from CTEAM App");
     stmt = conn.createStatement();
     rset = stmt.executeQuery(sql);
		    
     double amount = 0;
     int counter = 0;
     int inserted = 0;
		    
		    
     while (rset.next()) {
     FinTimol timol = new FinTimol();		    	
     timol.setAfm(rset.getString(3));
     timol.setSupname(rset.getString(4));
     timol.setAmount(new Double(rset.getString(2)));
     //System.out.println(AppUtil.getTimestamp(rset.getString(1)));
     timol.setDateoftimol(AppUtil.formatDateToTimestamp(rset.getDate(1)));		    	
     timol.setArtimol(rset.getString(7));
     timol.setFinKae(finKae);
     FinTimolDAO timolDAO = new FinTimolDAO();
     int check = timolDAO.checkTimol(timol.getArtimol(), timol.getDateoftimol(), timol.getAfm()).size();
     if (check>0){
     timol.setSelected(true);
     } else {		    		
     timol.setSelected(false);
     }
		    	
		    	
     retVal.add(timol);
     }		    		        	
     } catch (Exception e) {
     SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
     sessionBean.setErrorMsgKey("errMsg_GeneralError");
     FacesUtils.redirectWithNavigationID("error");
     AppUtil.goError(e, logger, sessionBean);
     } finally {
     try { 
     rset.close(); 
     } catch (Exception ignore) {          	
     }            
     try {
     stmt.close(); 
     } catch (Exception ignore) {          	
     }     	                                                   
     try {
     conn.close(); 
     } catch (Exception ignore) {          	
     }                    
     }   	
	  
     return retVal;
		
     }
    
    
    
     public static Object[] getTimolsFromCteam(String finKae, String fromDate, String toDate, String afm){    	
     String kae = null;
     if (finKae!=null)
     kae = finKae;
    	
     Connection conn = null;
     Statement stmt = null;
     ResultSet rset = null;	    
     Object[] retVal = new Object[3];
	    
     try {
     String sql = " SELECT  a.supplier_date, b.poso, e.afm, e.eponimia, a.code_parast, b.CODEPROYP, " +
     " a.supplier_ref "+
     " FROM shdl_parastatika_master a, " +
     " shdl_parastatika_detail b, " +
     " shdl_synalassomenoi e " +
     " WHERE a.record_sn = b.master_record_sn " +
     " AND a.suppliersn = e.record_sn " +
     (fromDate!=null ? " and a.supplier_date>='"+fromDate+"' " : " ") +
     (toDate!=null ? " and a.supplier_date<='"+toDate+"' " : " ") +			
     (kae!=null ? " and b.CODEPROYP like '"+kae+"%' " : " " ) +
     (afm!=null ? " and e.afm like '"+afm+"%' " : " " ) +
     " order by e.eponimia " ;
						
     conn = getConnection();
     if (conn==null) 
     throw new Exception("No Connection from CTEAM App");
     stmt = conn.createStatement();
     rset = stmt.executeQuery(sql);
		    
     double amount = 0;
     int counter = 0;
     int inserted = 0;
		    
     EntityManager em = EntityManagerHelper.getEntityManager();
     //FinDesm desm = em.find(FinDesm.class, new Double(211));
     //EntityManagerHelper.beginTransaction();
		    
     List<FinTimol> list = new ArrayList<FinTimol>(0);
     while (rset.next()) {
     FinTimol timol = new FinTimol();		    	
     timol.setAfm(rset.getString(3));
     timol.setSupname(rset.getString(4));
     timol.setAmount(new Double(rset.getString(2)));
     timol.setDateoftimol(AppUtil.formatDateToTimestamp(rset.getDate(1)));		    	
     timol.setArtimol(rset.getString(7));
		    	
     //timol.setFinDesm(desm);
     //timol.setFinKae(desm.getFinKae());
     //timol.setFinYear(desm.getFinYear());
		    	
     timol.setCover(new Double(0));
     timol.setForeas(em.find(Foreas.class, new Double(1)));
     timol.setFinEidosPist(em.find(FinEidosPist.class, new Double(1)));
		    	
     SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
     timol.setHospital(sessionBean.getUsers().getHospital());
		    	
     //timol.setFinKae(finKae);
     FinTimolDAO timolDAO = new FinTimolDAO();
     int check = timolDAO.checkTimol(timol.getArtimol(), timol.getDateoftimol(), timol.getAfm()).size();
     if (check>0){
     inserted+=1;
     timol.setSelected(true);
     } else {
     amount+=timol.getAmount().doubleValue();
     counter+=1;
		    		
     //em.persist(timol);
		    		
     timol.setSelected(false);
     }		    	
     list.add(timol);
     }	
		    
     // EntityManagerHelper.commit();		    
		    
		    
     //System.out.println("Total amount for KAE="+kae+" is ="+amount+" for "+counter+" timols!!!(Already inserted="+inserted+")");
		    
     retVal[0] = counter;
     retVal[1] = amount;
     retVal[2] = list;
		    
     } catch (Exception e) {
     SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
     sessionBean.setErrorMsgKey("errMsg_GeneralError");
     FacesUtils.redirectWithNavigationID("error");
     AppUtil.goError(e, logger, sessionBean);
     } finally {
     try { 
     rset.close(); 
     } catch (Exception ignore) {          	
     }            
     try {
     stmt.close(); 
     } catch (Exception ignore) {          	
     }     	                                                   
     try {
     conn.close(); 
     } catch (Exception ignore) {
          	
     }                    
     }   	
	  
		
     return retVal;
		
     }
    
    
    
    
     public static Connection getConnectionXE() throws Exception {    	
     try {
     Class.forName ("oracle.jdbc.driver.OracleDriver");
     Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hospital", "jijikos");
     return conn;
     } catch (Exception e) {			
     SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
     sessionBean.setErrorMsgKey("errMsg_GeneralError");
     FacesUtils.redirectWithNavigationID("error");
     AppUtil.goError(e, logger, sessionBean);
     throw e;
     }
     }
    
     public static Connection getParamConnectionXE(String ip, String sid, String port, String user, String pass) throws Exception {    	
     try {
     Class.forName ("oracle.jdbc.driver.OracleDriver");
     Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":"+port+":"+sid+"", user, pass);
     return conn;
     } catch (Exception e) {			
     SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
     sessionBean.setErrorMsgKey("errMsg_GeneralError");
     FacesUtils.redirectWithNavigationID("error");
     AppUtil.goError(e, logger, sessionBean);
     throw e;
     }
     }
    
     public static Boolean getDrugQuantityFromCteam(String code, String date){
     Boolean retVal = true; 
    	
     String sql = " SELECT " + 
     //    	"  c.codikos_eidous, c.record_sn AS eidos_record_sn, " +
     //    	"  c.perigrafh_eidous, c.omada_eidous AS eidos_omada_record_sn, " +
     //    	"  e.perigrafi AS apothiki, d.apothiki_record_sn, " +
     //    	"  a.user_date_registration, h.NAME AS eidosomada, " +
     "  NVL (SUM (  (  b.posothta " +
     "               * (b.flg_incposeis - b.flg_decposeis) " +
     "               * (  b.flg_agores " +
     "                  + b.flg_destroy " +
     "                  + b.flg_apografh " +
     "                  + b.flg_analosh " +
     "                 )  " +
     "              ) " +
     "            - (  b.posothta  " +
     "               * (b.flg_incposexa - b.flg_decposexa) " +
     "               * (b.flg_analosh + b.flg_destroy + b.flg_polhseis) " +
     "              ) " +
     "           ), " +
     "       0 " +
     "      ) AS posothta " +
     " FROM sh_parastatika_kinhseis_master a, " +
     "  sh_parastatika_kinhseis_detail b, " +
     "  sh_eidh c, " +
     "  sh_eidh_details d,   " +          
     "  sh_apothikes e, " +
     "  sh_hierarchy h " +
     " WHERE e.record_sn = 250 " +
     // " AND a.USER_DATE_REGISTRATION>='"+date +"'  " +
     " AND a.record_sn = b.master_record_sn " +
     " AND b.eidos_sn = d.record_sn " +
     " AND c.in_use = 1 " +
     " AND c.FARMAKO = 1 " +
     " AND c.CODIKOS_EIDOUS = '"+code+"' " + 
     " AND c.record_sn = d.eidh_record_sn " +
     " AND d.apothiki_record_sn = e.record_sn " +
     " AND c.omada_eidous = h.record_sn " +
     " AND (   (b.flg_incposeis = 1) " +
     " OR (b.flg_decposeis = 1) " +
     " OR (b.flg_incposexa = 1) " +
     " OR (b.flg_decposexa = 1) " +
     " ) " +
     " GROUP BY d.apothiki_record_sn, " +
     " e.perigrafi, " +
     " c.codikos_eidous, " +
     " c.record_sn, " +
     " c.perigrafh_eidous, " +
     " c.omada_eidous, " +
     " h.NAME, " +
     " a.user_date_registration " +         
     " ORDER BY a.user_date_registration DESC "; 
    	
     Connection conn = null;
     Statement stmt = null;
     ResultSet rset = null;
     try {
     conn = getConnection();
     stmt = conn.createStatement();               
     rset = stmt.executeQuery(sql);
          
     rset.next();
     if (rset==null|| rset.getDouble(1)<=0) {
     retVal = false;
     }
                   
          
     //          while (rset.next())
     //                System.out.println (rset.getString(1));   
     } catch (Exception e) {
     logger.error("Error on fetcing drug quantity from cteam ", e);
     e.printStackTrace();
     } finally {
     try { 
     rset.close(); 
     } catch (Exception ignore) {
     ignore.printStackTrace();
     }            
     try {
     stmt.close(); 
     } catch (Exception ignore) {
     ignore.printStackTrace();
     }     	                                                   
     try {
     conn.close(); 
     } catch (Exception ignore) {
     ignore.printStackTrace();
     }                    
     }
    
     return retVal;    	
     }  
    
     public static Integer fetchDesmCounter(Hospital hospital, FinYear year, FinKae kae, Foreas foreas){    	
     FinDesmDAO desmDAO = new FinDesmDAO();    	 
     return desmDAO.fetchDesmCounter(hospital, year, kae, foreas);
     }
    
     public static SelectItem[] foreasItems(Hospital hospital){
     List<Foreas> foreis = new HospitalDAO().findForeis(hospital);            	    	    	    	    	
     SelectItem[] selectedForeisItems = new SelectItem[foreis.size()];
     if (foreis!= null) {		    		    
     for (int i = 0; i < foreis.size(); i++) {		    		
     SelectItem selectItem = new SelectItem( foreis.get(i).getForeasid()  ,foreis.get(i).getName());
     selectedForeisItems[i] = selectItem;	    		
     }			   			    
     }
     return selectedForeisItems;
     }
    
    
     public static SelectItem[] departmentItems(Hospital hospital, Department department){
     List<Department> departments = new ArrayList<Department>(hospital.getDepartments());
            	
     SelectItem[] selectedDepartmentItems = null;
     if (departments.size()>1 && department!=null){
     selectedDepartmentItems = new SelectItem[departments.size()-1];
     } else if (departments.size()<=1 && department!=null){
     return null;
     } else if(department==null){
     selectedDepartmentItems = new SelectItem[departments.size()];
     }
    	
    	    	
     if (departments!= null) {		    
     int j=0;
     for (int i = 0; i < departments.size(); i++) {
     if (!departments.get(i).getDepartmentid().equals(department.getDepartmentid())) {		    				    		
     SelectItem selectItem = new SelectItem(departments.get(i).getDepartmentid(),departments.get(i).getName());
     selectedDepartmentItems[j] = selectItem;
     j++;
     }
     }			   			    
     }
     return selectedDepartmentItems;
     }
    
     */
}
