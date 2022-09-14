package com.cde.claimrequest;

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
import com.cde.pages.ClaimRequestPage;

public class ClaimRequestCh13 extends ActionDriver1 {
	

	public static final Logger logger = LogManager.getLogger(ClaimRequestCh13.class);
	Home home;
	ClaimRequestPage crp;

	@BeforeTest
	public void loginCDE() throws Throwable {
		home = new Home();
		home.verifyValidLogindetails();
	}

	@Test(priority = 0, description = "Request with valid docket range")
	public void validDocketRange() throws Throwable {
		try {

			System.out.println("hello");
			crp = new ClaimRequestPage(driver);

			crp.moveToRequest();
			Thread.sleep(1000);
			crp.clickonDRP();

			Assert.assertEquals(crp.validateClaimśRequestPage(), "Claim Requests - Court Data Exchange Admin");

			getScreenshot(System.getProperty("user.dir") + "\\successScreenshots\\Verifying CRP page.jpeg");

			Reporters.SuccessReport("DocketRequest", "User Verified Claim Request page Successfully");
			System.out.println("hello");
			crp.clickonAddCRP();
			Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
			String cname = reader.getCellData("ClaimRequest", "ClientName", 2);
			String casenum = reader.getCellData("ClaimRequest", "CaseNumber", 2);
			String fromrange = reader.getCellData("ClaimRequest", "DocketFromRange", 2);
			String torange = reader.getCellData("ClaimRequest", "DocketToRange", 2);
			crp.enterClient(cname);
			crp.enterCasenumber(casenum);
			System.out.println(casenum);
			crp.enterdocrangeFrom(fromrange);
			crp.enterdocrangeTo(torange);
			crp.scroll();
			crp.checkUseTest();
			crp.drpSubmit();

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir") + "\\FailedScreenshots\\Add crp failed.jpeg");
			Reporters.failureReport("Verifying CRP with docket range",
					"Unable to add CRP script using valid docket range");
		}

	}

	@AfterTest
	public void closeBrowser() {
		if (driver != null)
			driver.close();
	}



}
