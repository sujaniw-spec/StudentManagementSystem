package sujaniacademy.tests.testcomponenets;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import sujaniacademy.pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver = null;
	protected LandingPage landingPage;
	
	public WebDriver initializeDriver() {
		
		Properties prop = new Properties();
		FileInputStream inputStream;
		String browserName= null;
	    
		try {
			inputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\sujaniacademy\\resources\\GlobalData.properties");
			prop.load(inputStream);
			//check it comes from mevan command
			
			browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
			
			
			java.awt.Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

			options.addArguments("--window-size=" + (int) screenDimension.getWidth() + "," + (int) screenDimension.getHeight());
		//	driver.manage().window().setSize(new Dimension(1440,900));//help to run in full screen in headless mode
			}
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("fireFox")) {
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "edge.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Datbind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}
		
	}
	
	public File getScreenshot(String testCaseName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//store the file
		File fileDestination = new File(System.getProperty("user.dir") + "//reports//"+testCaseName+".jpg");
		try {
			FileUtils.copyFile(source, fileDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("[BaseTest][getScreenshot]"+e.toString());
		}
		return fileDestination;
	}
	
@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() {
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}

@AfterMethod(alwaysRun=true)	
	public void tearDown() {
		driver.quit();
	}
	
}
