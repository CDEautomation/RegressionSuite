package com.cde.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StartBrowser extends Base1 {
	  
	public static WebDriver driver;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

@AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.quit();
  }
}
