package sujaniacademy.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationteststore.com/");	
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
		
		By filterTextBoxLocator = By.id("filter_keyword");
		WebElement filterTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(filterTextBoxLocator));
		filterTextBox.sendKeys("hello");
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.SHIFT).sendKeys("Hiii").keyUp(Keys.SHIFT).perform();
		
		//hover my mouse on the element.
		
		By navLinkLocator = By.xpath("//ul[@class='nav-pills categorymenu']//a[contains(text(),'Apparel')]");
		action.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(navLinkLocator))).perform();
		
	}

}
