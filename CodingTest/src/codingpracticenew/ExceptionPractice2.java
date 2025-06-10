package codingpracticenew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionPractice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10/2;
		
		File file = new File(System.getProperty("user.dir")+"\\src\\codingpracticenew\\Test.txt");
		
        try (BufferedReader br = new BufferedReader(new FileReader(file))){	//auto closable interface          
       
        System.out.println(br.readLine());	
		
        }catch( IOException e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        } 
		
	}

}
