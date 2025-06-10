package sujaniacademy.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;

//import java.awt.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ResponsiveTest {

	private WebDriver driver;
	private WebDriverWait wait;
	
	private HashMap<String, Dimension> deviceMap = new HashMap<>() {{
		put("Pixal" , new Dimension(412,912));
		put("Tablet" , new Dimension(1024,1366));
		put("Desktop" , new Dimension(9977,3574));
	}};
	
	
	
	@BeforeMethod(description = "Launching Chrome Browser")
	public void setUp() {
		
		
		driver = new ChromeDriver();
		driver.get("https://dribbble.com");
		//pass specific dimension to the wd scripts
		//Dimension d = new Dimension(412,915);
		//driver.manage().window().setSize(d);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}
	
	@Test(description = "Checking if the webpage is responsive or not")
	public void responsiveTest() {
		for(Map.Entry<String, Dimension> device: deviceMap.entrySet()) {
			//Dimension d = new Dimension(412,915);
			if(device.getKey().equalsIgnoreCase("Pixal")) {
			driver.manage().window().setSize(device.getValue());
			System.out.println("Pixel Test");
			}
			else if(device.getKey().equalsIgnoreCase("Tablet")) {
			driver.manage().window().setSize(device.getValue());
			System.out.println("Tablet Test");
			}
			else if(device.getKey().equalsIgnoreCase("Desktop")) {
			driver.manage().window().setSize(device.getValue());
			System.out.println("Desktop Test");
			}
		}
	}

}
