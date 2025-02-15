package uiSalesforce;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.uiSalesforceBase.BasePage;
import testbase.uiSalesforceBase.BaseMethods;
import testbase.uiSalesforceBase.LocatorReader;
import testbase.uiSalesforceBase.WritingScreenShotsToXls;

public class CreateCase extends BasePage {

	BaseMethods methods = new BaseMethods();
	WritingScreenShotsToXls screenshot = new WritingScreenShotsToXls();
	
	String elementLocatorsProperties = "/src/test/resources/elementLocators.properties";
	LocatorReader locatorReader = new LocatorReader(elementLocatorsProperties);
		
	String contactName = "ZlatkoConOwn geoConOwner11";
	String accountName = "ZlatkoAutoTest11Geo";
	
	By selectContactName = By.xpath("//lightning-base-combobox-formatted-text[@title='"+contactName+"']");
	By selectAccountName = By.xpath("//input[@placeholder=\"Search Accounts...\"]//following::lightning-base-combobox-formatted-text[@title='"+accountName+"']");
	
	@Test(priority = 1, description = "This is a create case test 01")
	public void createNewCase01() throws IOException {
		methods.logInSf();
		methods.setApp();
		methods.waitForElementToAppear(locatorReader.getLocator("caseObject"));
		methods.clickBy("caseObject");
		methods.waitForElementToAppear(locatorReader.getLocator("caseNewButton"));
		methods.clickBy("caseNewButton");
		methods.waitForElementToAppear(locatorReader.getLocator("caseFieldContact"));
		methods.sendKeysBy("caseFieldContact", contactName);
		methods.clickBy("caseFieldContact");
		methods.waitForElementToAppear(selectContactName);
		driver.findElement(selectContactName).click();		
		methods.waitForElementToAppear(locatorReader.getLocator("caseFieldSearchAccounts"));
		methods.sendKeysBy("caseFieldSearchAccounts", accountName);
		methods.clickBy("caseFieldSearchAccounts");
		methods.waitForElementToAppear(selectAccountName);
		driver.findElement(selectAccountName).click();		
		methods.waitForElementToAppear(locatorReader.getLocator("caseFieldCaseOrigin"));
		methods.scrollElementIntoView(locatorReader.getLocator("caseFieldCaseOrigin"));
		methods.clickBy("caseFieldCaseOrigin");
		methods.clickBy("caseOriginPhone");
		methods.clickBy("saveEditButton");
		methods.waitForElementToAppear(locatorReader.getLocator("caseContactNameLocator"));
		String caseContactName = driver.findElement(locatorReader.getLocator("caseContactNameLocator")).getText();
		Assert.assertEquals(caseContactName, contactName, "Verification failed");
		String caseAccountName = driver.findElement(locatorReader.getLocator("caseAccountNameLocator")).getText();
		Assert.assertEquals(caseAccountName, accountName, "Verification failed");
		screenshot.screenShotToExcel(3, 5, 5);
		log.info("Case 01 is created successfully");

	}
	
	@Test(priority = 2, description = "This is a create case test 02", dependsOnMethods = "createNewCase01", alwaysRun = true)
	public void createNewCase02() throws IOException {
		
		methods.skipTest(false);
		
		methods.logInSf();
		methods.setApp();
		methods.waitForElementToAppear(locatorReader.getLocator("caseObject"));
		methods.clickBy("caseObject");
		methods.waitForElementToAppear(locatorReader.getLocator("caseNewButton"));
		methods.clickBy("caseNewButton");
		methods.waitForElementToAppear(locatorReader.getLocator("caseFieldContact"));
		methods.sendKeysBy("caseFieldContact", contactName);
		methods.clickBy("caseFieldContact");
		methods.waitForElementToAppear(selectContactName);
		driver.findElement(selectContactName).click();
		methods.waitForElementToAppear(locatorReader.getLocator("caseFieldSearchAccounts"));
		methods.sendKeysBy("caseFieldSearchAccounts", accountName);
		methods.clickBy("caseFieldSearchAccounts");
		methods.waitForElementToAppear(selectAccountName);
		driver.findElement(selectAccountName).click();
		methods.waitForElementToAppear(locatorReader.getLocator("caseFieldCaseOrigin"));
		methods.scrollElementIntoView(locatorReader.getLocator("caseFieldCaseOrigin"));
		methods.clickBy("caseFieldCaseOrigin");
		methods.clickBy("caseOriginPhone");
		methods.clickBy("saveEditButton");
		methods.waitForElementToAppear(locatorReader.getLocator("caseContactNameLocator"));
		String caseContactName = driver.findElement(locatorReader.getLocator("caseContactNameLocator")).getText();
		Assert.assertEquals(caseContactName, contactName, "Verification failed");
		String caseAccountName = driver.findElement(locatorReader.getLocator("caseAccountNameLocator")).getText();
		Assert.assertEquals(caseAccountName, accountName, "Verification failed");
		
	}

}
