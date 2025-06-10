package stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{

	RequestSpecification res;
	ResponseSpecification resposeSpec;
	Response response;
	TestDataBuild testDataBuild = new TestDataBuild();
	JsonPath js;
	static String placeId;

@Given("Add Place Payload with {string} {string} {string}")
public void add_place_payload_with(String name, String language, String address) throws IOException {
	// Write code here that turns the phrase above into concrete actions
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
			
//		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		//.addQueryParam("key", "qaclick123")
		//.setContentType(ContentType.JSON).build();	
		
		res = given().spec(requestSpecification())
		.body(testDataBuild.addPlacePayload(name,language,address ));
}

/*@When("user calls {string} with post http request")
public void user_calls_with_post_http_request(String resourceApi) {
	
	resposeSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
			.expectStatusCode(200).build();		
	//get api from enum
	APIResources resourceAPI = APIResources.valueOf(resourceApi);
	
			response = res.when().post(resourceAPI.getResource())
			.then().spec(resposeSpec)
			.extract().response();
}*/

@When("user calls {string} with {string} http request")
public void user_calls_with_http_request(String resourceApi, String httpMethod) {
    // Write code here that turns the phrase above into concrete actions
	resposeSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
			.expectStatusCode(200).build();		
	//get api from enum. constructor will be called with value of resource which you pass.
	APIResources resourceAPI = APIResources.valueOf(resourceApi);
	
	if(httpMethod.equalsIgnoreCase("POST")) {
			response = res.when().post(resourceAPI.getResource());
					//.then().spec(resposeSpec)
					//.extract().response();
	}		
	else if(httpMethod.equalsIgnoreCase("GET")) {
		response = res.when().get(resourceAPI.getResource());	
			//.then().spec(resposeSpec)
			//.extract().response();
	}
	if(httpMethod.equalsIgnoreCase("DELETE")) {
		response = res.when().delete(resourceAPI.getResource());
				//.then().spec(resposeSpec)
				//.extract().response();
}	
}

@Then("the API call is suceess with status code {int}")
public void the_api_call_is_suceess_with_status_code(int statusCode) {
	
   assertEquals(statusCode,response.getStatusCode());	
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String key, String value) {
  
	//String resp = response.asString();
	//js = new JsonPath(resp);
	String jsonKey = getJsonPath(response,key); //scope
		
	assertEquals(value,jsonKey);		
}

@Then("verify place_id created maps to {string} usning {string}")
public void verify_place_id_created_maps_to_usning(String expectedName, String endPointUrl) throws IOException {
	
    placeId = getJsonPath(response,"place_id");
    res =given().spec(requestSpecification()).queryParam("place_id", placeId);
	
	user_calls_with_http_request(endPointUrl, "GET");
	String actualName = getJsonPath(response,"name");
	assertEquals(expectedName,actualName);
	
}

@Given("delete place payload")
public void delete_place_payload() throws IOException {
	res =given().spec(requestSpecification()).body(testDataBuild.deletePlacePayLoad(placeId));
}
	
}
