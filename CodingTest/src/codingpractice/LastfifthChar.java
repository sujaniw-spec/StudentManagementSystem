package codingpractice;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LastfifthChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word= "abcdefnf";
		
		if(word.length() >= 5) {
			char letter =' ';
						
			for(int i=0; i<=word.length(); i++) {
				if(i == 4)
					letter = word.charAt(i);
			}
			System.out.println(letter);
			
			//last 5 th char
			letter = word.charAt(word.length()-5);
			System.out.println(letter);			
			
		}
		String withWhiteSpace ="hello    world  ";
		withWhiteSpace = withWhiteSpace.replaceAll("\\s", "");
		System.out.println("##### "+withWhiteSpace);	
		
		//print the last three characters of the string
		
		StringBuilder builder = new StringBuilder();
		for(int i=1; i<=word.length()-1; i++) {
			if(i==4)
				break;
			builder.append(word.charAt(word.length()-i));
			//System.out.print(word.charAt(word.length()-i));
		}
		System.out.println(builder.toString());
		//String lastThree = word.substring(word.length()-1, 3);
		//System.out.println(lastThree);	
		
		
		//Write a java program to print only letters from the string "cts123cts123"?
		String letword = "cts123cts123";
		letword = letword.replaceAll("[0-9]", "");
		System.out.println(letword);
		
		//Print char occurence
		String str = "My name is Krishna".toLowerCase();
		TreeMap <Character, Integer> map = new TreeMap<>();
		
		for(char c : str.toCharArray()) {
			if(c !=' ')
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		for(Entry <Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-> "+ entry.getValue());
		}
	}

}
