package com.cde.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DistrictPage {
	int count = 1;

	WebDriver driver=null;
	 public DistrictPage(WebDriver driver) { 
		  this.driver=driver;
	  PageFactory.initElements(this.driver, this);
	  
	  }
	
	@FindBy(id="Code")
	WebElement DistrictCode;
	
	@FindBy(id="district")
	WebElement DistrictName; 
	
	@FindBy(xpath="(//li[@id='admin-dropdown'])[4]")
	WebElement AdminDropdown;
	
	@FindBy(xpath="/html/body/header/nav/div/div/ul[2]/li[5]/ul/li[3]/a")
	WebElement District;
	
	@FindBy(xpath="//input[@class='btn btn-secondary']")
	WebElement Reset;
	// class based Xpath
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement Filter;
	
	@FindBy(xpath="//*[@id=\"RecordsPerPage\"]")
	WebElement PageFilter;
	
	@FindBy(xpath="//span[text()='>>>']")
	WebElement NextPage;
	//text based xpath
	
	@FindBy(xpath="//span[text()='<<<']")
	WebElement BackPage;
	//text based xpath
	
	@FindBy(xpath="//table[@class='table']//a")
	WebElement showClients;
	//parent based Xpath for AKB district
	
	@FindBy(xpath="//*[@id=\"table-scroll\"]/table/tbody/tr[1]/td[5]/a")
	WebElement Edit1;
	
	@FindBy(xpath="//*[@id=\"table-scroll\"]/table/tbody/tr[2]/td[5]/a")
	WebElement Edit2;
	
	@FindBy(linkText="Edit")
	WebElement editDistrict;
	
	
	@FindBy(xpath="//input[@id='District_Name']")
	WebElement dist_Name;
	
	@FindBy(xpath="//select[@id='ProductionPacerVersion']")
	WebElement ProductionVersion;
	
	@FindBy(xpath="//select[@id='TestPacerVersion']")						
	WebElement TestVersion;
	
	@FindBy(xpath="//select[@id='TrainingPacerVersion']")
	WebElement TrainVersion;
	
	@FindBy(xpath="/html/body/div[3]/main/form/div[1]/div[2]/div[3]/a")
	WebElement selectDropDown;
	
	@FindBy(xpath="//*[@id=\"table-scroll\"]/table/tbody/tr")
	WebElement getClientCount;
	
	
	
	// This method is used to hover to admin tab
	public void moveToAdmin() {
		Actions act = new Actions(driver);
		act.moveToElement(AdminDropdown).perform();
	}
	
	
	//This method is used to get the district page title
	public String validateDistrictPageTitle() {
		District.click();
		return driver.getTitle();
	}
	
	
	// This method is use to filter the district with the given name  
	public void gotoDist(String distName) {
		DistrictName.sendKeys(distName);
		Filter.click();
		if(getRowsCount()>1) {
			count = count +1;
			if(count % 2 == 0) {
				Edit1.click();
				}
			else {
				Edit2.click();
				}
			}
		else {
		editDistrict.click();
		count = 1;
		}
	}
	
	
	//This method is used to get the number of rows count from table 
	public int getRowsCount() {
		
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table-scroll\"]/table/tbody/tr"));
		return rows.size();
		
	}
	
	
	//This method is used to get the Name of district From district-Edit Tab
	public String verifyDistrictName() {
		String distname = dist_Name.getAttribute("value");
		return distname;
	}
	
	
	//This method is used to get the value of product version of particular district
	public String getProductVersion() {
		String prodVersion = new Select(ProductionVersion).getFirstSelectedOption().getText();
		return prodVersion;
	}
	
	
	//This method is used to get the value of Test version of particular district
	public String getTestVersion() {
		String testVersion = new Select(TestVersion).getFirstSelectedOption().getText();
		return testVersion;
	}
    
	
	//This method is used to get the value of training version of particular district
	public String getTrainingVersion() {
		String trainVersion = new Select(TrainVersion).getFirstSelectedOption().getText();
		return trainVersion;		
	}
	
	
	//This method is used to return the number count of client of particular district
	public String getClientCount() {
		selectDropDown.click();
		new Select (PageFilter).selectByVisibleText("50");
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table-scroll\"]/table/tbody/tr"));
		String s=Integer.toString(rows.size());
		return s;
	}
	
	//This method is used to return to the district page  
	public void returnToDistrictPage() {
		Actions act = new Actions(driver);
		act.moveToElement(AdminDropdown).perform();
		District.click();
	}

}
