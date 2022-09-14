package com.cde.helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {
	
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

}
