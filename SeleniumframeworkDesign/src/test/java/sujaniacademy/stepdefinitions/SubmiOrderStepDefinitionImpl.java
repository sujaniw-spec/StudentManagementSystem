package sujaniacademy.stepdefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sujaniacademy.pageobjects.CartPage;
import sujaniacademy.pageobjects.CheckoutPage;
import sujaniacademy.pageobjects.ConfirmationPage;
import sujaniacademy.pageobjects.LandingPage;
import sujaniacademy.pageobjects.ProductCatelogue;
import sujaniacademy.tests.testcomponenets.BaseTest;

public class SubmiOrderStepDefinitionImpl extends BaseTest{

	public LandingPage landingPage;
	public ProductCatelogue productCatelogue;
	public CartPage cartpage;
	public ConfirmationPage confirmationPage;
	
	@Given("user landed on Ecommerce Page")
	public void user_landed_on_Ecommerce_Page() {	
		landingPage = launchApplication();
    }
	
	@Given("^user Logged in with username (.+) and password (.+)$")
	public void user_loggedInWithUserNameAndPassword(String username, String password) {	
		productCatelogue = landingPage.logingApplication(username, password);
    }
	
	@When("^user adds product (.+) to Cart$")
	public void userAddProsuctToTheCart(String productName) {
		List<WebElement> products = productCatelogue.getProductList();		
		WebElement prod =productCatelogue.getProductByName(productName,products);
		cartpage = productCatelogue.addProduct(prod);		
	}
	
	@When("^user checkouts (.+) and submit the order$")
	public void userCheckoutsAndSubmitTheOrder(String productName) {
		//CartPage cartpage = productCatelogue.addProduct(prod);
		
		productCatelogue.goToCartPage();
		//Cart page
		
		Assert.assertTrue(cartpage.isProductInCart(productName));
	    
	    //click checkout
	  
		CheckoutPage checkoutPage = cartpage.checkout();
	    //Checkout page
	      
		checkoutPage.selectCountry("Canada");
		confirmationPage = checkoutPage.submitOrder();		
	}
	
	 @Then("the {string} message is displayed on ConfirmationPage")
	 public void messageIsDisplayedOnConfirmationPage(String message) {
		 Assert.assertEquals(confirmationPage.getThankYouMessage(), message);
		 Assert.assertTrue(confirmationPage.getThankYouMessage().equalsIgnoreCase(message));
		 driver.quit();
	 }
	 
	 @Then("the {string} is displayed")
	 public void TheMessageIsDisplayed(String message) {		
		 Assert.assertEquals(landingPage.getLoginErrorMessage(), message);
		 driver.quit();
	 }
	
	
}
