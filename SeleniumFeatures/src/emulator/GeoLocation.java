package emulator;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       //40 3
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		HashMap<String, Object> mapCordinators = new HashMap<>();
		mapCordinators.put("latitude", 40);
		mapCordinators.put("lonitude", 3);
		mapCordinators.put("accuracy", 1);
	     		
		 driver.executeCdpCommand("Emulation.setGeolocationOverride", mapCordinators);
		 driver.get("https://www.google.com/");
		 driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		 Thread.sleep(6000);
		 driver.findElements(By.cssSelector(".LC20lb" )).get(0).click();
		 String title = driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey")).getText();
		 
		 System.out.println(title);
	}

}
