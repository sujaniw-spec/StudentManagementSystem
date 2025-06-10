/**
 * 
 */
/**
 * 
 */
module DemoRest {
	//requires rest.assured;
	requires org.hamcrest;
	requires rest.assured.common;
	requires org.testng;
	requires json.path;
	requires rest.assured;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.annotation;
	requires org.seleniumhq.selenium.api;
	requires org.seleniumhq.selenium.chrome_driver;
	requires io.github.bonigarcia.webdrivermanager;
	//requires io.github.bonigarcia.webdrivermanager;
    
    opens pojo to com.fasterxml.jackson.databind; 
	exports demorest to org.testng;
}