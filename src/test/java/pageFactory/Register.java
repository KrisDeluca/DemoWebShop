package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	
	WebDriver regDriver;
	
	public Register(WebDriver driver)
	{
		regDriver = driver;
		
		PageFactory.initElements(regDriver, this);
	}
	
	@FindBy(linkText = "Register")
	WebElement regStart;
	
	@FindBy(id = "gender-male")
	WebElement male;
	
	@FindBy(id = "gender-female")
	WebElement female;
	
	@FindBy(name = "FirstName")
	WebElement fname;
	
	@FindBy(name = "LastName")
	WebElement lname;
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement psd;
	
	@FindBy(id = "ConfirmPassword")
	WebElement conpsd;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement msg;
	
	@FindBy(name = "register-button")
	WebElement regComp;
	
	@FindBy(xpath = "//input[@value = 'Continue']")
	WebElement cont;
	
	public void registerStart()
	{
		regStart.click();
	}
	
	public void selectGender(String gender)
	{
		if(gender.equalsIgnoreCase("Male"))
			male.click();
		else
			female.click();
	}
	
	public void enterName(String name)
	{
		String namesplit [] = name.split(" ");
		fname.sendKeys(namesplit[0]);
		lname.sendKeys(namesplit[1]);
	}
	
	public void enterEmail(String emailID)
	{
		email.sendKeys(emailID);
	}

	public void enterPassword(String password)
	{
		psd.sendKeys(password);
		conpsd.sendKeys(password);
	}
	
	public void registerComplete()
	{
		regComp.click();
	}
	public String registerMessage()
	{
		return msg.getText().trim();
	}
	public void selectContinue()
	{
		cont.click();
	}
	
	public String pageTitle()
	{
		return regDriver.getTitle();
	}
}
