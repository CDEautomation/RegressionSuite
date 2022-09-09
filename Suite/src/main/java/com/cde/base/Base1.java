package com.cde.base;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cde.config.Property;
import com.cde.helper.Accessories;
import com.cde.helper.GetCurrentDate;
import com.cde.helper.HtmlReporters;
import com.cde.helper.Reporters;

import java.net.MalformedURLException;

public class Base1 
{
	public static final String workingDir = System.getProperty("user.dir");
	public static Property configProps=new Property(workingDir + "\\src\\main\\java\\com\\cde\\config\\config.properties");
	public static String currentSuite="";
	public static String method="";
	public static String timeStamp=GetCurrentDate.timeStamp().replace(" ","_").replace(":","_").replace(".", "_");
	public static boolean flag =false;
	public static WebDriver driver;
	//public static Integer count=1;
	public static String result=null;
	public static String mesg=null;
	public static String TESTCASENAME="";
	
	public static String dbName = "test";
	public static String userName = "root";
	public static Connection conn = null;
	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static int count=1;
	public static int x=0;

	static String browser=null;
	static int len=0;
	static int i=0;
	static int j=0;
	static	 ITestContext itc;
			

	@BeforeSuite(alwaysRun = true) 
	public  void setupSuite(ITestContext ctx) throws Throwable {
		itc=ctx;
		String strBrowserType[];
		Accessories.calculateSuiteStartTime();


		browser=configProps.getProperty("browserType");

		if(!(browser.toString().contains(",")))
		{
			strBrowserType=new String[]{browser};
		}
		else
		{
			strBrowserType=browser.split("\\,");
		}
		len =strBrowserType.length;
		while(i<len)

		{
			//String browserType=strBrowserType[i];
			if(strBrowserType[i].toString().equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", workingDir + "/Executable/geckodriver.exe");
				driver = new FirefoxDriver();
				i=i+1;
				break;

			}
			else if(strBrowserType[i].toString().equalsIgnoreCase("ie"))
			{
				File file = new File("Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver= new InternetExplorerDriver();
				i=i+1;
				break;

			}
			else if(strBrowserType[i].toString().equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",workingDir + "/downloads/chromedriver.exe"); 
				 ChromeOptions options = new ChromeOptions();
				 driver = new ChromeDriver(options);
				 driver.manage().window().maximize();
				i=i+1;
				break;

			}

		}

		try 
		{
			
			Reporters.reportCreater();
			HtmlReporters.currentSuit = ctx.getCurrentXmlTest().getSuite().getName();
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
		
	}
	


	/**
	 *  De-Initializing and closing all the connections
	 * @throws Throwable
	 */

	@AfterSuite(alwaysRun = true) 
	public void getSummaryReport(ITestContext ctx) throws Throwable 
	{
		Accessories.calculateSuiteExecutionTime();
		HtmlReporters.createHtmlSummaryReport();
	}

	
	//@Parameters({"browserType"})
	public static String filePath()
	{
		String strDirectoy="";
		if(configProps.getProperty("browserType").equalsIgnoreCase("Chrome"))
		{
			strDirectoy="Chrome\\Chrome";	

		}
		else if(configProps.getProperty("browserType").equalsIgnoreCase("firefox"))
		{
			
			strDirectoy="Firefox/Firefox";
		}
		else
		{
			strDirectoy="IE\\IE";

		}

		if(strDirectoy!="")
		{
			new File(configProps.getProperty("screenShotPath")+strDirectoy+"_"+timeStamp).mkdirs();
		}

		
		return configProps.getProperty("screenShotPath")+strDirectoy+"_"+timeStamp+"/";
		

	}
	
	public static String result_browser()
	{
		if(configProps.getProperty("browserType").equals("Chrome"))
		{
			return "Chrome";
		}
		else if(configProps.getProperty("browserType").equals("firefox"))
		{
			return "Firefox";
		}
		else
		{
			return "IE";
		}
	}
	
	public static String methodName()
	{
		if(configProps.getProperty("browserType").equals("Chrome"))
		{
			return "post";
		}
		else
		{
			return "POST";
		}
	}


	@BeforeMethod(alwaysRun=true)
	public void reportHeader(Method method){
		
		flag=false;
		HtmlReporters.tc_name=method.getName().toString();
		String[] ts_Name=this.getClass().getName().toString().split("\\.");
		
		HtmlReporters.packageName=ts_Name[1];
		
		HtmlReporters.testHeader(HtmlReporters.tc_name);
	}
}
