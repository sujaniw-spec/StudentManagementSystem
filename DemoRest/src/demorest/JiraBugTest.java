package demorest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;
import java.util.*;
public class JiraBugTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI ="https://sujani75.atlassian.net/";
		
		//create bug
		String response = given()//.auth().oauth2("accesstoken")
		.header("Content-Type","application/json")
		//.cookie("session_id","cookie value")
		.header("Authorization","Basic c3VqYW5pNzVAZ21haWwuY29tOkFUQVRUM3hGZkdGMGVzaVViWTFNVWh3NF9jc2VnRkJteEtQTzVGRWlqLS1QRFRHam1zLVd4UUJpM0xFYUo3bGhfWWJsbW5mYVFydzIyZzd4SDlMTVUwa0QwUmI1dG5iUWx0WElFazVudXpSeDhFVE1JTlpPVVhaWVlJazZIZnhUR2YtVDV4bDZudEd3dzJPQjJEWl82Q0FkbDRtdC1seWVfS0ZGV3RyZE5BZGtYb0YwMVhSU1VHaz1BRDVCN0VBMQ==")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "       \"project\":\r\n"
				+ "       {\r\n"
				+ "          \"key\": \"SCRUM\"\r\n"
				+ "       },\r\n"
				+ "       \"summary\": \"Attachements and response are not working-Automation\",\r\n"
				+ "       \"description\": \"Attachements missing and response\",\r\n"
				+ "       \"issuetype\": {\r\n"
				+ "          \"name\": \"Bug\"\r\n"
				+ "       }\r\n"
				+ "   }\r\n"
				+ "}").log().all()
		.post("rest/api/2/issue")
		.then().log().all().assertThat().statusCode(201).time(lessThan(3000L))
		.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String issueId = js.getString("id");
		System.out.println(issueId);
		
		//add attachement
		String responseAttachment = given()
		.header("X-Atlassian-Token","no-check")
		.pathParam("key", issueId)
		.header("Authorization","Basic c3VqYW5pNzVAZ21haWwuY29tOkFUQVRUM3hGZkdGMGVzaVViWTFNVWh3NF9jc2VnRkJteEtQTzVGRWlqLS1QRFRHam1zLVd4UUJpM0xFYUo3bGhfWWJsbW5mYVFydzIyZzd4SDlMTVUwa0QwUmI1dG5iUWx0WElFazVudXpSeDhFVE1JTlpPVVhaWVlJazZIZnhUR2YtVDV4bDZudEd3dzJPQjJEWl82Q0FkbDRtdC1seWVfS0ZGV3RyZE5BZGtYb0YwMVhSU1VHaz1BRDVCN0VBMQ==")
		.multiPart("file", new File("C:\\Users\\sujan\\OneDrive\\Desktop\\Screenshot 2025-03-22 164213.png"))
		.log().all()
		.post("rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(responseAttachment);
		String fileName = js1.getString("filename");
		System.out.println(fileName);
		
		//get issue
		
		String getIssueResponse = given()
		.header("Content-Type","application/json")
		.header("Authorization","Basic c3VqYW5pNzVAZ21haWwuY29tOkFUQVRUM3hGZkdGMGVzaVViWTFNVWh3NF9jc2VnRkJteEtQTzVGRWlqLS1QRFRHam1zLVd4UUJpM0xFYUo3bGhfWWJsbW5mYVFydzIyZzd4SDlMTVUwa0QwUmI1dG5iUWx0WElFazVudXpSeDhFVE1JTlpPVVhaWVlJazZIZnhUR2YtVDV4bDZudEd3dzJPQjJEWl82Q0FkbDRtdC1seWVfS0ZGV3RyZE5BZGtYb0YwMVhSU1VHaz1BRDVCN0VBMQ==")
		.pathParam("key", issueId)
		.log().all()
		.get("rest/api/2/issue/{key}")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js2 = new JsonPath(getIssueResponse);
		String issueDescription = js2.getString("fields.issuetype.description");
		System.out.println(issueDescription);
		
	}

}
