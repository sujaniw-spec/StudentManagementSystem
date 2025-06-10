package exceldata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataReadThoughXsl {

	@Test(dataProvider="driverTest")
	public void testCaseData(String greeting, String communication, int id) {
		System.out.println(greeting+communication+id);
	}
	
	@DataProvider(name="driverTest")
	public Object[][] getData() {
		Object[][] data = {{"Hello","text",1},{"Bye","message",143},{"Solo","call",453}};
		
		return data;
	}
	
}
