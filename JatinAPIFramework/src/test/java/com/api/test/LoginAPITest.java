package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {

	@Test(description =" Verify if login is working...")
	public void loginTest() {
		
		//baseURI ="http://64.227.160.186:8080";
		Response response =given().baseUri("http://64.227.160.186:8080")
		.header("Content-Type","application/json")
		.body("{"
				+ "\"username\": \"sujaniw\","
				+ "\"password\": \"MyLokupusa123#@\""
				+ "}")
		.post("/api/auth/login");
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.statusCode(), 200);
		
		
	}
}
