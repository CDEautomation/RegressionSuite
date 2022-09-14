package com.cde.district;
import com.cde.helper.ActionDriver1;
import com.cde.helper.Reporters;
import com.cde.helper.TakeScreenShot;
import com.cde.util.WebUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.cde.helper.Xls_Reader;
import com.cde.home.Home;
import com.cde.pages.DistrictPage;
import com.cde.pages.Login;

public class EditDistrict extends ActionDriver1 {
	
	
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
	
	@Test(priority=1, description="Verify AKB District edit functionality")
	public void verifyAKBDistrict() throws Throwable {
		try {
			districtPage = new DistrictPage(driver);
			
			Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
			String distName = reader.getCellData("District", "DistrictName", 2);
			districtPage.gotoDist(distName);
			
			String dist_Name1 = districtPage.verifyDistrictName();
			Assert.assertEquals(dist_Name1, "District Of Alaska");
			
			String prodversion = districtPage.getProductVersion();
			String expProdVersion = reader.getCellData("District", "ProdVersion", 2);
			Assert.assertEquals(prodversion, expProdVersion);
			
			
			String testversion = districtPage.getTestVersion();
			String expTestVersion = reader.getCellData("District", "TestVersion", 2);
			Assert.assertEquals(testversion, expTestVersion);
			
			String trainingversion = districtPage.getTrainingVersion();
			String expTrainVersion = reader.getCellData("District", "TrainingVersion", 2);
			Assert.assertEquals(trainingversion, expTrainVersion);
			
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\Verify_AKB_districtPage.jpeg");
			Reporters.SuccessReport("DistrictPage", "User Verified AKB District Page Successfully");
		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_valid_credentialfailed.jpeg");
			Reporters.failureReport("Verify_valid_district_details", "Unable to Verify District_details_Script");

		} 
	}
	
	@Test(priority=2, description="Verify Client Count")
	public void verifyClientCount() throws Throwable{
		try {
			
		Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
		districtPage = new DistrictPage(driver);
		String numberOfClient = districtPage.getClientCount();
		String clientCount = reader.getCellData("District", "NumberofClient", 2);
		Assert.assertEquals(numberOfClient, clientCount);
		getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\Verify_Client_Count.jpeg");
		Reporters.SuccessReport("DistrictPage", "User Verified AKB District Client Count Successfully");
		
		}catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\Verify_client_Countfailed.jpeg");
			Reporters.failureReport("VerifyLogin_valid_credential", "Unable to Verify_client_CountScript");

		}
	}
	
	@AfterTest
	public void closeBrowser() {
		if (driver != null)
			driver.close();
	}

}