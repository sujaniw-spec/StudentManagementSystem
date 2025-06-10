package sujaniacademy.tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {

		String productName ="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");

				
		driver.findElement(By.id("userEmail")).sendKeys("sujaniw@yahoo.com");
		driver.findElement(By.id("userPassword")).sendKeys("MyLokupusa123#@");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
		
		List <WebElement> products =driver.findElements(By.cssSelector(".col-lg-4"));
		
		WebElement prod = products.stream().filter(product -> 
		product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		//Cart page
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	    Assert.assertTrue(match);
	    
	    //click checkout
	    driver.findElement(By.cssSelector(".totalRow button")).click();
		
	    //Checkout page
	    
	    Actions action = new Actions(driver);
	    action.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Canada").build().perform();
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    	    
	    driver.findElement(By.xpath("//button[contains(@class,'ta-item')][1]")).click();
	    
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    
	    String thanksText = driver.findElement(By.tagName("h1")).getText();
	    Assert.assertEquals(thanksText, "THANKYOU FOR THE ORDER.");
	    Assert.assertTrue(thanksText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	    driver.quit();
	    
	}
	
}
