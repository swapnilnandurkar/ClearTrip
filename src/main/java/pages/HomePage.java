package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//strong[text()='Round trip']/preceding-sibling::input")
	private WebElement roundTripRadioButton;
	
	@FindBy(xpath = "//label[@for='OneWay']/descendant::input")
	private WebElement oneWayRadioButton;
	
	@FindBy(xpath = "//dl[@class='vertical']//descendant::input[@id='FromTag']")
	private WebElement fromLocationTextBox;
	
	@FindBy(xpath = "//dl[@class='vertical']//descendant::input[@id='ToTag']")
	private WebElement toLocationTextBox;
	
	@FindBy(xpath = "//*[@id=\"DepartDate\"]")
	private WebElement deportOnDropDown;
	
	@FindBy(xpath = "//*[@id=\"ReturnDate\"]")
	private WebElement returnOnDropDown;
	
	@FindBy(css = "#Adults")
	private WebElement adultDropDown;
	
	@FindBy(css = "#Childrens")
	private WebElement childDropDown;
	
	@FindBy(css = "#Infants")
	private WebElement infantDropDown;
}
