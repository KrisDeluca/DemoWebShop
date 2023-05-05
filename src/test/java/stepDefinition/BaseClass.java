package stepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import pageFactory.Login;
import pageFactory.Register;
import pageFactory.Shop;
import pageFactory.Wishlist;
import utilities.BrowserStart;

public class BaseClass {

	public Register regObj;
	public Login logObj;
	public Shop shopObj;
	public Wishlist wishObj;
	public static WebDriver driver;
	public Properties read;
	public BrowserStart start;
	SoftAssert softAssertion;
    
    public String randomMail()
    {
    	return "@"+RandomStringUtils.randomAlphabetic(4)+"."+RandomStringUtils.randomAlphabetic(3);
    }

}
