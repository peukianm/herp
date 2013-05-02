// Decompiled by DJ v3.12.12.96 Copyright 2011 Atanas Neshkov  Date: 20/10/2012 11:22:53 ��
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   RecordFour.java

package com.hosp.eopyy;

import java.io.Serializable;

public class RecordFour
    implements Serializable
{

    public RecordFour()
    {
    }

    public String getProdAmount()
    {
        return prodAmount;
    }

    public void setProdAmount(String prodAmount)
    {
        this.prodAmount = prodAmount;
    }

    public String getProdCode()
    {
        return prodCode;
    }

    public void setProdCode(String prodCode)
    {
        this.prodCode = prodCode;
    }

    public String getProdTotalCost()
    {
        return prodTotalCost;
    }

    public void setProdTotalCost(String prodTotalCost)
    {
        this.prodTotalCost = prodTotalCost;
    }

    public String getProdUnitCost()
    {
        return prodUnitCost;
    }

    public void setProdUnitCost(String prodUnitCost)
    {
        this.prodUnitCost = prodUnitCost;
    }

    private String prodCode;//EXAM CODE
    private String prodUnitCost;//COST
    private String prodAmount;//QUANTITY
    private String prodTotalCost;//QUANTITY*COST
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "prodAmount="+prodAmount+" prodCode="+prodCode+ " prodTotalCost="+prodTotalCost+" prodUnitCost="+prodUnitCost;
    }
    
    
}