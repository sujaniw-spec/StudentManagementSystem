package sujaniacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sujaniacademy.abstractcomponents.AbstractComponents;

public class OrderPage extends AbstractComponents{

	WebDriver driver;
		
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNameList;
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public Boolean VerifyOrderDisplay(String productName) {
		return productNameList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	}	
}
