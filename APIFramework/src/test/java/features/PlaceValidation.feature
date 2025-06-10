Feature: Validating Place API's
#mvn test -Dcucumber.options="--tags @AddPlace" - run with tags
#mvn test  -to run all test
#mvn test verify - run with html reports

@AddPlace @Regression
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "Post" http request
	Then the API call is suceess with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" usning "GetPlaceAPI"
	
Examples:
	| name    | language | address            |
	| AAhouse | English  | World cross centre |
	#| BBhouse | Spanish  | Sea cross street   |


@DeletePlace @Regression	
Scenario: Verify if delete place functionality is working
	Given delete place payload
	When user calls "DeletePlaceAPI" with "DELETE" http request	
	Then the API call is suceess with status code 200
	And "status" in response body is "OK"
	