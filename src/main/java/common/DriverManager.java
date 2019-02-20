package common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private WebDriver driver;
	
	//Need to update method to support multiple browsers
	public WebDriver getDriver() throws FileNotFoundException, IOException {
		launchChromeBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		return driver;
	}

	private void launchChromeBrowser() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("disable-infobars");
		chromeOption.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOption);
	}
}
