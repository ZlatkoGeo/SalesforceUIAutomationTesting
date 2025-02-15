package testbase.common;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testbase.utilities.testUtils;

public class Listeners extends testUtils implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.title", "Salesforce Test Report");
		Reporter.log("Method name is - " + result.getName());
		System.out.println("Test case is starting");
	}

	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("Status of execution is - " + result.getStatus());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed - screenshot captured");
		try {
			getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("< a href=\"C:\\Tools\\Projects\\LearnJava\\SalesforceAutomation\\ScreenShots\">Test Results</a>");
	
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedVutWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestResult result) {

	}

	public void onFinish(ITestResult result) {

	}
}
