package uiSalesforce;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testbase.uiSalesforceBase.BasePage;
import testbase.uiSalesforceBase.LocatorReader;
import testbase.uiSalesforceBase.BaseMethods;

public class CreateContact extends BasePage{

	BaseMethods methods = new BaseMethods();
	SoftAssert softassert = new SoftAssert();
	
	String elementLocatorsProperties = "/src/test/resources/elementLocators.properties";
	LocatorReader locatorReader = new LocatorReader(elementLocatorsProperties);
	
	String firstName = "ZlatkoConOwn";
	String lastName = "geoConOwner04";
	String accountName = "ZlatkoAutoTest11Geo";
	String phoneNumber = "+38924448880";
	String mobileNumber = "+38970777222";
	String email = "georgievski.zlatko@hotmail.com";

	By selectAccountName = By.xpath("//lightning-base-combobox-formatted-text[@title='"+accountName+"']");	
	By actualContactNameLocator = By.xpath("//lightning-formatted-name[@slot=\"primaryField\"]");
	
	@Test(priority = 1, description = "This is a create contact test")
	public void createNewContact() {
				
		methods.logInSf();
		methods.setApp();
		methods.waitForElementToAppear(locatorReader.getLocator("contactObject"));
		methods.clickBy("contactObject");
		methods.waitForElementToAppear(locatorReader.getLocator("contactNewButton"));
		methods.clickBy("contactNewButton");
		methods.waitForElementToAppear(locatorReader.getLocator("contactFieldFirstName"));
		methods.sendKeysBy("contactFieldFirstName", firstName);
		methods.waitForElementToAppear(locatorReader.getLocator("contactFieldLastName"));
		methods.sendKeysBy("contactFieldLastName", lastName);
		methods.waitForElementToAppear(locatorReader.getLocator("contactFieldSearchAccounts"));
		methods.sendKeysBy("contactFieldSearchAccounts", accountName);
		methods.clickBy("contactFieldSearchAccounts");
		methods.waitForElementToAppear(selectAccountName);
		driver.findElement(selectAccountName).click();	
		methods.sendKeysBy("contactFieldPhone", phoneNumber);
		methods.sendKeysBy("contactFieldMobile", mobileNumber);
		methods.sendKeysBy("contactFieldEmail", email);
		methods.waitForElementToAppear(locatorReader.getLocator("saveEditButton"));
		methods.clickBy("saveEditButton");
		methods.waitForElementToAppear(actualContactNameLocator);
		String actualContactName = driver.findElement(actualContactNameLocator).getText();
		Assert.assertEquals(actualContactName, firstName + " " + lastName, "Verification failed");
	}
}
