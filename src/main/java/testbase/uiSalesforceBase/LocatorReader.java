package testbase.uiSalesforceBase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.InputStream;

public class LocatorReader {
	
	private Properties properties;
	
	 // Constructor to load properties file
    public LocatorReader(String filePath) {
     	properties = new Properties();
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\elementLocators.properties")) {
          properties.load(input);
      } catch (IOException ex) {
          ex.printStackTrace();
          // Handle the exception, e.g., throw a runtime exception
      }
    }

    // Method to get the locator from properties file and convert to By
    public By getLocator(String key) {
        String locatorValue = properties.getProperty(key);

        if (locatorValue == null) {
            throw new IllegalArgumentException("Locator not found for key: " + key);
        }

        // You can add more checks for other types of locators (CSS, ID, etc.)
        if (locatorValue.startsWith("//") || locatorValue.startsWith("(")) {
            return By.xpath(locatorValue);
        } else if (locatorValue.startsWith("#") || locatorValue.contains(".") || locatorValue.contains("")){
            return By.cssSelector(locatorValue);
        } else {
            return By.id(locatorValue);
        }
    }
}
