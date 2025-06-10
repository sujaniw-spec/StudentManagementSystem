package sujaniacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import sujaniacademy.abstractcomponents.AbstractComponents;

public class CheckoutPage  extends AbstractComponents{

	WebDriver driver;
	
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][1]")
	WebElement selectContry;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	By result = By.cssSelector(".ta-results");
	
	// action.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "Canada").build().perform();
	    // driver.findElement(By.xpath("//button[contains(@class,'ta-item')][1]")).click();
	//driver.findElement(By.cssSelector(".action__submit")).click();
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void selectCountry(String CountryName) {
		Actions action = new Actions(driver);
		action.sendKeys(country, CountryName).build().perform();
		waitForElementToAppear(result);
	    selectContry.click();
	}
	
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
}
