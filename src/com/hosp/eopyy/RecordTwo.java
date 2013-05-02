// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 20/10/2012 11:22:53 ��
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RecordTwo.java

package com.hosp.eopyy;

import java.io.Serializable;

public class RecordTwo
    implements Serializable
{

    public RecordTwo()
    {
    }

    public String getTimAmount()
    {
        return timAmount;
    }

    public String getTimDate()
    {
        return timDate;
    }

    public String getTimNum()
    {
        return timNum;
    }

    public void setTimAmount(String timAmount)
    {
        this.timAmount = timAmount;
    }

    public void setTimDate(String timDate)
    {
        this.timDate = timDate;
    }

    public void setTimNum(String timNum)
    {
        this.timNum = timNum;
    }

    private String timNum;
    private String timDate;
    private String timAmount;
    
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return  "Timol Num="+timNum+ " timolDate="+timDate+" tomolAmount="+timAmount   ;
    }
    
}