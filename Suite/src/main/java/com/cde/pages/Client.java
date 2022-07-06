package com.cde.pages;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cde.helper.Xls_Reader;

public class Client {

	public String district_code;
	public String client_type;
	public String client_code;
	public String F_Name;
	public String L_Name;
	public String trustee_email;
	public String exp_Name;
	public String Client_Type = "Ch13";
	Scanner sc= new Scanner(System.in);
	Xls_Reader reader = new Xls_Reader(System.getProperty("user.dir") + "/Testdata/TestInput.xlsx");

	WebDriver driver=null;
	public Client(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(this.driver, this);

	}
	WebDriverWait wait;
	@FindBy(id="client")
	WebElement client_search;

	@FindBy(linkText="Add")
	WebElement add; 
	
	@FindBy(xpath="//input[@class='btn btn-danger']")
	WebElement delete;

	@FindBy(xpath="//*[@id=\"Client_DistrictCode\"]")
	WebElement district;

	@FindBy(xpath="//*[@id=\"Client_ClientTypeId\"]")
	WebElement clienttype;

	@FindBy(xpath="//*[@id=\"client-input\"]")
	WebElement clientname;

	@FindBy(id="Client_FirstName")
	WebElement ftrusteename;

	@FindBy(id="Client.MiddleInitial")
	WebElement mtrusteename;

	@FindBy(id="Client_LastName")
	WebElement ltrusteename;

	@FindBy(id="Client_EmailAddress")
	WebElement trustee_Email;

	@FindBy(id="Client_IsUsingCde")
	WebElement usingcde; 

	@FindBy(id="Client_ClaimsAllowed")
	WebElement claimallowed; 

	@FindBy(id="Client_ACPAllowed")
	WebElement acpallowed;

	@FindBy(id="Client_ZeroDocketAllowed")
	WebElement zerodocketallowed;

	@FindBy(id="submit")
	WebElement submitbtn;

	@FindBy(xpath="//*[@id=\"complex-interactive\"]/form/div[3]/a")
	WebElement Back;

	@FindBy(xpath="/html/body/header/nav/div/div/ul[2]/li[5]/ul/li[2]/a")
	WebElement Client;


	@FindBy(xpath="(//li[@id='admin-dropdown'])[4]")
	WebElement AdminDropdown;

	@FindBy(id="production-username")
	WebElement produsername;

	@FindBy(id="production-password")
	WebElement prodpassword;

	@FindBy(id="production-confirm")
	WebElement prodconfirm;

	@FindBy(id="production-submit")
	WebElement prodsubmit;

	@FindBy(xpath="//div[1]/div/label[4][@class=\"cancel-button\"]")
	WebElement prodcancel;

	@FindBy(xpath="//*[@id=\"production-delete\"]")
	WebElement DeleteCredential;

	@FindBy(xpath="//div/h4[1]/label[1]")
	WebElement prodedit;

	@FindBy(xpath="//div/h4[1]/label[1]")
	WebElement testedit;

	@FindBy(id="test-username")
	WebElement testusername;

	@FindBy(id="test-password")
	WebElement testpassword;

	@FindBy(id="test-confirm")
	WebElement testconfirm;

	@FindBy(id="test-submit")
	WebElement testsubmit;

	@FindBy(xpath="//div[2]/div/label[4][@class=\"cancel-button\"]")
	WebElement testcancel;

	@FindBy(xpath="//*[@id=\"test-delete\"]/img")
	WebElement testdelete;

	@FindBy(name="Client.DistrictCode")
	WebElement districtDropdown;

	@FindBy(name="Client.ClientTypeId")
	WebElement clientType;

	@FindBy(id="submit")
	WebElement save;

	@FindBy(xpath="//*[@id=\"client\"]")
	WebElement client_Search;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement Filter;

	@FindBy(linkText="Edit")
	WebElement editClient;
	
	@FindBy(linkText="Delete")
	WebElement deleteClient;

	@FindBy(id="Client_ClientCode")
	WebElement client_confirm;


	// This method is used to hover to Admin tab
	public void moveToAdmin() {
		Actions act = new Actions(driver);
		act.moveToElement(AdminDropdown).perform();
	}


	//This method is used to validate client page with the help of title
	public String validateClientPage() {
		Client.click();
		return driver.getTitle();
	}
    
	//This method is used to return to the client Page
	public void returnToClientPage() {
		Actions act = new Actions(driver);
		act.moveToElement(AdminDropdown).perform();
		Client.click();
	}
	
	//This method is used to validate client Add page with the help of title
	public String validateClientAddPage() {
		add.click();
		return driver.getTitle();
	}
	
	//This method is used to validate client Edit page with the help of title
    public String validateClientEditPage() {
    	returnToClientPage();
    	editClient.click();
    	return driver.getTitle();
    }
    
  //This method is used to validate client Delete page with the help of title
    public String validateClientDeletePage() {
    	deleteClient.click();
    	System.out.println(driver.getTitle());
    	return driver.getTitle();
    }
	
	//This method is used to search the client with the help of given client code
	public void search_Client(String client_name) {
		client_search.sendKeys(client_name);
		Filter.click();
		editClient.click();
	}
	
	//This method is used to enter trustee email address inside client page
	public void editTrusteeEmail() {
		System.out.print("\nEnter Email address :==> ");
		trustee_email = sc.nextLine();
		trustee_Email.clear();
		trustee_Email.sendKeys(trustee_email);
		System.out.println("\n");
	}
	
	//This method is used to give an Client Code from Excel Sheet for Edit purpose
	public String getClientCode(){
		int rowCount = reader.getRowCount("Client_Details");
		System.out.println("\nNumber of row count is :==>> "+ rowCount); 
		String name = reader.getCellData("Client_Details", "Client_Code", rowCount-1);
		return name;
	}
	
	//These function is used to add the details of client(First name, Last name, email address)
	public void addDetails() {
		
		F_Name = RandomStringUtils.randomAlphabetic(5);
		ftrusteename.clear();
		ftrusteename.sendKeys(F_Name);
		
		L_Name = RandomStringUtils.randomAlphabetic(5);
		ltrusteename.clear();
		ltrusteename.sendKeys(L_Name);
		
		trustee_email = "test"+RandomStringUtils.randomNumeric(5)+"@ecf.epiqsystems.com";
		trustee_Email.clear();
		trustee_Email.sendKeys(trustee_email);
		
		usingcde.click();
		claimallowed.click();
		acpallowed.click();
		save.click();
	}
	
	
	//This function is used to add the data into excel 
	public void addDataExcel() {
		
		
		int rowCount = reader.getRowCount("Client_Details");
		
		
		reader.setCellData("Client_Details", "District_Code", rowCount, "ALNB");

		reader.setCellData("Client_Details", "Client_Type", rowCount, "Ch13");

		reader.setCellData("Client_Details", "Client_Code", rowCount, exp_Name);

		reader.setCellData("Client_Details", "Trustee_Fname", rowCount, F_Name);

		reader.setCellData("Client_Details", "Trustee_Lname", rowCount, L_Name);

		reader.setCellData("Client_Details", "Client_Email", rowCount, trustee_email);
	}
	
	//These method is used to update the data into excel sheet
	public String[] updateDataExcel() {
		
		int rowCount = reader.getCellRowNum("Client_Details", "Client_Code", client_code);
		
		System.out.println("Number we get to update the Client_Type :==>>  "+rowCount);
		
		reader.setCellData("Client_Details", "District_Code", rowCount, "ALNB");

		reader.setCellData("Client_Details", "Client_Type", rowCount, "Ch13");

		reader.setCellData("Client_Details", "Trustee_Fname", rowCount, F_Name);

		reader.setCellData("Client_Details", "Trustee_Lname", rowCount, L_Name);

		reader.setCellData("Client_Details", "Client_Email", rowCount, trustee_email);
		
		return new String[] {F_Name, L_Name, trustee_email};
		
	}
	
	//These method is used to delete the data into excel sheet
	public void deleteDataExcel() {
		//int rowCount = reader.getCellRowNum("Client_Details", "Client_Code", client_code);
		//reader.removeColumn("Client_Details", rowCount);
		//System.err.println("Number to delete the row count is ::==>> "+rowCount);
		
		int rowCount = reader.getCellRowNum("Client_Details", "Client_Code", client_code);
		
		System.out.println("Number we get to update the Client_Type :==>>  "+rowCount);
		
		reader.setCellData("Client_Details", "District_Code", rowCount, "");

		reader.setCellData("Client_Details", "Client_Type", rowCount, "");
		
		reader.setCellData("Client_Details", "Client_Code", rowCount, "");

		reader.setCellData("Client_Details", "Trustee_Fname", rowCount, "");

		reader.setCellData("Client_Details", "Trustee_Lname", rowCount, "");

		reader.setCellData("Client_Details", "Client_Email", rowCount, "");
		
	}
	
	
	
	//These function is used to new add the client 
	public String clientAdd() {
		String ranstr = RandomStringUtils.randomAlphabetic(4);
		exp_Name = "Ch13-ALNB-"+ranstr;
		client_Search.sendKeys(exp_Name);
		Filter.click();
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table-scroll\"]/table/tbody/tr"));
		System.out.println("\nNumber of search client :==>> "+rows.size());
		if(rows.size()==0) {
			
			add.click();
			Select district_dropdown = new Select(districtDropdown);
			district_dropdown.selectByValue("ALNB");
			
			Select client_dropdown = new Select(clientType);
			client_dropdown.selectByVisibleText("Ch13");
			clientname.sendKeys(exp_Name);
			addDetails();
			addDataExcel();
			return exp_Name;
		}else {
			System.err.println("Already have an client with the same Client Code");
		}
		editClient.click();
		return null;
	}


	// These method is used to verify the added client details
	public String verifyAddedClient() {
		System.out.println("\n  Added Client Name is :-- "+exp_Name+"    \n");
		client_Search.sendKeys(exp_Name);
		Filter.click();
		editClient.click();
		String act_name = client_confirm.getAttribute("value");
		System.out.println("Actual Client Name we are getting is :===>> "+ act_name);
		return act_name;
	}
	
	//These function is used to edit the existing client details
	public String[] clientEdit() {
		client_code = getClientCode();
		System.out.println("Name of client code we are getting is :==>> "+client_code);
		client_search.sendKeys(client_code);
		Filter.click();
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table-scroll\"]/table/tbody/tr"));
		System.out.println("\nNumber of search client :==>> "+rows.size());
		editClient.click();		
		addDetails();
		String data[] = updateDataExcel();
		return data;
		
	}
	
	//These function is used to verify the details of edited client 
	public String[] verifyEditedClient() {
		returnToClientPage();
		search_Client(client_code);
		
		System.err.println("\nClient code we are searching is :==>> " +client_code);
		String first_name = ftrusteename.getAttribute("value") ;
		String last_name =	ltrusteename.getAttribute("value");
		String email_addr = trustee_Email.getAttribute("value");
		String data[] =  {first_name, last_name, email_addr};
		return data;
	}
	
	//These function is used to delete the details of deleted client
	public String clientDelete() {
		client_code = getClientCode();
		System.err.println("Name of client code we are getting to delete :==>> "+client_code);
		client_search.sendKeys(client_code);
		Filter.click();
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table-scroll\"]/table/tbody/tr"));
		System.err.println("\nNumber of search client to delete is :==>> "+rows.size());
		if(rows.size()>=1) {
			deleteClient.click();
			delete.click();
			deleteDataExcel();
			return "yes";
		}
		else {
			return "no";
		}
	}
	
	//These function is used to verify the details of deleted client
		public String verifyDelitedClient() {
			returnToClientPage();
			client_search.sendKeys(client_code);
			Filter.click();
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table-scroll\"]/table/tbody/tr"));
			System.err.println("\nClient code we are searching to verify is :==>> " +client_code);
			if(rows.size()>=1) {
				return "no";
			}
			else {
				return "yes";
			}
		}

}
















/*
public String clientEdit() {
	System.out.print("\nEnter Client Code for which You wants to Edit Details  :==>> ");
	client_code = sc.nextLine();
	client_search.clear();
	client_search.sendKeys(client_code);
	Filter.click();
	List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"table-scroll\"]/table/tbody/tr"));
	System.out.println("\nNumber of search client :==>> "+rows.size());
	if(rows.size()>=1) {
		editClient.click();
		System.out.println("\nEnter a choice of Field Which you want to Edit/Delete \n1.Trustee Name\n2.Email address\n3.Check Box check/unckeck\n4.Client Credential \n:==>>");
		String field_value = sc.nextLine();
		if(field_value.contains("1")) {
			editTrusteeName();
			save.click();
			return "1";
		}else if(field_value.contains("2")){
			editTrusteeEmail();
			save.click();
			return "2";
		}
		else if(field_value.contains("3")) {
			save.click();
			return "3";
		}
		else if(field_value.contains("4")) {
			save.click();
			return "4";
		}
		else {
			System.out.println("\nEnter a valid Input Field :==>> ");
		}
	}else {
		System.err.println("\nEnter a valid Client Code :==>> " );
		clientEdit();			
	}
	return "";
}
*/





/*
public String clientAdd() {
	try {
		System.out.print("\nEnter Client Code to Add the Client :==> ");
		district_code = sc.nextLine();
		System.out.println("\nClient Code is :==>> "+district_code);
		do {
			Select district_dropdown = new Select(districtDropdown);
			district_dropdown.selectByValue(district_code);

			try {
				System.out.print("\nEnter client Type for which wants to add the Client :==> ");
				client_type = sc.nextLine();
				Select client_dropdown = new Select(clientType);
				client_dropdown.selectByVisibleText(client_type);
				System.out.println("\nClient Code is :==>> "+client_type);

				clientname.sendKeys(client_type+district_code);
				exp_Name = client_type+district_code;

				if(client_type.contains("Ch13"))
				{
					do {
						System.out.print("\nEnter First Name:==> ");
						F_Name = sc.nextLine();
						if(F_Name.length()!=0) {
							ftrusteename.sendKeys(F_Name);
						}
						else {
							System.err.println("\nFirst Name is not Empty");
						}
					}while(F_Name.length()==0);
					
					do {
						System.out.print("\nEnter Last Name:==> "); 
						L_Name = sc.nextLine();
						if(L_Name.length()!=0) {
							ltrusteename.sendKeys(L_Name);
						}else {
							System.err.println("\nLast Name is not Empty");
						}
					}while(L_Name.length()==0);
				
					
					trustee_Email.sendKeys("test1234@ecf.epiqsystems.com");
				}
				else {
					trustee_Email.sendKeys("test1234@ecf.epiqsystems.com");
				}

				usingcde.click();
				claimallowed.click();
				acpallowed.click();
				save.click();
				return exp_Name;
			}
			catch (Exception e){
				System.err.println("\nEnter a Valid Client Code");
			}
		}while(district_code!=null);

	} catch (Exception e) {
		System.err.println("\nEnter a Valid District Code");
		clientAdd();
	}
	return exp_Name;
}
*/


/*

//This method is used to enter trustee name inside client page  
public void editTrusteeName() {
	do {
		System.out.print("\nEnter First Name:==> ");
		F_Name = sc.nextLine();
		if(F_Name.length()!=0) {
			ftrusteename.clear();
			ftrusteename.sendKeys(F_Name);
		}
		else {
			System.err.println("\nFirst Name is not Empty");
		}
	}while(F_Name.length()==0);
	
	do {
		System.out.print("\nEnter Last Name:==> "); 
		L_Name = sc.nextLine();
		if(L_Name.length()!=0) {
			ltrusteename.clear();
			ltrusteename.sendKeys(L_Name);
		}else {
			System.err.println("\nLast Name is not Empty");
		}
	}while(L_Name.length()==0);
	System.out.println("\n");
}
*/