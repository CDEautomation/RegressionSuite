package com.cde.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Login {
	WebDriver driver=null;
	 public Login(WebDriver driver) { 
		  this.driver=driver;
	  PageFactory.initElements(this.driver, this);
	  
	  }
	WebDriverWait wait;
	@FindBy(name = "Username")
	WebElement userName;

	@FindBy(id = "idSIButton9")
	WebElement next;

	@FindBy(name = "Password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Submit' and @id='submit']")
	WebElement signinbtn;
	
	@FindBy(xpath="//span[@class = \"alert-danger\"]")
	WebElement errorMessage;
	
	@FindBy(xpath = "//a[text() = \"Logout\"]")
	WebElement logout;
	
	@FindBy(xpath = "//span[@id = \"UserIdentity\"]")
	WebElement UserIdentity;
	
	@FindBy(xpath="//button/span[text()=\"Accept\"]")
	WebElement acceptalrt;
	
	
	
	
	 
	 
	//This method is used to get the page title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	/**
	 * This method to enter the username
	 * 
	 * @throws Exception
	 */
	public void enterSignInUser(String uname) {
		userName.clear();
		userName.sendKeys(uname);
		  
	}
	/**
	 * This method to enter the password
	 * 
	 * @throws Exception
	 */
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	/**
	 * This method to click on Sign In button
	 * 
	 * @throws Exception
	 */
	public void clickOnSignIn() throws Exception {
		signinbtn.click();
	}
	/**
	 * This method to get the error message
	 * 
	 * @throws Exception
	 */
	public String getErrorMessage() {
		String errorMessage=this.errorMessage.getText();
		return errorMessage;
	}
	
	//This method is used to get the home page title
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		public void userIdentity() {
			UserIdentity.click();
		}
		
		public void logout() {
			logout.click();
		}
		
		
		
		
}
