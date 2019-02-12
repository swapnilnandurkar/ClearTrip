package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

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
	
	@FindBy(css = "#ui-id-2 > li > a")
	private WebElement toLocationSuggestion;
	
	@FindBy(css = "#ui-id-1 > li > a")
	private WebElement fromLocationSuggestion;
	
	@FindBy(css = "#SearchBtn")
	private WebElement searchFlightButton;
	
	public void selectOneWayTrip() {
		selectTripType(oneWayRadioButton);
	}
	
	public void selectRoundTrip() {
		actions.clickOnWebElement(roundTripRadioButton);
	}
	
	public void selectTripType(WebElement element) {
		actions.clickOnWebElement(element);
	}
	
	public void enterFromAndToLocation(String fromLocation, String toLocation) {
		enterLocation(fromLocationTextBox, fromLocationSuggestion, fromLocation);
		enterLocation(toLocationTextBox, toLocationSuggestion, toLocation);

	}
	
	public void enterLocation(WebElement elementLocation, WebElement locationSuggestion, String location) {
		actions.clickOnWebElement(elementLocation);
		actions.sendKeys(location, elementLocation);
		//waits.applyFluentWait(locationSuggestion);
		actions.clickOnWebElement(locationSuggestion);
	}
	
	public void enterDepartOnDate(String date) {
		enterDate(deportOnDropDown, date);
	}
	
	public void enterReturntOnDate(String date) {
		enterDate(returnOnDropDown, date);
	}
	
	public void enterDate(WebElement element, String date) {
		actions.clickOnWebElement(element);
		actions.sendKeys(date, element);
	}

	public void enterNumberOfAdultsChildrenAndInfants(String adult, String child, String infant) {
		actions.selectDropdownByVisibleText(adult, adultDropDown);
		actions.selectDropdownByVisibleText(child, childDropDown);
		actions.selectDropdownByVisibleText(infant, infantDropDown);
	}

	public void searchFlight() {
		actions.clickOnWebElement(searchFlightButton);
	}

	public void navigateHomePage(String url) {
		driver.get(url);
	}
}
