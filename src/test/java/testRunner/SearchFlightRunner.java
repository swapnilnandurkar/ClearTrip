package testRunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/search"
		, glue ="stepDefinition"
		, plugin = {"html:target/cucumber-html-report"}
		, monochrome = true)
//@Test
public class SearchFlightRunner extends AbstractTestNGCucumberTests{
	
}
