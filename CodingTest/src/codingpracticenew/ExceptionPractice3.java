package codingpracticenew;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionPractice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10/2;
		int numbers[] = {1,2,3,4,5};
		File file = new File(System.getProperty("user.dir")+"\\src\\codingpracticenew\\Test.txt");
		FileReader fr = null;
		BufferedReader br = null;
        try {		
        System.out.println(System.getProperty("user.dir")+"\\Test.txt");	
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        System.out.println(br.readLine());	
		System.out.println(numbers[0]);
        }catch(ArithmeticException | ArrayIndexOutOfBoundsException  | IOException e) {
        	System.out.println(e.getMessage());
        	e.printStackTrace();
        } 
		finally {
			try {
				br.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
