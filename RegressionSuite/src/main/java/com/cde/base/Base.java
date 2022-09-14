/*
 * package com.cde.base;
 * 
 * import java.io.FileInputStream; import java.io.FileNotFoundException; import
 * java.io.IOException; import java.nio.file.Files; import java.nio.file.Path;
 * import java.nio.file.Paths; import java.util.HashMap; import
 * java.util.Properties; import java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions; import
 * org.openqa.selenium.firefox.FirefoxDriver; import
 * org.openqa.selenium.remote.CapabilityType; import
 * org.openqa.selenium.remote.DesiredCapabilities;
 * 
 * import com.cde.helper.HtmlReporters; import com.cde.helper.Reporters;
 * 
 * public class Base { public WebDriver driver; public static Properties prop;
 * public static final String workingDir = System.getProperty("user.dir");
 * 
 * public Base() { try {
 * 
 * prop = new Properties(); FileInputStream fi = new FileInputStream( workingDir
 * + "\\src\\main\\java\\com\\cde\\config\\application.properties");
 * prop.load(fi);
 * 
 * } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException
 * e) { e.printStackTrace(); }
 * 
 * }
 * 
 * @SuppressWarnings("deprecation") public void initialization(String url)
 * throws Throwable {
 * 
 * String browserName = prop.getProperty("browser");
 * 
 * if(browserName.equals("chrome")){
 * 
 * System.setProperty("webdriver.chrome.driver",workingDir+
 * "/downloads/chromedriver.exe");
 * 
 * ChromeOptions options = new ChromeOptions();
 * 
 * //DesiredCapabilities cap = DesiredCapabilities.chrome();
 * //cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
 * //cap.setCapability(ChromeOptions.CAPABILITY, options); //options.merge(cap);
 * driver = new ChromeDriver(options);
 * 
 * }else
 * 
 * if (browserName.equals("firefox")) {
 * System.setProperty("webdriver.gecko.driver", workingDir +
 * "/Executable/geckodriver.exe"); driver = new FirefoxDriver();
 * 
 * }
 * 
 * driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 * 
 * 
 * driver.get(url);
 * 
 * 
 * }
 * 
 * 
 * }
 */