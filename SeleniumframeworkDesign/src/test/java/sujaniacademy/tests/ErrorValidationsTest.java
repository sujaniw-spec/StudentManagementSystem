package sujaniacademy.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import sujaniacademy.pageobjects.CartPage;
import sujaniacademy.pageobjects.ProductCatelogue;
import sujaniacademy.tests.testcomponenets.BaseTest;
import sujaniacademy.tests.testcomponenets.Retry;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups = {"ErrorHandling"} , retryAnalyzer=Retry.class)
	void errorLoginValidation() {
		
		landingPage.logingApplication("rrsujaniw@yahoo.com", "MyLokupusa123#@ee");
		Assert.assertEquals(landingPage.getLoginErrorMessage(), "Incorrect email or password.");		
			
	   // tearDown();
	}
	
	@Test
	public void submitOrderError() {
		
			String productName ="ZARA COAT 3";		
			ProductCatelogue productCatelogue = landingPage.logingApplication("cat123@yahoo.com", "MyLokupusa123#@");						
			List<WebElement> products = productCatelogue.getProductList();			
			WebElement prod =productCatelogue.getProductByName(productName,products);			
			CartPage cartpage = productCatelogue.addProduct(prod);			
			productCatelogue.goToCartPage();			
			
			Assert.assertFalse(cartpage.isProductInCart("ZARA COAT 33333"));		    
	}
}
