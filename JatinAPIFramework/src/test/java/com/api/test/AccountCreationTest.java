package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.model.Request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description ="Verify if Login API ")
	public void createAccountTest() {
		
		 SignUpRequest signUpRequest = new SignUpRequest.Builder()
		            .username("Jo")
		            .password("john123")
		            .email("ccc@email.com")
		            .firstName("John")
		            .lastName("Doe")
		            .mobileNumber("1234567890")
		            .build();
		 
		
		AuthService authService = new AuthService();
		Response response= authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
	}
}
