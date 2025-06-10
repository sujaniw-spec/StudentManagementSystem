package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DBConnection {
	
   public static void main(String [] args) {
        try {
        	WebDriverManager.chromedriver().setup();
    		ChromeDriver driver = new ChromeDriver();
    		
            // Load MySQL JDBC Driver (not required for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            String url = "jdbc:mysql://localhost:3306/QADbt";
            String user = "root";
            String password = "root";
            
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully!");
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from Credentials where scenario='basiccard'");
            
            driver.get("https://login.salesforce.com");
            while(rs.next()) {
            	driver.findElement(By.id("username")).sendKeys(rs.getString("username"));
            	driver.findElement(By.id("password")).sendKeys(rs.getString("password"));            	            	
            }
            
            rs.close();

            conn.close();
            driver.findElement(By.id("Login")).click();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
