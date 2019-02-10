package common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.ExcelUtils;

public class BaseTest {
	WebDriver driver;
	ExcelUtils excelUtils;
	Map<String, String> testCaseData;
	
	@Before
	public void launchBrowser() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		excelUtils = new ExcelUtils();
		testCaseData = excelUtils.getMapTestData(System.getProperty("user.dir") + "//src//test//resources//testData//", "ClearTripTestData.xlsx", "Flight_Search", 2);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
	}
	
    @After
    public void quitBrowser() {
    	driver.close();
    }
}
