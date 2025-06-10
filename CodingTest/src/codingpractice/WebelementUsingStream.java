package codingpractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebelementUsingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Sorting web table and compare it with sorted list
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();
		//capture all webelemnts into list
		List <WebElement> fruitsList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
		//capture text of all webelements into a new list
		
		List <String> fruitsNamesList = fruitsList.stream().map(w -> w.getText())
		.collect(Collectors.toList());
		
		//List <String> friutsNames = fruitsList.stream().collect(Collectors.toList()).forEach(w ->w.getText());
//	  for(WebElement element : fruitsList ) {
//		  fruitsNamesList.add(element.getText());
//	  }
//	  
	  //sort on the original list of step3 -> sorted list
	//  List <String> sortedFruitsNamesList = fruitsNamesList.stream().sorted().collect(Collectors.toList());
		List<String> tempList = new ArrayList<>(fruitsNamesList); // Copy original list
		Collections.sort(tempList);
		//compare original list vs sorted list.
	  Assert.assertEquals(tempList, fruitsNamesList);
	  List <String> priceList = null;
	  
	  do {
	  //scan the name column with getText -> Beans -> print price of Rice
	  List <WebElement> rows = driver.findElements(By.xpath("//tbody/tr/td[1]"));	  
	  priceList = rows.stream().filter(s -> s.getText().contains("Rice")).
	  map(s ->getVegiePrice(s)).collect(Collectors.toList());
	  
	  if(priceList.size()<1) {
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
	  
	  }while(priceList.size()<1);
	  
	
	  priceList.forEach(s -> System.out.println(s));
	
	}

	private static String getVegiePrice(WebElement s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();		
	}

}
