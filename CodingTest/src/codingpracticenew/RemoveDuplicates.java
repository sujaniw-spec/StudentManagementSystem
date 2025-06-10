package codingpracticenew;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "automation";
		
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		
		for(char c: str1.toCharArray()) {
			set.add(c);			
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c: set) {
			sb.append(c);
		}
		System.out.println(sb.toString());		
	
	}

}
