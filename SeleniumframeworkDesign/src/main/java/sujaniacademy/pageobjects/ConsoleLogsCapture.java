package sujaniacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConsoleLogsCapture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        
        //Listeners = OntestFaliure
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2",Keys.ENTER);
        
        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);// Get LogEntries object
        List<LogEntry> logs = entry.getAll(); //Get LogEntries object - Get all methods in the logs
        
        for(LogEntry logEntry : logs) { //Print the log
        System.out.println(logEntry.getMessage())	;
        }
	}

}
