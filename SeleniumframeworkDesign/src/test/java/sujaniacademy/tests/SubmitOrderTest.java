package sujaniacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import sujaniacademy.pageobjects.CartPage;
import sujaniacademy.pageobjects.CheckoutPage;
import sujaniacademy.pageobjects.ConfirmationPage;
import sujaniacademy.pageobjects.LandingPage;
import sujaniacademy.pageobjects.OrderPage;
import sujaniacademy.pageobjects.ProductCatelogue;
import sujaniacademy.tests.testcomponenets.BaseTest;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubmitOrderTest extends BaseTest{
	String productName ="ZARA COAT 3";
	
	//@Test
	//public void submitOrder() {
//	public static void main(String[] args) {	
//		SubmitOrderTest test = new SubmitOrderTest();
//		test.runTest();
//}
	
	@Test(dataProvider="getData", groups= {"Purchase"})
	//void submitOrder(String email, String password, String productName) {
	void submitOrder(HashMap<String,String> input) {
	//	String productName ="ZARA COAT 3";
	//	LandingPage landingPage = launchApplication();
			
		//LandingPage landingPage = new LandingPage(driver);
		//landingPage.goTo();
		ProductCatelogue productCatelogue = landingPage.logingApplication(input.get("email"), input.get("password"));
					
		List<WebElement> products = productCatelogue.getProductList();
		
		WebElement prod =productCatelogue.getProductByName(input.get("product"),products);
		
		CartPage cartpage = productCatelogue.addProduct(prod);
		
		productCatelogue.goToCartPage();
		//Cart page
		
		Assert.assertTrue(cartpage.isProductInCart(input.get("product")));
	    
	    //click checkout
	  
		CheckoutPage checkoutPage = cartpage.checkout();
	    //Checkout page
	      
		checkoutPage.selectCountry("Canada");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	     
	    Assert.assertEquals(confirmationPage.getThankYouMessage(), "THANKYOU FOR THE ORDER.");
	    Assert.assertTrue(confirmationPage.getThankYouMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	    tearDown();
	}	
	
	//To verify order is displaying in the orders page
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistoryTest() {
		ProductCatelogue productCatelogue = landingPage.logingApplication("sujaniw@yahoo.com", "MyLokupusa123#@");
		OrderPage orderPage = productCatelogue.goToOrdersPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));	
		tearDown();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
	
	List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//sujaniacademy//data//PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
/*	@DataProvider
	public Object[][] getData() {
		
		HashMap <String, String> map = new HashMap<>();
		map.put("email", "sujaniw@yahoo.com");
		map.put("password", "MyLokupusa123#@");
		map.put("product", "ZARA COAT 3");
		
		HashMap <String, String> map1 = new HashMap<>();
		map1.put("email", "cat123@yahoo.com");
		map1.put("password", "MyLokupusa123#@");
		map1.put("product", "ADIDAS ORIGINAL");
		
	//	return new Object[][] {{"sujaniw@yahoo.com","MyLokupusa123#@","ZARA COAT 3"},{"cat123@yahoo.com", "MyLokupusa123#@","ADIDAS ORIGINAL"} };
		return new Object[][] {{map},{map1}};

	}*/
}
