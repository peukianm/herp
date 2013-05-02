// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 20/10/2012 11:22:53 ��
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DapyUtility.java

package com.hosp.eopyy;

import com.hosp.util.MessageBundleLoader;
import java.io.*;
import java.util.*;

// Referenced classes of package edit:
//            ContractCost, RecordTwo, RecordThree, RecordFour, 
//            Contract, RecordOne

public class DapyUtility
{

    public DapyUtility()
    {
    }

    private boolean isWindowsOS()
    {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.startsWith("windows");
    }

    public boolean isDateCorrect(String dateStr)
    {
        boolean dateIsCorrect = true;
        int day = (new Integer(dateStr.substring(0, 2))).intValue();
        int month = (new Integer(dateStr.substring(3, 5))).intValue();
        int year = (new Integer(dateStr.substring(6))).intValue();
        if(year > 999)
        {
            GregorianCalendar gc = new GregorianCalendar();
            boolean leapYear = gc.isLeapYear(year);
            if(month < 1 || month > 12)
                dateIsCorrect = false;
            else
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            {
                if(day < 1 || day > 31)
                    dateIsCorrect = false;
            } else
            if(day < 1 || day > 30)
                dateIsCorrect = false;
            else
            if(month == 2)
            {
                if(leapYear && day > 29)
                    dateIsCorrect = false;
                if(!leapYear && day > 28)
                    dateIsCorrect = false;
            }
        } else
        {
            dateIsCorrect = false;
        }
        return dateIsCorrect;
    }

    public boolean isDatePreviousOrSameToCurrent(String dateStr)
    {
        int day = (new Integer(dateStr.substring(0, 2))).intValue();
        int month = (new Integer(dateStr.substring(3, 5))).intValue() - 1;
        int year = (new Integer(dateStr.substring(6))).intValue();
        GregorianCalendar now = new GregorianCalendar();
        GregorianCalendar specifiedDate = new GregorianCalendar(year, month, day);
        return now.compareTo(specifiedDate) >= 0;
    }

    public boolean checkForDuplicate(ArrayList list)
    {
        HashSet set = new HashSet();
        for(int i = 0; i < list.size(); i++)
        {
            boolean val = set.add(list.get(i));
            if(!val)
                return val;
        }

        return true;
    }

    public ArrayList checkForDuplicateRows(ArrayList list)
    {
        ArrayList duplicates = new ArrayList();
        HashSet set = new HashSet();
        for(int i = 0; i < list.size(); i++)
        {
            boolean val = set.add(list.get(i));
            if(!val && !duplicates.contains(list.get(i)))
                duplicates.add(list.get(i));
        }

        return duplicates;
    }

    public ArrayList retrieveCountriesData()
    {
        ArrayList countryData = new ArrayList();
        String dapyCountriesFileDir = isWindowsOS() ? "C:\\TEMP\\DAPY_COUNTRIES.txt" : "/tmp/DAPY_COUNTRIES.txt";
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(dapyCountriesFileDir), "UTF-8"));
            String str;
            while((str = in.readLine()) != null) 
                countryData.add(str);
            in.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return countryData;
    }

    public ArrayList retrievePublishersData()
    {
        ArrayList publishersData = new ArrayList();
        String dapyPublishersFileDir = isWindowsOS() ? "C:\\TEMP\\DAPY_PUBLISHERS.txt" : "/tmp/DAPY_PUBLISHERS.txt";
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(dapyPublishersFileDir), "UTF-8"));
            String str;
            while((str = in.readLine()) != null) 
                publishersData.add(str);
            in.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return publishersData;
    }

    public ArrayList retrieveContractFileList()
    {
        ArrayList contractDataFileList = new ArrayList();
        String contractFileDir = isWindowsOS() ? "C:\\TEMP\\DAPY_CONTRACTS" : "/tmp/DAPY_CONTRACTS";
        File fdir = new File(contractFileDir);
        if(!fdir.isDirectory())
            return null;
        String contractFiles[] = fdir.list();
        String arr$[] = contractFiles;
        int len$ = arr$.length;
        for(int i$ = 0; i$ < len$; i$++)
        {
            String contractFile = arr$[i$];
            contractDataFileList.add(contractFile);
        }

        return contractDataFileList;
    }

    public ArrayList tryToRetrieveContractFile(String loadedContractFile)
    {
        ArrayList contractData = new ArrayList();
        boolean isWindows = isWindowsOS();
        String contractFileDir = isWindows ? "C:\\TEMP\\DAPY_CONTRACTS" : "/tmp/DAPY_CONTRACTS";
        File fdir = new File(contractFileDir);
        if(!fdir.isDirectory())
            return null;
        String contractFileName = isWindows ? (new StringBuilder()).append("C:\\TEMP\\DAPY_CONTRACTS\\").append(loadedContractFile).toString() : (new StringBuilder()).append("/tmp/DAPY_CONTRACTS/").append(loadedContractFile).toString();
        File f = new File(contractFileName);
        if(!f.exists())
            return null;
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(contractFileName), "UTF-8"));
            String str;
            while((str = in.readLine()) != null) 
                contractData.add(str);
            in.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return contractData;
    }

    public ArrayList retrieveContractData(String contractFile)
    {
        ArrayList contractData = new ArrayList();
        String contractFileName = isWindowsOS() ? (new StringBuilder()).append("C:\\TEMP\\DAPY_CONTRACTS\\").append(contractFile).toString() : (new StringBuilder()).append("/tmp/DAPY_CONTRACTS/").append(contractFile).toString();
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(contractFileName), "UTF-8"));
            String str;
            while((str = in.readLine()) != null) 
                contractData.add(str);
            in.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return contractData;
    }

    public boolean deleteContractFile(String contractNum)
    {
        String contractFileName = isWindowsOS() ? (new StringBuilder()).append("C:\\TEMP\\DAPY_CONTRACTS\\").append(contractNum).toString() : (new StringBuilder()).append("/tmp/DAPY_CONTRACTS/").append(contractNum).toString();
        File ftoDel = new File(contractFileName);
        return ftoDel.delete();
    }

    

    public StringWriter createHL7File(RecordOne dapyData)
    {
        String seq5ivcStr = "0".equals(dapyData.getFld05()) ? "NORM" : "ADD";
        String seq10ivcStr = (new StringBuilder()).append(dapyData.getFld07()).append("^^^^^^^^^").append(dapyData.getFld06()).toString();
        String seq27ivcStr = (new StringBuilder()).append(dapyData.getFld08()).append(" ").append(dapyData.getFld09()).toString();
        String seq3ivcStr = dapyData.getFld10();
        String mesCreationDate = makeDateString(false);
        String FHS_seg = "FHS|^~\\&|||||||DIAG1|1|O";
        String r1f12val = dapyData.getFld12();
        String r1f11 = dapyData.getFld11();
        String r1f11val = r1f11.length() != 1 ? r1f11 : (new StringBuilder()).append("0").append(r1f11).toString();
        String seq7bhsStr = (new StringBuilder()).append(r1f12val).append(r1f11val).append("~").append(r1f12val).append(r1f11val).toString();
        String BHS_seg = (new StringBuilder()).append("BHS|^~\\&|||||").append(seq7bhsStr).append("||||A73918").toString();
        int mshAA = 0;
        boolean isWindows = isWindowsOS();
        String fileName = isWindows ? "C:\\TEMP\\DIAG1.txt" : "/tmp/DIAG1.txt";
        File f = new File(fileName);
        if(f.exists())
        {
            String suffixStr = makeDateString(true);
            String oldFileName = isWindows ? (new StringBuilder()).append("C:\\TEMP\\DIAG1_").append(suffixStr).append(".txt").toString() : (new StringBuilder()).append("/tmp/DIAG1_").append(suffixStr).append(".txt").toString();
            f.renameTo(new File(oldFileName));
        }
        try
        {
            StringWriter stringWriter = new StringWriter();
            
            BufferedWriter bw = new BufferedWriter(stringWriter);
            
            
            
            //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "ISO-8859-7"));
            bw.write(FHS_seg);
            bw.newLine();
            bw.write(BHS_seg);
            bw.newLine();
            for(Iterator i$ = dapyData.getTimologia().iterator(); i$.hasNext(); bw.newLine())
            {
                RecordTwo rec2 = (RecordTwo)i$.next();
                mshAA++;
                String mshAAStr = (new Integer(mshAA)).toString();
                String MHS_tim_seg = (new StringBuilder()).append("MSH|^~\\&|||||").append(mesCreationDate).append("||ZHC^Z01^ZHC_Z01|MSGID").append(giveLeadingZeroes(mshAAStr, 5)).append(mshAAStr).append("|P|2.6").toString();
                bw.write(MHS_tim_seg);
                bw.newLine();
                String IVC_seg = (new StringBuilder()).append("IVC|").append(rec2.getTimNum()).append("||").append(seq3ivcStr).append("|OR|").append(seq5ivcStr).append("|FS|").append(constructDateFieldForHL7(rec2.getTimDate())).append("|").append(constructFloatFieldForHL7(rec2.getTimAmount())).append("||").append(seq10ivcStr).append("|").append(MessageBundleLoader.getMessage("hellenic_IKA_forHL7file")).append("|||||||||||||| ||").append(seq27ivcStr).toString();
                bw.write(IVC_seg);
            }

            String BTS_seg = (new StringBuilder()).append("BTS|").append(dapyData.getFld13()).append("||").append(constructFloatFieldForHL7(dapyData.getFld14())).toString();
            bw.write(BTS_seg);
            bw.newLine();
            bw.write(BHS_seg);
            bw.newLine();
            for(Iterator i$ = dapyData.getParapemptika().iterator(); i$.hasNext();)
            {
                RecordThree r3 = (RecordThree)i$.next();
                mshAA++;
                String mshAAStr = (new Integer(mshAA)).toString();
                String MHS_par_seg = (new StringBuilder()).append("MSH|^~\\&|||||").append(mesCreationDate).append("||ZHC^Z02^ZHC_Z02|MSGID").append(giveLeadingZeroes(mshAAStr, 5)).append(mshAAStr).append("|P|2.6").toString();
                bw.write(MHS_par_seg);
                bw.newLine();
                double detailsSumVal = getTheSumOfParapemptikoDetails(r3.getProducts());
                String seq5psgStr = constructFloatFieldForHL7(calculateDoubleGinToStr(detailsSumVal, 1));
                String PSG_seg = (new StringBuilder()).append("PSG|").append(r3.getFld05()).append("|||Y|").append(seq5psgStr).toString();
                bw.write(PSG_seg);
                bw.newLine();
                String seq1zsgStr = constructDateFieldForHL7(r3.getFld06());
                String seq2zsgStr = constructDateFieldForHL7(r3.getFld10());
                String seq3zsgStr = constructDateFieldForHL7(r3.getFld14());
                String seq14zsgStr = "";
                if(!"".equals(r3.getFld28()))
                    seq14zsgStr = (new StringBuilder()).append("|||||||||||").append(r3.getFld28()).toString();
                String ZSG_seg = (new StringBuilder()).append("ZSG|").append(seq1zsgStr).append("|").append(seq2zsgStr).append("|").append(seq3zsgStr).append(seq14zsgStr).toString();
                bw.write(ZSG_seg);
                bw.newLine();
                String seq3pidStr = "";
                boolean amkaExist = false;
                String amkaStr = "";
                if(!"".equals(r3.getFld19()))
                {
                    amkaStr = (new StringBuilder()).append("~").append(r3.getFld19()).append("^^^^").append(MessageBundleLoader.getMessage("hellenic_AMKA_forHL7file")).toString();
                    amkaExist = true;
                }
                boolean amaExist = false;
                String amaStr = "";
                if(!"".equals(r3.getFld20()))
                {
                    amaStr = (new StringBuilder()).append("~").append(r3.getFld20()).append("^^^^").append(MessageBundleLoader.getMessage("hellenic_AMA_forHL7file")).toString();
                    amaExist = true;
                }
                boolean idNumExist = false;
                String idNumStr = "";
                if(!"".equals(r3.getFld25()))
                {
                    idNumStr = (new StringBuilder()).append("~").append(r3.getFld25()).append("^^^^").append(MessageBundleLoader.getMessage("hellenic_ADT_forHL7file")).toString();
                    idNumExist = true;
                }
                boolean afmExist = false;
                String afmStr = "";
                if(!"".equals(r3.getFld26()))
                {
                    afmStr = (new StringBuilder()).append("~").append(r3.getFld26()).append("^^^^").append(MessageBundleLoader.getMessage("hellenic_AFM_forHL7file")).toString();
                    afmExist = true;
                }
                if(amkaExist || amaExist || idNumExist || afmExist)
                {
                    String seq3StrTemp = (new StringBuilder()).append(amkaStr).append(amaStr).append(idNumStr).append(afmStr).toString();
                    seq3pidStr = (new StringBuilder()).append(seq3StrTemp.substring(1)).append("|").toString();
                } else
                {
                    seq3pidStr = "|";
                }
                String seq5pidStr = (new StringBuilder()).append(r3.getFld21()).append("^").append(r3.getFld22()).toString();
                if(!"".equals(r3.getFld23()) && !"".equals(r3.getFld24()))
                {
                    seq5pidStr = (new StringBuilder()).append(seq5pidStr).append("^").append(r3.getFld23()).append(" ").append(r3.getFld24()).toString();
                } else
                {
                    if(!"".equals(r3.getFld23()))
                        seq5pidStr = (new StringBuilder()).append(seq5pidStr).append("^").append(r3.getFld23()).toString();
                    if(!"".equals(r3.getFld24()))
                        seq5pidStr = (new StringBuilder()).append(seq5pidStr).append("^").append(" ").append(r3.getFld24()).toString();
                }
                String seq7pidStr = constructDateFieldForHL7(r3.getFld27());
                String seq28pidStr = r3.getFld18();
                String PID_seg = (new StringBuilder()).append("PID|||").append(seq3pidStr).append("|").append(seq5pidStr).append("||").append(seq7pidStr).append("|||||||||||||||||||||").append(seq28pidStr).toString();
                bw.write(PID_seg);
                bw.newLine();
                String PV1_seg = "PV1|N";
                bw.write(PV1_seg);
                bw.newLine();
                String PV2_seg = "PV2";
                bw.write(PV2_seg);
                bw.newLine();
                String DG1_seg = "DG1";
                if(!"".equals(r3.getFld16()) && !"".equals(r3.getFld17()))
                    DG1_seg = (new StringBuilder()).append(DG1_seg).append("|001||").append(r3.getFld16()).append("^").append(r3.getFld17()).append("^I10|||A").toString();
                bw.write(DG1_seg);
                bw.newLine();
                String DG1_emp_seg = "DG1";
                bw.write(DG1_emp_seg);
                bw.newLine();
                int parDetAA = 0;
                String seq6plsStr = r3.getFld15();
                
                int seq18pls = (new Integer(r3.getFld04())).intValue() + 1;
                String seq18plsStr = (new Integer(seq18pls)).toString();
                String seq20plsStr = r3.getFld29();
                String seq25plsStr = r3.getFld03();
                String r3f11 = r3.getFld11();
                String r3f11val = "0".equals(r3f11) ? "00000" : r3f11;
                String r3f12 = r3.getFld12();
                String r3f12val = "".equals(r3f12) ? " " : r3f12;
                String r3f13 = r3.getFld13();
                String r3f13val = "".equals(r3f13) ? " " : r3f13;
                String seq29plsStr = (new StringBuilder()).append(r3f11val).append("^").append(r3f12val).append("^").append(r3f13val).toString();
                String seq30plsStr = "";
                if(!"".equals(r3.getFld07()))
                {
                    String r3f7 = r3.getFld07();
                    String r3f7val = "0".equals(r3f7) ? "00000" : r3f7;
                    String r3f8 = r3.getFld08();
                    String r3f8val = "".equals(r3f8) ? " " : r3f8;
                    String r3f9 = r3.getFld09();
                    String r3f9val = "".equals(r3f9) ? " " : r3f9;
                    seq30plsStr = (new StringBuilder()).append("|").append(r3f7val).append("^").append(r3f8val).append("^").append(r3f9val).toString();
                }
                Iterator cc = r3.getProducts().iterator();
                while(cc.hasNext()) 
                {
                    RecordFour r4 = (RecordFour)cc.next();
                    parDetAA++;
                    String parDetAAStr = (new Integer(parDetAA)).toString();
                    String PSL_seg = (new StringBuilder()).append("PSL|||").append(parDetAAStr).append("|||").append(seq6plsStr).append("|").append(r4.getProdCode()).append("|3||||").append(r4.getProdAmount()).append("|").append(constructFloatFieldForHL7(r4.getProdUnitCost())).append("||").append(constructFloatFieldForHL7(r4.getProdTotalCost())).append("|||").append(seq18plsStr).append("||").append(seq20plsStr).append("|NO||||").append(seq25plsStr).append("||||").append(seq29plsStr).append(seq30plsStr).toString();
                    bw.write(PSL_seg);
                    bw.newLine();
                    String ZSL_seg = "ZSL";
                    bw.write(ZSL_seg);
                    bw.newLine();
                }
            }

            
            bw.flush();
            bw.close();
            return stringWriter;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
        
//        return fileName;
//        String saveDataResp = saveDapyFileFields(dapyData);
//        if(null == saveDataResp)
//            return null;
//        else
//            return fileName;
    }

    public int checkIfDapyFileIsAlreadySaved(String dapyFile)
    {
        boolean isWindows = isWindowsOS();
        String dapyDataFileDir = isWindows ? "C:\\TEMP\\DAPY_FILES_DATA" : "/tmp/DAPY_FILES_DATA";
        File dfdir = new File(dapyDataFileDir);
        if(!dfdir.isDirectory())
            return 0;
        String dapyDataFileName = isWindows ? (new StringBuilder()).append("C:\\TEMP\\DAPY_FILES_DATA\\").append(dapyFile).toString() : (new StringBuilder()).append("/tmp/DAPY_FILES_DATA/").append(dapyFile).toString();
        File f = new File(dapyDataFileName);
        return f.exists() ? 1 : 0;
    }

    public String saveDapyFileFields(RecordOne dapyData)
    {
        String separator = "#";
        String r1f5 = dapyData.getFld05();
        String r1f6 = dapyData.getFld06();
        String r1f7 = dapyData.getFld07();
        String r1f8 = dapyData.getFld08();
        String r1f9 = dapyData.getFld09();
        String r1f10 = dapyData.getFld10();
        String r1f11 = dapyData.getFld11();
        String r1f12 = dapyData.getFld12();
        String r1f13 = dapyData.getFld13();
        String r1f14 = dapyData.getFld14();
        String r1f15 = dapyData.getFld15();
        String r1f16 = dapyData.getFld16();
        String row1 = (new StringBuilder()).append("1").append(separator).append(r1f5).append(separator).append(r1f6).append(separator).append(r1f7).append(separator).append(r1f8).append(separator).append(r1f9).append(separator).append(r1f10).append(separator).append(r1f11).append(separator).append(r1f12).append(separator).append(r1f13).append(separator).append(r1f14).append(separator).append(r1f15).append(separator).append(r1f16).toString();
        ArrayList rows2 = new ArrayList();
        String row2;
        for(Iterator i$ = dapyData.getTimologia().iterator(); i$.hasNext(); rows2.add(row2))
        {
            RecordTwo rec2 = (RecordTwo)i$.next();
            String r2f3 = rec2.getTimNum();
            String r2f4 = rec2.getTimDate();
            String r2f5 = rec2.getTimAmount();
            row2 = (new StringBuilder()).append("2").append(separator).append(r2f3).append(separator).append(r2f4).append(separator).append(r2f5).toString();
        }

        boolean isWindows = isWindowsOS();
        String dapyDataFileDir = isWindows ? "C:\\TEMP\\DAPY_FILES_DATA" : "/tmp/DAPY_FILES_DATA";
        File dfdir = new File(dapyDataFileDir);
        boolean success;
        if(!dfdir.isDirectory())
            success = (new File(dapyDataFileDir)).mkdirs();
        String dataFileName = (new StringBuilder()).append(r1f10).append("_").append(r1f5).append("_").append(r1f11).append("_").append(r1f12).toString();
        String dapyDataFileName = isWindows ? (new StringBuilder()).append("C:\\TEMP\\DAPY_FILES_DATA\\").append(dataFileName).toString() : (new StringBuilder()).append("/tmp/DAPY_FILES_DATA/").append(dataFileName).toString();
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dapyDataFileName), "UTF-8"));
            bw.write(row1);
            bw.newLine();
            for(Iterator i$ = rows2.iterator(); i$.hasNext(); bw.newLine())
            {
                String r2 = (String)i$.next();
                bw.write(r2);
            }

            int parAA = 0;
            for(Iterator i$ = dapyData.getParapemptika().iterator(); i$.hasNext();)
            {
                RecordThree r3 = (RecordThree)i$.next();
                parAA++;
                String r3f3 = r3.getFld03();
                String r3f4 = r3.getFld04();
                String r3f5 = r3.getFld05();
                String r3f6 = r3.getFld06();
                String r3f7 = r3.getFld07();
                String r3f8 = r3.getFld08();
                String r3f9 = r3.getFld09();
                String r3f10 = r3.getFld10();
                String r3f11 = r3.getFld11();
                String r3f12 = r3.getFld12();
                String r3f13 = r3.getFld13();
                String r3f14 = r3.getFld14();
                String r3f15 = r3.getFld15();
                String r3f16 = r3.getFld16();
                String r3f17 = r3.getFld17();
                String r3f18 = r3.getFld18();
                String r3f19 = r3.getFld19();
                String r3f20 = r3.getFld20();
                String r3f21 = r3.getFld21();
                String r3f22 = r3.getFld22();
                String r3f23 = r3.getFld23();
                String r3f24 = r3.getFld24();
                String r3f25 = r3.getFld25();
                String r3f26 = r3.getFld26();
                String r3f27 = r3.getFld27();
                String r3f28 = r3.getFld28();
                String r3f29 = r3.getFld29();
                bw.write((new StringBuilder()).append("3").append(separator).append(r3f3).append(separator).append(r3f4).append(separator).append(r3f5).append(separator).append(r3f6).append(separator).append(r3f7).append(separator).append(r3f8).append(separator).append(r3f9).append(separator).append(r3f10).append(separator).append(r3f11).append(separator).append(r3f12).append(separator).append(r3f13).append(separator).append(r3f14).append(separator).append(r3f15).append(separator).append(r3f16).append(separator).append(r3f17).append(separator).append(r3f18).append(separator).append(r3f19).append(separator).append(r3f20).append(separator).append(r3f21).append(separator).append(r3f22).append(separator).append(r3f23).append(separator).append(r3f24).append(separator).append(r3f25).append(separator).append(r3f26).append(separator).append(r3f27).append(separator).append(r3f28).append(separator).append(r3f29).toString());
                bw.newLine();
                Iterator dd = r3.getProducts().iterator();
                while(dd.hasNext()) 
                {
                    RecordFour r4 = (RecordFour)dd.next();
                    String parAAStr = (new Integer(parAA)).toString();
                    String r4f4 = r4.getProdCode();
                    String r4f5 = r4.getProdUnitCost();
                    String r4f6 = r4.getProdAmount();
                    String r4f7 = r4.getProdTotalCost();
                    bw.write((new StringBuilder()).append("4").append(separator).append(parAAStr).append(separator).append(r4f4).append(separator).append(r4f5).append(separator).append(r4f6).append(separator).append(r4f7).toString());
                    bw.newLine();
                }
            }

            bw.flush();
            bw.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return dataFileName;
    }

    public ArrayList retrieveDapyFileDataList()
    {
        ArrayList dapyDataFileList = new ArrayList();
        String dapyFileDataDir = isWindowsOS() ? "C:\\TEMP\\DAPY_FILES_DATA" : "/tmp/DAPY_FILES_DATA";
        File dfdir = new File(dapyFileDataDir);
        if(!dfdir.isDirectory())
            return null;
        String dapyDataFiles[] = dfdir.list();
        String arr$[] = dapyDataFiles;
        int len$ = arr$.length;
        for(int i$ = 0; i$ < len$; i$++)
        {
            String dapyDataFile = arr$[i$];
            dapyDataFileList.add(dapyDataFile);
        }

        return dapyDataFileList;
    }

    public ArrayList retrieveDapyFileData(String dapyFile)
    {
        ArrayList dapyFileData = new ArrayList();
        String dapyFileName = isWindowsOS() ? (new StringBuilder()).append("C:\\TEMP\\DAPY_FILES_DATA\\").append(dapyFile).toString() : (new StringBuilder()).append("/tmp/DAPY_FILES_DATA/").append(dapyFile).toString();
        try
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(dapyFileName), "UTF-8"));
            String str;
            while((str = in.readLine()) != null) 
                dapyFileData.add(str);
            in.close();
        }
        catch(Exception e)
        {
            return null;
        }
        return dapyFileData;
    }

    private String giveLeadingZeroes(String realVal, int fieldSize)
    {
        String leadingZeroes = "";
        for(int i = 0; i < fieldSize - realVal.length(); i++)
            leadingZeroes = (new StringBuilder()).append(leadingZeroes).append("0").toString();

        return leadingZeroes;
    }

    private String constructFloatFieldForHL7(String realVal)
    {
        String retField = "";        
        if(-1 != realVal.indexOf("."))
        {
            String parts[] = realVal.split("\\.");            
            if(parts[1].length() == 1)
                retField = (new StringBuilder()).append(parts[0]).append(".").append(parts[1]).append("0").toString();
            else
                retField = (new StringBuilder()).append(parts[0]).append(".").append(parts[1]).toString();
        } else if (-1 != realVal.indexOf(",")) {
            String parts[] = realVal.split(",");            
            if(parts[1].length() == 1)
                retField = (new StringBuilder()).append(parts[0]).append(".").append(parts[1]).append("0").toString();
            else
                retField = (new StringBuilder()).append(parts[0]).append(".").append(parts[1]).toString();
        
        }
        else
        {
            retField = (new StringBuilder()).append(realVal).append(".00").toString();
        }
        return retField;
    }

    private String constructDateFieldForHL7(String realVal)
    {
        String retField = "";
        if(!"".equals(realVal))
        {
            String dateParts[] = realVal.split("/");
            retField = (new StringBuilder()).append(retField).append(dateParts[2]).append(dateParts[1]).append(dateParts[0]).toString();
        }
        return retField;
    }

    private String makeDateString(boolean withSecs)
    {
        String dateStr = "";
        GregorianCalendar gc = new GregorianCalendar();
        String yearStr = (new Integer(gc.get(1))).toString();
        int month = (new Integer(gc.get(2))).intValue() + 1;
        String monthStr = (new Integer(month)).toString();
        if(monthStr.length() == 1)
            monthStr = (new StringBuilder()).append("0").append(monthStr).toString();
        int day = gc.get(5);
        String dayStr = (new Integer(day)).toString();
        if(dayStr.length() == 1)
            dayStr = (new StringBuilder()).append("0").append(dayStr).toString();
        int hour = gc.get(11);
        String hourStr = (new Integer(hour)).toString();
        if(hourStr.length() == 1)
            hourStr = (new StringBuilder()).append("0").append(hourStr).toString();
        int minute = gc.get(12);
        String minuteStr = (new Integer(minute)).toString();
        if(minuteStr.length() == 1)
            minuteStr = (new StringBuilder()).append("0").append(minuteStr).toString();
        if(withSecs)
        {
            int second = gc.get(13);
            String secondStr = (new Integer(second)).toString();
            if(secondStr.length() == 1)
                secondStr = (new StringBuilder()).append("0").append(secondStr).toString();
            dateStr = (new StringBuilder()).append(yearStr).append(monthStr).append(dayStr).append(hourStr).append(minuteStr).append(secondStr).toString();
        } else
        {
            dateStr = (new StringBuilder()).append(yearStr).append(monthStr).append(dayStr).append(hourStr).append(minuteStr).toString();
        }
        return dateStr;
    }

    public String calculateDoubleGinToStr(double doubleVal, int intVal)
    {
        String resultStr = (new Double(doubleVal * (double)intVal)).toString();
        String modifiedStr = "";
        String akerPart = "";
        String decPart = "";
        if(-1 == resultStr.indexOf("E"))
        {
            akerPart = resultStr.substring(0, resultStr.indexOf("."));
            decPart = resultStr.substring(resultStr.indexOf(".") + 1);
        } else
        {
            int indOfE = resultStr.indexOf("E");
            String last = resultStr.substring(indOfE + 1);
            int lastInt = (new Integer(last)).intValue();
            String tempAker = resultStr.substring(0, resultStr.indexOf("."));
            String tempDecPart = resultStr.substring(resultStr.indexOf(".") + 1, indOfE);
            String tempDecPart2 = tempDecPart.substring(0, lastInt);
            akerPart = (new StringBuilder()).append(tempAker).append(tempDecPart2).toString();
            decPart = tempDecPart.substring(lastInt);
        }
        if(decPart.length() > 0 && !"0".equals(decPart))
        {
            if(decPart.length() > 2)
            {
                Long aker = new Long(akerPart);
                Integer first = new Integer(decPart.substring(0, 1));
                Integer second = new Integer(decPart.substring(1, 2));
                Integer third = new Integer(decPart.substring(2, 3));
                if(third.intValue() > 5)
                {
                    second = Integer.valueOf(second.intValue() + 1);
                    if(second.intValue() == 10)
                    {
                        second = Integer.valueOf(0);
                        first = Integer.valueOf(first.intValue() + 1);
                        if(first.intValue() == 10)
                        {
                            first = Integer.valueOf(0);
                            aker = Long.valueOf(aker.longValue() + 1L);
                        }
                    }
                }
                modifiedStr = (new StringBuilder()).append(aker.toString()).append(",").append(first.toString()).append(second.toString()).toString();
            } else
            if(decPart.length() == 1)
                modifiedStr = (new StringBuilder()).append(akerPart).append(",").append(decPart).append("0").toString();
            else
                modifiedStr = (new StringBuilder()).append(akerPart).append(",").append(decPart).toString();
        } else
        {
            modifiedStr = (new StringBuilder()).append(akerPart).append(",00").toString();
        }
        return modifiedStr;
    }

    public double getTheSumOfParapemptikoDetails(ArrayList rec4List)
    {
        double detailsSumVal = 0.0D;
        double valToAdd = 0.0D;
        for(Iterator i$ = rec4List.iterator(); i$.hasNext();)
        {
            RecordFour r4 = (RecordFour)i$.next();
            if(-1 != r4.getProdTotalCost().indexOf(","))
                valToAdd = (new Double(r4.getProdTotalCost().replace(",", "."))).doubleValue();
            else
                valToAdd = (new Double(r4.getProdTotalCost())).doubleValue();
            detailsSumVal += valToAdd;
        }

        return detailsSumVal;
    }
}