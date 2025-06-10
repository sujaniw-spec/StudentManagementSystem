package codingpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScripExecuteDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Sorting web table and compare it with sorted list
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List <WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int total =0;
		for(WebElement value : values) {
			total+=Integer.parseInt(value.getText());
		}
		System.out.println(total);
		
		String totalValue = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1];
		System.out.println(totalValue);
		Assert.assertEquals(totalValue, String.valueOf(total).toString());
		
		
		
	}

}
