package codingpractice;

import java.util.Arrays;
import java.util.List;

public class IncrementNumberRepresentArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = {1,0,9};
		String strNum="";
			
		for(int i=0; i<array.length; i++) {
			strNum+=array[i];
		}
		
		//System.out.println(Integer.parseInt(strNum)+1);
		int total = Integer.parseInt(strNum)+1;
		String strTot = String.valueOf(total).toString();
		int [] strArray = new int[strTot.length()];
		for(int i=0; i<strArray.length; i++) {
			strArray[i]= Character.getNumericValue(strTot.charAt(i));
		}
		
		for(int i=0; i<strArray.length; i++) {
			System.out.print(strArray[i]+ " ");
		}
		
		
	}

}
