package com.cde.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocketRequestPage {
	WebDriver driver=null;
	public DocketRequestPage(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(this.driver, this);

	}
	
	WebDriverWait wait;
	
	@FindBy(xpath="//li[2][@id=\"admin-dropdown\"]")
	WebElement req;
	
	
	
	@FindBy(xpath="//li[2][@id=\"admin-dropdown\"]/ul/li[2]/a")
	WebElement docketreq;
	
	//a[@class='add-button btn btn-success']
	
	@FindBy(xpath="//a[@class='add-button btn btn-success']")
	WebElement addBtn;
	
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
		public void moveToRequest() {
			Actions act = new Actions(driver);
			act.moveToElement(req).perform();
		}
		
		//This method is used to validate Docket Request page with the help of title
		public String validateDocketRequestPage() {
			docketreq.click();
			return driver.getTitle();
		}
		
		// This method is used to click on DocketRequest 
		public void clickonDRP() {
			Actions act = new Actions(driver);
			act.moveToElement(req).perform();
			docketreq.click();
		}
		
		// This method is used to click on add DocketRequest 
		public void clickonAddDRP() {
			
			addBtn.click();
		}	
	
		
		//This method is used to enter the client code
		public void enterClient(String client_name) {
			clientcode.clear();
			clientcode.sendKeys(client_name);
			
		}
		
		//This method is used to enter the client code
		public void enterCasenumber(String casenumber) {
			casenum.clear();
			casenum.sendKeys(casenumber);
			
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
		public void checkUseTest() {
			
			
			useTest.click();
			
			
		}	
		
		
		// This method is used to click on submit button
				public void drpSubmit() {
					
					submit.click();
				}	
}
