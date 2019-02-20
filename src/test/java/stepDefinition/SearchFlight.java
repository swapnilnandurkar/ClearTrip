package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.testng.Assert;

import common.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;
import utils.ExcelUtils;

public class SearchFlight{
	
	private WebDriver driver;
	private ExcelUtils excelUtils;
	private Map<String, String> testCaseData;
	private HomePage homePage;
	private ApplicationContext context;
	
	@Before
	public void setEnvironmentAndData() throws FileNotFoundException, IOException {
		context = new FileSystemXmlApplicationContext("Spring.xml"); 
		excelUtils = (ExcelUtils)context.getBean("excelUtils");
		testCaseData = excelUtils.getMapTestData("src/test/resources/testData/", "ClearTripTestData.xlsx", "Flight_Search", 2);
	}

	@Before
	public void launchBrowser() throws FileNotFoundException, IOException {
		this.driver = new DriverManager().getDriver();
	}
	
    @After
    public void quitBrowser() {
    	driver.close();
    }
    
	@Given("^User navigate to the home page$")
	public void user_navigate_to_the_home_page() throws FileNotFoundException, IOException {
		testCaseData = excelUtils.getMapTestData(System.getProperty("user.dir") + "//src//test/resources//testData//", "ClearTripTestData.xlsx", "Flight_Search", 2);
		homePage = new HomePage(driver);
	    homePage.navigateToHomePage("https://cleartrip.com");
	}

	@Given("^user select a One way trip$")
	public void user_select_a_One_way_trip() throws InterruptedException, FileNotFoundException, IOException {
	    homePage.selectOneWayTrip();
	    Thread.sleep(1000);
	}

	@When("^user enters From and To location$")
	public void user_enters_From_and_To_location() throws InterruptedException {
	    homePage.enterFromAndToLocation(testCaseData.get("From Location"), testCaseData.get("To Location"));
		Thread.sleep(1000);
	}

	@And("^user selects Depart on date$")
	public void user_selects_Depart_on_date() throws InterruptedException {
	    homePage.enterDepartOnDate(testCaseData.get("Depart On"));
		Thread.sleep(1000);
	}

	@And("^user selects number of Adults, children and infants$")
	public void user_selects_number_of_Adults_children_and_infants() throws InterruptedException {
	    homePage.enterNumberOfAdultsChildrenAndInfants(testCaseData.get("Adults"), testCaseData.get("Chidern"), testCaseData.get("Infants"));
		Thread.sleep(1000);
	}

	@And("^search a flight$")
	public void search_a_flight() throws InterruptedException {
	    homePage.searchFlight();
		Thread.sleep(1000);
	}

	@Then("^user should able to see flights details along with fares$")
	public void user_should_able_to_see_flights_details_along_with_fares() throws InterruptedException {
		Assert.assertTrue(new SearchResultPage(driver).isSearchResultDisplayed(), "No Flight found!! for date");
	}

	@Given("^user select a Round trip$")
	public void user_select_a_Round_trip() throws InterruptedException, FileNotFoundException, IOException {
		testCaseData = excelUtils.getMapTestData(System.getProperty("user.dir") + "//src//test/resources//testData//", "ClearTripTestData.xlsx", "Flight_Search", 1);
	    homePage.selectRoundTrip();
		Thread.sleep(1000);
	}

	@When("^user enters From and To locations$")
	public void user_enters_From_and_To_locations() throws InterruptedException {
		homePage.enterFromAndToLocation("Pune ", "New Delhi");
		Thread.sleep(1000);
	}

	@When("^user selects Depart on and Return on date$")
	public void user_selects_Depart_on_and_Return_on_date() throws InterruptedException {
		homePage.enterDepartOnDate(testCaseData.get("Depart On"));
		homePage.enterReturntOnDate(testCaseData.get("Return On"));
	    Thread.sleep(1000);
	}
}
