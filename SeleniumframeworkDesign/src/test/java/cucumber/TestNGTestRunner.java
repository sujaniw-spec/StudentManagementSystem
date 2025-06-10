package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber -> TestNG, Junit both can be used.
//if you have TestNg assertion in your project use this.(TestNG)
//If you have JUnit code/assertions in the project then use junit way 

@CucumberOptions(features="src/test/java/cucumber", glue="sujaniacademy.stepdefinitions",
monochrome=true,plugin= {"html:target/cucumber.html"}, tags= "@Regression")
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
