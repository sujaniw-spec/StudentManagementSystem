package sujaniacademy.appium1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;

public class BaseTest {

	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		URI url = new URI("http://localhost:4723");
		
		//Start appium server
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\sujan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)	
				.build();
		
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("SujaniEmulator1");
		options.setApp("C:\\ECLIPSE-PROJECTS\\Appium1\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		driver = new AndroidDriver(url.toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void longPressAction(WebElement element) {
	
	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) element).getId(),
		    "duration", 2000				    
		));
	}
	
	
	public void scrollToTheEndAction() {
		boolean canScrollMore=false;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
		));
		}while(canScrollMore);
	}
	
	public void swipeAction(WebElement element, String direction) {
		   ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
		    		"elementId",((RemoteWebElement)element).getId(),
		    	    "direction", direction,
		    	    "percent", 0.75
		    	));
			
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	
}
