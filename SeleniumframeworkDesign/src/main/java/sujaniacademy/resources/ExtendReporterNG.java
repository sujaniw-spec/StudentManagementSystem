package sujaniacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReporterNG {

	public static ExtentReports getReportObject() {
		
		
			String path =System.getProperty("user.dir")+"//reports//index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			
			ExtentReports extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Rahul Shetty");
			return extent;
			
			
			
		

       
//        extent.createTest(path);
//        
//        // Create test
//        ExtentTest test = extent.createTest("Initial Demo");
//
//        // Setup WebDriver
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/");
//        System.out.println(driver.getTitle());
//
//        driver.close();
//
//        // Log failure
//        test.fail("Fail");  // ✅ This should work now.
//
//        // Generate Report
//        extent.flush();
	}
}
