package pageFactory;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Shop  {

	WebDriver shopDriver;
	JavascriptExecutor js;

	public Shop(WebDriver driver)
	{
		shopDriver = driver;
		PageFactory.initElements(shopDriver, this);
		js = (JavascriptExecutor) shopDriver;
	}
	

	@FindBy(xpath = "(//a[@href='/books'])[1]")
	WebElement books;

	@FindBy(xpath = "(//a[@href='/electronics'])[1]")
	WebElement electronics;

	@FindBy(xpath = "(//a[@href='/cell-phones'])[4]")
	WebElement cellphones;
	
	@FindBy(xpath = "(//a[@href='/computers'])[1]")
	WebElement computers;
	
	@FindBy(xpath = "(//a[@href='/desktops'])[4]")
	WebElement desktops;

	@FindBy(linkText = "Shopping cart")
	WebElement cart;

	@FindBy(xpath = "(//input[@value='Add to cart'])[1]")
	WebElement add;

	@FindBy(xpath = "//ul[@class='option-list']/li/label")
	List <WebElement> specs;
	
	@FindBy(name = "removefromcart")
	List <WebElement> removeItem;
	
	@FindBy(name = "updatecart")
	WebElement removeAll;

	@FindBy(id = "termsofservice")
	WebElement terms;
	
	@FindBy(id = "checkout")
	WebElement checkout;
	
	@FindBy(name = "CountryId")
	WebElement countryId;

	@FindBy(xpath = "//div[@class='order-summary-content']")
	WebElement emptyCartMsg;	
	
	public void selectBook()
	{
		books.click();
	}

	public void selectElectronic()
	{
		electronics.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}
	
	public void selectCellphone()
	{
		cellphones.click();
	}

	public void selectComputer()
	{
		computers.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}

	public void selectDesktop()
	{
		desktops.click();
	}
	
	public void addCart()
	{
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", add);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		add.click();
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}

	public void selectSpecs(String processor, String memory, String disk, String software)
	{
		for(WebElement i : specs)
		{
			String text=i.getText().trim();
			if(i.getText().contains("Other"))
			{
				text="Other Office";				//Added this logic to ensure 3rd option is not clicked when input is 2nd option
			}

			if(text.contains(processor)||text.contains(memory)||text.contains(disk)||text.contains(software))
			{
				js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", i);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {}
				i.click();
			}
		}
	}

	public void shopCart()
	{
		cart.click();
	}
	
	public void checkout()
	{
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", checkout);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		Select country = new Select(countryId);
		int random = (int) (Math.random()*237);
		country.selectByValue(Integer.toString(random));
		
		terms.click();
		checkout.click();
	}
	
	public String selectItems()
	{
		String check= "Not Empty";		//flag default off
		for(WebElement i : removeItem)
		{
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
			
			try {
			i.click();
			} catch (NoSuchElementException e) {
				check= "Empty";		//flag set, cart is empty
			}
		}
		return check;
	}

	public String updateCart()
	{
		String check= "Not Empty";		//flag default off
		try {
			removeAll.click();
			} catch (NoSuchElementException e) {
				check= "Empty";		//flag set, cart is empty
			}
		return check;
	}
	
	public String emptyCartMsg()
	{
		return emptyCartMsg.getText().trim();
	}
}
