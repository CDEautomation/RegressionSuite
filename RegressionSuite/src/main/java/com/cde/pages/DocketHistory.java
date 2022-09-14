package com.cde.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DocketHistory {

	WebDriver driver = null;

	public DocketHistory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "(//a[@class='nav-link text-dark'])[3]")
	WebElement DocHistName;

	@FindBy(xpath = "//h1[text()='Docket History']")
	WebElement PageTitle;

	@FindBy(name = "DistrictCode")
	WebElement districtDropdown;

	@FindBy(id = "casenumber")
	WebElement CaseNum;

	@FindBy(id = "DocketNumberStart")
	WebElement DocNumStart;

	@FindBy(id = "DocketNumberEnd")
	WebElement DocNumEnd;

	@FindBy(id = "DocketStateId")
	WebElement StatusDropdown;

	@FindBy(id = "InsertedFrom")
	WebElement StartDate;

	@FindBy(id = "InsertedTo")
	WebElement EndDate;

	@FindBy(id = "client")
	WebElement ClientCode;

	@FindBy(id = "DocketSourceId")
	WebElement SourceDropdown;

	@FindBy(id = "ProductTypeId")
	WebElement ProductType;

	@FindBy(id = "DocumentType")
	WebElement DocumentType;

	@FindBy(xpath = "(//input[@name='ButtonType'])[2]")
	WebElement Reset;

	@FindBy(id = "filter")
	WebElement Filter;

	@FindBy(id = "RecordsPerPage")
	WebElement Pagination;

	// text based xpath
	@FindBy(xpath = "//span[text()='>>>']")
	WebElement NextPage;

	// text based xpath
	@FindBy(xpath = "//span[text()='<<<']")
	WebElement BackPage;

	public String validateDocHistPageTitle() {
		DocHistName.click();
		return driver.getTitle();
	}
	
	public void filterDocHistPage() {
		StartDate.clear();
		EndDate.clear();
		Filter.click();
	}
	
	public int[] getDate() {
		
		int[] data = new int[3];
		int date = ThreadLocalRandom.current().nextInt(01, 28 + 1);
		data[0] = date;
		int month = ThreadLocalRandom.current().nextInt(01, 12 + 1);
		data[1] = month; 
		int year = ThreadLocalRandom.current().nextInt(2020, 2022 + 1);
		data[2] = year;
		
		System.out.println("\n Value of date is : "+data[0]+"\n");
		
		System.out.println("\n Value of month is : "+data[1]+"\n");		

		System.out.println("\n Value of year is : "+data[2]+"\n");
		
		return data;
	}
	
	
	// These method is used to verify the district filter and pass the boolean result as per the details
	public boolean verifyFilterDist() {
		String[] strArray = new String[] { "AKB", "OHNB", "NCWB", "KSB", "INNB", "DEB",
				"PRB", "IASB", "MDB"};
		for (int i = 0; i <= strArray.length - 1; i++) {
			Select district_dropdown = new Select(districtDropdown);
			district_dropdown.selectByVisibleText(strArray[i]);
			filterDocHistPage();
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody[1]/tr"));
			for (int j = 1; j <= cells.size(); j++) {
				WebElement val = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+ j + "]/td[1]"));
				if (val.getText().equals(strArray[i])) {
					System.out.println("content we get >>   " + val.getText() + "\n");
				} else {
					System.out.println("\n Not getting an valid data ");
					return false;
				}
			}

		}
		return true;
	}
	
	public boolean verifyCaseFilter() {
		String[] strArray = new String[] { "06-12256", "22-00378", "22-00242", "14-01150", "21-10592", "19-12345",
				"12-34567", "21-17789", "21-12141" };
		for (int i = 0; i <= strArray.length - 1; i++) {
			CaseNum.sendKeys(strArray[i]);
			filterDocHistPage();
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody[1]/tr"));
			for (int j = 1; j <= cells.size(); j++) {
				WebElement val = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr[" + j + "]/td[2]"));
				if (val.getText().equals(strArray[i])) {
					System.out.println("content we get >>   " + val.getText() + "\n");
					CaseNum.clear();
				} else {
					System.out.println("\n Not getting an valid data ");
					return false;
				}
			}

		}
		return true;
	}	

	
	public boolean verifyStatusFilter() {
		String[] strArray = new String[] {"Failed", "Parsed", "Requested", "Retrieving", "Retrying", "Delivering",
				"Delivered", "RssCase", "FailedToRetrieve", "FailedInConsumer", "PacerLoginFailed" };
		for (int i = 0; i <= strArray.length - 1; i++) {
			Select status_dropdown = new Select(StatusDropdown);
			status_dropdown.selectByVisibleText(strArray[i]);
			filterDocHistPage();
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody[1]/tr"));
			for (int j = 1; j <= cells.size(); j++) {
				WebElement val = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+ j + "]/td[5]"));
				if (val.getText().contentEquals(strArray[i])) {
					System.out.println("content we get >>   " + val.getText() + "\n");
				} else {
					System.out.println("\n Not getting an valid data ");
					return false;
				}
			}

		}
		return true;

	}
	
	public boolean verifySourceFilter() {
		String[] strArray = new String[] { "Email", "Docket Request", "Claim Request", "Rss Feed", "DDP", "BNC Email"};
		for (int i = 0; i <= strArray.length - 1; i++) {
			Select source_dropdown = new Select(SourceDropdown);
			source_dropdown.selectByVisibleText(strArray[i]);
			filterDocHistPage();
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody[1]/tr"));
			for (int j = 1; j <= cells.size(); j++) {
				WebElement val = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+ j + "]/td[8]"));
				if (val.getText().equals(strArray[i].replaceAll("\\s",""))) {
					System.out.println("content we get >>   " + val.getText() + "\n");
				} else {
					System.out.println("\n Not getting an valid data ");
					return false;
				}
			}

		}
		return true;
	}

	public boolean verifyProductTypeFilter() {
		
		String[] strArray = new String[] { "Ch11", "Ch13", "AACER"};
		for (int i = 0; i <= strArray.length-1; i++) {
			Select producttype_dropdown = new Select(ProductType);
			producttype_dropdown.selectByVisibleText(strArray[i]);
			filterDocHistPage();
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody[1]/tr"));
			for (int j = 1; j <= cells.size(); j++) {
				WebElement val = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+ j + "]/td[4]"));
				String val1 = val.getText().toLowerCase();
				String val2 = strArray[i].toLowerCase();
				if (val1.contains(val2)) {
					System.out.println("content we get >>   " + val.getText() + "\n");
				} else {
					System.out.println("\n Not getting an valid data ");
					return false;
				}
			}
		}
		return true;
	}

	public boolean verifyDocumentTypeFilter() {

		String[] strArray = new String[] { "Document", "Claim", "Petition", "No Document", "Restricted",
				"Restricted Claim", "DDP", "BNC" };
		for (int i = 0; i <= strArray.length - 1; i++) {
			Select document_dropdown = new Select(DocumentType);
			document_dropdown.selectByVisibleText(strArray[i]);
			filterDocHistPage();
			List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody[1]/tr"));
			for (int j = 1; j <= cells.size(); j++) {
				WebElement val = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+ j + "]/td[7]"));
				if (val.getText().equals(strArray[i])) {
					System.out.println("content we get >>   " + val.getText() + "\n");
				} else {
					System.out.println("\n Not getting an valid data ");
					return false;
				}
			}
		}
		return true;
	}

	public boolean verifyDateRangeFilter() {
		int[] start_date = getDate();
		StartDate.sendKeys(""+start_date[0]+"-"+start_date[1]+"-"+start_date[2]+"");
//		int[] end_date = getDate();
		String end_date = "20-06-2022";
		EndDate.sendKeys(end_date);
//		EndDate.sendKeys(""+end_date[0]+"-"+end_date[1]+"-"+end_date[2]+"");
		Filter.click();
		
//		List<WebElement> cells = driver.findElements(By.xpath("//table[@class='table']/tbody[1]/tr"));
//		for (int j = 1; j <= cells.size(); j++) {
//			WebElement val = driver.findElement(By.xpath("//table[@class='table']/tbody[1]/tr["+ j + "]/td[6]"));
//			if( val >= start_date && val <= end_date) {
//				System.out.println("content we get >>   " + val.getText() + "\n");
//			} else {
//				System.out.println("\n Not getting an valid data ");
//				return false;
//			}
//		}
		
		return false;
	}

}