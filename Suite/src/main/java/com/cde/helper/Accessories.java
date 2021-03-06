package com.cde.helper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Accessories extends HtmlReporters{

	//	return date
	public static String dateStamp(){
		DateFormat dateFormat = new SimpleDateFormat();
		Date date = new Date();
		return dateFormat.format(date).substring(0,7);
	}
	//return time and date
	public static String timeStamp(){
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime()).toString();
	}
	// return environmental details
	public static String osEnvironment(){

		return "Current suit exicuted on : "+System.getProperty("os.name")
				+"/version : "+System.getProperty("os.version")
				+"/Architecture : "+System.getProperty("os.arch");
	}
	public static String getHostName() throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();

		return hostname;
	}
	public static void calculateTestCaseStartTime(){			
		HtmlReporters.iStartTime = System.currentTimeMillis();
	}


	/***
	 * 		This method is supposed to be used in the @AfterMethod to calculate the total test case execution time 
	 * to show in Reports by taking the start time from the calculateTestCaseStartTime method.
	 */
	public static void calculateTestCaseExecutionTime(){

		HtmlReporters.iEndTime = System.currentTimeMillis();
		HtmlReporters.iExecutionTime=(HtmlReporters.iEndTime-HtmlReporters.iStartTime);
		HtmlReporters.list.add((HtmlReporters.iExecutionTime)/1000.0);
	}


	/***
	 * 		This method is supposed to be used in the @BeforeSuite in-order trigger the Suite Start Time
	 * which inturn used to calculate the Total Suite execution time to show in Reports.
	 */
	public static void calculateSuiteStartTime(){

		HtmlReporters.iSuiteStartTime = System.currentTimeMillis(); //Newly added
	}


	/***
	 * 		This method is supposed to be used in the @AfterMethod to calculate the total suite execution time
	 * to show in Reports by taking the suite start time from the calculateSuiteStartTime method.
	 */
	public static void calculateSuiteExecutionTime(){

		HtmlReporters.iSuiteEndTime = System.currentTimeMillis(); //Newly added
		HtmlReporters.iSuiteExecutionTime = (HtmlReporters.iSuiteEndTime-HtmlReporters.iSuiteStartTime)/1000.000;//Newly added
	}
	
	public static String getIpAddress() throws Exception
	{
		return InetAddress.getLocalHost().getHostAddress();
	}
	
	public static String DocketHID(String DHID) throws Exception
	{
		return DHID;
	}
	public static String DocketNumber(String Dnumber) throws Exception
	{
		return Dnumber;
	}
}
