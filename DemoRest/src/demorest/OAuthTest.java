package demorest;

//import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

public class OAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] coursetitles = {"Selenium Webdriver Java","Cypress","Protractor"};

		//create token
		String response = given().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		JsonPath js = new JsonPath(response);
		String accessToken = js.getString("access_token");
		System.out.println(accessToken);
		
		//get course details
		GetCourse getCourse = given()
		.queryParam("access_token", accessToken)
		.when().log().all()
		.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourse.class);
		//.then().log().all().assertThat().statusCode(200)
		//.extract().asString();
		System.out.println(getCourse.getInstructor());
		System.out.println(getCourse.getLinkedIn());
		System.out.println(getCourse.getCourses().getApi().get(0).getCourseTitle());	
		
		List<WebAutomation> list = getCourse.getCourses().getWebAutomation();
		
		for(WebAutomation wa : list) {
			if(wa.getCourseTitle().equalsIgnoreCase("Cypress")) {
				System.out.println(wa.getPrice());
			}
		}
		
		List<Api> listApi = getCourse.getCourses().getApi();
		
		for(Api api : listApi) {
			System.out.println(api.getCourseTitle());
		}
		
		//Get the course titles of WebAutomation
		ArrayList <String> a = new ArrayList<String>();
		
		for(int i=0; i<list.size(); i++) {
			a.add(list.get(i).getCourseTitle());
		}
		
		List <String> expectedlist = Arrays.asList(coursetitles);
		Assert.assertTrue(a.equals(expectedlist));
		System.out.println("************");
		for(String ac: a) {
			System.out.println(ac);
		}
		
		for(String ec: expectedlist) {
			System.out.println(ec);
		}
		
	}

}
