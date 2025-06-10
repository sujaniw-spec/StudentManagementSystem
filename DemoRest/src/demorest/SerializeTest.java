package demorest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

public class SerializeTest {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace p = new AddPlace();
		p.setAccuracy(50);		
		p.setName("Frontline house");
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
		
		System.out.println(new ObjectMapper().writeValueAsString(p));
		
		Response res = given().queryParam("key", "qaclick123")
		.contentType("application/json")
		.body(p)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.extract().response();
		
		String resposeAsString = res.asString();
		System.out.println(resposeAsString);
	    System.out.println(res.body().asPrettyString());		
	}

}
