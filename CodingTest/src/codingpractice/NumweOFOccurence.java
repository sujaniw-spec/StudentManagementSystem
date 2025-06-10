package codingpractice;

import java.util.HashMap;
import java.util.Map;

public class NumweOFOccurence {

	 public static void main(String[] args) {
	     /*   String str = "My name is Krishna";
	        int[] charCounts = new int[256]; // Array to store character frequencies

	        // Convert to lowercase to make it case-insensitive
	        str = str.toLowerCase();

	        // Count occurrences of each character
	        for (char ch : str.toCharArray()) {
	            if (ch != ' ') { // Ignore spaces
	                charCounts[ch]++; // Increment the frequency
	            }
	        }

	        // Print non-zero character counts
	        for (int i = 0; i < charCounts.length; i++) {
	            if (charCounts[i] > 0) {
	                System.out.println("'" + (char) i + "' : " + charCounts[i]);
	            }
	        }*/
		 
		   String str = "My name is Krishna";
	        Map<Character, Integer> charCountMap = countCharacterOccurrences(str);

	        // Print character frequencies
	        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
	            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
	        }
	        
	        System.out.println("-------------------");
	        Map <Character, Integer> mapOccur = CountCharOccurence(str);
	        
	        for(Map.Entry<Character, Integer> entry : mapOccur.entrySet()) {
	        	System.out.println(entry.getKey() +" => "+ entry.getValue());
	        }
	        
	    }
	
	 public static Map<Character, Integer> countCharacterOccurrences(String str) {
	        Map<Character, Integer> charCountMap = new HashMap<>();

	        // Convert to lowercase to make it case-insensitive
	        str = str.toLowerCase();

	        for (char ch : str.toCharArray()) {
	            if (ch != ' ') { // Ignore spaces
	                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
	            }
	        }
	        return charCountMap;
	    }
	 
	 public static Map<Character, Integer> CountCharOccurence(String str){
		 Map<Character, Integer> mapChars = new HashMap<>();
		 str = str.toLowerCase();
		 for(char ch : str.toCharArray()) {
			 if(ch != ' ') {
				 mapChars.put(ch, mapChars.getOrDefault(ch, 0) + 1);
			 }
		 }
		 return mapChars;
	 }
}
