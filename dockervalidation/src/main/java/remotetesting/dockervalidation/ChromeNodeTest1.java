package remotetesting.dockervalidation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeNodeTest1 {

		@BeforeTest
		public void startDocker() throws IOException, InterruptedException {
			 //delete the output file.
		       File f = new File("output.txt");
		       if(f.delete()) {
		    	   System.out.println("file deleted successfully");
		    	   System.out.flush();
		       }
		       
			StartDocker s = new StartDocker();
			s.startFile();			
		}
		
		@AfterTest
		public void stopDocker() throws IOException, InterruptedException {
			StopDockerHub s = new StopDockerHub();
			s.stopFile();
		}
	
	
	
	   @Test
		public void test1() throws MalformedURLException {
			// TODO Auto-generated method stub
	        ChromeOptions options = new ChromeOptions();
			
			URL url = new URL("http://localhost:4444/wd/hub");
			RemoteWebDriver driver = new RemoteWebDriver(url,options);
			driver.get("https://www.google.com");
	        System.out.println("Title: " + driver.getTitle());
	       // System.out.flush();
	        driver.quit();
			
		}

	}


