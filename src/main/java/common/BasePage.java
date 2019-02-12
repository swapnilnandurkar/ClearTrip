package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserActions;
import utils.Waits;

public class BasePage {
	protected BrowserActions actions;
	protected WebDriver driver;
	protected Waits waits;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		actions = new BrowserActions(driver);
		waits = new Waits(driver);
		PageFactory.initElements(driver, this);
	}
}
