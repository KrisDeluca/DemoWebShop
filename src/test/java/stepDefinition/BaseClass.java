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

    static {
        System.setProperty("extent.reporter.spark.start", "true");
        System.setProperty("extent.reporter.spark.out", "extentReports/Report.html");
        
        System.setProperty("screenshot.dir", "Screenshots/");		
		System.setProperty("screenshot.rel.path", "../Screenshots");
		
		System.setProperty("basefolder.name", "target/extentReports/Report");
		System.setProperty("basefolder.datetimepattern", "d-MMM-YY HH-mm-ss");
		
		System.setProperty("systeminfo.user", "dashboard,test,exception,author,device,log");
		System.setProperty("systeminfo.build", "Kris Deluca");
		System.setProperty("systeminfo.AppName", "Chrome");
    }
}
