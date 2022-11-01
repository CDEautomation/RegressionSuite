package com.cde.util;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtils {
	
	
	private static WebDriver driver = null;
	
				
		public static void handleException(String description, Throwable ex, Logger logger) {
			StringWriter sw = new StringWriter();
			ex.printStackTrace(new PrintWriter(sw));
			String error = sw.toString();
			logger.error(error);
			
			//Assert.fail(description + "  -->  " + error);
		}
		
		public static void mouseHover(By locator)
		{
			WebElement mo=driver.findElement(locator);
			Actions a = new Actions(driver);
			a.moveToElement(mo).perform();
		}
		
		public static void WaitVisibilityOfElementIDLocated(WebDriver driver,By present){
			   WebDriverWait wait = new WebDriverWait(driver, 60);
			   wait.until(ExpectedConditions.visibilityOfElementLocated(present));
			 }
		
		public static double getRandomIntegerBetweenRange(double min, double max) {
			double x = (int) (Math.random() * ((max - min) + 1)) + min;
			return x;
		}
		
		public static void mouseHoverSpecificLocator(WebDriver driver, WebElement element) {

			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();

		}
		
		public static boolean isElementDisplayed(WebElement element) {
			try {
				return element.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}
		
		public static void enterTextInTextBox(WebDriver driver, WebDriverWait wait, WebElement webEelement,
				String textTobeSet) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webEelement));
				element.clear();
				element.sendKeys(textTobeSet);
			} catch (StaleElementReferenceException e) {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webEelement));
				element.sendKeys(textTobeSet);
			}

		}
		
		public static void clickEventByUsingJavascriptExe(WebDriver driver, WebDriverWait wait, WebElement webEelement)
				throws Exception {

			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(webEelement));
			// wait.until(ExpectedConditions.visibilityOf(webEelement));
			try {
				JavascriptExecutor ex = (JavascriptExecutor) driver;
				ex.executeScript("arguments[0].click();", webEelement);
			} catch (Exception e) {
				// Thread.sleep(500);
				e.printStackTrace();
				webEelement.click();
			}
		}
	// These method is used to select a dropdown menu with the help of given text 
		public static void selectByText(WebElement element, String text) {
			Select district_dropdown = new Select(element);
			district_dropdown.selectByVisibleText(text);
			
		}

		


}
