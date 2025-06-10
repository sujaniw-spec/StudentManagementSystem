package emulator;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		
		devTools.addListener(Network.requestWillBeSent(), request ->{
			Request req = request.getRequest();
			System.out.println(req.getUrl());
		});
		
		//Event will get fired - when response get back
		devTools.addListener(Network.responseReceived(), response ->{
			Response res = response.getResponse();
		//	System.out.println(res.getUrl());
		//	System.out.println(res.getStatus());
			
			if(res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() +" is failing"+res.getStatus());
			}
		});
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//button[contains(text(),'Virtual Library')]")).click();
	}

}
