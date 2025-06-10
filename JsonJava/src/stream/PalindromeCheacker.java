package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PalindromeCheacker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "madam".replaceAll("\\s+", "").toLowerCase();
		String reverse="";
		
		for(int i = str.length()-1; i>=0; i--) {
			reverse+=str.charAt(i);
		}
		
		if(str.equals(reverse))
		System.out.println("Plindrome");
		
		//reverse words
		String input = "Hello World";
		String [] words = input.split(" ");
		StringBuilder reverseSb = new StringBuilder();
		
		for(String word: words) {
			StringBuilder sb = new StringBuilder(word).reverse();
			reverseSb.append(sb).append(" ");
		}
		System.out.println(reverseSb.toString().trim());
		
		//Word Count
		 String input1 = "Hello world! Hello again, world.";
		 
		 String[] strA = input1.toLowerCase().split("\\s+");
		 HashMap<String, Integer> hs = new HashMap<>();
		 
		 for(String word: strA) {
			 word = word.replaceAll("[^a-zA-Z]", "");
			 if(!word.isEmpty())
				 hs.put(word, hs.getOrDefault(word, 0)+1);
		 }
		 
		 for(Map.Entry<String, Integer> m: hs.entrySet()) {
			 System.out.println(m.getKey() + " "+m.getValue());
		 }
		 
		 //print array high to low
		 
		 int [] arr = {3,5,1,8,4};
		 int max = arr[0];
		 
		 for(int i=0; i<arr.length; i++) {
			 if(arr[i] > max) {
				 max = arr[i];
			 }
		 }
		Integer [] temp = new Integer[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			temp[i] = arr[i];
		}
		
		Arrays.sort(temp, Collections.reverseOrder());
		
		for(int i: temp) {
			System.out.print(i);
		}
		 
	}

}
