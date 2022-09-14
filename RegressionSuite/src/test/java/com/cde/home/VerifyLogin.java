/*
 * package com.cde.home;
 * 
 * import org.testng.annotations.Test;
 * 
 * import com.cde.base.Base; import com.cde.helper.TakeScreenShot; import
 * com.cde.pages.Login; import com.cde.reportlisteners.ExtentReporter; import
 * com.cde.util.WebUtils; import com.relevantcodes.extentreports.ExtentReports;
 * import com.relevantcodes.extentreports.ExtentTest;
 * 
 * import org.testng.annotations.BeforeTest; import
 * org.apache.log4j.BasicConfigurator; import org.apache.log4j.LogManager;
 * import org.apache.log4j.Logger; import org.openqa.selenium.By; import
 * org.testng.Assert; import org.testng.annotations.AfterTest;
 * 
 * public class VerifyLogin extends Base { public static final Logger logger =
 * LogManager.getLogger(VerifyLogin.class); public Login loginPage; static
 * ExtentReports report; static ExtentTest test;
 * 
 * public VerifyLogin() { super();
 * System.out.println(prop.getProperty("browser"));
 * BasicConfigurator.configure(); logger.info("Validation over invalid login");
 * }
 * 
 * @BeforeTest public void setUp() throws Throwable { report = new
 * ExtentReports( System.getProperty("user.dir") +
 * "\\src\\main\\java\\com\\cde\\testdata\\ExtentReportResults.html"); test =
 * report.startTest("VerifyLogin", "to verify the login page ");
 * logger.info("In setUp method LoginValidation");
 * initialization("https://cde-qaf.epiqsystems.com");
 * 
 * // System.out.println(prop.getProperty("url"));
 * 
 * }
 * 
 * @Test(priority = 4, description =
 * "ValidCredential::UserIsLoggedInSuccessfully") public void verifyValidLogin()
 * { try { loginPage = new Login(driver); String pageTitle =
 * loginPage.validateLoginPageTitle(); Assert.assertEquals(pageTitle,
 * "Login - Court Data Exchange Admin");
 * loginPage.enterSignInUser(prop.getProperty("username"));
 * loginPage.enterPassword(prop.getProperty("password"));
 * loginPage.clickOnSignIn(); Thread.sleep(3000); String hpageTitle =
 * loginPage.validateHomePageTitle(); Assert.assertEquals(hpageTitle,
 * "Home page - Court Data Exchange Admin");
 * 
 * // loginPage.userIdentity(); Thread.sleep(1000); loginPage.logout();
 * 
 * } catch (Exception ex) {
 * TakeScreenShot.takeScreenshot("VerifyLogin_valid_credential", driver);
 * WebUtils.handleException("VerifyLogin_valid_credential", ex, logger); } catch
 * (Error er) { TakeScreenShot.takeScreenshot("VerifyLogin_valid_credential",
 * driver); WebUtils.handleException("VerifyLogin_valid_credential", er,
 * logger);
 * 
 * }
 * 
 * }
 * 
 * @Test(priority = 0, description = "BlankCredential::Failedmessage displayed",
 * enabled = false) public void verifyBlankCredentials() { try { loginPage = new
 * Login(driver); String pageTitle = loginPage.validateLoginPageTitle();
 * Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
 * loginPage.enterSignInUser(""); loginPage.enterPassword("");
 * loginPage.clickOnSignIn(); Thread.sleep(2000);
 * Assert.assertEquals(loginPage.getErrorMessage(),
 * "Enter valid Username or Password."); Thread.sleep(1000); } catch (Exception
 * ex) { TakeScreenShot.takeScreenshot("VerifyLogin_BlankCredential", driver);
 * WebUtils.handleException("VerifyLogin_BlankCredential", ex, logger); } catch
 * (Error er) { TakeScreenShot.takeScreenshot("VerifyLogin_BlankCredential",
 * driver); WebUtils.handleException("VerifyLogin_BlankCredential", er, logger);
 * 
 * }
 * 
 * }
 * 
 * @Test(priority = 1, description = "InvalidUsername::Failedmessage displayed")
 * public void verifyIncorrectPwd() { try { loginPage = new Login(driver);
 * String pageTitle = loginPage.validateLoginPageTitle();
 * Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
 * loginPage.enterSignInUser(prop.getProperty("Incorrectuname"));
 * loginPage.enterPassword(prop.getProperty("password"));
 * loginPage.clickOnSignIn(); Thread.sleep(2000);
 * Assert.assertEquals(loginPage.getErrorMessage(),
 * "Enter valid Username or Password."); Thread.sleep(1000); } catch (Exception
 * ex) { TakeScreenShot.takeScreenshot("VerifyLogin_Invalid_username", driver);
 * WebUtils.handleException("VerifyLogin_Invalid_username", ex, logger); } catch
 * (Error er) { TakeScreenShot.takeScreenshot("VerifyLogin_Invalid_username",
 * driver); WebUtils.handleException("VerifyLogin_Invalid_username", er,
 * logger);
 * 
 * }
 * 
 * }
 * 
 * @Test(priority = 2, description = "InvalidPassword::Failedmessage displayed")
 * public void verifyIncorrectUname() { try { loginPage = new Login(driver);
 * String pageTitle = loginPage.validateLoginPageTitle();
 * Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
 * loginPage.enterSignInUser(prop.getProperty("username"));
 * loginPage.enterPassword(prop.getProperty("Incorrectpwd"));
 * loginPage.clickOnSignIn(); Thread.sleep(2000);
 * Assert.assertEquals(loginPage.getErrorMessage(),
 * "Enter valid Username or Password.");
 * 
 * } catch (Exception ex) {
 * TakeScreenShot.takeScreenshot("VerifyLogin_Invalid_password", driver);
 * WebUtils.handleException("VerifyLogin_Invalid_password", ex, logger); } catch
 * (Error er) { TakeScreenShot.takeScreenshot("VerifyLogin_Invalid_password",
 * driver); WebUtils.handleException("VerifyLogin_Invalid_password", er,
 * logger);
 * 
 * }
 * 
 * }
 * 
 * @Test(priority = 3, description = "Invaliduserpwd::Failedmessage displayed")
 * public void verifyIncorrectUserPwd() { try { loginPage = new Login(driver);
 * String pageTitle = loginPage.validateLoginPageTitle();
 * Assert.assertEquals(pageTitle, "Login - Court Data Exchange Admin");
 * loginPage.enterSignInUser(prop.getProperty("Incorrectuname1"));
 * loginPage.enterPassword(prop.getProperty("Incorrectpwd1"));
 * loginPage.clickOnSignIn(); Thread.sleep(2000);
 * Assert.assertEquals(loginPage.getErrorMessage(),
 * "Enter valid Username or Password."); } catch (Exception ex) {
 * TakeScreenShot.takeScreenshot("VerifyLogin_Invalid_credential", driver);
 * WebUtils.handleException("VerifyLogin_Invalid_credential", ex, logger); }
 * catch (Error er) {
 * TakeScreenShot.takeScreenshot("VerifyLogin_Invalid_credential", driver);
 * WebUtils.handleException("VerifyLogin_Invalid_credential", er, logger);
 * 
 * }
 * 
 * }
 * 
 * @AfterTest public void closeBrowser() { if (driver != null) driver.close(); }
 * 
 * }
 */