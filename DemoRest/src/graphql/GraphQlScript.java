package graphql;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.Assert;

import files.PayLoad;
import files.Reusable;

public class GraphQlScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Query
		int characterid=13534;
		String response = given().log().all().header("content-type","application/json")
		//.body("{\"query\":\"query($characterId : Int!, $locationId:Int!) {\\n  character(characterId:$characterId)\\n  {\\n    name   \\n    type\\n    status\\n    gender\\n    \\n  }\\n  location(locationId:$locationId){\\n    id,\\n    name\\n  }\\n  \\n  characters(filters:{name:\\\"Robin\\\"}){\\n    info{count},\\n    result{\\n    id\\n      name\\n    }\\n    \\n  }\\n episode(episodeId:13924){\\n  name\\n  air_date\\n}\\n  episodes(filters:{name:\\\"TwoEpisode\\\"}){\\n    info{\\n      count\\n    }\\n    result{\\n      id\\n      name\\n    }\\n    \\n  }\\n  \\n  locations(filters:{}){\\n    result{\\n      id\\n      name\\n    }\\n  }\\n  \\n}\\n\\n\\n\",\"variables\":{\"characterId\":13534,\"locationId\":19927}}")
		.body("{\"query\":\"query($characterId : Int!) {\\n  character(characterId:$characterId)\\n  {\\n    name   \\n    type\\n    status\\n    gender\\n    \\n  }\\n}\\n  \",\"variables\":{\"characterId\":"+13534+"}}")
		.when().post("https://rahulshettyacademy.com/gq/graphql")
		.then().extract().response().asPrettyString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String characterName = js.getString("data.character.name");
		System.out.println(characterName);
		Assert.assertEquals("robin", characterName);
		
		//Mutation
		String locationName="North America";
		String mutationResponse = given().log().all().header("content-type","application/json")
				//.body("{\"query\":\"query($characterId : Int!, $locationId:Int!) {\\n  character(characterId:$characterId)\\n  {\\n    name   \\n    type\\n    status\\n    gender\\n    \\n  }\\n  location(locationId:$locationId){\\n    id,\\n    name\\n  }\\n  \\n  characters(filters:{name:\\\"Robin\\\"}){\\n    info{count},\\n    result{\\n    id\\n      name\\n    }\\n    \\n  }\\n episode(episodeId:13924){\\n  name\\n  air_date\\n}\\n  episodes(filters:{name:\\\"TwoEpisode\\\"}){\\n    info{\\n      count\\n    }\\n    result{\\n      id\\n      name\\n    }\\n    \\n  }\\n  \\n  locations(filters:{}){\\n    result{\\n      id\\n      name\\n    }\\n  }\\n  \\n}\\n\\n\\n\",\"variables\":{\"characterId\":13534,\"locationId\":19927}}")
				.body("{\"query\":\"mutation($locationName:String!,$characterName:String!,$episodeName:String!){\\n  createLocation(location:{name:$locationName, type:\\\"SouthZone\\\",dimension:\\\"238\\\"} )\\n  {\\n    id\\n  }\\n  \\n  createCharacter(character:{name:,$characterName, type:\\\"macho1\\\", status:\\\"live\\\",species:\\\"fantacy1\\\",gender:\\\"female\\\",image:\\\"png\\\",originId:19911, locationId:19911}){\\n    id\\n  }\\n  \\n  createEpisode(episode:{name:$episodeName, air_date:\\\"2024-01-25\\\",episode:\\\"200\\\"}){\\n    id\\n  }\\n  \\n}\\n\\n\",\"variables\":{\"locationName\":\""+locationName+"\",\"characterName\":\"Baskin Robin\",\"episodeName\":\"Manifest\"}}")
				.when().post("https://rahulshettyacademy.com/gq/graphql")
				.then().log().all().extract().response().asPrettyString();
		
		System.out.println(mutationResponse);
		JsonPath js1 = new JsonPath(mutationResponse);
		String characterId = js1.getString("data.createCharacter.id");
		System.out.println(characterId);
		
	}

}
