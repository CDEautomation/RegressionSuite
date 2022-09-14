package com.cde.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cde.util.ICommonConstants;
import com.cde.util.WebUtils;

public class DocketRequestPage extends WebUtils {
	WebDriver driver=null;
	WebDriverWait wait;
	public DocketRequestPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		wait=new WebDriverWait(driver, ICommonConstants.EXPLICIT_WAIT);
	}
	

	
	@FindBy(xpath="//li[@id='admin-dropdown'][1]")
	WebElement req;
	
	
	
	@FindBy(linkText="Docket Requests")
	WebElement docketreq;
	
	//a[@class='add-button btn btn-success']
	
	@FindBy(linkText="Add")
	WebElement addbtn; 
	
	@FindBy(id="client")
	WebElement clientcode;
	
	
	@FindBy(id="caseNumbers")
	WebElement casenum;
	
	@FindBy(id="IsDocketRequest")
	WebElement isDocketchk;
	
	@FindBy(id="IsClaimRequest")
	WebElement isClaimchk;
	
	@FindBy(id="DocketRangeFrom")
	WebElement docketRangeFrom;
	
	@FindBy(id="DocketRangeTo")
	WebElement docketRangeTo;
	
	@FindBy(id="DocketFiledRangeFrom")
	WebElement docketFiledRangeFrom;
	
	@FindBy(id="DocketFiledRangeTo")
	WebElement docketFiledRangeTo;
	
	@FindBy(id="UseTestMode")
	WebElement useTest;
	
	@FindBy(id="submit")
	WebElement submit;
	
	// This method is used to hover to Requests tab
		public void moveToRequest() throws Exception {
			Actions act = new Actions(driver);
			act.moveToElement(req).perform();
			//WebUtils.clickEventByUsingJavascriptExe(driver, wait, docketreq);
		}
		
		//This method is used to validate Docket Request page with the help of title
		public String validateDocketRequestPage() {
			
			return driver.getTitle();
		}
		
		// This method is used to click on DocketRequest 
		public void clickonDRP() throws Exception {
			//Actions act = new Actions(driver);
			//act.moveToElement(docketreq).perform();
			WebUtils.clickEventByUsingJavascriptExe(driver, wait, docketreq);
			//docketreq.click();
			//WebUtils.mouseHover(docketreq);
		}
		
		// This method is used to click on add DocketRequest 
		public void clickonAddDRP() throws Exception {
			WebUtils.clickEventByUsingJavascriptExe(driver, wait, addbtn);
			//addbtn.click();
		}	
	
		
		//This method is used to enter the client code
		public void enterClient(String client_name) {
			//clientcode.clear();
			//clientcode.sendKeys(client_name);
			WebUtils.enterTextInTextBox(driver, wait, clientcode, client_name);
			WebUtils.useTabKey(driver);
			
		}
		
		//This method is used to enter the client code
		public void enterCasenumber(String casenumber) {
			//casenum.clear();
			//casenum.sendKeys(casenumber);
			WebUtils.enterTextInTextBox(driver, wait, casenum, casenumber);
			WebUtils.useTabKey(driver);
		}	
		

		//This method is used to enter the client code
		public void checkDocketRequest() {
			
			
			
		}	
		
		
		//This method is used to enter document range from 
		public void enterdocrangeFrom(String from) {
			docketRangeFrom.clear();
			docketRangeFrom.sendKeys(from);
			
		}		
	
		//This method is used to enter document range To
		public void enterdocrangeTo(String to) {
			docketRangeTo.clear();
			docketRangeTo.sendKeys(to);
			
		}

		//This method is used to check the use test 
		public void checkUseTest() throws Exception {
			
			WebUtils.clickEventByUsingJavascriptExe(driver, wait, useTest);
			useTest.click();
			WebUtils.useTabKey(driver);
			
		}	
		
		public void scroll() throws Exception {
			WebUtils.scrollToView(driver, submit);
		}
		
		
		// This method is used to click on submit button
				public void drpSubmit() {
					
					submit.click();
				}
				
				public String getErrorMessage() {
					return null;
				//	String errorMessage=this.errorMessage.getText();
					//return errorMessage;
				}
}
