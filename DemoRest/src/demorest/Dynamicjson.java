package demorest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import files.Reusable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Dynamicjson {

	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String asile) {
		RestAssured.baseURI ="http://216.10.245.166";
		String response = given().header("Content-Type","application/json")
		.body(PayLoad.addBook(isbn,asile))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = Reusable.rowToJson(response);
		String bookId = js.get("ID");
		System.out.println(bookId);		
	}
	

	@Test(dataProvider="BooksData")
	public void deleteBook(String isbn, String asile) {
		RestAssured.baseURI ="http://216.10.245.166";
		String response = given().log().all().header("Content-Type","application/json")
		.body(PayLoad.deleteBook(isbn,asile))
		.when().post("/Library/DeleteBook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = Reusable.rowToJson(response);
		String message = js.get("msg");
		System.out.println(message);		
	}
	
	
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		//Object[][] o = {{"b","n"},{"n","g"}};
		return new Object[][] {{"dfscb","8754"},{"ghfv","3234"},{"hnbm","9812"}};
	}
}
