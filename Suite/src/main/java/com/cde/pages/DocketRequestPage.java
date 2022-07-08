package com.cde.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	
	
	
}
