package sujaniacademy.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sujaniacademy.abstractcomponents.AbstractComponents;

public class ProductCatelogue extends AbstractComponents{

	WebDriver driver;
	
	public ProductCatelogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	
	@FindBy(css=".card-body button:last-of-type")
	WebElement prodCheoutButton;
  
	By toastMessage = By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement ngAnimator;
			
	By productsBy = By.cssSelector(".col-lg-4");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		
		return products;
	}
	
	public WebElement getProductByName(String productName, List<WebElement> products) {
		return  products.stream().filter(product -> 
		product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
	}
	
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	
	public CartPage addProduct(WebElement prod) {
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisaperar(ngAnimator);
		return new CartPage(driver);
	}
}
