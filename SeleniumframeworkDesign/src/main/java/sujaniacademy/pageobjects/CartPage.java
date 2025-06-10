package sujaniacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sujaniacademy.abstractcomponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	WebDriver driver;
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement totalRow;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public Boolean isProductInCart(String productName) {
		return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	}
	
	public CheckoutPage checkout() {
		totalRow.click();
		return new CheckoutPage(driver);
	}
	
}
