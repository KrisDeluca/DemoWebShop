package pageFactory;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wishlist {
	
	WebDriver wishDriver;
	JavascriptExecutor js;
	
	public Wishlist(WebDriver driver)
	{
		wishDriver = driver;
		PageFactory.initElements(wishDriver, this);
		js = (JavascriptExecutor) wishDriver;
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchItem;
	
	@FindBy(xpath = "//input[@value = 'Search']")
	WebElement searchButton;
	
	@FindBy(xpath = "(//h2[@class='product-title'])[1]")
	WebElement item;
	
	@FindBy(xpath = "(//input[@value = 'Add to wishlist'])[1]")
	WebElement add;
	
	@FindBy(xpath = "(//a[@class = 'ico-wishlist'])[1]")
	WebElement  wishlist;
	
	@FindBy(xpath = "//td[@class = 'product']/a")
	List <WebElement>products;
	
	@FindBy(xpath = "//div[@class = 'wishlist-content']")
	WebElement emptyWishlistMsg;
	
	public void search(String item)
	{
		searchItem.sendKeys(item);
		searchButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
	}
	
	public void selectItem()
	{
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", item);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		item.click();
	}
	
	public void addWish()
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
	
	public void wishCart()
	{
		wishlist.click();
	}
	
	public String checkItems(String item)
	{
		String product = "Empty";
		for(WebElement i : products)
		{
			if((i.getText()).contains(item))
			{
				product = item;
			}
		}
		return product;
	}
	
	public String emptyCartMsg()
	{
		return emptyWishlistMsg.getText().trim();
	}
}
