package rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.PayLoad;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Validate if Add Place API working as expected
		//given - get all input details
		//when - Submit the api - response - http method
		//Then - validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response =  given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
			.body(PayLoad.AddPlace()).when().post("maps/api/place/add/json")
			.then().assertThat().statusCode(200).body("scope",equalTo("APP"))
			.header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		//System.out.println(response);
		JsonPath js = new JsonPath(response);// parsing json
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
	}

}
