package demorest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

public class specBuilderTest {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);		
		p.setName("Frontline house1");
		p.setAddress("35, side layout, cohen 09");
		p.setLanguage("English-IN");
		p.setWebsite("http://google.com");
		p.setPhone_number("(+1) 9835 893 3937");
		List<String> typeList = new ArrayList<String>();
		typeList.add("shoe park");
		typeList.add("shoe");		
		p.setTypes(typeList);
		Location location = new Location();
		location.setLat(-38.383494);
		location.setLng(33.427362);
		p.setLocation(location);
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		
		RequestSpecification res = given().spec(req)
		.body(p);
		
		ResponseSpecification resposeSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
		.expectStatusCode(200).build();	
		
		Response response = res.when().post("/maps/api/place/add/json")
		.then().spec(resposeSpec)
		.extract().response();
		
		String resposeAsString = response.asString();
		System.out.println(resposeAsString);
	    System.out.println(response.body().asPrettyString());		
	}

}
