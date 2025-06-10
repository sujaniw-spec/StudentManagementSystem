package demorest;

	import static io.restassured.RestAssured.given;



	import java.util.ArrayList;

	import java.util.Arrays;

	import java.util.List;



	import org.openqa.selenium.By;

	import org.openqa.selenium.Keys;

	import org.openqa.selenium.WebDriver;

	import org.openqa.selenium.chrome.ChromeDriver;



	import io.restassured.parsing.Parser;

	import io.restassured.path.json.JsonPath;

	import io.restassured.response.Response;

	import io.restassured.response.ResponseBody;

	import pojo.Api;

	import pojo.GetCourse;





	public class Test1AuthCode {



	public static void main(String[] args) throws InterruptedException {

	// TODO Auto-generated method stub

	String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2F0Ab_5qlml2RvR8tl23xNSXedKXjUhdF_FIdAD3afCrQVLAzYDtqzYXx_9KoQ2I0bI9Aurcg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";



	String partialcode=url.split("code=")[1];

	String code=partialcode.split("&scope")[0];


	System.out.println(code);




	String response =

	                given() 

	                .urlEncodingEnabled(false)

	                       .queryParams("code",code)

	               

	                   .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

	                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

	                        .queryParams("grant_type", "authorization_code")

	                        .queryParams("state", "verifyfjdss")

	                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

	                     // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")

	                       

	                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

	                        .when().log().all()

	                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

	// System.out.println(response);

	JsonPath jsonPath = new JsonPath(response);

	    String accessToken = jsonPath.getString("access_token");

   System.out.println("accessToken"+accessToken);

	String r2=    given().contentType("application/json").

	queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)
	.log().all()
	.when()

	           .get("https://rahulshettyacademy.com/getCourse.php")

	.asString();

//	System.out.println(r2);





	}




	}
