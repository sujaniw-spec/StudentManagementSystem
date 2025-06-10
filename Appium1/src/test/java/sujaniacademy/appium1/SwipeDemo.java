package sujaniacademy.appium1;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class SwipeDemo extends BaseTest{

	@Test
	public void scrollDemoTestt() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Photos']")).click();
		
	    WebElement firstImageElement = driver.findElement(By.xpath("(//android.widget.ImageView) [1]"));
		Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView) [1]")).getDomAttribute("focusable"),"true");
	    
	    //if the first image on focus, then swipe
		
		swipeAction(firstImageElement,"left");
	    
	  /*  ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	    		"elementId",((RemoteWebElement)firstImageElement).getId(),
	    	    "direction", "left",
	    	    "percent", 0.75
	    	));*/
		
	    
	    Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView) [1]")).getDomAttribute("focusable"),"false");
		   
		Thread.sleep(2000);
	}
	

}
