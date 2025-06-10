package sujaniacademy.pageobjects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v131.network.model.ErrorReason;
import org.openqa.selenium.devtools.v131.fetch.Fetch;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkFailedRequest {

	public static void main(String[] args) {
		  WebDriverManager.chromedriver().setup();
	        ChromeDriver driver = new ChromeDriver();

	        DevTools devTools = driver.getDevTools();
	        devTools.createSession();
	        
	        Optional <List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty()))); 
	        devTools.send(Fetch.enable(patterns, Optional.empty()));

	        devTools.addListener(Fetch.requestPaused(), request -> {
	        	devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
	        });

	        

	        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	        driver.findElement(By.xpath("//button[contains(text(),'Virtual Library')]")).click();

	       
	        driver.quit();

	}

}
