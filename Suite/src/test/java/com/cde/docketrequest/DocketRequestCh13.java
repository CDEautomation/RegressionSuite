package com.cde.docketrequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cde.helper.ActionDriver1;
import com.cde.helper.Reporters;
import com.cde.helper.Xls_Reader;
import com.cde.home.Home;
import com.cde.pages.Client;
import com.cde.pages.DocketRequestPage;
import com.cde.pages.Login;

public class DocketRequestCh13 extends ActionDriver1{
	public static final Logger logger = LogManager.getLogger(DocketRequestCh13.class);
	Home home;
	DocketRequestPage drp;
	
	
	@BeforeTest
	public void loginCDE() throws Throwable{
		home=new Home();
		home.verifyValidLogindetails();
	}
	@Test(priority=0,description = "Request with valid docket range")
	public void validDocketRange() throws Throwable {
		/* try { */
			
	
	
	drp=new DocketRequestPage(driver);
	
	drp.moveToRequest();
	//drp.clickonDRP();
	 
	Assert.assertEquals(drp.validateDocketRequestPage(), "Docket Requests - Court Data Exchange Admin");
	
	getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\Verifying DRP page.jpeg");
	
	Reporters.SuccessReport("DocketRequest", "User Verified Docket Request page Successfully");
	drp.clickonAddDRP();
	System.out.println("hello"); 
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
	String cname = reader.getCellData("DocketRequest", "ClientName", 2);
	String casenum = reader.getCellData("DocketRequest", "CaseNumber", 2);
	String fromrange = reader.getCellData("DocketRequest", "DocketFromRange", 2);
	String torange = reader.getCellData("DocketRequest", "DocketToRange", 2);
	drp.enterClient(cname);
	drp.enterCasenumber(casenum);
	drp.enterdocrangeFrom(fromrange);
	drp.enterdocrangeTo(torange);
	drp.checkUseTest();
	drp.drpSubmit();
	
		/*}catch(Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\Add Drp failed.jpeg");
			Reporters.failureReport("Verifying DRP with docket range", "Unable to add DRP script using valid docket range");
		}*/
		
	}
	
	 @AfterTest
		public void closeBrowser() {
			if (driver != null)
				driver.close();
		}
	  
	

}
