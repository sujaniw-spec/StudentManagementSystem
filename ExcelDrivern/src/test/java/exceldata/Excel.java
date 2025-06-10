package exceldata;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel {
	
	DataFormatter formatter = new DataFormatter();
	
	
	@Test(dataProvider="getExcelData")
	public void testCaseData(String greeting, String communication, String id) {
		System.out.println(greeting+communication+id);
	}
	
		
		@DataProvider(name="getExcelData")
		public Object[][] getExcelData() throws IOException {
			//Object[][] data = {{"Hello","text",1},{"Bye","message",143},{"Solo","call",453}};
			FileInputStream fis = new FileInputStream("C://ECLIPSE-PROJECTS//Hello.xlsx");
			try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
				//int sheets = workbook.getNumberOfSheets();
				XSSFSheet sheet = workbook.getSheetAt(0);
				int rowCount = sheet.getPhysicalNumberOfRows();
				XSSFRow row = sheet.getRow(0);
				int colCount = row.getLastCellNum();
				Object[][] data = new Object[rowCount][colCount];
				
				for(int i=1; i<rowCount; i++) {
					row = sheet.getRow(i);
					for(int j=0; j<colCount; j++) {
					//	System.out.println(row.getCell(j));
						XSSFCell cell = row.getCell(j);
						data[i][j] = formatter.formatCellValue(cell);
						//data[i][j] = row.getCell(j);
						//System.out.println(data[i][j]);
					}
				}
				return data;
			}
	}
}
