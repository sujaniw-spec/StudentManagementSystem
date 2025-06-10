package sujaniacademy.ExtentReports;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

    ExtentReports extent;

    @Test
    public void initialDemo() {
        // Setup Extent Reports
        ExtentSparkReporter reporter = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        // Create test
        ExtentTest test = extent.createTest("Initial Demo");

        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());

        driver.close();

        // Log failure
        test.fail("Fail");  // ✅ This should work now.

        // Generate Report
        extent.flush();
    }
}
