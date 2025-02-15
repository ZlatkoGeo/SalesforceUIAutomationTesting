package testbase.common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonDataSetup {

	@BeforeSuite
	public void dataSetup() {
		System.out.println("Common data setup");
	}
	
	@AfterSuite
	public void dataTearndown() {
		System.out.println("Common data cleanup");
	}
}
