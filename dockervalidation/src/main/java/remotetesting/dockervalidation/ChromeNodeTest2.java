package remotetesting.dockervalidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeNodeTest2 {

		@Test
		public void test2() throws MalformedURLException {
			// TODO Auto-generated method stub
	        ChromeOptions options = new ChromeOptions();
			
			URL url = new URL("http://localhost:4444/wd/hub");
			RemoteWebDriver driver = new RemoteWebDriver(url,options);
			driver.get("https://www.gmail.com");
	        System.out.println("Title: " + driver.getTitle());
	        System.out.flush();

	        driver.quit();
			
		}

	}


