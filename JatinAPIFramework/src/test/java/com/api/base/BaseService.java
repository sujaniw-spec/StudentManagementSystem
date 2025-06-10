package com.api.base;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.filter.Filter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.api.filters.*;

public class BaseService { //wrapper class for Rest Assured
//BASE URI
	//Creating the request
	//Handling the response
	//https://tech-with-jatin.notion.site/E2E-Automation-Framework-Creation-1526d427c22780328b8fff211ee050b7 - documentation
	private static final String BASE_URL ="http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static{
		RestAssured.filters(new LogginFilter());
	}
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected Response postRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	
	protected Response putRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
	}
	
	protected Response gettRequest(String endPoint) {
		return requestSpecification.get(endPoint);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer "+token);		
	}
}
