package uiSalesforce;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.uiSalesforceBase.BaseMethods;
import testbase.uiSalesforceBase.BasePage;
import testbase.uiSalesforceBase.LocatorReader;
import testbase.uiSalesforceBase.WritingScreenShotsToXls;


public class CreateAccount extends BasePage{	
	
		BaseMethods methods = new BaseMethods();
		WritingScreenShotsToXls screenshot = new WritingScreenShotsToXls();
		
		String elementLocatorsProperties = "/src/test/resources/elementLocators.properties";
		LocatorReader locatorReader = new LocatorReader(elementLocatorsProperties);
		
		String accountName = "ZlatkoAutoTest13Geo";
		
		By actualAccountNameLocator = By.xpath("//lightning-formatted-text[@slot=\"primaryField\"]");

		@Test(priority = 1, description = "This is a create account test")
		public void createConsumerAccount() throws IOException {
			methods.logInSf();
			methods.setApp();
			methods.waitForElementToAppear(locatorReader.getLocator("accountObjet"));
			methods.clickBy("accountObjet");
			methods.waitForElementToAppear(locatorReader.getLocator("accountNewButton"));
			methods.clickBy("accountNewButton");
			methods.waitForElementToAppear(locatorReader.getLocator("radioButton"));
			methods.clickBy("radioButton");
			methods.waitForElementToAppear(locatorReader.getLocator("nextButton"));
			methods.clickBy("nextButton");
			methods.waitForElementToAppear(locatorReader.getLocator("accountFieldName"));
			methods.sendKeysBy("accountFieldName", accountName);
			methods.waitForElementToAppear(locatorReader.getLocator("saveEditButton"));
			methods.clickBy("saveEditButton");
			methods.waitForElementToAppear(actualAccountNameLocator);
			String actualAccountName = driver.findElement(actualAccountNameLocator).getText();
			Assert.assertEquals(actualAccountName, accountName, "Verification failed");
			screenshot.screenShotToExcel(1, 5, 5);	
	}

}
