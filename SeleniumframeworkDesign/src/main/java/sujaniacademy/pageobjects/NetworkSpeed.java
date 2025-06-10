package sujaniacademy.pageobjects;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.network.Network;
import org.openqa.selenium.devtools.v130.network.model.ConnectionType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
       //remove the internet connection
        // devTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.ETHERNET), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
    	
        devTools.addListener(Network.loadingFailed(), loadingFailed->{
        	System.out.println(loadingFailed.getErrorText());
        	System.out.println(loadingFailed.getTimestamp());
        });
        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[contains(text(),'Virtual Library')]")).click();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
	}

}
