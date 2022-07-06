package com.cde.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User {
	
	WebDriver driver=null;
	 public User(WebDriver driver) { 
		  this.driver=driver;
	  PageFactory.initElements(this.driver, this);
	  
	  }
	 
	 @FindBy(id="Code")
	 WebElement User;
	 
	 
	 @FindBy(id="Code")
	 WebElement User1;
	 
	 @FindBy(id="Code")
	 WebElement User2;
	 
	 @FindBy(id="Code")
	 WebElement User3;
	 
	 @FindBy(id="Code")
	 WebElement User4;
	 

}
