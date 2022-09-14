package com.cde.home;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.cde.helper.ActionDriver1;
import com.cde.helper.Reporters;
import com.cde.helper.TakeScreenShot;
import com.cde.helper.Xls_Reader;
import com.cde.pages.Login;
import com.cde.util.WebUtils;

public class Home extends ActionDriver1 {

	public static final Logger logger = LogManager.getLogger(Home.class);
	Login loginPage;

	@Test(priority = 4, description = "ValidCredential::UserIsLoggedInSuccessfully")
	public void verifyValidLogindetails() throws Throwable {
		try {
			System.out.println(System.getProperty("user.dir"));
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
			Thread.sleep(3000);
			String hpageTitle = loginPage.validateHomePageTitle();
			Assert.assertEquals(hpageTitle, "Home page - Court Data Exchange Admin");
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\VerifyLogin_valid_credential.jpeg");
			Reporters.SuccessReport("LoginPage", "UserIsLoggedInSuccessfully is Successfull");

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_valid_credentialfailed.jpeg");
			Reporters.failureReport("VerifyLogin_valid_credential", "Unable to VerifyLogin_valid_credentialScript");

		} catch (Error er) {
			TakeScreenShot.takeScreenshot("VerifyLogin_valid_credentialerror", driver);
			WebUtils.handleException("VerifyLogin_valid_credentialerror", er, logger);
		}

	}

	@Test(priority = 0, description = "BlankCredential::Failedmessage displayed")
	public void verifyBlankCredentials() throws Throwable {
		try {
			Login loginPage = new Login(driver);
			launchApplication("https://cde-qaf.epiqsystems.com/");
			String pageTitle = loginPage.validateLoginPageTitle();
			Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
			loginPage.enterSignInUser("");
			loginPage.enterPassword("");
			loginPage.clickOnSignIn();
			Thread.sleep(2000);
			Assert.assertEquals(loginPage.getErrorMessage(), "Enter valid Username or Password.");
			Thread.sleep(1000);
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\VerifyLogin_BlankCredential.jpeg");
			Reporters.SuccessReport("LoginPage", "BlankCredential is veryfied Successfully");

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_BlankCredentialfailed.jpeg");
			Reporters.failureReport("VerifyLogin_BlankCredential", "Unable to VerifyLogin_BlankCredentialScript");

		} catch (Error er) {
			TakeScreenShot.takeScreenshot("VerifyLogin_BlankCredentialerror", driver);
			WebUtils.handleException("VerifyLogin_BlankCredentialerror", er, logger);
		}

	}


	@Test(priority = 1, description = "InvalidUsername::Failedmessage displayed")
	public void verifyIncorrectUname() throws Throwable {
		try {
			loginPage = new Login(driver);
			launchApplication("https://cde-qaf.epiqsystems.com/");
			Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
			String usrname = reader.getCellData("LoginCredentials", "username", 3);
			String pword = reader.getCellData("LoginCredentials", "password", 3);
			String pageTitle = loginPage.validateLoginPageTitle();
			Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
			loginPage.enterSignInUser(usrname);
			loginPage.enterPassword(pword);
			loginPage.clickOnSignIn();
			Thread.sleep(2000);
			Assert.assertEquals(loginPage.getErrorMessage(), "Enter valid Username or Password.");
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\VerifyLogin_InvalidUsername.jpeg");
			Reporters.SuccessReport("LoginPage", "InvalidUsername is verified Successfully");

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_InvalidUsernamefailed.jpeg");
			Reporters.failureReport("VerifyLogin_InvalidUsername", "Unable to VerifyLogin_InvalidUsernameScript");

		} catch (Error er) {
			TakeScreenShot.takeScreenshot("VerifyLogin_InvalidUsernameerror", driver);
			WebUtils.handleException("VerifyLogin_InvalidUsernameerror", er, logger);
		}

	}

	@Test(priority = 2, description = "InvalidPassword::Failedmessage displayed")
	public void verifyIncorrectPwd() throws Throwable {
		try {
			loginPage = new Login(driver);
			launchApplication("https://cde-qaf.epiqsystems.com/");
			Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
			String usrname = reader.getCellData("LoginCredentials", "username", 4);
			String pword = reader.getCellData("LoginCredentials", "password", 4);
			String pageTitle = loginPage.validateLoginPageTitle();
			Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
			loginPage.enterSignInUser(usrname);
			loginPage.enterPassword(pword);
			loginPage.clickOnSignIn();
			Thread.sleep(2000);
			Assert.assertEquals(loginPage.getErrorMessage(), "Enter valid Username or Password.");
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\VerifyLogin_InvalidPassword.jpeg");
			Reporters.SuccessReport("LoginPage", "InvalidPassword is verified Successfully");

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_InvalidPasswordfailed.jpeg");
			Reporters.failureReport("VerifyLogin_InvalidPassword", "Unable to VerifyLogin_InvalidPasswordScript");

		} catch (Error er) {
			TakeScreenShot.takeScreenshot("VerifyLogin_InvalidPassworderror", driver);
			WebUtils.handleException("VerifyLogin_InvalidPassworderror", er, logger);
		}

	}
	
	
	@Test(priority = 3, description = "Invalid_usernamepassword::Failedmessage displayed")
	public void verifyIncorrectUserPwd() throws Throwable {
		try {
			loginPage = new Login(driver);
			launchApplication("https://cde-qaf.epiqsystems.com/");
			Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");
			String usrname = reader.getCellData("LoginCredentials", "username", 5);
			String pword = reader.getCellData("LoginCredentials", "password", 5);
			String pageTitle = loginPage.validateLoginPageTitle();
			Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
			loginPage.enterSignInUser(usrname);
			loginPage.enterPassword(pword);
			loginPage.clickOnSignIn();
			Thread.sleep(2000);
			Assert.assertEquals(loginPage.getErrorMessage(), "Enter valid Username or Password.");
			getScreenshot(System.getProperty("user.dir")+"\\successScreenshots\\VerifyLogin_Invalid_usernamepassword.jpeg");
			Reporters.SuccessReport("LoginPage", "Invalid_usernamepassword is verified Successfully");

		} catch (Exception e) {
			getScreenshot(System.getProperty("user.dir")+"\\FailedScreenshots\\VerifyLogin_Invalid_usernamepasswordfailed.jpeg");
			Reporters.failureReport("VerifyLogin_Invalid_usernamepassword", "Unable to VerifyLogin_Invalid_usernamepasswordScript");

		} catch (Error er) {
			TakeScreenShot.takeScreenshot("VerifyLogin_Invalid_usernamepassworderror", driver);
			WebUtils.handleException("VerifyLogin_Invalid_usernamepassword", er, logger);
		}

	}

	
	@AfterTest
	public void closeBrowser() {
		if (driver != null)
			driver.close();
	}

}
