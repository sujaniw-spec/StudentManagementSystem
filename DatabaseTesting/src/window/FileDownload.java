package window;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dowloadPath = System.getProperty("user.dir");
		
		WebDriverManager.chromedriver().setup();
		
		HashMap<String, Object> chromePref = new HashMap<String, Object>();
		chromePref.put("profile.default_content_settings.popups",0);
		chromePref.put("download.default_directory", dowloadPath);
		
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePref);
		ChromeDriver driver = new ChromeDriver(options);
		
		File f = new File(dowloadPath +"/Converted.zip");
		if(f.exists()) {
			Assert.assertTrue(f.exists());
			if(f.delete()) {
				System.out.println("File deleted");
			}
		}
		else {
			Assert.assertFalse(f.exists());
			System.out.println("File not found");
		}
		
	}

}
