package emulator;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.emulation.Emulation;

import org.openqa.selenium.devtools.HasDevTools;
//import org.openqa.selenium.devtools.v117.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileImulator {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		//send commands to Command Dev Tools protocol (CDP) -> send command to CDP Methods -> CDP Methods will invoke and get access to chrome dev tools.
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-expand-lg" )).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Virtual Library')]" )).click();
	}

}
