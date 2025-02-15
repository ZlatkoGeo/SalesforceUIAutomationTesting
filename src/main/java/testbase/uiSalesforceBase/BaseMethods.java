package testbase.uiSalesforceBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;


public class BaseMethods extends BasePage{

	String elementLocatorsProperties = "/src/test/resources/elementLocators.properties";
	LocatorReader locatorReader = new LocatorReader(elementLocatorsProperties);
			
	By titleOfPage = By.xpath("//h1[@class=\"appName slds-context-bar__label-action slds-context-bar__app-name\"]//child::span[@class='slds-truncate']");
	
	String username = "****";
	String password = "***";
			
	public void logInSf() {

		driver.get("https://test.salesforce.com/");
		driver.manage().window().maximize();
		sendKeysBy("usernameId", username);
		sendKeysBy("passwordId", password);
		clickBy("logInToSandbox");
		String url = driver.getCurrentUrl();
		driver.manage().timeouts(). getPageLoadTimeout();
		log.info("Navigated to correct url" + ": " + url);

	}
	
	public void setApp() {
		
		waitForPageToLoad(driver);
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String currentTitle = driver.findElement(titleOfPage).getText();
		
	    if (!currentTitle.equals("Service")) {    
	        waitForElementToAppear(locatorReader.getLocator("appLauncher"));
	        clickBy("appLauncher");   	
	        waitForElementToAppear(locatorReader.getLocator("searchAppLauncher"));
			sendKeysBy("searchAppLauncher", "Service");
			sendKeysByKey("searchAppLauncher", Keys.ENTER);
	        waitForElementToAppear(locatorReader.getLocator("titleService"));
	    }    
	}
					
	public void waitForElementToAppear(By locator) {		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
	}

	// Method to wait for the page to be fully loaded
    public static void waitForPageToLoad(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait until the page's readyState is "complete"
        wait.until(driver1 -> js.executeScript("return document.readyState").equals("complete"));
    }
	
	public void scrollElementIntoView(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void skipTest(Boolean status) {
		
		Boolean datasetup = status;
		
		log.info("Skipping this test based on condition");
		if(datasetup == true) {
			log.info("Execute the test");
		}
		else {
			log.info("Do not execute further steps");
			throw new SkipException("Do not execute further steps");
		}
	}
	
	public void clickBy(String string) {
		
		By loginButton = locatorReader.getLocator(string);
        WebElement loginBtnElement = driver.findElement(loginButton);
        loginBtnElement.click();
		
	}
	
	public void sendKeysBy(String string, String string1) {
		
		By loginButton = locatorReader.getLocator(string);
        WebElement loginBtnElement = driver.findElement(loginButton);
        loginBtnElement.sendKeys(string1);
		
	}
	
	public void sendKeysByKey(String string, Keys enter) {
		
		By loginButton = locatorReader.getLocator(string);
        WebElement loginBtnElement = driver.findElement(loginButton);
        loginBtnElement.sendKeys(enter);
        	
	}
	
	public String getTextBy(String string) {
		
		By loginButton = locatorReader.getLocator(string);
        WebElement loginBtnElement = driver.findElement(loginButton);
        return loginBtnElement.getText();
		
	}
}
