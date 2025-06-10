package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;

public class ExtractJson {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ObjectMapper o = new ObjectMapper();
		CustomerDetailAppium c = o.readValue(new File("C:\\ECLIPSE-PROJECTS\\JsonJava\\customerInfo0.json"), CustomerDetailAppium.class);
		System.out.println(c.getCourseName());
	}

}
