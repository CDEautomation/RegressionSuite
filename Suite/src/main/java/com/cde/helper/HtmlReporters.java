package com.cde.helper;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;



import com.cde.base.Base1;

import com.cde.config.Property;

public class HtmlReporters  {

	public static long iStartTime = 0;
	public static long iEndTime = 0;
	public static long iExecutionTime = 0;
	public static long iSuiteStartTime = 0;
	public static long iSuiteEndTime = 0;
	public static double iSuiteExecutionTime = 0;
	public static ArrayList<Double> list = new ArrayList<Double>();
	public static long startStepTime = 0;
	public static long endStepTime= 0;
	public static double stepExecutionTime = 0;

	static String startedAt="";
	public static String tc_name="";
	public static String packageName="";
	static Map<String, String> map= new LinkedHashMap<String, String>();
	//static Property config = new Property("config.properties");
	public static final String workingDir = System.getProperty("user.dir");
	public static Property configProps=new Property(workingDir + "\\src\\main\\java\\com\\cde\\config\\config.properties");
	public static String currentSuit="";
	public static int pCount=0;
	public static int fCount=0;
	public  static String[] key;
	public static String value[];



	

	public static void createDetailedReport() throws Exception
	{
		String[] s=GetCurrentDate.timeStamp().split(":");
		for(int i=0;i<s.length-1;i++){
			startedAt=startedAt+"-"+s[i];
		}
		startedAt=startedAt.substring(1,startedAt.length());
		startedAt=startedAt.replace(" ", "_");
		//System.out.println(Base.filePath()+"Results_"+Base.timeStamp+".html");
		File file = new File(Base1.filePath()+"Results_"+Base1.timeStamp+".html"); 

		Writer writer = new FileWriter(file,true);
		writer.write("<HTML>");
		writer.write("<BODY>");
		writer.write("<script> document.addEventListener('DOMContentLoaded', function() {"+
				"var url = document.URL; var id = url.split('#'); document.getElementById(id[1]).style.display='inline';"+
				"}, false); </script>");
		writer.write("<TABLE border=0 cellSpacing=1 cellPadding=1 width='110%'>");

		//workingDir = System.getProperty("user.dir").replace(File.separator, "/");
		//writer.write("<TR><TD align='left'><img src='file:///"+workingDir+"/Logos/"+config.getProperty("Clint_logo")+".jpeg' alt='"+config.getProperty("Clint_logo")+"' height='50' width='125'> </TD>");
		writer.write("<TD align='center'><H4 align='center'><font color='660066' face='arial' color='#E0E0E0' size=5><b>Detailed report</b></H4></TD>");
		//writer.write("<TD align='right'><img src='file:///"+workingDir+"/Logos/charter.png' alt='charter' height='75' width='150'>  </TD></TR>");

		writer.write("</TABLE>");
		writer.write("</BODY>");
		writer.write("</HTML>");
		writer.flush();  
		writer.close();
	}
	@SuppressWarnings("rawtypes")
	public static void createHtmlSummaryReport() throws Exception{

		//Property configProps=new Property("config.properties");
		//System.out.println(Base.filePath()+"SummaryResults_"+Base.timeStamp+".html");
		File file = new File(Base1.filePath()+"SummaryResults_"+Base1.timeStamp+".html");//"SummaryReport.html"
		Writer writer = null;

		if(file.exists())
		{
			file.delete();
		}
		//Create Summary report first table
		writer = new FileWriter(file,true); 
		try{
			writer.write("<HTML>");
			writer.write("<HEAD>");

			writer.write("<BODY>");


			writer.write("<TABLE border=0 cellSpacing=1 cellPadding=1 width='100%'>");
			
			writer.write("<TD align='center'><H4 align='center'><font color='660066' face='arial' color='#E0E0E0' size=5><b>Execution Summary Report</b></H4></TD>");
			//writer.write("<TD align='right'><img src='file:///"+workingDir+"/Logos/charter.png' alt='charter' height='75' width='150'>  </TD></TR>");

			writer.write("<TABLE border=1 align='center' cellSpacing=1 cellPadding=1 width='35%' font='arial'>");		 
			writer.write("<tr><td width=150 align='left' bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>Test_Environment</b></td>");
			writer.write("<td width=150 align='left' color='#153E7E'><FONT FACE='Arial' SIZE=1.85><b>"+configProps.getProperty("Test_Environment")+"</b></td></tr>");
			//writer.write("<tr><td width=150 align='left' bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>Run ID</b></td>");
			//writer.write("<td width=150 align='left' color='#153E7E'><FONT FACE='Arial' SIZE=1.85><b>"+config.getProperty("RunID")+"</b></td></tr>");
			writer.write("<tr><td width=150 align='left' bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>Run Date&Time</b></td>");
			writer.write("<td width=150 align='left' color='#153E7E'><FONT FACE='Arial' SIZE=1.85><b>"+GetCurrentDate.timeStamp()+"</b></td></tr>");
			writer.write("</table><hr/>");

			writer.write("<DIV style='padding:20px;margin:5px;'>"
					+ "<DIV style='float:left'>"
					+ "<DIV>"
					+ "<TABLE border=1 cellSpacing=1 cellPadding=1 width='100%' font='arial'>");
			writer.write("<tr><td colspan='2' align='center'><FONT COLOR='#153E7E' FACE='Arial' SIZE=2><b>Environment</b></td></tr>");
		
			writer.write("<tr><td width=150 align='left' bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>IP Address</b></td>");
			writer.write("<td width=150 align='left' color='#153E7E'><FONT FACE='Arial' SIZE=1.85><b>"+GetCurrentDate.getIpAddress()+"</b></td></tr>");
		
			writer.write("<tr><td width=150 align='left' bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>OS Name</b></td>");
			writer.write("<td width=150 align='left' color='#153E7E'><FONT FACE='Arial' SIZE=1.85><b>"+System.getProperty("os.name")+"</b></td></tr>");

			writer.write("</TABLE>"
					+ "</DIV></br>");


			//Create Summary report Second table
			writer.write("<DIV>");
			writer.write("<TABLE border=1 cellSpacing=1 cellPadding=1 width='100%' font='arial'>");		 
			writer.write("<TR><TD colspan='2' align='center'><FONT COLOR='#153E7E' FACE='Arial' SIZE=2><b>Execution Status</b></TD></TR>");

			Iterator<Entry<String, String>> iterator=map.entrySet().iterator();

			while(iterator.hasNext()) 
			{
				Map.Entry mapEntry = (Map.Entry) iterator.next();
				String value= mapEntry.getValue().toString();
				System.out.println(value);
				if(value.equals("PASS"))
				{
					pCount+=1; 
				}
				else
				{
					fCount+=1;       			  
				}

				writer.write("</tr>");
			}

			writer.write("<tr>");
			writer.write("<tr><td width=150 align='left' bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>Suite</b></td>");
			writer.write("<td width=150 align='left'><FONT FACE='Arial' SIZE=1.85><b>"+currentSuit+"</b></td></tr>");
			writer.write("<tr><td width=150 align='left'bgcolor='#153E7E' ><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>No. of  Scripts Executed</b></td>");
			writer.write("<td width=150 align='left' color='#153E7E'><FONT FACE='Arial' SIZE=1.85><b>"+map.size()+"</b></td></tr>");
			writer.write("<tr>");
			writer.write("<tr><td width=150 align='left' bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>No. of  Scripts Passed</b></td>");
			writer.write("<td width=150 align='left' color='#E0E0E0'><FONT FACE='Arial' SIZE=1.85><b>"+ pCount +"</b></td></tr>");
			writer.write("<tr>");
			writer.write("<tr><td width=150 align='left'bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>No. of  Scripts Failed</b></td>");
			writer.write("<td width=150 align='left'color='red' ><FONT FACE='Arial' SIZE=1.85><b>"+ fCount +"</b></td></tr>");

			writer.write("<TR><td width=150 align='left'bgcolor='#153E7E'><FONT COLOR='#E0E0E0' FACE='Arial' SIZE=1.85><b>Suite Execution Time</b></td>");//Newly added for Report
			writer.write("<TD width=150 align='left'color='red' ><FONT FACE='Arial' SIZE=1.85><b>"+ iSuiteExecutionTime +" secs" +"</b></TD></TR>");//Newly added for Report			
			writer.write("</TR>"
					+ "</TABLE>"
					+ "</DIV></br>");

			//Create Summary report third table		
			writer.write("<DIV>");
			writer.write("<TABLE border=1 cellSpacing=1 cellPadding=1 width='200%' font='arial'>");		 
			writer.write("<tr><td colspan='3' align='center'><FONT COLOR='#153E7E' FACE='Arial' SIZE=2><b>Summary Report</b></td></tr>"); 
			writer.write("<tr><td align='center'><FONT COLOR='#153E7E' FACE='Arial' SIZE=2.25><b>Module</b></td>" +
					"<td align='center'><FONT COLOR='#153E7E' FACE='Arial' SIZE=2.25><b>Test Case</b></td>" +
					"<td align='center'><FONT COLOR='#153E7E' FACE='Arial' SIZE=2.25><b>Status</b></td>"
					);

			Iterator<Entry<String, String>> iterator1=map.entrySet().iterator();

			while(iterator1.hasNext())
			{

				Map.Entry mapEntry1 = (Map.Entry) iterator1.next();
				key = mapEntry1.getKey().toString().split(":");
				String value=(String) mapEntry1.getValue();
				System.out.println(value);
				writer.write("<tr>");
				writer.write("<td><FONT color=#153e7e size=1 face=Arial><B>"+key[0]+"</B></td>");
				writer.write("<td><FONT color=#153e7e size=1 face=Arial><B>"+key[1]+"</B></td>");

				if(value.equals("PASS"))
				{
					writer.write("<TD width='30%' bgcolor=green align=center><FONT color=white size=1 face=Arial><B><a href='Results_"+Base1.timeStamp+".html#"+key[1]+"'>"+value+"</a></B></td>"); 
					//writer.write("<TD width='30%' bgcolor=#2DFACA align=center><FONT color=white size=1 face=Arial><B><a href='Results_"+Base.timeStamp+".html#"+key[1]+"'>"+value+"</a></B></td>");
				}
				else
				{
					writer.write("<TD width='30%' bgcolor=red align=center><FONT color=white size=1 face=Arial><B><a href='Results_"+Base1.timeStamp+".html#"+key[1]+"'>"+value+"</a></B></td>");	
				}


				writer.write("</tr>");
			}
			writer.write("</table>");

			writer.write( "</DIV>");
			writer.write( "</DIV>");


			if(configProps.getProperty("PieChartEnable").equalsIgnoreCase("True"))
			{
				writer.write("<script type='text/javascript' src='piecanvas.js'></script>");
				writer.write("<script type='text/javascript' src='https://www.google.com/jsapi'></script>");
				writer.write("<script type='text/javascript'>"
						+ "google.load('visualization', '1', {packages:['corechart']});"
						+ "google.setOnLoadCallback(drawChart);"
						+ "function drawChart() {"
						+ "var data = google.visualization.arrayToDataTable(["			 		
						+ "['Status', 'Count'],"			 		
						+ "['PASS',     "+pCount+"],"
						+ "['FAIL',      "+fCount+"]"
						+ "]);"
						+ "var options = {"
						+ "title: 'Test Cases Status Chart',"
						+ "is3D: true,"
						+ "chartArea : {left:0,top:0,width:'80%',height:'80%'},"
						+ "colors:['green','red','blue'],};"
						+ "var chart = new google.visualization.PieChart(document.getElementById('piechart'));"
						+ "chart.draw(data, options);"
						+ "}</script>");	

				//pie chart

				writer.write("<DIV style='float:right; padding-right:50px;'>");
				writer.write("<colspan='2' align='right'><FONT COLOR='#153E7E' FACE='Arial' SIZE=2>");
				writer.write("<DIV id='piechart' style='padding:50px 10px 10px 80px;'></DIV>"
						+ "</DIV>");

				writer.write("<DIV style=clear:both;'></DIV>"
						+ "</DIV>");

			}
			writer.write("</BODY></HTML>");				
			writer.flush();  
			writer.close();
			//map.clear();

		}
		catch (Exception e) {
			writer.flush();
			writer.close();
		}


	}


	//Crate a report file
	public static void htmlCreateReport() throws Exception
	{
		//long startStepTime = System.currentTimeMillis();		//For Step start time
		//map.clear();
		//System.out.println(Base.filePath()+"Results_"+Base.timeStamp+".html");
		File file = new File(Base1.filePath()+"Results_"+Base1.timeStamp+".html");//"Results.html"

		if(file.exists())
		{
			file.delete();
		}
		//		long endStepTime = System.currentTimeMillis(); //For Step End time			
		//		double stepExecutionTime = (endStepTime - startStepTime)/1000.000;	//For Step wise execution time		

	}
	public static void onSuccess(String strStepName,String strStepDes){

		//Property configProps=new Property("config.properties");
		//System.out.println(Base.filePath()+"Results_"+Base.timeStamp+".html");
		//File file = new File(Base.filePath()+"/"+"Results_"+Base.timeStamp+".html");//"SummaryReport.html"
		File file = new File(Base1.filePath()+"Results_"+Base1.timeStamp+".html");//"SummaryReport.html"
		Writer writer = null;



		try{
			writer = new FileWriter(file,true); 
			if(configProps.getProperty("OnSuccessScreenshot").equalsIgnoreCase("True"))
			{
				writer.write("<tr><TD width='300px'><FONT color=#153e7e size=1 face=Arial><B>" + strStepName
						+ " </b></td><TD width='600px'><FONT color=#153e7e size=1 face=Arial><B>" + strStepDes + "</B></td>"
						+ " </td><TD width='100px' bgcolor=green align=center><FONT color=white size=1 face=Arial><B><a href="+strStepDes.replace(" ", "_").replace(":", "_")+"_"+Base1.timeStamp+".jpeg>" + "Passed" + "</a></td></tr>");
			}
			else{
				writer.write("<tr><TD width='300px'><FONT color=#153e7e size=1 face=Arial><B>" + strStepName
						+ " </b></td><TD width='600px'><FONT color=#153e7e size=1 face=Arial><B>" + strStepDes + "</B></td>"
						+ " </td><TD width='100px' bgcolor=green align=center><FONT color=white size=1 face=Arial><B>" + "Passed" + "</td></tr>");
			}
			writer.flush();
			writer.close();

			if(!map.get(packageName+":"+tc_name).equals("FAIL"))
			{
				map.put(packageName+":"+tc_name, "PASS");
			}

			endStepTime = System.currentTimeMillis(); //For Step End time			
			stepExecutionTime = (endStepTime - startStepTime)/1000.000;	//For Step wise execution time	
			writer.write("<TD align=center><FONT color=#153e7e size=1 face=Arial><B>" + stepExecutionTime +" secs" +"</B></FONT></TD>"+"</TR>");
		}
		catch(Exception e){

		}
	}

	public static void onFailure(String strStepName,String strStepDes){
		//System.out.println(Base.filePath()+"Results_"+Base.timeStamp+".html");
		File file = new File(Base1.filePath()+"Results_"+Base1.timeStamp+".html");//"SummaryReport.html"
		Writer writer = null;

		try{
			writer = new FileWriter(file,true); 
			writer.write("<tr><TD width='300px'><FONT color=#153e7e size=1 face=Arial><B>" + strStepName
					+ " </b></td><TD width='600px'><FONT color=#153e7e size=1 face=Arial><B>" + strStepDes + "</B></td>"
					+ " </td><TD width='100px' bgcolor=red align=center><FONT color=white size=1 face=Arial><B><a href="+strStepDes.replace(" ", "_").replace(":", "_")+"_"+Base1.timeStamp+".jpeg>" + "Failed" + "</a></td></tr>");

			writer.flush();
			writer.close();

			map.put(packageName+":"+tc_name, "FAIL");

			endStepTime = System.currentTimeMillis(); //For Step End time			
			stepExecutionTime = (endStepTime - startStepTime)/1000.000;	//For Step wise execution time
			writer.write("<TD align=center><FONT color=#153e7e size=1 face=Arial><B>" + stepExecutionTime +" secs" +"</B></FONT></TD>"+"</TR>");
		}
		catch(Exception e){

		}
	}

	public static void testHeader(String strTestName){
		Writer writer=null;
		try{
			//System.out.println(Base.filePath()+"Results_"+Base.timeStamp+".html");
			File file = new File(Base1.filePath()+"Results_"+Base1.timeStamp+".html");//"Results.html"
			writer = new FileWriter(file,true);
			writer.write("<div name='"+tc_name+"'><TABLE style='display:none' id = '"+tc_name+"' border=1 cellSpacing=1 cellPadding=1 width='80%' font='arial'>");
			//writer.write("<tr ><td colspan=3><H4 align=center><FONT color=black size=4 face=Arial><B>" +strTestName + "</B></H4></td></tr>");
			writer.write("<tr ><td colspan=3><H4 align=center><FONT color=black size=4 face=Arial><B>" + strTestName + "</B></H4></td></tr>");
			
			writer.write("<tr><TD bgColor='#153e7e' width='100px' align=middle><FONT color='#e0e0e0' size=2 face='Arial'><B>Step</b></td>" 						
					+"<TD bgColor=#153e7e width='200px' align=middle><FONT color=#e0e0e0 size=2 face=Arial><B>" +"Description</b></td>"						 
					+"<TD bgColor=#153e7e  align=middle><FONT color=#e0e0e0 size=2 face=Arial><B>Status</b></td></tr></div>");
			map.put(packageName+":"+tc_name, "status");
		}
		catch(Exception e)
		{

		}
		finally
		{
			try{
				writer.flush();
				writer.close();
			}
			catch(Exception e){

			}
		}
	}
		public static void info(String DocketHID, String DocketNumber, String casenumber, String Client){
			Writer writer=null;
			try{
				File file = new File(Base1.filePath()+"Results_"+Base1.timeStamp+".html");//"Results.html"
				writer = new FileWriter(file,true);
				
				
				writer.write("<tr cellSpacing=1 cellPadding=1><td width='150' align='right' bgcolor='#153E7E'><font color='#E0E0E0' face='Arial' size='1.85'><b>Order ID</b></font></td>"
						+"<td width='150' align='left' color='#153E7E'><font face='Arial' size='1.85'><b>"+ DocketHID +"</b></font></td>"
						+"</tr><tr><td width='150' align='right' bgcolor='#153E7E'><font color='#E0E0E0' face='Arial' size='1.85'><b>GUID</b></font></td>"
						+"<td width='150' align='left' color='#153E7E'><font face='Arial' size='1.85'><b>"+ DocketNumber +"</b></font></td>"
						+"</tr><tr><td width='150' align='right' bgcolor='#153E7E'><font color='#E0E0E0' face='Arial' size='1.85'><b>Line Item</b></font></td>"
						+"<td width='150' align='left' color='#153E7E'><font face='Arial' size='1.85'><b>"+casenumber+"</b></font></td></tr>"
						+"</tr><tr><td width='150' align='right' bgcolor='#153E7E'><font color='#E0E0E0' face='Arial' size='1.85'><b>Product Name</b></font></td>"
						+"<td width='150' align='left' color='#153E7E'><font face='Arial' size='1.85'><b>"+Client+"</b></font></td></tr>");
				
				}
			catch(Exception e)
			{

			}
			finally
			{
				try{
					writer.flush();
					writer.close();
				}
				catch(Exception e){

				}
			}
	}
}
