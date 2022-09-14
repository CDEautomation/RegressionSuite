package com.cde.helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;import org.testng.ITestContext;

import com.cde.base.Base1;

public class ActionDriver1 extends Base1{
	
	/**
	 * launch application URl
	 * @param url --Application url
	 */
	
	
	
	public static void launchApplication(String url) { 
		
		driver.get(url); }
	 
	public static void getScreenshot(String path) throws Exception
	 {
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		
		  FileUtils.copyFile(scrFile, new File(path));
		 
		
	  
	 }
	public static void takeScreenshot(String testName,WebDriver driver){
		try{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		if(driver!=null){
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destination = currentDir + "\\cde_screenshots\\" + testName + "_" + dateName + ".png";
        File finalDestination = new File(destination);
       FileUtils.copyFile(scrFile,finalDestination);
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void acceptalert() {
		//acceptalrt.click();
		
		  Alert alert = driver.switchTo().alert(); alert.accept();
		 
	}
}
