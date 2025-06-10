package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class JsonToJava {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, StreamWriteException, DatabindException, IOException {
		// TODO Auto-generated method stub
		CustomerDetail c= new CustomerDetail();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","root");
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia' ");
	    	
		ArrayList <CustomerDetail>list = new ArrayList<>();
		while(rs.next()) {
			//c = new CustomerDetail();
			c.setCourseName(rs.getString(1));
			c.setPurchasedDate(rs.getString(2));
			c.setAmount(rs.getInt(3));
			c.setLocation(rs.getString(4));
			list.add(c);
		}
		conn.close();
		
		System.out.println(c.getCourseName());
		System.out.println(c.getPurchasedDate());
		System.out.println(c.getAmount());
		System.out.println(c.getLocation());
		
		//jackson api helps to convert java object to json file.
		
		ObjectMapper ob = new ObjectMapper();
		//ob.writeValue(new File("C:\\ECLIPSE-PROJECTS\\JsonJava\\customerInfo.json"), list);
		
		for(int i=0; i<list.size(); i++) {
			//ob.writeValue(new File("C:\\ECLIPSE-PROJECTS\\JsonJava\\customerInfo"+i+".json"), list.get(i));
		ob.writeValue(new File("C:\\ECLIPSE-PROJECTS\\JsonJava\\customerInfoP"+i+".json"),  list.get(i));
		
		}
		
	}

}
