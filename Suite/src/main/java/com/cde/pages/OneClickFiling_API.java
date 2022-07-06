package com.cde.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OneClickFiling_API {
	
	WebDriver driver=null;
	 public OneClickFiling_API(WebDriver driver) { 
		  this.driver=driver;
	  PageFactory.initElements(this.driver, this);
	  
	  }
	
	@FindBy(linkText="Authentication")
	WebElement Authentication;
	
	@FindBy(id="client")
	WebElement ClientCode;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(id="MenuId")
	WebElement APIMenu;
	
	@FindBy(xpath="//*[@id=\"MenuId\"]/option[2]")
	WebElement EventCodes;
	
	@FindBy(xpath="//*[@id=\"MenuId\"]/option[3]")
	WebElement OneClickFiling;

}
