package com.practice.pageObject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Section02Page {
	WebDriver ldriver;

	public Section02Page(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//button[@id='openwindow']")
	WebElement openWindowButton;

	@FindBy(xpath = "//a[@id='opentab']")
	WebElement openTabButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement enterYourNameField;

	@FindBy(xpath = "//input[@id='alertbtn']")
	WebElement alertButton;

	@FindBy(xpath = "//input[@id='confirmbtn']")
	WebElement confirmButton;

	public String openWindow() {
		openWindowButton.click();
		String parentWindow = ldriver.getWindowHandle();
		Set<String> window = ldriver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String title = null;
		for (int j = 0; j < window.size(); j++) {
			if (it.hasNext()) {
				String childWindow = it.next().toString();
				if (!childWindow.equals(parentWindow)) {
					ldriver.switchTo().window(childWindow);
					title = ldriver.getTitle();
					ldriver.close();
					ldriver.switchTo().window(parentWindow);
				}
			}
		}
		return title;
	}

	public String openTab() throws InterruptedException {
		openTabButton.click();
		String pwindow = ldriver.getWindowHandle();
		// System.out.println("Parent window "+pwindow);
		Set<String> window = ldriver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String title = null;
		for (int i = 0; i < window.size(); i++) {
			if (it.hasNext()) {
				String childWindow = it.next().toString();
				if (!pwindow.equals(childWindow)) {
					ldriver.switchTo().window(childWindow);
					// System.out.println("Child window "+childWindow);
					title = ldriver.getTitle();
					ldriver.close();
					ldriver.switchTo().window(pwindow);

					// System.out.println(title);
				}

			}
		}

		return title;
	}

	public String switchAlert() {
		enterYourNameField.sendKeys("Testing");
		alertButton.click();
		String alterText = ldriver.switchTo().alert().getText();
		//System.out.println(alterText);
		ldriver.switchTo().alert().accept();
		try {
			ldriver.switchTo().alert();
			//System.out.println("Fail");
		} catch (Exception e) {
			//System.out.println("Pass");
		}
		return alterText;
	}

	public String switchConfirm() {
		enterYourNameField.sendKeys("Testing Confirm");
		confirmButton.click();
		String alterText = ldriver.switchTo().alert().getText();
		// System.out.println(alterText);
		ldriver.switchTo().alert().dismiss();
		try {
			ldriver.switchTo().alert();
			// System.out.println("Fail");
		} catch (Exception e) {
			// System.out.println("Pass");
		}
		return alterText;
	}

}
