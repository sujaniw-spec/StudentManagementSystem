package com.api.base;

import com.api.model.Request.LoginRequest;
import com.api.model.Request.ProfileRequest;

import io.restassured.response.Response;

public class UserprofileManagementService extends BaseService{

private final static String BASE_PATH = "/api/users/";
	
	public Response getProfile(String token) {
		setAuthToken(token);
		return gettRequest(BASE_PATH+"profile");
	}
	
	public Response updateProfile(String token, ProfileRequest payLoad) {
		setAuthToken(token);		
		return putRequest(payLoad,BASE_PATH+"profile");
	}
	
	
}
