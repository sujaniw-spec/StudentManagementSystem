package sujaniacademy.appium1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

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

public class ScrollDemo extends BaseTest{

		@Test
		public void scrollDemoTestt() throws MalformedURLException, URISyntaxException, InterruptedException {
			
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			
			// using anroiduiautomater - If you where to scroll is known prior use this
		//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"webView\"));"));
		//	Thread.sleep(2000);
			
			//if you have no idea where to exactly scroll use this, scrolling little by litte
			/*boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
			));*/
			
			//if you want to scroll until end of the page
			scrollToTheEndAction();
			
			Thread.sleep(2000);
		}
		
	

}
