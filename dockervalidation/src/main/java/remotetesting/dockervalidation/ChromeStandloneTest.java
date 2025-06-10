package remotetesting.dockervalidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandloneTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
        ChromeOptions options = new ChromeOptions();
		
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url,options);
		driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        driver.quit();
		
	}

}
