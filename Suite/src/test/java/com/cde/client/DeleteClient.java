package com.cde.client;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.cde.helper.ActionDriver1;
import com.cde.helper.Reporters;
import com.cde.helper.Xls_Reader;
import com.cde.home.Home;
import com.cde.pages.Client;
import com.cde.pages.Login;

public class DeleteClient extends ActionDriver1{
	
	public static final Logger logger = LogManager.getLogger(Home.class);
	Client clientPage;
	Login loginPage;
	
	 @Test(priority=0,description = "Verify Client Page Successfully")
	  public void verifyClientPage() throws Throwable {
		  try {
			  System.out.println(System.getProperty("user.dir"));
			  clientPage = new Client(driver);
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
			  clientPage.moveToAdmin();
			  String clientPageTitle = clientPage.validateClientPage();
	          System.out.println(clientPageTitle);
			  Assert.assertEquals(clientPageTitle, "Client - List - Court Data Exchange Admin");
			  getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\VerifyLogin_valid_clienPage.jpeg");
			  Reporters.SuccessReport("ClientPage", "User Verified Client Page Successfully");
		  }catch(Exception e) {
				getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_valid_credentialfailed.jpeg");
				Reporters.failureReport("VerifyLogin_valid_credential", "Unable to VerifyLogin_valid_credentialScript");
		  }
	  }
	 
	 
	 @Test(priority=3, description="Verify Client Delete Functionality")
	  public void verifyClientDelete() throws Throwable {
		  try {
			  clientPage = new Client(driver);
			  clientPage.returnToClientPage();
			  String clientDeletePageTitle = clientPage.validateClientDeletePage();
			  Assert.assertEquals(clientDeletePageTitle, "Delete - Court Data Exchange Admin");
			  clientPage.returnToClientPage();
			  String act_result = clientPage.clientDelete();
			  String exp_result = clientPage.verifyDelitedClient();
			  Assert.assertEquals(act_result, exp_result);
			  getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\Verify_Deleted_Client");
			  Reporters.SuccessReport("ClientEditPage", "User Verified Deleted Client Successfully");
		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\Verify_client_delete_credentialfailed.jpeg");
			  Reporters.failureReport("VerifyLogin_valid_credential", "Unable to Verify_client_delete_Script");
		}
		  
	  }
	 
	 
	 @AfterTest
		public void closeBrowser() {
			if (driver != null)
				driver.close();
		}

}
