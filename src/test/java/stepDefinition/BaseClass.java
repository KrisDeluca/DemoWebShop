package stepDefinition;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
	
}
