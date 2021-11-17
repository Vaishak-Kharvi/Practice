package com.practice.testCase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.practice.utilities.ReadConfig;

public class Base {
	public WebDriver driver;

	public void initialization() {
		String browser = ReadConfig.getBrowser();
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/Driver/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	public void tearDown() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
	}
	
	public static void captureScreenShot(WebDriver driver,String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"./Screenshot/"+testCaseName+".png");
		FileUtils.copyFile(src, des);
		System.out.println("Screenshot captured for Test case "+testCaseName);
	}

}
