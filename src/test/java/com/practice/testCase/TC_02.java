package com.practice.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;


import com.practice.pageObject.Section02Page;
import com.practice.utilities.ReadConfig;

public class TC_02 extends Base{
	
	
	
	@BeforeClass
	public void launch() {
		initialization();
		String url = ReadConfig.getUrl();
		driver.get(url);
	}
	
	@Test
	public void validateWindow() throws IOException {
		Section02Page s2 = new Section02Page(driver);
		if(s2.openWindow().equals("QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy")){
			AssertJUnit.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateWindow");
			AssertJUnit.assertTrue(false);
		}
		
	}
	
	@Test
	public void validateTab() throws IOException, InterruptedException {
		Section02Page s2 = new Section02Page(driver);
		if(s2.openTab().equals("Rahul Shetty Academy")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateTab");
			AssertJUnit.assertTrue(false);
		}
	}
	
	@Test
	public void validateAlert() throws IOException {
		Section02Page s2 = new Section02Page(driver);
		if(s2.switchAlert().equals("Hello Testing, share this practice page and share your knowledge")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "Validate alert");
			AssertJUnit.assertTrue(false);
		}
		
		if(s2.switchConfirm().equals("Hello Testing Confirm, Are you sure you want to confirm?")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "Validate alert Confirm");
			AssertJUnit.assertTrue(false);
		}
		
		
	}
	
	@AfterClass
	public void end() {
		tearDown();
	}

}
