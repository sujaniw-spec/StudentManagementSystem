package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification req;
	
	public static String getGlobalProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\ECLIPSE-PROJECTS\\APIFramework\\src\\test\\java\\resources\\global.properties");
		
		prop.load(fis);
		return prop.getProperty("baseUrl");
	
	}

	public RequestSpecification requestSpecification() throws IOException {
		
		if(req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			//RestAssured.baseURI = "https://rahulshettyacademy.com";
			
			 req = new RequestSpecBuilder().setBaseUri(getGlobalProperties())
			.addQueryParam("key", "qaclick123")
			
			.addFilter(RequestLoggingFilter.logRequestTo(log))//logging req
			.addFilter(ResponseLoggingFilter.logResponseTo(log)) //logging response
			
			.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}
	
	public String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.getString(key);
	}
}
