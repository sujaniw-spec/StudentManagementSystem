package codingpractice;

import java.util.Set;
import java.util.TreeSet;

public class SecondLargestdigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  //str1025rts
		String original = "str10257rts";
		original = original.replaceAll("\\D+", "");
		System.out.println(original);
		
		char [] charArray = original.toCharArray();
		Set <Integer> treeSet = new TreeSet<>();// maintain sorted order
		
		for(char c: charArray) {
			treeSet.add(Character.getNumericValue(c));
		}
		
		//find the second largerst
		Integer [] digits = treeSet.toArray(new Integer[0]);
		if(digits.length <2) {
			System.out.println("No second largest digit found");
		}
		else {
			System.out.println("Second largest digit "+digits[digits.length -2]);
		}
		
		 StringBuilder numberBuilder = new StringBuilder();
	        for (char c : original.toCharArray()) {
	            if (Character.isDigit(c)) { // Check if character is a digit
	                numberBuilder.append(c);
	            }
	        }
	      //  numberBuilder.toString().toCharArray()

	}

}
