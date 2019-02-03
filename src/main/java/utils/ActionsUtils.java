package utils;

import org.openqa.selenium.interactions.Actions;

public class ActionsUtils {
	
	public void advanceUserInteraction(Actions actions) {
		actions.build().perform();
	}
	
	//How to use above method
	public void usage() {
		//advanceUserInteraction(new org.openqa.selenium.interactions.Actions(new FirefoxDriver()).click());
	}
}
