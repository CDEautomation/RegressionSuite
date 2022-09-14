package com.cde.helper;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import com.cde.base.Base;
import com.cde.base.Base1;

public class GetCurrentDate extends Base1 {
	
	public static String getDateMMddYYYYFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	public static String getDateyyyyMMddhhmmssFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	
	public static String getDateMMddYYFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	public static String getDateMMddYYYYFormat1() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	public static String getDateddMMYYYYFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	
	public static String retriveNthDate(int n) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(getDateddMMYYYYFormat()));
		c.add(Calendar.DATE, n);  // number of days to add
		System.out.println(sdf.format(c.getTime()));  
		
		return sdf.format(c.getTime());
	}
	public static String retriveNthDate1(int n) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(getDateMMddYYYYFormat1()));
		c.add(Calendar.DATE, n);  // number of days to add
		System.out.println(sdf.format(c.getTime()));  
		
		return sdf.format(c.getTime());
	}
	
	public static String getDateMMDDYYYY() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
		Date date = new Date();
		String currentDate = sdf.format(date);
		return currentDate;
	}
	public static String timeStamp(){
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime()).toString();
	}
	
	/***
	 * 		This method is supposed to be used in the @BeforeSuite in-order trigger the Suite Start Time
	 * which inturn used to calculate the Total Suite execution time to show in Reports.
	 */
	public static void calculateSuiteStartTime(){

		HtmlReporters.iSuiteStartTime = System.currentTimeMillis(); //Newly added
	}
	
	public static String getIpAddress() throws Exception
	{
		return InetAddress.getLocalHost().getHostAddress();
	}


}
