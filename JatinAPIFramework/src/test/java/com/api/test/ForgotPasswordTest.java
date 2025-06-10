package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test
	public void forgotPassword() {
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("sujaniw@yahoo.com");
		System.out.println(response.asPrettyString());
	}
}
