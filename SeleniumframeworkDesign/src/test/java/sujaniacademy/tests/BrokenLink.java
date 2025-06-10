package sujaniacademy.tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("C:\\ECLIPSE-PROJECTS\\SeleniumframeworkDesign\\src\\test\\java\\sujaniacademy\\tests\\testcomponenets\\link.html");	
		
		List<WebElement> aList = driver.findElements(By.tagName("a"));
		System.out.println(aList.size());
		
		for(WebElement aElement: aList) {
			checkBrokenLink(aElement.getDomAttribute("href"));
		}
		//aList.parallelStream().filter(w -> checkBrokenLink(w.getDomAttribute("href")))
      

	}

	private static void checkBrokenLink(@Nullable String url) throws IOException {
		
		//Checking if the URL is broken or not
		//API Request from Java
		//HEAD only gives the meta data. Does not download body. Get gives the response body as well
		try {
		URL urlLink = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)urlLink.openConnection();
		connection.setRequestMethod("HEAD");
		connection.connect();
		
		int statusCode = connection.getResponseCode();
		
		if(statusCode >=400) {
			System.out.println("Broken Link "+url);
		}
		else if(statusCode >=200 && statusCode <400) {
			System.out.println("Valid Link "+url);
		}
		}catch(Exception e) {
		System.err.println("cauth the exception "+e.getMessage());
		}
		
	}

}
