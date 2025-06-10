package demorest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.OrderDetail;
import pojo.Orders;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.setContentType(ContentType.JSON)
		.build();
		
		LoginRequest login = new LoginRequest();
		login.setUserEmail("sujaniw@yahoo.com");
		login.setUserPassword("MyLokupusa123#@");
		
		LoginResponse loginResponse = 
		given().log().all().spec(req)
		.body(login)
		.when().post("/api/ecom/auth/login")
		.then().log().all().extract().response().as(LoginResponse.class);
		
		String token = loginResponse.getToken();
		String userId = loginResponse.getUserId();
		System.out.println(token);
		System.out.println(userId);
		
		//Add Product
		RequestSpecification addProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token)
				.build();
		RequestSpecification reqAddProduct = given().log().all().spec(addProductBaseReq)
		.param("productName", "start")
		.param("productAddedBy", userId)
		.param("productCategory", "fashion")
		.param("productSubCategory", "shirts")
		.param("productPrice", "1000")
		.param("productDescription", "Star Original")
		.param("productFor", "Women")
		.multiPart("productImage", new File("C:\\Users\\sujan\\OneDrive\\Desktop\\Star.jpg"));
		
		String addProductresponse = reqAddProduct.when().post("/api/ecom/product/add-product")
		.then().extract().response().asString();
		
		JsonPath js = new JsonPath(addProductresponse);
		String productid = js.get("productId");
		System.out.println("productid "+productid);
		
		//Create order
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCountry("Canada");
		orderDetail.setProductOrderedId(productid);
		
		List <OrderDetail> orderdetaillist = new ArrayList<OrderDetail>();
		orderdetaillist.add(orderDetail);
		
		Orders order = new Orders();
		order.setOrders(orderdetaillist);
		
		RequestSpecification createOrderBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token)
				.setContentType(ContentType.JSON)
				.build();
		RequestSpecification createorderReq = given().log().all().spec(createOrderBaseReq)
		.body(order);
		
		String orderRes = createorderReq.when()
		.post("/api/ecom/order/create-order")
		.then().log().all().extract().response().asString();
		
		JsonPath js1 = new JsonPath(orderRes);
		String orderId = js1.get("orders[0]");
		
		System.out.println(orderId);
		String productOrderId = js1.get("productOrderId[0]");
		System.out.println("productOrderId "+productOrderId);
		
		//delete product
			RequestSpecification deleteProductBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).setContentType(ContentType.JSON)
				.build();
		
	 //If https or SSL ceritification is not valid we can bypass it by the method 'relaxedHTTPSValidation'
			
		RequestSpecification deleteProdSpec = given().relaxedHTTPSValidation().log().all().spec(deleteProductBaseReq)
		.pathParam("productId", productid);
		
		String deleteProd = deleteProdSpec.when().delete("/api/ecom/product/delete-product/{productId}")
		.then().log().all().extract().response().asString();
		
		System.out.println(deleteProd);
		
	}

}
