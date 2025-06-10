package demorest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

public class TestQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI ="https://jsonplaceholder.typicode.com";
		Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("title", "foo");
        jsonMap.put("body", "bar9");
        jsonMap.put("userId", 9);
        //jsonMap.put("id", 101);
        
		String response = given()
		.header("Content-Type", "application/json")
		.body(jsonMap)
		.when()
		.post("/posts")
		.then()
		.assertThat().statusCode(201)
		.body("title",equalTo("foo"))
		.extract().asString();
		
		JsonPath js = new JsonPath(response);
		String userId = js.getString("userId");
		
		//System.out.println(userId);
		
		String getId = given().log().all()
		//.header("Content-Type", "application/json")
		.when()
		.get("/posts/"+userId)
		.then()
		.extract().response().asString();
		
		JsonPath js1 = new JsonPath(getId);
		String userId1 = js.getString("id");
		System.out.println(userId1);
		System.out.println(getId);
	}

}
