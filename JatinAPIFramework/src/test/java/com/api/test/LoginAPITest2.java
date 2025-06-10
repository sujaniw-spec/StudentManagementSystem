package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import com.api.model.Request.LoginRequest;
import com.api.model.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)	
public class LoginAPITest2 {

	@Test
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("sujaniw");
		loginRequest.setPassword("MyLokupusa123#@");
		
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		System.out.println(response.asPrettyString());
		
		//deserialize
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(),"sujaniw@yahoo.com");
		
	}
}
