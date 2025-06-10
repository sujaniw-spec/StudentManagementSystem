package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
//import com.api.filters.*;

public class LogginFilter  implements Filter{
	
	private static final Logger logger = LogManager.getLogger(LogginFilter.class);

	
	//capture the request and response. Intercept the req and res, so you can logg your req and respnse. intercept using filter
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		// TODO Auto-generated method stub
		logRequest(requestSpec);
		
		Response response = ctx.next(requestSpec, responseSpec); //REquestis going to executed
		logResponse(response);
		return response;
	}
	
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI:"+ requestSpec.getBaseUri());
		logger.info("BASE URI:"+ requestSpec.getHeaders());
		logger.info("BASE URI:"+ requestSpec.getBody());
	}
	
	public void logResponse(Response response) {
		logger.info("Status Code:"+ response.statusCode());
		logger.info("Response Header payload:"+ response.headers());
		logger.info("Response body:"+ response.getBody().prettyPrint());		
		
	}

}
