package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutor {
	WebDriver driver;
	JavascriptExecutor javaScriptExecutor;

	public JavaScriptExecutor(WebDriver driver) {
		this.driver = driver;
	}
	
	public void executeJavaScript(String script, Object... args) {
		javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeAsyncScript(script, args);
	}
	
	public void executeASyncJavaScript(String script, Object... args) {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript(script, args);
	}
}
