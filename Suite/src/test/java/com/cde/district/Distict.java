package com.cde.district;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.cde.helper.ActionDriver1;
import com.cde.helper.Reporters;
import com.cde.helper.TakeScreenShot;
import com.cde.helper.Xls_Reader;
import com.cde.home.Home;
import com.cde.pages.DistrictPage;
import com.cde.pages.Login;
import com.cde.util.WebUtils;

public class Distict extends ActionDriver1 {
	
	public static final Logger logger = LogManager.getLogger(Home.class);
	DistrictPage districtPage;
	Login loginPage;
	@Test(priority = 0, description = "User is able to validate Valid District Page or not")
	public void verifyValidDistrictPage() throws Throwable {
		try {
			System.out.println(System.getProperty("user.dir"));
			districtPage = new DistrictPage(driver);
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
			districtPage.moveToAdmin();
            String distpageTitle = districtPage.validateDistrictPageTitle();
            System.out.println(distpageTitle);
			Assert.assertEquals(distpageTitle, "Districts - Court Data Exchange Admin");
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\VerifyLogin_valid_districtPage.jpeg");
			Reporters.SuccessReport("DistrictPage", "User Verified District Page Successfully");

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_valid_credentialfailed.jpeg");
			Reporters.failureReport("VerifyLogin_valid_credential", "Unable to VerifyLogin_valid_credentialScript");

		} catch (Error er) {
			TakeScreenShot.takeScreenshot("VerifyLogin_valid_credentialerror", driver);
			WebUtils.handleException("VerifyLogin_valid_credentialerror", er, logger);
		}

	}
	
	@Test(priority=1, description="Verify District functionality")
	public void verifyDistrict() throws Throwable {
		try {
			districtPage = new DistrictPage(driver);
			
			for (int i=50; i<=98; i++) {
				
			
			Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
			String distName = reader.getCellData("District", "DistrictName", i);
			districtPage.gotoDist(distName);
			
			String dist_Name1 = districtPage.verifyDistrictName();
			Assert.assertEquals(dist_Name1, distName);
			
			String prodversion = districtPage.getProductVersion();
			String expProdVersion = reader.getCellData("District", "ProdVersion", i);
			Assert.assertEquals(prodversion, expProdVersion);
						
			String testversion = districtPage.getTestVersion();
			String expTestVersion = reader.getCellData("District", "TestVersion", i);
			Assert.assertEquals(testversion, expTestVersion);
			
			String trainingversion = districtPage.getTrainingVersion();
			String expTrainVersion = reader.getCellData("District", "TrainingVersion", i);
			Assert.assertEquals(trainingversion, expTrainVersion);
			
			String numberOfClient = districtPage.getClientCount();
			String clientCount = reader.getCellData("District", "NumberofClient", i);
			Assert.assertEquals(numberOfClient, clientCount);
			
			districtPage.returnToDistrictPage();
			}
			
			
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\Verify_districtPage.jpeg");
			Reporters.SuccessReport("DistrictPage", "User Verified Districts Successfully");
		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_valid_credentialfailed.jpeg");
			Reporters.failureReport("Verify_valid_district_details", "Unable to Verify District_details_Script");

		} 
	}
	
	
	
	@AfterTest
	public void closeBrowser() {
		if (driver != null)
			driver.close();
	}

}