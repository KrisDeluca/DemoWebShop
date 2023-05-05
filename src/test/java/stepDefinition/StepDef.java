package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageFactory.Login;
import pageFactory.Register;
import pageFactory.Shop;
import pageFactory.Wishlist;

public class StepDef extends BaseClass{

	//Common
	
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		regObj = new Register(driver);
		logObj = new Login(driver);
		shopObj = new Shop(driver);
		wishObj = new Wishlist(driver);
	}
	
	@Then("PageTitle should be {string}")
	public void page_title_should_be(String title) {
		Assert.assertEquals(regObj.pageTitle(), title);
	}
	
	@AfterStep
	public void takeScreenShotOnFailedScenario(Scenario scenario) 
	{
		if ((scenario.isFailed())) 
		{
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	@AfterAll
	public static void writeExtentReport() {
		Properties read = new Properties();
		try {
			read.load(new FileInputStream("resources/Config.properties"));
		} catch (Exception e) {}
		Reporter.loadXMLConfig(new File(read.getProperty("reportConfigPath")));
	}
	
	//Register
	
	@When("Click on Register button to initiate")
	public void click_on_register_button_to_initiate() {
		regObj.registerStart();
	}

	@When("Enter Details {string}, {string} & {string}")
	public void enter_details(String gender, String name, String email) {
		regObj.selectGender(gender);
		regObj.enterName(name);
		regObj.enterEmail(email+randomMail());
	}

	@When("Enter Password {string}")
	public void enter_password(String passwd) {
		regObj.enterPassword(passwd);	    
	}

	@When("Click on Register button to complete")
	public void click_on_register_button_to_complete() {
		regObj.registerComplete();
	}
	@Then("Success Message displays")
	public void success_message_displays() {
		Assert.assertEquals(regObj.registerMessage(), "Your registration completed");
	}

	@When("Click on Continue")
	public void click_on_continue() {
		regObj.selectContinue();	    
	}	
	
	//Login	
	
	@When("Click on Login link")
	public void click_on_login_link() {
		logObj.selectLogin();
	}

	@When("Enter Login details {string} & {string}")
	public void enter_login_details(String email, String password) {
		logObj.loginDetails(email, password);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		logObj.loginButton();
	}
	
	@Then("Profile Name should be {string}")
	public void profile_name_should_be(String profile) {
		Assert.assertEquals(logObj.profileName(), profile);
	}
	
	//Shop
	
	@When("Click on Books under categories")
	public void click_on_books_under_categories() {
		shopObj.selectBook();
	}

	@And("Add Item to cart")
	public void add_item_to_cart() {
		shopObj.addCart();
	}

	@When("Click on Electronics under categories")
	public void click_on_electronics_under_categories() {
		shopObj.selectElectronic();
	}

	@When("Click on Cellphones tab")
	public void click_on_cellphones_tab() {
		shopObj.selectCellphone();
	}

	@When("Click on Computers under categories")
	public void click_on_computers_under_categories() {
		shopObj.selectComputer();
	}

	@When("Click on Desktops tab")
	public void click_on_desktops_tab() {
		shopObj.selectDesktop();
	}

	@Then("Select specs {string}, {string}, {string} & {string}")
	public void select_specs(String processor, String memory, String disk, String software) {
		shopObj.selectSpecs(processor, memory, disk, software);
	}
	
	@Then("Go to Shopping Cart")
	public void go_to_shopping_cart() {
		shopObj.shopCart();
	}

	@Then("Fill required fields and checkout")
	public void fill_required_fields_and_checkout() {
		shopObj.checkout();
	}

	@Then("Select all items in cart")
	public void select_all_items_in_cart() {
		softAssertion= new SoftAssert();
		softAssertion.assertEquals(shopObj.selectItems(), "Not Empty", "Cart is Empty already");		
	}

	@Then("Click on Update Cart")
	public void click_on_update_cart() {
		softAssertion.assertEquals(shopObj.updateCart(), "Not Empty", "Cart is Empty already");
	}

	@Then("Cart should be empty")
	public void cart_should_be_empty() {		
		Assert.assertEquals(shopObj.emptyCartMsg(), "Your Shopping Cart is empty!");
		softAssertion.assertAll();
	}
	
	//Wishlist
	
	@When("Enter {string} in Search Box")
	public void enter_in_search_box(String item) {
		wishObj.search(item);
	}
	
	@When("Click on Item Link")
	public void click_on_item_link() {
		wishObj.selectItem();
	}
	
	@And("Add to Wishlist")
	public void add_to_wishlist() {
		wishObj.addWish();
	}
		
	@Then("Go to Wishlist Cart")
	public void go_to_wishlist_Cart() {
	    wishObj.wishCart();
	}
	
	@And("{string} should be available on Wishlist")
	public void should_be_available_on_wishlist(String item) {		
		Assert.assertEquals(wishObj.checkItems(item), item, item+" is available in cart");
	}

	@Then("Wishlist should be empty")
	public void wishlist_should_be_empty() {
		Assert.assertEquals(wishObj.emptyCartMsg(), "The wishlist is empty!");		
	}
}
