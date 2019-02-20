package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class SearchResultPage  extends BasePage{
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".listView.flights > li")
	private List<WebElement> results;
	
	public boolean isSearchResultDisplayed() {
		return results.size() > 0;
	}
}
