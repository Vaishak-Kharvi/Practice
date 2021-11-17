package com.practice.testCase;

import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.Assert;
import java.io.IOException;


import org.testng.asserts.SoftAssert;

import com.practice.pageObject.Section01Page;
import com.practice.utilities.ReadConfig;

public class TC_01 extends Base {
	
	@BeforeClass
	public void launch() {
		initialization();
		String url = ReadConfig.getUrl();
		driver.get(url);
	}

	@Test
	public void validateTitle() throws IOException {
		Section01Page s1 = new Section01Page(driver);
		String title = s1.getPageTitle();
		System.out.println("Test Validate Title");
		if (title.equals("Practice Page")) {
			Assert.assertTrue(true);
		} else {
			captureScreenShot(driver, "validateTitle");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void validateHeader() throws IOException {
		Section01Page s1 = new Section01Page(driver);
		String header = s1.getHeader();
		System.out.println("Test Validate Header");
		if (header.equals("Practice Page")) {
			Assert.assertTrue(true);
		} else {
			captureScreenShot(driver, "validateHeader");
			Assert.assertTrue(false);
		}

	}
	
	@Test
	public void validateRadioFieldset() throws IOException {
		Section01Page s1 = new Section01Page(driver);
		System.out.println("Test Validate Radio fields");
		String radioText = s1.getRadioButtonText();
		if(radioText.equals("Radio Button Example")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateRadioFieldset");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = -1)
	public void validateRadioButtonStatus() throws IOException {
		Section01Page s1 = new Section01Page(driver);
		SoftAssert sa = new SoftAssert();
		Boolean result1 = s1.getRadio1Status();
		if(result1.equals(false)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateRadioButtonStatus");
			Assert.assertTrue(false);
		}
		
		Boolean result2 = s1.getRadio2Status();
		if(result2.equals(false)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateRadioButtonStatus");
			Assert.assertTrue(false);
		}
		
		Boolean result3 = s1.getRadio3Status();
		if(result3.equals(false)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateRadioButtonStatus");
			Assert.assertTrue(false);
		}
		sa.assertAll();
	}
	
	@Test
	public void validateRadioButton() throws IOException {
		Section01Page s1 = new Section01Page(driver);
		SoftAssert sa = new SoftAssert();
		Boolean result1 = s1.clickRadio1();
		if(result1.equals(true)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateRadioButton");
			Assert.assertFalse(false);
		}
		
		Boolean result2 = s1.clickRadio2();
		if(result2.equals(true)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateRadioButton");
			Assert.assertFalse(false);
		}
		
		Boolean result3 = s1.clickRadio3();
		if(result3.equals(true)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateRadioButton");
			Assert.assertFalse(false);
		}
		sa.assertAll();
	}
	
	@Test(enabled = false)
	public void validateDropdown() throws InterruptedException {
		Section01Page s1 = new Section01Page(driver);
		String n = s1.EnterCountry("ind");
		System.out.println(n);
	}
	
	@Test
	public void validateStaticDropdown() {
		Section01Page s1 = new Section01Page(driver);
		s1.clickDropdown();
	}
	
	@Test
	public void validateCheckBox() throws IOException {
		Section01Page s1 = new Section01Page(driver);
		if(s1.clickCheckBox1().equals(true)){
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateCheckBox");
			Assert.assertTrue(false);
		}
		if(s1.clickCheckBox2().equals(true)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateCheckBox");
			Assert.assertTrue(false);
		}
		if(s1.clickCheckBox3().equals(true)) {
			Assert.assertTrue(true);
		}
		else {
			captureScreenShot(driver, "validateCheckBox");
			Assert.assertTrue(false);
		}
	}
	
	@AfterClass
	public void end() {
		tearDown();
	}

}
