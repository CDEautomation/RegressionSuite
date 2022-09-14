package com.cde.helper;

import com.cde.base.Base1;
import com.cde.config.Property;

public class Reporters extends Base1{

	public static final String workingDir = System.getProperty("user.dir");
	public static Property configProps=new Property(workingDir + "\\src\\main\\java\\com\\cde\\config\\config.properties");
	static String  timeStamp=GetCurrentDate.timeStamp().replace(":", "_").replace(".", "_");

	public static void reportCreater() throws Throwable{
		int intReporterType=Integer.parseInt(configProps.getProperty("reportsType"));

		switch (intReporterType) {
		case 1:

			break;
		case 2:

			HtmlReporters.htmlCreateReport();
			HtmlReporters.createDetailedReport();

			break;
		default:

			HtmlReporters.htmlCreateReport();
			break;
		}
	}

	public static void SuccessReport(String strStepName, String strStepDes) throws Throwable{
		int intReporterType=Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:

			break;
		case 2:
			if(configProps.getProperty("OnSuccessScreenshot").equalsIgnoreCase("True"))
			{
				ActionDriver1.getScreenshot(Base1.filePath()+strStepDes.replace(" ", "_")+"_"+Base1.timeStamp+".jpeg");
			}
			HtmlReporters.onSuccess(strStepName, strStepDes);

			break;

		default:
			if(configProps.getProperty("OnSuccessScreenshot").equalsIgnoreCase("True"))
			{
				ActionDriver1.getScreenshot(Base1.filePath()+strStepDes.replace(" ", "_")+"_"+Base1.timeStamp+".jpeg");
			}
			HtmlReporters.onSuccess(strStepName, strStepDes);
			break;
		}
	}	

	public static void failureReport(String strStepName, String strStepDes) throws Throwable{
		int intReporterType=Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:
			flag= true;
			break;
		case 2:

			ActionDriver1.getScreenshot(Base1.filePath()+strStepDes.replace(" ", "_").replace(":", "_")+"_"+Base1.timeStamp+".jpeg");
			flag= true;
			HtmlReporters.onFailure(strStepName, strStepDes);

			break;

		default:
			flag =true;
			ActionDriver1.getScreenshot(Base1.filePath()+strStepDes.replace(" ", "_")+"_"+Base1.timeStamp+".jpeg");				
			HtmlReporters.onFailure(strStepName, strStepDes);
			break;
		}

	}
}
