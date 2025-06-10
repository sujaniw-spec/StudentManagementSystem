package emulator;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CDPCommandsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		 HashMap<String, Object> deviceMetrics = new HashMap<>();
		 deviceMetrics.put("width", 600);
		 deviceMetrics.put("height", 1000);
	     deviceMetrics.put("deviceScaleFactor", 50);
	     deviceMetrics.put("mobile", true);
	     
		 driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		 
		 driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			driver.findElement(By.cssSelector(".navbar-expand-lg" )).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Virtual Library')]" )).click();
	}

}
