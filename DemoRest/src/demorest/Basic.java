package demorest;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;

import files.PayLoad;
import files.Reusable;
//import static org.hamcrest.MatcherAssert.assertThat;

//import static org.hamcrest.Matchers.*;

public class Basic {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Validate AddPlace API
		//given - all input details
		//when - submit the api, resource, http method
		//Then - validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		/* Json payload taken as a string
		 * String response = given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(PayLoad.addPlace())
		.when().post("maps/api/place/add/json")
		.then()//.log().all().
		.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
	
		//add place -> update place with new address ->get place to validate if new address is present in response
		System.out.println(response);
	//	JsonPath json = new JsonPath(response); //for parsing json
		String placeId = Reusable.rowToJson(response).getString("place_id");
		System.out.println(placeId); */
		
		//Json payload taken as a file -> then to String - content of the file convert into Byte->Byte data to String
		String response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type","application/json")				
				.body(new String(Files.readAllBytes(Paths.get("C:\\ECLIPSE-PROJECTS\\DemoRest\\AddPlace.json"))))
				.when().post("maps/api/place/add/json")
				.then()//.log().all().
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)")
				.extract().response().asString();
			
				//add place -> update place with new address ->get place to validate if new address is present in response
				System.out.println(response);
			//	JsonPath json = new JsonPath(response); //for parsing json
				String placeId = Reusable.rowToJson(response).getString("place_id");
				System.out.println(placeId); 
		
		
		
		//Update Place
		String newAddress = "102 Summer walk, CA";
		
		given().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		//Get Place
		String updatedAddressResponse = given().queryParam("place_id", placeId).queryParam("key", "qaclick123")
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).body("address", equalTo(newAddress))
		.header("Server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		//System.out.println("address -> "+updatedAddress);
		JsonPath json1 = new JsonPath(updatedAddressResponse); 
		String updatedAddress =Reusable.rowToJson(updatedAddressResponse).getString("address");
		
		System.out.println(updatedAddress);
		Assert.assertEquals(updatedAddress, newAddress);
	}

}
