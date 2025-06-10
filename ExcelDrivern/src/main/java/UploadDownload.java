import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadDownload {
	static DataFormatter formatter = new DataFormatter();
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
        String fileName ="C:\\Users\\sujan\\Downloads\\download.xlsx";
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		driver.findElement(By.id(("downloadButton"))).click();
		
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		
		upload.sendKeys(fileName);
		
		//By toasterLocator = By.cssSelector(".Toastify__toast-icon div:nth-child(1)");
		By toasterLocator = By.xpath("//div[contains(text(),'Updated Excel Data Successfully')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(toasterLocator));
		//Thread.sleep(6000);
		String toasterMessage = driver.findElement(toasterLocator).getText();
		Assert.assertEquals("Updated Excel Data Successfully.", toasterMessage);
		
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(toasterLocator));
		
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getDomAttribute("data-column-id");
		
		String actuallpPrice = driver.findElement(By.xpath("//div[text()='Apple']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']")).getText();
		Assert.assertEquals("599", actuallpPrice);
		System.out.println("actuallpPrice "+actuallpPrice);
		
//		FileInputStream fis = new FileInputStream(fileName);
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		//int sheets = workbook.getNumberOfSheets();
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		//Identify Testcases column by scanning the entire 1st row.
//		Iterator<Row> rows = sheet.iterator();
//		Row firstRow = rows.next();
//		Iterator<Cell> cell = firstRow.cellIterator();
//		int k=0;
//		int column=0;
//		while(cell.hasNext()) {
//			Cell value = cell.next();
//			System.out.println("**"+value.getStringCellValue());
//			if(value.getStringCellValue().equalsIgnoreCase("Apple")) {
//				System.out.println("**"+value.getRowIndex());
//				System.out.println("&&"+value.getColumnIndex());
//				column = k;
//			}
//			k++;
//		}
//		System.out.println("column "+column);
		
		int col = getColumnumber(fileName,"price");
		System.out.println("Col number "+col);
		int row = getRowNumber(fileName,"Apple");
		System.out.println("row number "+row);
		updateCell(row,col,"599",fileName);
		
	}

	private static void updateCell(int row, int col, String value,String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	             
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            Row targetRow = sheet.getRow(row);

	            if (targetRow == null) {
	                targetRow = sheet.createRow(row);
	            }

	            Cell cell = targetRow.getCell(col);
	            if (cell == null) {
	                cell = targetRow.createCell(col);
	            }
	            cell.setCellValue(value);

	            try (FileOutputStream fos = new FileOutputStream(fileName)) {
	                workbook.write(fos);
	            }
	            
	            System.out.println("Cell updated successfully!");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}

	private static int getRowNumber(String fileName, String keyword) {
	    try (FileInputStream fis = new FileInputStream(fileName);
	         XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	         
	        XSSFSheet sheet = workbook.getSheetAt(0);
	        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row != null) {
	                for (int j = 0; j < row.getLastCellNum(); j++) {
	                    Cell cell = row.getCell(j);
	                    if (cell != null && cell.getCellType() == CellType.STRING && 
	                        cell.getStringCellValue().equalsIgnoreCase(keyword)) {
	                        return i;  // Return the row index if "Apple" is found
	                    }
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return -1;
	}
	
	private static int getColumnumber(String fileName, String header) {
		try (FileInputStream fis = new FileInputStream(fileName);
	             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
	             
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            Row firstRow = sheet.getRow(0); // Assuming headers are in the first row
	            if (firstRow != null) {
	                for (int i = 0; i < firstRow.getLastCellNum(); i++) {
	                    Cell cell = firstRow.getCell(i);
	                    if (cell != null && header.equalsIgnoreCase(cell.getStringCellValue())) {
	                        return i;
	                    }
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	        return -1;
	}

}
