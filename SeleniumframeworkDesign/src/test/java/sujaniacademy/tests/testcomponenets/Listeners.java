package sujaniacademy.tests.testcomponenets;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import sujaniacademy.resources.ExtendReporterNG;

public class Listeners extends BaseTest implements ITestListener{

	ExtentReports extents = ExtendReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); //Thread safe

	
	@Override
    public void onTestStart(ITestResult result) {
		test = extents.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // assign uniquethread id
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Code to run when a test is successful
    	//test.log(Status.PASS, "Test Passed");
    	extentTest.get().log(Status.PASS, "Test Passed");

    	System.out.println("PASSSS####################");
    }

    
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Take screenshot and attach to report
        File filePath = getScreenshot(result.getMethod().getMethodName(), driver);
        extentTest.get().addScreenCaptureFromPath(filePath.getAbsolutePath(), result.getMethod().getMethodName());
    }

   /* public void onTestFailure(ITestResult result) {
    	// TODO Auto-generated method stub
    			extentTest.get().fail(result.getThrowable());//
    			
    			try {
    				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
    						.get(result.getInstance());
    				
    			} catch (Exception e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    			}
    			   			
    			
    			File filePath = null;
    			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
    			extentTest.get().addScreenCaptureFromPath(filePath.getPath(), result.getMethod().getMethodName());
    			
    			
    			//Screenshot, Attach to report

    	/*test.log(Status.FAIL, "Test failed");
    	test.fail(result.getThrowable());
    	File filePath = null;
    	try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("Listeners -> onTestFailure->driver "+e1.toString());
		}

    	
    	//screenshot
    	try {
    		filePath = getScreenshot(result.getMethod().getMethodName(),driver);
    	}catch(Exception e) {
    		System.out.println("Listeners -> onTestFailure "+e.toString());
    	}    	
    	test.addScreenCaptureFromPath(filePath.getPath(), result.getMethod().getMethodName());
    	
    }*/

    @Override
    public void onTestSkipped(ITestResult result) {
        // Code to run when a test is skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Code to run when a test fails but is within success percentage
    }

    @Override
    public void onStart(ITestContext context) {
        // Code to run before any tests are executed
    }

    @Override
    public void onFinish(ITestContext context) {
        // Code to run after all tests have been executed
    	extents.flush();    	
    }
}
