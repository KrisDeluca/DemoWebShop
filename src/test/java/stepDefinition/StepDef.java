package stepDefinition;

import java.time.Duration;

import org.testng.Assert;
import io.cucumber.java.en.*;
import pageFactory.Login;
import pageFactory.Register;
import pageFactory.Shop;

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
	}
	
	@Then("PageTitle should be {string}")
	public void page_title_should_be(String title) {
		Assert.assertEquals(regObj.pageTitle(), title);
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
		regObj.enterEmail(email);
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
		shopObj.selectItems();
	}

	@Then("Click on Update Shopping Cart")
	public void click_on_update_shopping_cart() {
		shopObj.updateCart();
	}

	@Then("Cart should be empty")
	public void cart_should_be_empty() {
		Assert.assertEquals("Your Shopping Cart is empty!" , shopObj.emptyCartMsg());		
	}
}
