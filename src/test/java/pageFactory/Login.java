package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver logDriver;
	
	public Login(WebDriver driver)
	{
		logDriver = driver;
		PageFactory.initElements(logDriver, this);
	}
	
	@FindBy(linkText = "Log in")
	WebElement loginText;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement psd;

	@FindBy(xpath = "//input[@value='Log in']")
	WebElement loginButton;
	
	@FindBy(xpath = "(//a[@class='account'])[1]")
	WebElement profile;
	
	public void selectLogin()
	{
		loginText.click();
	}
	
	public void loginDetails(String emailID, String password)
	{
		email.sendKeys(emailID);
		psd.sendKeys(password);
	}
	
	public void loginButton()
	{
		loginButton.click();
	}
	
	public String profileName()
	{
		return profile.getText();
	}
}
