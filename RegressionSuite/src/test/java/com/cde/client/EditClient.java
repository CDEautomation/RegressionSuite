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

public class EditClient extends ActionDriver1 {
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
	
	@Test(priority=2, description="Verify Client Edit Functionality")
	  public void verifyEditClient() throws Throwable {
		  try {
			  clientPage = new Client(driver);
			  String clientEditPageTitle = clientPage.validateClientEditPage();
			  Assert.assertEquals(clientEditPageTitle, "Client - Edit - Court Data Exchange Admin");
			  clientPage.returnToClientPage();
			  String act_result[] = clientPage.clientEdit();
			  String exp_result[] = clientPage.verifyEditedClient();
			  System.out.println("\nActual Result we are getting is :==>> "+act_result[0]+act_result[1]+act_result[2]);
			  System.out.println("\nExpeted Result we are getting is :==>> "+exp_result[0]+exp_result[1]+exp_result[2]+"\n");
			  Assert.assertEquals(act_result, exp_result);
			  Assert.assertEquals(act_result[1], exp_result[1]);
			  Assert.assertEquals(act_result[2], exp_result[2]);
			  getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\Verify_Edited_Client");
			  Reporters.SuccessReport("ClientEditPage", "User Verified Edit Client Successfully");
		  }catch (Exception e) {
			  getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\Verify_client_edit_credentialfailed.jpeg");
			  Reporters.failureReport("VerifyLogin_valid_credential", "Unable to Verify_client_edit_Script");
		}
		 
	  }
	
	@AfterTest
	public void closeBrowser() {
		if (driver != null)
			driver.close();
	}

}
