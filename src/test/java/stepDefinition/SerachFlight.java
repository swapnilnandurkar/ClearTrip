package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import utils.ExcelUtils;

public class SerachFlight{
	
	private WebDriver driver;
	private ExcelUtils excelUtils;
	private Map<String, String> testCaseData;
	private HomePage homePage;
	private ApplicationContext context;

	@Before
	public void launchBrowser() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//drivers//chromedriver.exe");
		context = new FileSystemXmlApplicationContext("Spring.xml"); 
		ChromeOptions chromeOption = (ChromeOptions)context.getBean("chromeOption");
		chromeOption.addArguments("disable-notifications");
		driver = (ChromeDriver)context.getBean("driver");
		excelUtils = (ExcelUtils)context.getBean("excelUtils");
		testCaseData = excelUtils.getMapTestData(System.getProperty("user.dir") + "//src//test//resources//testData//", "ClearTripTestData.xlsx", "Flight_Search", 2);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
	}
	
    @After
    public void quitBrowser() {
    	driver.close();
    }
    
	@Given("^User navigate to the home page$")
	public void user_navigate_to_the_home_page() throws FileNotFoundException, IOException {
		testCaseData = excelUtils.getMapTestData(System.getProperty("user.dir") + "//src//test/resources//testData//", "ClearTripTestData.xlsx", "Flight_Search", 2);
		homePage =  (HomePage)context.getBean("homePage");
	    homePage.navigateHomePage("https://cleartrip.com");
	    new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
	    System.out.println("^User navigate to the home page$");
	}

	@Given("^user select a One way trip$")
	public void user_select_a_One_way_trip() throws InterruptedException, FileNotFoundException, IOException {
	    homePage.selectOneWayTrip();
	    Thread.sleep(1000);
		System.out.println("^user select a One way trip$");
	}

	@When("^user enters From and To location$")
	public void user_enters_From_and_To_location() throws InterruptedException {
	    homePage.enterFromAndToLocation(testCaseData.get("From Location"), testCaseData.get("To Location"));
		System.out.println("^user enters From and To location$");
		Thread.sleep(1000);
	}

	@And("^user selects Depart on date$")
	public void user_selects_Depart_on_date() throws InterruptedException {
	    homePage.enterDepartOnDate(testCaseData.get("Depart On"));
		System.out.println("^user selects Depart on date$");
		Thread.sleep(1000);
	}

	@And("^user selects number of Adults, children and infants$")
	public void user_selects_number_of_Adults_children_and_infants() throws InterruptedException {
	    homePage.enterNumberOfAdultsChildrenAndInfants(testCaseData.get("Adults"), testCaseData.get("Chidern"), testCaseData.get("Infants"));
		System.out.println("^user selects number of Adults, children and infants$");
		Thread.sleep(1000);
	}

	@And("^search a flight$")
	public void search_a_flight() throws InterruptedException {
	    homePage.searchFlight();
		System.out.println("^search a flight$");
		Thread.sleep(1000);
	}

	@Then("^user should able to see flights details along with fares$")
	public void user_should_able_to_see_flights_details_along_with_fares() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		//Assert
	    System.out.println("^user should able to see flights details along with fares$");
	    Thread.sleep(1000);
	}

	@Given("^user select a Round trip$")
	public void user_select_a_Round_trip() throws InterruptedException, FileNotFoundException, IOException {
		testCaseData = excelUtils.getMapTestData(System.getProperty("user.dir") + "//src//test/resources//testData//", "ClearTripTestData.xlsx", "Flight_Search", 1);
	    homePage.selectRoundTrip();
		System.out.println("^user select a Round trip$");
		Thread.sleep(1000);
	}

	@When("^user enters From and To locations$")
	public void user_enters_From_and_To_locations() throws InterruptedException {
		homePage.enterFromAndToLocation("Pune ", "New Delhi");
		System.out.println("^user enters From and To locations$");
		Thread.sleep(1000);
	}

	@When("^user selects Depart on and Return on date$")
	public void user_selects_Depart_on_and_Return_on_date() throws InterruptedException {
		homePage.enterDepartOnDate(testCaseData.get("Depart On"));
		homePage.enterReturntOnDate(testCaseData.get("Return On"));
	    System.out.println("^user selects Depart on and Return on date$");
	    Thread.sleep(1000);
	}
}
