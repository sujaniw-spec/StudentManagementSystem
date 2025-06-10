package codingpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		String str = "swisbdcds";
		
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		
		for(Character c : str.toCharArray()) {;
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		
		for(Character c: str.toCharArray()) {
			if(charCount.get(c) == 1)
				System.out.println("letter "+c);
		}
		
		//Find duplicate characters in String using HashMap.
		
		Map<Character, Integer> dupMap = new HashMap<>();
		
		for(char a: str.toCharArray()) {
			dupMap.put(a, dupMap.getOrDefault(a, 0)+1);			
		}
		
		for(char a: str.toCharArray()) {
			if(dupMap.get(a) > 1) {
				//System.out.println("letter "+a + "Duplicate "+dupMap.get(a));
			}
		}
		
		for(Entry<Character, Integer> entry : dupMap.entrySet()) {
			if(entry.getValue() >1)
				System.out.println(entry.getKey() +"-> "+ entry.getValue());
		}
		//dupMap.forEach((key,value) -> System.out.println(key +value));
	}

}
