package stepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ExcelUtils;

public class SerachFlight{
	
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
	
	@Given("^User navigate to the home page$")
	public void user_navigate_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^user select a One way trip$")
	public void user_select_a_One_way_trip() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user enters From and To location$")
	public void user_enters_From_and_To_location() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@And("^user selects Depart on date$")
	public void user_selects_Depart_on_date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@And("^user selects number of Adults, children and infants$")
	public void user_selects_number_of_Adults_children_and_infants() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@And("^search a flight$")
	public void search_a_flight() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user should able to see flights details along with fares$")
	public void user_should_able_to_see_flights_details_along_with_fares() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^user select a Round trip$")
	public void user_select_a_Round_trip() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user enters From and To locations$")
	public void user_enters_From_and_To_locations() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user selects Depart on and Return on date$")
	public void user_selects_Depart_on_and_Return_on_date() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
    
    @After
    public void quitBrowser() {
    	driver.close();
    }
}
