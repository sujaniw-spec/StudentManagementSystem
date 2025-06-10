package demorest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OauthAuthorizationCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
	/*	WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("sujani75@gmail.com");
	//	driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("MyToyota7503#@");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(4000);
		String url = driver.getCurrentUrl();*/
		
		String autoCode = "4%2F0Ab_5qlnk_oyLTZZxp-7zdohTsskkSGYWMDzNxIoktbae-GYkkXgiZf-rie34S3KeZv0Ilw";
		
		String accessTokenResponse = given()
		.urlEncodingEnabled(false) // do not convert % value convert to numerical
		.queryParams("code",autoCode)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		//.queryParams("scope", "https://www.googleapis.com/auth/userinfo.email")
		//.queryParams("response_type", "code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		
		String response = given().queryParam("access_token", accessToken)
		.when()
		.get("https://rahulshettyacademy.com/getCourse.php")
		.asString();
		
		System.out.println(response);
	}

}
