package com.cde.dockethistory;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cde.helper.Reporters;
import com.cde.helper.TakeScreenShot;
import com.cde.helper.Xls_Reader;
import com.cde.home.Home;
import com.cde.pages.DocketHistory;
import com.cde.pages.Login;
import com.cde.util.WebUtils;
import com.cde.helper.ActionDriver1;


public class CaseFilter extends ActionDriver1{
	
	public static final Logger logger = LogManager.getLogger(Home.class);
	DocketHistory dockethist;
	Login loginPage;
	
	@Test(priority = 0, description = "Verify Valid Docket History Page or not")
	public void verifyDocketHistoryPage() throws Throwable {
		try {
			System.out.println(System.getProperty("user.dir"));
			dockethist = new DocketHistory(driver);
			loginPage = new Login(driver);
			launchApplication("https://cde-qaf.epiqsystems.com/");
			Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
			String usrname = reader.getCellData("LoginCredentials", "username", 2);
			String pword = reader.getCellData("LoginCredentials", "password", 2);
			String pageTitle = loginPage.validateLoginPageTitle();
			System.out.println(pageTitle);
			Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
			loginPage.enterSignInUser(usrname);
			loginPage.enterPassword(pword);
			loginPage.clickOnSignIn();
			String docHistpageTitle = dockethist.validateDocHistPageTitle();
			System.out.println("Docket history Page Title is :--> " + docHistpageTitle);
			Assert.assertEquals(docHistpageTitle, "Docket History - Court Data Exchange Admin");
			getScreenshot(System.getProperty("user.dir") + "\\successScreenshots\\VerifyLogin_valid_dockethistory_Page.jpeg");
			Reporters.SuccessReport("DistrictPage", "User Verified Docket History Page Successfully");
		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir") + "\\FailedScreenshots\\VerifyLogin_valid_credentialfailed.jpeg");
			Reporters.failureReport("VerifyLogin_valid_credential", "Unable to VerifyLogin_valid_credentialScript");

		} catch (Error er) {
			TakeScreenShot.takeScreenshot("VerifyLogin_valid_credentialerror", driver);
			WebUtils.handleException("VerifyLogin_valid_credentialerror", er, logger);
		}
	}
	
	@Test(priority = 1, description = "Verify Case Filter functionality")
	public void verifyCaseFilter() throws Throwable {
		try {
			dockethist = new DocketHistory(driver);
			boolean result = dockethist.verifyCaseFilter();
			Assert.assertEquals(result, true);
			getScreenshot(System.getProperty("user.dir") + "\\successScreenshots\\Verify_dockethistory_case_Filter.jpeg");
			Reporters.SuccessReport("DocketHistoryPage", "User Verified Docket History Case Filter Successfully");

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir") + "\\FailedScreenshots\\Verify_case_filterfailed.jpeg");
			Reporters.failureReport("Verify_case_filter", "Unable to Verify_Case_FilterScript");
		}
	}

}
