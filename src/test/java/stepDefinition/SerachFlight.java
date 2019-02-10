package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SerachFlight{
	
	@Given("^User navigate to the home page$")
	public void user_navigate_to_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("^User navigate to the home page$");
	}

	@Given("^user select a One way trip$")
	public void user_select_a_One_way_trip() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("^user select a One way trip$");
	}

	@When("^user enters From and To location$")
	public void user_enters_From_and_To_location() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("^user enters From and To location$");
	}

	@And("^user selects Depart on date$")
	public void user_selects_Depart_on_date() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("^user selects Depart on date$");
	}

	@And("^user selects number of Adults, children and infants$")
	public void user_selects_number_of_Adults_children_and_infants() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("^user selects number of Adults, children and infants$");
	}

	@And("^search a flight$")
	public void search_a_flight() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("^search a flight$");
	}

	@Then("^user should able to see flights details along with fares$")
	public void user_should_able_to_see_flights_details_along_with_fares() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("^user should able to see flights details along with fares$");
	}

	@Given("^user select a Round trip$")
	public void user_select_a_Round_trip() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("^user select a Round trip$");
	}

	@When("^user enters From and To locations$")
	public void user_enters_From_and_To_locations() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("^user enters From and To locations$");
	}

	@When("^user selects Depart on and Return on date$")
	public void user_selects_Depart_on_and_Return_on_date() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("^user selects Depart on and Return on date$");;
	}
}
