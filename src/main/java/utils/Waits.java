package utils;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	WebDriver driver;
	public Waits(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement applyExplicitWait(int timeOutInSeconds, ExpectedCondition<WebElement> expectedCondition) {
		return new WebDriverWait(driver, timeOutInSeconds).until(expectedCondition);
	}
	
	public void applyFluentWait(final WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
		  public WebElement apply(WebDriver driver) {
		  return element;
		}
		});
	}
	
}

