package com.hosp.action;

import com.hosp.dao.ExAssertionDAO;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAction {

	/**
	 * @param args
	 */
	
	private static  String patern = "#,###.00";
	public static void main(String[] args) {
		try {
			NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
			format.setGroupingUsed(true); 
			
			
			Double value = new Double(5000000.4);
//			System.out.println("(GET AS STRING) value=" + value);
			Number number = format.parse(value.toString());						
//			System.out.println(format.format(value));
//			System.out.println("(GET AS STRING) format value=" + number);
			
						
			Pattern p = Pattern.compile("(\\d){11}");
			Matcher m = p.matcher("15077503397");
//			System.out.println(m.matches());
                        
                        ExAssertionDAO dao = new ExAssertionDAO();
                        dao.test();
			 
			
			//DecimalFormat df = new DecimalFormat(patern);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			// TODO: handle exception
		}

	}

}
