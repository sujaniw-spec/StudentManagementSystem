package sujaniacademy.appium1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasic extends BaseTest{

		@Test
		public void wifiSettingsName() throws MalformedURLException, URISyntaxException {
			//AndroidDriver
			//Appium code -> send to appium server ->then send to mbile
		/*URI url = new URI("http://localhost:4723");
			
			//Start appium server
			AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\sujan\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1")
					.usingPort(4723)	
					.build();
			
			service.start();
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setDeviceName("SujaniEmulator1");
			options.setApp("C:\\ECLIPSE-PROJECTS\\Appium1\\src\\test\\java\\resources\\ApiDemos-debug.apk");
			
			AndroidDriver driver = new AndroidDriver(url.toURL(),options);*/
			
			//Actual implementation
			//Xpath, id, accessabilityId, classname, androidAutomator
			//configureAppium();
			driver.findElement(AppiumBy.accessibilityId("Preference")).click();	
			driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();	
			driver.findElement(By.id("android:id/checkbox")).click();
			driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
			
			String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
			Assert.assertEquals(alertTitle, "WiFi settings");
			
			driver.findElement(By.id("android:id/edit")).sendKeys("Sujani wifi");
			
			driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
			
			
			//tearDown();
		}
		
	

}
