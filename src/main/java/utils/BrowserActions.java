package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserActions {
	
	WebDriver driver;
	
	public BrowserActions(WebDriver driver) {
		this.driver = driver;
	}

	public void selectDate(int day) {
		
	}
	
	public void sendKeys(String text, WebElement element) {
		element.clear();
		element.sendKeys(text);
	}
	
	public void selectDropdownByVisibleText(String text, WebElement element) {
		new Select(element).selectByVisibleText(text);
	}
	
	public void selectDropdownByValue(String value, WebElement element) {
		new Select(element).selectByValue(value);
	}
	
	public void deSelectDropdownByValue(String value, WebElement element) {
		new Select(element).deselectByValue(value);
	}
	
	public void deSelectDropdownByVisibleText(String text, WebElement element) {
		new Select(element).deselectByVisibleText(text);
	}
	
	public void deSelectAll(WebElement element) {
		new Select(element).deselectAll();
	}
	
	public void clickOnWebElement(WebElement element) {
		element.click();
	}

	public void selectDate(String date) {
		
	}
}
