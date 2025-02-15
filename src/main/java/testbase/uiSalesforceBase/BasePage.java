package testbase.uiSalesforceBase;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static String browser = "Firefox";
	public static WebDriver driver;
	public static Logger log = (Logger) LogManager.getLogger(BasePage.class.getName());
	
	@BeforeSuite
	public void launchBrowser() {
			
		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	}
	
	@AfterSuite
	public void closingBrowser() {
		
		driver.close();
	}
}
		

