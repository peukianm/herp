/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.eopyy;

import com.hosp.util.FormatUtils;
import com.hosp.util.MessageBundleLoader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author peukianm
 */
public class ClosedHL7 {
    
    
    
    public StringWriter createHL7File(AdmissionTemp admission)
    {        
        try  {
        
            StringWriter stringWriter = new StringWriter();
            BufferedWriter bw = new BufferedWriter(stringWriter);

            int mshCounter = 1;

            // FHS|^~\\&|||||||HOSP1||I
            String FHS = "FHS|^~\\&|||||||HOSP1||I";
            bw.write(FHS);
            bw.newLine();

            // BHS|^~\&|||||201204~201204
            String BHS1 = (new StringBuilder()).append("BHS|^~\\&|||||").append(admission.getFromYear()).append(admission.getFromMonth()).append(admission.getToYear()).append(admission.getToMonth()).toString();
            bw.write(BHS1);
            bw.newLine();                           


            // INVOICES!!!!!!!!!!!!!!
            List<InvoiceTemp> invoices = admission.getInvoices();
            String countInvoices =   Integer.toString(invoices.size());        
            for (int idx1 = 0; idx1 < invoices.size(); idx1++) {
                InvoiceTemp invoiceTemp = invoices.get(idx1);

                // MSH|^~\&|||||||ZHC^Z03^ZHC_Z03|MSGID00001|P|2.6
                String MHS = (new StringBuilder()).append("MSH|^~\\&|||||||ZHC^Z03^ZHC_Z03|MSGID").append(FormatUtils.giveLeadingZeroes(Integer.toString(mshCounter), 5)).append("|P|2.6").toString();
                bw.write(MHS);
                bw.newLine();
                mshCounter++;

                // IVC|11101110||5967|OR|NORM|SU|20120202|||ΠΡΩΤΟΒΑΘΜΙΑ ΙΑΤΡΙΚΗ ΑΕ^^^^^^^^^10000|ΕΟΠΥΥ||||||||||12.12|10.27|4.04||||999397355 1159
                String IVC= (new StringBuilder()).append("IVC|").append(invoiceTemp.getInvoiceNumber()).append("||").append(admission.getContractNumber()).append("|OR|")
                        .append(admission.getAdmissionType()).append(invoiceTemp.getInvoiceType()+"|").append(FormatUtils.constructDateFieldForHL7(invoiceTemp.getInvoiceDate())+"|")
                        .append("||").append(admission.getHospital().getName()).append("^^^^^^^^^").append(admission.getHospital().getDapycode()).append("|ΕΟΠΥΥ")
                        .append("||||||||||").append( FormatUtils.constructFloatFieldForHL7(invoiceTemp.getTotalAmount())).append(FormatUtils.constructFloatFieldForHL7(invoiceTemp.getNetAmount()))
                        .append(FormatUtils.constructFloatFieldForHL7(invoiceTemp.getVatAmount())).append(admission.getHospital().getAfm()+" "+admission.getHospital().getDoy()).toString()          ;
                System.out.println(IVC);
                bw.write(IVC);
                bw.newLine();
            }        

            // BTS|2||3600.20
            String BTS = (new StringBuilder()).append("BTS|").append(countInvoices).append("||").append(admission.getTotaldAmount()).toString();
            bw.write(BTS);
            bw.newLine();

            // BHS|^~\&|||||201204~201204
            String BHS2 = (new StringBuilder()).append("BHS|^~\\&|||||").append(admission.getFromYear()+admission.getFromMonth()+"~"+admission.getToYear()+admission.getToMonth()).toString();
            bw.write(BHS2);
            bw.newLine();
            
            
            // DISCHARGES !!!!!!!!!!!!!!
            List<DischargeTemp> discharges = admission.getDischarges();
            String countDischarges =   Integer.toString(discharges.size());        
            for (int idx2 = 0; idx2 < discharges.size(); idx2++) {            
                DischargeTemp discharge = discharges.get(idx2);
                
                // MSH|^~\&|||||||ZHC^Z04^ZHC_Z04|MSGID00003|P|2.6
                String MHS = (new StringBuilder()).append("MSH|^~\\&|||||||ZHC^Z04^ZHC_Z04|MSGID").append(FormatUtils.giveLeadingZeroes(Integer.toString(mshCounter), 5)).append("|P|2.6").toString();
                mshCounter++;
                bw.write(MHS);
                bw.newLine();
               
                // PSG|11111|201210111022|12211111|200807011144||Y||1
                String PSG =  (new StringBuilder()).append("MSH|").append(discharge.getAdmissionNumber()+"|").append(FormatUtils.constructDateFieldForHL7(discharge.getAdmissionDate().toString())).append(discharge.getAdmissionTime()+"|")
                              .append(discharge.getDischargeNumber()+"|").append(FormatUtils.constructDateFieldForHL7(discharge.getDischargeDate().toString())).append(discharge.getDischargeTime()).append("||Y||").append(discharge.getDischargeType()).toString();            
                bw.write(PSG);
                bw.newLine();
            
              //  ZSG||20110303||||||||||||US|J.013||||7774477|8855888|995599999
                String ZSG = (new StringBuilder()).append("ZSG||").append(discharge.getAprovalDate()+"|").append("|||||||||||").append(discharge.getCountryCode()+"|").append(discharge.getChronicalDiseaseCode()+"|")
                             .append("||||").append(discharge.getEadmissionNumber()+"|").append(discharge.getEdischargeNumber()+"|").append(discharge.getDoctorAFM()).toString();
                bw.write(ZSG);
                bw.newLine();
                
                //PID||111|111^^^^ΦΟΡΕΑΣ~111111^^^^ΑΜΑ~Τ 1111^^^^ΑΔΤ~119999111^^^^ΑΦΜ||ΠΑΠΣΡΟΥ^ΝΙΚΑΟΣ^ΓΕΩΙΟΣΜΑΡ||19651014|3|||^ΠΕΤΣ^78^^ΑΘΗΝ^ΑΤΤΗ^12211|||2101118811|||||02010101010|||||||||0|20001112|1
                String PID = (new StringBuilder()).append("PID||").append(discharge.getPatientOPSNID()).append("|").append(discharge.getPatientID()).append("||").append(discharge.getPatientName()).append("||")
                             .append(FormatUtils.constructDateFieldForHL7(discharge.getPatientDateOfBirth())).append("||||").append(discharge.getPatientAddress())
                             .append("|||").append(discharge.getPatientPhone()).append("|||||").append(discharge.getPatientAMKA()).append("|||||||||").append(discharge.getPatientInsuranceOrigin())
                             .append("|").append(FormatUtils.constructDateFieldForHL7(discharge.getPatientDateOfDeath())).toString();        
            
                bw.write(PID);
                bw.newLine(); 
                
                
                // PV1|I|||||55244678914^ΠΕΤΡΣ^ΕΜΜΑΗΛ||||||||B6|||1||1
                String PV1 = (new StringBuilder()).append("PV1|").append(discharge.getTreatmentType()).append("|||||").append(discharge.getTreamentDoctor()).append("||||||||")
                             .append(discharge.getAdmissionCause()).append("|||").append(discharge.getPatientDirectInsurance()).append("||").append(discharge.getAdmissionPossition()).toString();
            
                bw.write(PV1);
                bw.newLine();
            
                // PV2||||||||||||||||||||||||||||||||||||||||||D
                String PV2 = (new StringBuilder()).append("PV2||||||||||||||||||||||||||||||||||||||||||").append(discharge.getAdmissionOutcome()).toString();
                bw.write(PV2);
                bw.newLine();
            
                //admission diagnoses
                List<DiagnoseTemp> admissionDiagnoses = discharge.getAdmitDiagnoses();
                if (admissionDiagnoses != null) {
                    for (int i = 0; i < admissionDiagnoses.size(); i++) {
                        DiagnoseTemp diagnoseTemp = admissionDiagnoses.get(i);
                        
                        //DG1|001|ICD-10|J43.11|ASTHMA^I10||A
                        String DG1 = (new StringBuilder()).append("DG1|").append(diagnoseTemp.getCodeOPSN()).append("|ICD-10|").append(diagnoseTemp.getCode()).append("|") 
                                      .append(diagnoseTemp.getDescrption()).append("||A").toString();
                         bw.write(DG1);
                         bw.newLine();                         
                    }                
                }
                    
                
                //admission diagnoses
                List<DiagnoseTemp> dischargeDiagnoses = discharge.getDischargeDiagnoses();
                if (dischargeDiagnoses != null) {
                    for (int k = 0; k < dischargeDiagnoses.size(); k++) {
                        DiagnoseTemp temp = dischargeDiagnoses.get(k);
                        
                        //DG1|001|ICD-10|J43.11|ASTHMA^I10||A
                        String DG1 = (new StringBuilder()).append("DG1|").append(temp.getCodeOPSN()).append("|ICD-10|").append(temp.getCode()).append("|") 
                                      .append(temp.getDescrption()).append("||D").toString();
                        bw.write(DG1);
                        bw.newLine();                         
                    }                
                }
                
                
                // CHARGES!!!!!!!
                List<ChargeTemp> charges = discharge.getCharges();
                if (charges != null) {
                    for (int counter = 0; counter < charges.size(); counter++) {
                        ChargeTemp charge = charges.get(counter);
                        
                        // PSL|||1||||10^390000014|3||201101011111|201112022233|1||0|400.00|30.33||1|||NO||||||11||12242697852^ΣΟΦ^ΑΘΑΝΑΣΙΟΣ|55244678914^ΚΗΣ^ΕΜΜΑΝΟΥΗΛ
                        String PSL = (new StringBuilder()).append("PSL|||").append(counter).append("||||").append(charge.getChargeCode()).append("|").append(charge.getChargeType())
                                     .append("||").append(FormatUtils.constructDateFieldForHL7(charge.getAdmissionDate())).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getDischargeDate())).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getPercentageConsumption()))
                                      .append("||").append(charge.getDailyDosage()).append(FormatUtils.constructFloatFieldForHL7(charge.getNetChargeAmount())).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getChargeAmount())).append("||")
                                      .append(charge.getField18()).append("|||NO|").append(charge.getField22()).append("||||||||").append(charge.getPrescriptionDoctor()).toString();
                       bw.write(PSL);
                       bw.newLine();
                       
                       
                       // ZSL|20121101|20090411|||2|3|1100.11|777.77|5.50|450.2|17.4||123456789|987654321|16.00|0.20||444444444
                       String ZSL = (new StringBuilder()).append("ZSL|").append(FormatUtils.constructDateFieldForHL7(charge.getStartPrescriptionDate())).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getEndPrescriptionDate())).append("|||")
                                    .append(charge.getTreatmentSector()).append("|").append(charge.getTreatmentPosition()).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getSupplierPercentage())).append("|")
                                    .append(FormatUtils.constructDateFieldForHL7(charge.getSupplierAmount())).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getPatientPercentage())).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getPatientAmount()))
                                    .append("|").append(charge.getVAT()).append("||").append(charge.getControlerDoctorAFM()).append("|").append(charge.getReceiptDostorAFM())
                                    .append("|").append(FormatUtils.constructDateFieldForHL7(charge.getSupplierDiscountPercentage())).append("|").append(FormatUtils.constructDateFieldForHL7(charge.getSupplierDiscountAmount())).append("|")
                                    .append(charge.getLaparaskopiki()).append("|").append(charge.getSupplierAFM()).toString();
                       bw.write(ZSL);
                       bw.newLine();                                                                
                    }                
                }
            }
            
            bw.flush();
            bw.close();
            
            return stringWriter;
            
        }     
        catch(Exception e)  {
            e.printStackTrace();
            return null;
        }        
    }
    
    
    
    
    
}
