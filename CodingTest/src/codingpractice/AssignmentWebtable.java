package codingpractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentWebtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Sorting web table and compare it with sorted list
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
				
		List <WebElement> numberOfRows = driver.findElements(By.cssSelector("table[name='courses'] tr"));
		System.out.println("Number of rows: "+numberOfRows.size());
		
		List <WebElement> numberOfColums = driver.findElements(By.cssSelector("table[name='courses'] th"));
		System.out.println("Number of columns: "+numberOfColums.size());
		
		List <WebElement> secondRow = driver.findElements(By.cssSelector("table[name='courses'] tr:nth-child(3) td"));
		
		secondRow.stream().map(td -> td.getText()).forEach(td -> System.out.print(td));		
	}
}
