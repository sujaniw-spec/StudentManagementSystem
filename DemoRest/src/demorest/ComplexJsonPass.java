package demorest;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath json = new JsonPath(PayLoad.getCoursePrice());
		
		//Print number of course retured by API
		int count = json.getInt("courses.size()");
		System.out.println("count "+count);
		
		//print purchase amount
		
		int purchaseAmount = json.getInt("dashboard.purchaseAmount");
		System.out.println("purchaseAmount "+purchaseAmount);
		
		//Print title of the first course
		String title = json.getString("courses[0].title");
		System.out.println("title "+title);
		
		//print all course titles and their respective prices
		
		for(int i=0; i<count; i++) {
			String courseTitle =json.get("courses["+i+"].title");
			System.out.println("courseTitle "+courseTitle);
			int coursePrice = json.get("courses["+i+"].price");
			System.out.println("coursePrice "+coursePrice);
		}
		
		for(int i=0; i<count; i++) {
			String courseTitle =json.get("courses["+i+"].title");
			if(courseTitle.equals("RPA")){
			int copies = json.get("courses["+i+"].copies");
			System.out.println("copies "+copies);
			break;
			}
		}
		
		//getTotalAmount(); 
		
		//getTotalAmount();
	}
	
	@Test
	public void getTotalAmount() {
		JsonPath json = new JsonPath(PayLoad.getCoursePrice());
		
		//Print number of course retured by API
		int count = json.getInt("courses.size()");
		System.out.println("count "+count);
		
		//print purchase amount
		
		int purchaseAmount = json.getInt("dashboard.purchaseAmount");
		int total=0;
		for(int i=0; i<count; i++) {
			String courseTitle =json.get("courses["+i+"].title");
			
			int coursePrice = json.get("courses["+i+"].price");
			int copies = json.get("courses["+i+"].copies");
			total+=(coursePrice*copies);			
		}
		
		System.out.println("total "+total);
		if(purchaseAmount == total) {
			System.out.println("Purchase amount equals to total");
		}
		Assert.assertEquals(total, purchaseAmount);
	}

}
