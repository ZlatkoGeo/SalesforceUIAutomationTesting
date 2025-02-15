package uiSalesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testbase.uiSalesforceBase.BaseMethods;
import testbase.uiSalesforceBase.BasePage;
import testbase.uiSalesforceBase.LocatorReader;

public class AddInfoToTheAccount extends BasePage{
	
	BaseMethods methods = new BaseMethods();
	SoftAssert softassert = new SoftAssert();
	String elementLocatorsProperties = "/src/test/resources/elementLocators.properties";
	LocatorReader locatorReader = new LocatorReader(elementLocatorsProperties);
	
	String accountName = "ZlatkoAutoTest10Geo";
	String billingStreetAddress = "Pitu Guli 20/15";
	String billingPostalCodeAddress = "1000";
	String billingCityAddress = "Skopje";
	String billingCountryAdress = "Macedonia";

	By clickExistingAccount = By.xpath("//th[@scope=\"row\"]//following::a[text()='"+accountName+"']");

	@Test(priority = 1, description = "This is a test for additional information")
	public void addInfoForBillingAddress() {
		methods.logInSf();
		methods.setApp();
		methods.waitForElementToAppear(locatorReader.getLocator("accountObjet"));
		methods.clickBy("accountObjet");
		methods.waitForElementToAppear(locatorReader.getLocator("selectAccountListView"));
		methods.clickBy("selectAccountListView");
		methods.waitForElementToAppear(locatorReader.getLocator("listViewTypeAllAccounts"));
		methods.clickBy("listViewTypeAllAccounts");
		methods.waitForElementToAppear(locatorReader.getLocator("searchBoxAccount"));
		methods.sendKeysBy("searchBoxAccount", accountName);
		methods.sendKeysByKey("searchBoxAccount", Keys.ENTER);
		methods.waitForElementToAppear(clickExistingAccount);
		driver.findElement(clickExistingAccount).click();
		methods.waitForElementToAppear(locatorReader.getLocator("editBillingAddress"));
		methods.clickBy("editBillingAddress");
		methods.sendKeysBy("billingStreetField", billingStreetAddress);
		methods.sendKeysBy("billingPostalCodeField", billingPostalCodeAddress);
		methods.sendKeysBy("billingCityField", billingCityAddress);
		methods.sendKeysBy("billingCountryField", billingCountryAdress);
		methods.clickBy("saveEditButton");
		methods.waitForElementToAppear(locatorReader.getLocator("billingAddressOneLocator"));
		String billingAddressOne = methods.getTextBy("billingAddressOneLocator");
		softassert.assertEquals(billingAddressOne, billingStreetAddress, "Verification failed");
		String billingAddressTwo = methods.getTextBy("billingAddressTwoLOcator");
		softassert.assertEquals(billingAddressTwo, billingPostalCodeAddress + " " + billingCityAddress, "Verification failed");
		String billingAddressThree = methods.getTextBy("billingAddressThreeLocator");
		softassert.assertEquals(billingAddressThree, billingCountryAdress, "Verification failed");

	}
}
