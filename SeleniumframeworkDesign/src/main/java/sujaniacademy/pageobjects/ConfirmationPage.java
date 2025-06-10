package sujaniacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sujaniacademy.abstractcomponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(tagName="h1")
	WebElement thanksText;
	// String thanksText = driver.findElement(By.tagName("h1")).getText();
	
	public String getThankYouMessage() {
		return thanksText.getText();
	}
}
