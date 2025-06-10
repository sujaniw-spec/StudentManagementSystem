package remotetesting.dockervalidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StandloneFireFoxTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		FirefoxOptions options = new FirefoxOptions();
			
			URL url = new URL("http://localhost:4445/wd/hub");
			RemoteWebDriver driver = new RemoteWebDriver(url,options);
			driver.get("https://www.google.com");
	        System.out.println("Title: " + driver.getTitle());

	        driver.quit();
			
	}

}
