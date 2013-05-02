/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.util;

import com.hosp.entities.ExExam;
import com.hosp.entities.ExPara;
import com.hosp.entities.ExParaExams;
import com.hosp.entities.ExTimol;
import com.hosp.entities.Patients;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author peukianm
 */
public class CheckUtil {

    public static Boolean checkAmka(String amka) {
        if (amka != null) {
            Pattern p = Pattern.compile("(\\d){11}");
            Matcher m = p.matcher(amka);
            if (!m.matches()) {
                return false;
            } else {
                return true;
            }
        }

        return true;
    }

    public static boolean checkPatient(Patients patient) {
        Boolean retValue = true;
        try {
            if (!Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,40}", patient.getSurname())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("surname") + ":" + MessageBundleLoader.getMessage("surnameCheck"));
                retValue = false;
            }

            if (!Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,20}", patient.getName())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("name") + ":" + MessageBundleLoader.getMessage("nameCheck"));
                retValue = false;
            }

            if (!Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,20}", patient.getFathername())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("fatherName") + ":" + MessageBundleLoader.getMessage("nameCheck"));
                retValue = false;
            }
//             if (!Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,20}", patient.getAmka())) {
//                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("amka") + ":" + MessageBundleLoader.getMessage("amkaCheck"));
//                retValue = false;
//            }


            return retValue;
        } catch (Exception ex) {
            ex.printStackTrace();
            return retValue;
        }
    }

    public static boolean checkPara(ExPara para) {
        Boolean retValue = true;
        try {
            if (para.getCdoctorsurname() != null && !Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,40}", para.getCdoctorsurname())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("doctorSurname") + ":" + MessageBundleLoader.getMessage("surnameCheck"));
                retValue = false;
            }

            if (!Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,40}", para.getDoctorsurname())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("doctorSurname") + ":" + MessageBundleLoader.getMessage("surnameCheck"));
                retValue = false;
            }


            if (!Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,20}", para.getDoctorname())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("doctorName") + ":" + MessageBundleLoader.getMessage("nameCheck"));
                retValue = false;
            }

            if (para.getCdoctorname() != null && !Pattern.matches("[\u0391-\u03A9\\-/A-Z ]{1,20}", para.getCdoctorname())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("doctorName") + ":" + MessageBundleLoader.getMessage("nameCheck"));
                retValue = false;
            }

            if (para.getCodctorcode() != null && !Pattern.matches("[0-9\\-]{1,15}", para.getCodctorcode())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("tsayAprovalCodeDoctor") + ":" + MessageBundleLoader.getMessage("doctorCodeCheck"));
                retValue = false;
            }


            if (!Pattern.matches("[0-9\\-]{1,15}", para.getDoctorcode())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("tsayRecipeCodeDoctor") + ":" + MessageBundleLoader.getMessage("doctorCodeCheck"));
                retValue = false;
            }



            if (para.getIssuedate().compareTo(new Date()) > 0) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("issueDate") + ":" + MessageBundleLoader.getMessage("issueDateCheck"));
                retValue = false;
            }

            if (para.getApprovaldate() != null && para.getApprovaldate().compareTo(new Date()) > 0) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("approvalDate") + ":" + MessageBundleLoader.getMessage("approvalDateCheck"));
                retValue = false;
            }

            if (para.getExecutiondate().compareTo(new Date()) > 0) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("exeDate") + ":" + MessageBundleLoader.getMessage("executionDateCheck"));
                retValue = false;
            }

            if (para.getExParaExamses().size() > 99) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("paraExamsCountCheck"));
                retValue = false;
            }
                        
            if (FormatUtils.subtractDate(para.getApprovaldate(), para.getExecutiondate())<0 || FormatUtils.subtractDate(para.getApprovaldate(), para.getExecutiondate())>30 ) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("invalidApprovalDate"));
                retValue = false;
                
            }


            if (FormatUtils.getMonth(para.getExecutiondate()) != Integer.parseInt(para.getExAssertion().getExPeriod().getExMonth().getName())
                    || FormatUtils.getYear(para.getExecutiondate()) != Integer.parseInt(para.getExAssertion().getExPeriod().getExYear().getName())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("invalidExecutionDate"));
                retValue = false;
            }
            return retValue;

        } catch (Exception ex) {
            ex.printStackTrace();
            return retValue;
        }
        // "[0-9\u0391-\u03A9.:=\\-()/,A-Z ]{1,100}"


        // "[0-9]{1,12}"
        //     "[\u0391-\u03A9\\-/A-Z ]{1,50}"

    }

    public boolean checkForDuplicate(ArrayList list) {
        HashSet set = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            boolean val = set.add(list.get(i));
            if (!val) {
                return val;
            }
        }

        return true;
    }

    public static Boolean checkTimol(ExTimol timol) {
        Boolean retValue = true;
        try {
            if (timol.getTimoldate().compareTo(new Date()) > 0) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("invoiceDate") + ":" + MessageBundleLoader.getMessage("timolDateCheck"));
                retValue = false;
            }

            if (!Pattern.matches("[0-9\u0391-\u03A9.:=\\-()/,A-Z ]{1,15}", timol.getCode())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("invoiceNumber") + ":" + MessageBundleLoader.getMessage("timolNumberCheck"));
                retValue = false;
            }
            return retValue;
        } catch (Exception ex) {
            ex.printStackTrace();
            return retValue;
        }
    }

    public static boolean checkForDuplicateTimolNumber(List<ExTimol> list, ExTimol timol) {
        for (int i = 0; i < list.size(); i++) {
            if (timol.getCode().trim().equals(list.get(i).getCode().trim())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("invoiceNumber") + ":" + MessageBundleLoader.getMessage("duplicateTimolCheck"));
                return false;
            }
        }

        return true;
    }

    public static boolean checkForDuplicateParaExams(List<ExParaExams> list, ExParaExams paraExam) {
        for (int i = 0; i < list.size(); i++) {
            if (paraExam.getExExam().getExamid().equals(list.get(i).getExExam().getExamid())) {
                //FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("exam") + ":" + MessageBundleLoader.getMessage("duplicateExamsCheck"));
                return false;
            }
        }

        return true;
    }

    public static boolean checkForDuplicateParaExams(List<ExParaExams> list, ExExam exam) {
        for (int i = 0; i < list.size(); i++) {
            if (exam.getExamid().equals(list.get(i).getExExam().getExamid())) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("exam") + ":" + MessageBundleLoader.getMessage("duplicateExamsCheck"));
                return false;
            }
        }

        return true;
    }

    public ArrayList checkForDuplicateRows(ArrayList list) {
        ArrayList duplicates = new ArrayList();
        HashSet set = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            boolean val = set.add(list.get(i));
            if (!val && !duplicates.contains(list.get(i))) {
                duplicates.add(list.get(i));
            }
        }

        return duplicates;
    }
}
