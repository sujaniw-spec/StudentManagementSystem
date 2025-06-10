package api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


public class OneSingleJson {

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
		
		//ObjectMapper ob = new ObjectMapper();
		//ob.writeValue(new File("C:\\ECLIPSE-PROJECTS\\JsonJava\\customerInfo.json"), list);
		
		JSONArray  jsonArray = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			//ob.writeValue(new File("C:\\ECLIPSE-PROJECTS\\JsonJava\\customerInfo"+i+".json"), list.get(i));
			//convert java object to json using gson
			Gson g = new Gson();
			String jsonString = g.toJson( list.get(i));
			jsonArray.add(jsonString);
		}	
		
		//Json simple
		JSONObject jo = new JSONObject();
		jo.put("data",jsonArray);		
		
		System.out.println(jo.toJSONString());
		
		String unescapedJsonString = StringEscapeUtils.unescapeJava(jo.toJSONString());
		System.out.println(unescapedJsonString);
		String removeDoubleQuoteInfront = unescapedJsonString.replace("\"{", "{");
		String finalString = removeDoubleQuoteInfront.replace("}\"","}");
		System.out.println(finalString);
		
		try(FileWriter file = new FileWriter("C:\\ECLIPSE-PROJECTS\\JsonJava\\SingleJson.json")){
			file.write(finalString);
		}
		
	}

}
