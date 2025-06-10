package codingpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoComplete {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Sorting web table and compare it with sorted list
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		
		
		Thread.sleep(3000);
		List <WebElement> autocompleList = driver.findElements(By.cssSelector(".ui-menu-item"));
		String dropdownValue="";
		
		for(WebElement listElement : autocompleList ) {
			if(listElement.getText().equals("India")) {
				dropdownValue =driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText();
				driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).click();				
				break;
			}	
			else {
				driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			}
		}
		
	//	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
	//	driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		
		//String dropdownValue = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li[2]")).getText();
		
		System.out.println("dropdownValue: " + dropdownValue);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String value =(String)js.executeScript("return document.getElementById('autocomplete').value;");
		System.out.println("Value of input field: " + value);
		
		
	}

}
