package stepDefinition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.BrowserStart;

public class EntryExitStep extends BaseClass{

	@Given("User launchs Browser")
	public void user_launchs_browser() throws FileNotFoundException, IOException {
		read = new Properties();
		start = new BrowserStart();
		read.load(new FileInputStream("resources/Config.properties"));
		driver = start.selectBrowser(read.getProperty("Browser"));    
	}
	
	@Then("Close the Browser")
	public void close_the_browser() {
		driver.quit();		
	}	
	
}
