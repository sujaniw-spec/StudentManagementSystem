package files;

import io.restassured.path.json.JsonPath;

public class Reusable {

	public static JsonPath rowToJson(String response) {
		JsonPath jsonPath = new JsonPath(response); 
		return jsonPath;
	}
}
