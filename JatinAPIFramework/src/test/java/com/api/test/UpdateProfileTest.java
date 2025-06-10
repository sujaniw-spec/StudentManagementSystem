package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserprofileManagementService;
import com.api.model.Request.LoginRequest;
import com.api.model.Request.ProfileRequest;
import com.api.model.response.LoginResponse;
import com.api.model.response.UserGetResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void updateProfileTest() throws JsonProcessingException {
		
		AuthService authService = new AuthService();
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("sujaniw");
		loginRequest.setPassword("MyLokupusa123#@");
		
		Response response = authService.login(loginRequest);
		LoginResponse login = response.as(LoginResponse.class);
		String token = login.getToken();
		System.out.println("------------------------------------------------------------");
		
		UserprofileManagementService userManager = new UserprofileManagementService();
		response = userManager.getProfile(token);
		System.out.println(response.asPrettyString());
		
		UserGetResponse userResponse = response.as(UserGetResponse.class);
		Assert.assertEquals(userResponse.getUsername(), "sujaniw");
		
		System.out.println("------------------------------------------------------------");
		
		ProfileRequest profile = new ProfileRequest();
		profile.setEmail("sujaniw@yahoo.com");
		profile.setFirstName("Sujani");
		profile.setLastName("Wijesundera");
		profile.setMobileNumber("4039213432");
		
		System.out.println(new ObjectMapper().writeValueAsString(profile));
		response = userManager.updateProfile(token, profile);		
		
		System.out.println(response.asPrettyString());
		
	}
}
