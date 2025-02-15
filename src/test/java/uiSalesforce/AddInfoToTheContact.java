package uiSalesforce;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testbase.uiSalesforceBase.BaseMethods;
import testbase.uiSalesforceBase.BasePage;
import testbase.uiSalesforceBase.LocatorReader;
import testbase.uiSalesforceBase.WritingScreenShotsToXls;

public class AddInfoToTheContact extends BasePage{
	
	BaseMethods methods = new BaseMethods();
	WritingScreenShotsToXls screenshot = new WritingScreenShotsToXls();
	SoftAssert softassert = new SoftAssert();
	
	String elementLocatorsProperties = "/src/test/resources/elementLocators.properties";
	LocatorReader locatorReader = new LocatorReader(elementLocatorsProperties);
	
	String contactName = "ZlatkoConOwn geoConOwner11";
	String faxInfo = "+38975888364";
	String otherPhoneInfo = "+076333789";
	String assistentInfo = "Simeon Petrevski";
	String assistentPhoneInfo = "+078949015";
	String descriptionInfo = "Test Automation";
	
	By clickExistingContact = By.xpath("//th[@scope=\"row\"]//following::a[text()='"+contactName+"']");
	
	@Test(priority = 1, description = "This is a test for additional information")
	public void addInfoForDifferentFields() throws IOException, InterruptedException {
		methods.logInSf();
		methods.setApp();
		methods.waitForElementToAppear(locatorReader.getLocator("contactObject"));
		methods.clickBy("contactObject");
		methods.waitForElementToAppear(locatorReader.getLocator("selectContactListView"));
		methods.clickBy("selectContactListView");
		methods.waitForElementToAppear(locatorReader.getLocator("listViewTypeAllContacts"));
		methods.clickBy("listViewTypeAllContacts");
		methods.waitForElementToAppear(locatorReader.getLocator("searchBoxContact"));
		methods.sendKeysBy("searchBoxContact", contactName);
		methods.sendKeysByKey("searchBoxContact", Keys.ENTER);
		methods.waitForElementToAppear(clickExistingContact);
		driver.findElement(clickExistingContact).click();
		methods.waitForElementToAppear(locatorReader.getLocator("detailsContactTab"));
		methods.clickBy("detailsContactTab");
		methods.waitForElementToAppear(locatorReader.getLocator("faxContactEditButton"));
		methods.clickBy("faxContactEditButton");
		methods.sendKeysBy("faxContactField", faxInfo);
		methods.sendKeysBy("otherPhoneField", otherPhoneInfo);
		methods.sendKeysBy("assistantContactField", assistentInfo);
		methods.sendKeysBy("asstPhoneContactField", assistentPhoneInfo);
		methods.sendKeysBy("descriptionField", descriptionInfo);
		methods.clickBy("saveEditButton");
		methods.waitForElementToAppear(locatorReader.getLocator("acctualFaxInfoLocator"));
		String acctualFaxInfo = methods.getTextBy("acctualFaxInfoLocator");
		softassert.assertEquals(acctualFaxInfo, faxInfo, "Verification failed");		
		methods.waitForElementToAppear(locatorReader.getLocator("acctualOtherPhoneLocator"));
		String acctualOtherPhone = methods.getTextBy("acctualOtherPhoneLocator");
		softassert.assertEquals(acctualOtherPhone, otherPhoneInfo, "Verification failed");		
		methods.waitForElementToAppear(locatorReader.getLocator("acctualAssistantLocator"));
		String acctualAssistant = methods.getTextBy("acctualAssistantLocator");
		softassert.assertEquals(acctualAssistant, assistentInfo, "Verification failed");		
		methods.waitForElementToAppear(locatorReader.getLocator("acctualAssistantPhoneLocator"));
		String acctualAssistantPhone = methods.getTextBy("acctualAssistantPhoneLocator");
		softassert.assertEquals(acctualAssistantPhone, assistentPhoneInfo, "Verification failed");		
		methods.waitForElementToAppear(locatorReader.getLocator("acctualDescriptionLocator"));
		String acctualDescription = methods.getTextBy("acctualDescriptionLocator");
		softassert.assertEquals(acctualDescription, descriptionInfo, "Verification failed");		
		screenshot.screenShotToExcel(5, 5, 6);
		softassert.assertAll();
	}
}
