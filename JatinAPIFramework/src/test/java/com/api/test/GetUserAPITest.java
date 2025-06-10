package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserprofileManagementService;
import com.api.model.Request.LoginRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserGetResponse;

import io.restassured.response.Response;

public class GetUserAPITest {

	@Test
	public void getProfileInfo() {
		
		AuthService authService = new AuthService();
		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("sujaniw");
		loginRequest.setPassword("MyLokupusa123#@");
		
		Response response = authService.login(loginRequest);
		LoginResponse login = response.as(LoginResponse.class);
		String token = login.getToken();
		System.out.println(token);
		UserprofileManagementService profile = new UserprofileManagementService();
		Response res = profile.getProfile(token);
		UserGetResponse  userResponse = res.as(UserGetResponse.class);
		
		System.out.println(userResponse.toString());
		
		
	}
}
