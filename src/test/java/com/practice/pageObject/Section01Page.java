package com.practice.pageObject;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.practice.testCase.Base;

public class Section01Page extends Base {
	WebDriver ldriver;

	public Section01Page(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//h1")
	WebElement header;

	@FindBy(xpath = "//div[@id='radio-btn-example']/fieldset/child::legend")
	WebElement radioButtonText;

	@FindBy(xpath = "//input[@value='radio1']")
	WebElement radioButton1;

	@FindBy(xpath = "//input[@value='radio2']")
	WebElement radioButton2;

	@FindBy(xpath = "//input[@value='radio3']")
	WebElement radioButton3;

	@FindBy(xpath = "//div[@id='select-class-example']/fieldset/legend")
	WebElement sugessiontext;

	@FindBy(xpath = "//input[@id='autocomplete']")
	WebElement autoCompleteTextBox;

	@FindBy(xpath = "//ul[@id='ui-id-1']")
	WebElement autoCompleteArea;
	
	@FindBy(xpath = "//select[@id='dropdown-class-example']")
	WebElement dropdown;
	
	@FindBy(xpath = "//input[@id='checkBoxOption1']")
	WebElement checkBoxOption1;
	
	@FindBy(xpath = "//input[@id='checkBoxOption2']")
	WebElement checkBoxOption2;
	
	@FindBy(xpath = "//input[@id='checkBoxOption3']")
	WebElement checkBoxOption3;
	
	@FindBy(xpath = "//legend[text()='Checkbox Example']/parent::fieldset/label")
	List<WebElement> checkboxes;

	public String getPageTitle() {
		String t = ldriver.getTitle();
		return t;
	}

	public String getHeader() {
		return header.getText();
	}

	public String getRadioButtonText() {
		return radioButtonText.getText();
	}

	public Boolean getRadio1Status() {
		return radioButton1.isSelected();
	}

	public Boolean getRadio2Status() {
		return radioButton2.isSelected();
	}

	public Boolean getRadio3Status() {
		return radioButton3.isSelected();
	}

	public Boolean clickRadio1() {
		radioButton1.click();
		return radioButton1.isSelected();
	}

	public Boolean clickRadio2() {
		radioButton2.click();
		return radioButton2.isSelected();
	}

	public Boolean clickRadio3() {
		radioButton3.click();
		return radioButton3.isSelected();
	}

	public String getSugessionText() {
		return sugessiontext.getText();
	}

	public String EnterCountry(String cname) throws InterruptedException {
		autoCompleteTextBox.sendKeys(cname);
		autoCompleteTextBox.sendKeys(Keys.ARROW_DOWN);
		List<WebElement> al = driver.findElements(By.xpath("//*[@id='ui-id-1']"));
		System.out.println(al.toString());
		System.out.println(al.size());
		Iterator<WebElement> it = al.iterator();
		for (int i = 0; i < al.size(); i++) {
			if (it.hasNext()) {
				if (al.get(i).getText().equals("India")) {
					al.get(i).click();
					break;
				}
			}
		}
		return autoCompleteTextBox.getText();
	}
	
	public void clickDropdown() {
		dropdown.click();
		Select s = new Select(dropdown);
		s.selectByVisibleText("Option2");
	}
	
	
	public Boolean clickCheckBox1() {
		checkBoxOption1.click();
		return checkBoxOption1.isSelected();
	}
	public Boolean clickCheckBox2() {
		checkBoxOption2.click();
		return checkBoxOption2.isSelected();
	}
	public Boolean clickCheckBox3() {
		checkBoxOption3.click();
		return checkBoxOption3.isSelected();
	}

}
