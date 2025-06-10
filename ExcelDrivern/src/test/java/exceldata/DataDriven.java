package exceldata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) {
		//getData("Purchase");
	}
	
	public static ArrayList<String> getData(String testCaseName){
		ArrayList <String> list = new ArrayList<String>();

		try {
			FileInputStream fis = new FileInputStream("C://ECLIPSE-PROJECTS//DemoData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			int sheets = workbook.getNumberOfSheets();
			for(int i=0; i<sheets; i++) {
				if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				//Identify Testcases column by scanning the entire 1st row.
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				int k=0;
				int column=0;
				while(cell.hasNext()) {
					Cell value = cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				System.out.println("column "+column);
				
				while(rows.hasNext()) {
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cv = r.cellIterator();
						
						while(cv.hasNext()) {
						//	System.out.println(cv.next().getRichStringCellValue());
							Cell c = cv.next();
							if(c.getCellType() == CellType.STRING) {
								list.add(c.getStringCellValue());}
							else {
								list.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							//	list.add(String.valueOf(c.getNumericCellValue()));
								}
						}
						
					}
				}
				}				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  list;
	}

}
