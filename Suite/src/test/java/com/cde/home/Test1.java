package com.cde.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
	public  WebDriver driver;
  @Test
  public void f() {
	  System.out.println(System.getProperty("user.dir"));
	  System.setProperty("webdriver.chrome.driver","C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","C:/Users/624269/OneDrive - Epiq Inc/Documents/CDEAdminTest/Suite/Executable/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://cde-qaf.epiqsystems.com/");
		//driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.close();
				//driver.manage()
  }
}