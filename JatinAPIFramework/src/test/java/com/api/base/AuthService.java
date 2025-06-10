package com.api.base;

import java.util.HashMap;

import com.api.model.Request.LoginRequest;
import com.api.model.Request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private final static String BASE_PATH = "/api/auth/";
	
	public Response login(LoginRequest payLoad) {
		return postRequest(payLoad, BASE_PATH+"login");
	}
	
	public Response signUp(SignUpRequest payLoad) {
		return postRequest(payLoad, BASE_PATH+"signup");
	}
	
	public Response forgotPassword(String email) {
		HashMap<String, String> payLoad = new HashMap<>();
		payLoad.put("email", email);
		return postRequest(payLoad, BASE_PATH+"forgot-password");
	}
}
