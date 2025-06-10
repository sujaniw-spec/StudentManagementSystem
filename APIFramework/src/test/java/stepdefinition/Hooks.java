package stepdefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace") //before run DeletePlace run this beforeScenario
	public void beforeScenario() throws IOException {
		//write a code that will give you place id
		//execute this code that will place id is null
		StepDefinition sd = new StepDefinition();
		System.out.println("StepDefinition.placeId "+StepDefinition.placeId );
		if (StepDefinition.placeId == null) {
		
			sd.add_place_payload_with("Sujani", "French", "Asia");
			sd.user_calls_with_http_request("AddPlaceAPI", "POST");
			
			sd.verify_place_id_created_maps_to_usning("Sujani","GetPlaceAPI");
		}
	}
}
