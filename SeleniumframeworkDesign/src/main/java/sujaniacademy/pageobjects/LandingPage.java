package sujaniacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sujaniacademy.abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	//WebElement userEmailElement = driver.findElement(By.id("userEmail"));//.sendKeys("sujaniw@yahoo.com");
	//WebElement userPassword = driver.findElement(By.id("userPassword"));//.sendKeys("MyLokupusa123#@");
	//WebElement submitButton = driver.findElement(By.id("login"));//.click();
	
	//PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submitButton;
	
	@FindBy(id="toast-container")
	WebElement errorToaster;
	
	public String getLoginErrorMessage() {
		waitForElementToAppear(errorToaster);
		return errorToaster.getText();
	}
	
	public ProductCatelogue logingApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submitButton.click();
		return new ProductCatelogue(driver);
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
}
