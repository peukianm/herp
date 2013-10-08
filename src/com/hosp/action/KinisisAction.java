/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosp.action;

import com.hosp.bean.ErrorBean;
import com.hosp.bean.ErrorFile;
import com.hosp.bean.KinisisAdmissionBean;
import com.hosp.bean.SessionBean;
import com.hosp.eopyy.AdmissionTemp;
import com.hosp.eopyy.ChargeTemp;
import com.hosp.eopyy.DiagnoseTemp;
import com.hosp.eopyy.DischargeTemp;
import com.hosp.util.CheckUtil;
import com.hosp.util.FacesUtils;
import com.hosp.util.MessageBundleLoader;
import com.hosp.util.PersistenceUtil;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author peukianm
 */
public class KinisisAction implements Serializable {
    
    private static final Logger logger = Logger.getLogger(KinisisAction.class);
    private SessionBean sessionBean = (SessionBean) FacesUtils.getManagedBean("sessionBean");
    @EJB
    private PersistenceUtil persistenceUtil;

    public void fetchOPSNData() {
        try {

            System.out.println("START FETCHING FROM OPSN");
            Connection connection = persistenceUtil.getConnection();
            System.out.println("Connection="+connection);
            if (connection == null) {
                FacesUtils.addErrorMessage(MessageBundleLoader.getMessage("noConnectionWithOPSN"));
                //FacesUtils.updateHTMLComponnetWIthJS("contractMsg");
            } else {

                KinisisAdmissionBean kinisisAdmissionBean = (KinisisAdmissionBean) FacesUtils.getManagedBean("kinisisAdmissionBean");

                String sql = persistenceUtil.getReportDataSQL2(kinisisAdmissionBean.getOpsnListNumber());


                Statement stmt = null;
                ResultSet rset = null;

                stmt = connection.createStatement();
                System.out.println(sql);
                rset = stmt.executeQuery(sql);

                AdmissionTemp admissionTemp = new AdmissionTemp();
                admissionTemp.setAdmissionType(kinisisAdmissionBean.getAdmissionType()); // TYPOS REPORT KANONIKI H SYMPLHRVMATIKI
                admissionTemp.setContractNumber(kinisisAdmissionBean.getContractNumber());
                admissionTemp.setHospital(sessionBean.getUsers().getHospital());
                admissionTemp.setFromMonth(kinisisAdmissionBean.getMonth());
                admissionTemp.setFromYear(kinisisAdmissionBean.getYear());
                admissionTemp.setSubmissionType(kinisisAdmissionBean.getSubmissionType()); //TYPOS YPOBOLHS MANUAL OR ELECTRONICA:


                String currentAdmID = "";
                int admissionCounter = 0;
                float admissionAmount = 0;
                float dischargeAmount = 0;

                List<DischargeTemp> discharges = new ArrayList<DischargeTemp>();
                DischargeTemp dischargeTemp = new DischargeTemp();
                List<ChargeTemp> charges = new ArrayList<ChargeTemp>();
                List<ErrorFile> errors = new ArrayList<ErrorFile>();
                while (rset.next()) {
                    String admissionID = rset.getString(21);
                    String typeOfSubmission = "1";                    
                    if (!admissionID.equals(currentAdmID)) {
                        if (!currentAdmID.equals("")) {
                            dischargeTemp.setDischargeAmount(new Float(dischargeAmount));
                            discharges.add(dischargeTemp);
                            dischargeAmount = 0;
                        }
                        admissionCounter++;
                        currentAdmID = admissionID;
                        admissionAmount = 0;
                        dischargeTemp = new DischargeTemp();
                        charges = new ArrayList<ChargeTemp>();
                        dischargeTemp.setCharges(charges);
                        // dischargeTemp.setAdmissionCaudee();  optional PINAKAS 00001

                        //System.out.println("ADMISSION DATE=" + rset.getString(24));

                        if (rset.getString(24) != null && !rset.getString(24).equals("")) {
                            dischargeTemp.setAdmissionDate(rset.getDate(24));
                        } else {
                            dischargeTemp.getErrorCode().add("1000");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1000");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1000"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }


                        if (rset.getString(22) != null && !rset.getString(22).equals("")) {
                            dischargeTemp.setAdmissionNumber(rset.getString(22)); //AM ADMISSION 
                        } else {
                            dischargeTemp.getErrorCode().add("1001");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1001");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1001"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }

                        if (rset.getString(26) != null && !rset.getString(26).equals("")) {
                            dischargeTemp.setAdmissionOutcome(rset.getString(26));  // EKVASI      
                        } else {
                            dischargeTemp.getErrorCode().add("1002");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1002");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1002"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }



                        /**
                         *
                         * TODO DIKAIOYMENH UESH NOSHLEIAS 1-Γ, 2-ΒΓ
                         */
                        dischargeTemp.setAdmissionPossition(rset.getString(43));  //SEAT PINAKAS 14

                        dischargeTemp.setAdmissionTime("0900"); //SETT THE ADMISSION TIME
                        dischargeTemp.setDischargeTime("1400");

                        //dischargeTemp.setAdmitDiagnoses(); OPTIONAL NOT SET
                        //dischargeTemp.setAprovalDate(); OPTIONAL

                        //dischargeTemp.setChronicalDiseaseCode(); //OPTIONAL    !!!!!!
                        //dischargeTemp.setCountryCode(currentAdmID); SET TO GR BY DEFAULT


                        if (rset.getString(25) != null && !rset.getString(25).equals("")) {
                            dischargeTemp.setDischargeDate(rset.getDate(25));
                        } else {
                            dischargeTemp.getErrorCode().add("1003");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1003");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1003"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }



                        dischargeTemp.setDischargeNumber(rset.getString(22)); // SAME AS ADMISSION OPSN NUMBER


                        if (rset.getString(23) != null && !rset.getString(23).trim().equals("")) {//checking notes    
                            dischargeTemp.setDischargeType("1"); // electronic or manual announcment default 1 (electronic)
                            typeOfSubmission = "1";
                            String notes = rset.getString(23);
                            String[] edata = notes.split("-");
                            if (edata.length == 2) {
                                for (int ii = 0; ii < edata.length; ii++) {
                                    if (ii == 0) {
                                        dischargeTemp.setEadmissionNumber(edata[ii]);
                                    }
                                    if (ii == 1) {
                                        dischargeTemp.setEdischargeNumber(edata[ii]);
                                    }
                                }
                            } else {
                                dischargeTemp.getErrorCode().add("1004");
                                ErrorFile errorFile = new ErrorFile();
                                errorFile.setErrorCode("1004");
                                errorFile.setErrorMsg(MessageBundleLoader.getMessage("1004"));
                                errorFile.setAdmissionAM(rset.getString(22));
                                errorFile.setPatientAM(rset.getString(49));
                                errorFile.setType("1");
                                errorFile.setDischarge(dischargeTemp);
                                errors.add(errorFile);
                            }

                        } else {
                            dischargeTemp.setDischargeType("0");
                            typeOfSubmission = "0";
                        }

                        //dischargeTemp.setDoctorAFM(sql); PROAIRETIKO
                        //dischargeTemp.setEadmissionNumber(admissionID);
                        //dischargeTemp.setEdischargeNumber(admissionID);


                        if (rset.getString(6) != null && !rset.getString(6).equals("") && CheckUtil.checkAmka(rset.getString(6))) {
                            dischargeTemp.setPatientAMKA(rset.getString(6));
                        } else {
                            dischargeTemp.getErrorCode().add("1005");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1005");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1005"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }




                        String address = " ";
                        if (rset.getString(9) != null && !rset.getString(9).equals("")) {
                            address = rset.getString(9);
                        } else {
                            dischargeTemp.getErrorCode().add("1006");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1006");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1006"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }


                        String city = " ";
                        if (rset.getString(10) != null && !rset.getString(10).equals("")) {
                            city = rset.getString(10);
                        }


                        String TK = " ";
                        if (rset.getString(12) != null && !rset.getString(12).equals("")) {
                            TK = rset.getString(12);
                        }

                        String prefecture = " ";
                        if (rset.getString(48) != null && !rset.getString(48).equals("")) {
                            prefecture = rset.getString(48);
                        }

                        String edapyAddress = "^" + address + "^ ^" + city + "^" + prefecture+"^"+TK;
                        dischargeTemp.setPatientAddress(edapyAddress);

                        dischargeTemp.setPatientFirstName(rset.getString(2));
                        dischargeTemp.setPatientSurname(rset.getString(3));

                        if (rset.getString(5) != null && !rset.getString(5).equals("")) {
                            dischargeTemp.setPatientDateOfBirth(rset.getString(5));
                        } else {
                            dischargeTemp.getErrorCode().add("1007");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1007");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1007"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }



                        if (rset.getString(26) != null && rset.getString(26).equals("D")) {
                            dischargeTemp.setPatientDateOfDeath(rset.getString(25));
                        }



                        if (rset.getString(30) != null && !rset.getString(30).equals("")) {
                            dischargeTemp.setPatientDirectInsurance(rset.getString(30));
                        } else {
                            dischargeTemp.getErrorCode().add("1008");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1008");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1008"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }


                        //dischargeTemp.setPatientIDForeign(currentAdmID);  SETTING IF WE HAVE FOREIGNER

                        String AMA = "";
                        String insuranceID = rset.getString(47);
                        dischargeTemp.setPatientAMA(AMA);
                        String edapyInsurance = rset.getString(13);
                        dischargeTemp.setPatientInsurance(edapyInsurance);  
                        
                        if (insuranceID.equals("16")) {
                            AMA = rset.getString(19); //OGA BOOK
                        } else {
                            AMA = rset.getString(17); // OTHERS INSURANCES
                        }

                        
                        if (AMA==null || AMA.equals("")){
                            dischargeTemp.getErrorCode().add("1027");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1027");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1027"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }
                        
                        if (edapyInsurance==null || edapyInsurance.equals("")){
                            dischargeTemp.getErrorCode().add("1028");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1028");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1028"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }
                        
                        
                        String ID = AMA + "^^^^~" + edapyInsurance + "^^^^ΦΟΡΕΑΣ";

                        dischargeTemp.setPatientIDGreek(ID);


                        if (dischargeTemp.getCountryCode().equals("GR")) {
                            dischargeTemp.setPatientID(dischargeTemp.getPatientIDGreek()); //Setting Greek ID
                            dischargeTemp.setPatientInsuranceOrigin("0"); //Set to default 0 (greek origin) 1 to European origin
                        } else {
                            dischargeTemp.setPatientID(dischargeTemp.getPatientIDForeign()); //Setting Greek ID
                            dischargeTemp.setPatientInsuranceOrigin("1"); //Set to default 0 (greek origin) 1 to European origin
                        }
                        //dischargeTemp.setPatientInsuranceOrigin(admissionID); Set to default 0 (greek origin) 1 to European origin

                        dischargeTemp.setPatientOPSNID(rset.getString(1));


                        if (rset.getString(14) != null && !rset.getString(14).equals("") && rset.getString(14).length() <= 15) {
                            dischargeTemp.setPatientPhone(rset.getString(14));
                        } else {
                            dischargeTemp.setPatientPhone("0000000000");
                        }


                        if (rset.getString(26) != null && rset.getString(26).equals("D")) {
                            dischargeTemp.setPatientTypeOfDeath("1"); //1 before 2 during 3 after surgery
                        } else {
                            dischargeTemp.setPatientTypeOfDeath("0");
                        }




                        String doctorAMKA = rset.getString(46);

                        String doctorFirstName = rset.getString(44);
                        String doctorLastName = rset.getString(45);

                        if (doctorAMKA != null && !doctorAMKA.equals("")) {
                            if (doctorFirstName == null || doctorLastName.equals("")) {
                                doctorFirstName = " ";
                            }
                            if (doctorLastName == null || doctorLastName.equals("")) {
                                doctorLastName = " ";
                            }
                            dischargeTemp.setTreamentDoctor(doctorAMKA + "^" + doctorLastName + "^" + doctorFirstName);

                        } else {
                            dischargeTemp.getErrorCode().add("1009");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1009");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1009"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }

                        //dischargeTemp.setTreatmentType(currentAdmID); ///PINAKAS 0013

                        DiagnoseTemp diagnose = new DiagnoseTemp();


                        if (rset.getString(27) != null && !rset.getString(27).equals("")) {
                            diagnose.setCode(rset.getString(27));
                        } else {
                            dischargeTemp.getErrorCode().add("1020");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1020");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1020"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1");
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }
                        diagnose.setCodeOPSN("1"); //AYJVN ARIUMOS DIAGNWSIS


                        if (rset.getString(28) != null && !rset.getString(28).equals("")) {
                            diagnose.setDescrption(rset.getString(28));
                        } else {
                            dischargeTemp.getErrorCode().add("1021");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1021");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1021"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("1"); 
                            errorFile.setDischarge(dischargeTemp);
                            errors.add(errorFile);
                        }



                        diagnose.setDiagnoseType("D"); //A-ADMITTING    D-DISCHARGE                      
                        List diagnoses = new ArrayList(1);
                        diagnoses.add(diagnose);
                        dischargeTemp.setDischargeDiagnoses(diagnoses);

                    } // END NEW ADMISSION DATA


                    ChargeTemp charge = new ChargeTemp();


                    if (rset.getString(32) != null && !rset.getString(32).equals("")) {
                        charge.setAdmissionDate(rset.getString(32));
                    } else {
                        dischargeTemp.getErrorCode().add("1022");
                        ErrorFile errorFile = new ErrorFile();
                        errorFile.setErrorCode("1022");
                        errorFile.setErrorMsg(MessageBundleLoader.getMessage("1022"));
                        errorFile.setAdmissionAM(rset.getString(22));
                        errorFile.setPatientAM(rset.getString(49));
                        errorFile.setType("2");
                        errorFile.setDischarge(dischargeTemp);
                        errorFile.setChargeTemp(charge);
                        errors.add(errorFile);
                    }
                    if (rset.getString(33) != null && !rset.getString(33).equals("")) {
                        charge.setDischargeDate(rset.getString(33));
                    } else {
                        dischargeTemp.getErrorCode().add("1023");
                        ErrorFile errorFile = new ErrorFile();
                        errorFile.setErrorCode("1023");
                        errorFile.setErrorMsg(MessageBundleLoader.getMessage("1023"));
                        errorFile.setAdmissionAM(rset.getString(22));
                        errorFile.setPatientAM(rset.getString(49));
                        errorFile.setType("2");
                        errorFile.setDischarge(dischargeTemp);
                        errorFile.setChargeTemp(charge);
                        errors.add(errorFile);
                    }

                    if (rset.getString(39) != null && !rset.getString(39).equals("")) {
                        charge.setChargeAmount(rset.getString(39));
                        Float total = rset.getFloat(39);
                        admissionAmount = admissionAmount+total;
                        dischargeAmount = dischargeAmount+total;
                        System.out.println("TOTAL="+total);
                        
                        
                    } else {
                        dischargeTemp.getErrorCode().add("1024");
                        ErrorFile errorFile = new ErrorFile();
                        errorFile.setErrorCode("1024");
                        errorFile.setErrorMsg(MessageBundleLoader.getMessage("1024"));
                        errorFile.setAdmissionAM(rset.getString(22));
                        errorFile.setPatientAM(rset.getString(49));
                        errorFile.setType("2");
                        errorFile.setDischarge(dischargeTemp);
                        errorFile.setChargeTemp(charge);
                        errors.add(errorFile);
                    }

                    if (rset.getString(36) != null && !rset.getString(36).equals("")) {
                        charge.setNetChargeAmount(rset.getString(36));
                    } else {
                        dischargeTemp.getErrorCode().add("1025");
                        ErrorFile errorFile = new ErrorFile();
                        errorFile.setErrorCode("1025");
                        errorFile.setErrorMsg(MessageBundleLoader.getMessage("1025"));
                        errorFile.setAdmissionAM(rset.getString(22));
                        errorFile.setPatientAM(rset.getString(49));
                        errorFile.setType("2");
                        errorFile.setDischarge(dischargeTemp);
                        errorFile.setChargeTemp(charge);
                        errors.add(errorFile);
                    }

                    if (rset.getString(37) != null && !rset.getString(37).equals("")) {
                        charge.setVAT(rset.getString(37));
                    } else {
                        dischargeTemp.getErrorCode().add("1026");
                        ErrorFile errorFile = new ErrorFile();
                        errorFile.setErrorCode("1026");
                        errorFile.setErrorMsg(MessageBundleLoader.getMessage("1026"));
                        errorFile.setAdmissionAM(rset.getString(22));
                        errorFile.setPatientAM(rset.getString(49));
                        errorFile.setType("2");
                        errorFile.setDischarge(dischargeTemp);
                        errorFile.setChargeTemp(charge);
                        errors.add(errorFile);
                    }


                    charge.setPatientAmount("0");
                    charge.setPatientPercentage("0");
                    charge.setPercentageConsumption("0");



//                   charge.setSupplierAmount(admissionID);
//                   charge.setSupplierDiscountAmount(currentAdmID);
//                   charge.setSupplierDiscountPercentage(admissionID);
//                   charge.setSupplierPercentage(currentAdmID);
//                   charge.setSupplierAFM(sql);

                    //charge.setControlerDoctorAFM(currentAdmID);
                    //charge.setDailyDosage(admissionID);                   


                    String serviceID = rset.getString(31);
                    String chargeDescription = rset.getString(34);
                    String amkaReceipt;
                    String KEN = rset.getString(50);


                    //NOSHLEIA
                    if (serviceID.equals("1111")) {
                        charge.setChargeType("1");
                        if (chargeDescription == null || chargeDescription.equals("")) {
                            charge.getErrorCode().add("1011");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1011");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1011"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("2");
                            errorFile.setDischarge(dischargeTemp);
                            errorFile.setChargeTemp(charge);
                            errors.add(errorFile);
                        }

                        String nosilioCode = chargeDescription;
                        charge.setChargeCode("1^" + nosilioCode);
                        charge.setField22(nosilioCode);
                    } //FARMAKA    
                    else if (serviceID.equals("4111")) {
                        if (chargeDescription == null || chargeDescription.equals("")) {
                            charge.getErrorCode().add("1012");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1012");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1012"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("2");
                            errorFile.setDischarge(dischargeTemp);
                            errorFile.setChargeTemp(charge);
                            errors.add(errorFile);
                        } else {
                            String data[] = chargeDescription.split("-");
                            if (data.length != 2) {
                                charge.getErrorCode().add("1012");
                                ErrorFile errorFile = new ErrorFile();
                                errorFile.setErrorCode("1012");
                                errorFile.setErrorMsg(MessageBundleLoader.getMessage("1012"));
                                errorFile.setAdmissionAM(rset.getString(22));
                                errorFile.setPatientAM(rset.getString(49));
                                errorFile.setType("2");
                                errorFile.setDischarge(dischargeTemp);
                                errorFile.setChargeTemp(charge);
                                errors.add(errorFile);
                            } else {
                                charge.setChargeCode("2^" + data[0]);
                                amkaReceipt = data[1];


                                charge.setStartPrescriptionDate(rset.getString(24));
                                charge.setEndPrescriptionDate(rset.getString(25));
                                charge.setPrescriptionDoctor(amkaReceipt + "^ ^ ");

                                if (typeOfSubmission.equals("1")) {
                                    charge.setField18("1");
                                } else if (typeOfSubmission.equals("0")) {
                                    charge.setField18("2");
                                }


                                if (!CheckUtil.checkAmka(amkaReceipt)) {
                                    charge.getErrorCode().add("1013");
                                    ErrorFile errorFile = new ErrorFile();
                                    errorFile.setErrorCode("1013");
                                    errorFile.setErrorMsg(MessageBundleLoader.getMessage("1013"));
                                    errorFile.setAdmissionAM(rset.getString(22));
                                    errorFile.setPatientAM(rset.getString(49));
                                    errorFile.setType("2");
                                    errorFile.setDischarge(dischargeTemp);
                                    errorFile.setChargeTemp(charge);
                                    errors.add(errorFile);
                                }
                            }
                        }

                        charge.setChargeType("2");
                    } //EIDIKA UERAPEYTIKA MESA (YLIKA)
                    else if (serviceID.equals("5113")) {

                        if (chargeDescription == null || chargeDescription.equals("")) {
                            charge.getErrorCode().add("1014");
                            ErrorFile errorFile = new ErrorFile();
                            errorFile.setErrorCode("1014");
                            errorFile.setErrorMsg(MessageBundleLoader.getMessage("1014"));
                            errorFile.setAdmissionAM(rset.getString(22));
                            errorFile.setPatientAM(rset.getString(49));
                            errorFile.setType("2");
                            errorFile.setDischarge(dischargeTemp);
                            errorFile.setChargeTemp(charge);
                            errors.add(errorFile);
                        } else {
                            String data[] = chargeDescription.split("-");
                            if (data.length != 2) {
                                charge.getErrorCode().add("1014");
                                ErrorFile errorFile = new ErrorFile();
                                errorFile.setErrorCode("1014");
                                errorFile.setErrorMsg(MessageBundleLoader.getMessage("1014"));
                                errorFile.setAdmissionAM(rset.getString(22));
                                errorFile.setPatientAM(rset.getString(49));
                                errorFile.setType("2");
                                errorFile.setDischarge(dischargeTemp);
                                errorFile.setChargeTemp(charge);
                                errors.add(errorFile);
                            } else {
                                charge.setChargeCode("4^" + data[0]);
                                amkaReceipt = data[1];

                                charge.setField22(data[0]);
                                charge.setStartPrescriptionDate(rset.getString(24));
                                charge.setEndPrescriptionDate(rset.getString(25));
                                charge.setPrescriptionDoctor(amkaReceipt + "^ ^ ");

                                if (typeOfSubmission.equals("1")) {
                                    charge.setField18("1");
                                } else if (typeOfSubmission.equals("0")) {
                                    charge.setField18("2");
                                }



                                if (!CheckUtil.checkAmka(amkaReceipt)) {
                                    charge.getErrorCode().add("1013");
                                    ErrorFile errorFile = new ErrorFile();
                                    errorFile.setErrorCode("1013");
                                    errorFile.setErrorMsg(MessageBundleLoader.getMessage("1013"));
                                    errorFile.setAdmissionAM(rset.getString(22));
                                    errorFile.setPatientAM(rset.getString(49));
                                    errorFile.setType("2");
                                    errorFile.setDischarge(dischargeTemp);
                                    errorFile.setChargeTemp(charge);
                                    errors.add(errorFile);
                                }
                            }
                        }
                        charge.setChargeType("9");
                    } // (EJETASEIS) ΑΞΟΝΙΚΗ ΕΓΚΕΦΑΛΟΥ
                    else if (serviceID.equals("21812")) {

                        charge.setChargeType("9");
                    } // (EJETASEIS) ΑΞΟΝΙΚΗ 
                    else if (serviceID.equals("21811")) {

                        charge.setChargeType("9");
                    } // (EJETASEIS) ΜΑΓΝΙΤΙΚΗ
                    else if (serviceID.equals("21911")) {

                        charge.setChargeType("9");
                    } //KEN
                    else {
                        if (KEN == null || KEN.equals("")) {
                            charge.getErrorCode().add("1015");
                            charge.setField22(KEN);
                        } else {
                            charge.setChargeCode("6^" + KEN);
                        }
                        charge.setChargeType("6");
                    }


                    //charge.setLaparaskopiki(admissionID);                  
                    //charge.setReceiptDostorAFM(admissionID);                   


                    if (rset.getString(29) != null && !rset.getString(29).equals("")) {
                        charge.setTreatmentPosition(rset.getString(29));
                    } else {
                        charge.getErrorCode().add("1016");
                        ErrorFile errorFile = new ErrorFile();
                        errorFile.setErrorCode("1016");
                        errorFile.setErrorMsg(MessageBundleLoader.getMessage("1016"));
                        errorFile.setAdmissionAM(rset.getString(22));
                        errorFile.setPatientAM(rset.getString(49));
                        errorFile.setType("2");
                        errorFile.setDischarge(dischargeTemp);
                        errorFile.setChargeTemp(charge);
                        errors.add(errorFile);
                    }


                    if (rset.getString(42) != null && !rset.getString(42).equals("")) {
                        charge.setTreatmentSector(rset.getString(42));
                    } else {
                        charge.getErrorCode().add("1017");
                        ErrorFile errorFile = new ErrorFile();
                        errorFile.setErrorCode("1017");
                        errorFile.setErrorMsg(MessageBundleLoader.getMessage("1017"));
                        errorFile.setAdmissionAM(rset.getString(22));
                        errorFile.setPatientAM(rset.getString(49));
                        errorFile.setType("2");
                        errorFile.setDischarge(dischargeTemp);
                        errorFile.setChargeTemp(charge);
                        errors.add(errorFile);
                    }

                    dischargeTemp.getCharges().add(charge);
                    //discharges.add(dischargeTemp);
                }
                
                if (dischargeTemp!=null && dischargeTemp.getCharges()!=null && dischargeTemp.getCharges().size()>0) {
                    dischargeTemp.setDischargeAmount(new Float(dischargeAmount));
                    discharges.add(dischargeTemp);
                }

                System.out.println("ADMISSIONS="+admissionCounter);
                admissionTemp.setDischarges(discharges);
                admissionTemp.setTotaldAmount(new Float(admissionAmount));
                kinisisAdmissionBean.setErrors(errors);
                kinisisAdmissionBean.setAdmission(admissionTemp);

            }

        } catch (Exception e) {
            e.printStackTrace();
            sessionBean.setErrorMsgKey("errMsg_GeneralError");
            goError(e);
        }
    }

    
    
    public void editRow(RowEditEvent event) {          
        DischargeTemp discharge = (DischargeTemp)event.getObject();
        
    }
            
    
    
    public void goError(Exception ex) {
        try {
            logger.error("-----------AN ERROR HAPPENED !!!! -------------------- : " + ex.toString());
            if (sessionBean.getUsers() != null) {
                logger.error("User=" + sessionBean.getUsers().getUsername());
            }
            logger.error("Cause=" + ex.getCause());
            logger.error("Class=" + ex.getClass());
            logger.error("Message=" + ex.getLocalizedMessage());
            logger.error(ex, ex);
            logger.error("--------------------- END OF ERROR --------------------------------------------------------\n\n");

            ErrorBean errorBean = (ErrorBean) FacesUtils.getManagedBean("errorBean");
            errorBean.reset();
            errorBean.setErrorMSG(MessageBundleLoader.getMessage(sessionBean.getErrorMsgKey()));
            //FacesUtils.redirectAJAX("./templates/error.jsf?faces-redirect=true");
            FacesUtils.redirectAJAX(FacesUtils.getContextPath() + "/templates/error.jsf?faces-redirect=true");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
