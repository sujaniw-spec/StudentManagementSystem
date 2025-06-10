package codingpractice;

import java.util.HashMap;
import java.util.Map;

public class NumberOfOccurenceHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My name is Krishna";
		Map <Character, Integer> mapOccurence = getOccurenceCount(str);
		
		for(Map.Entry<Character, Integer> entry : mapOccurence.entrySet()) {
			System.out.println(entry.getKey() +" => "+entry.getValue());
		}
	}
	
	static Map<Character, Integer> getOccurenceCount(String sentence){
		
		Map <Character, Integer> charMap = new HashMap<>();
		
		sentence = sentence.toLowerCase();
		
		//char[] charArray = sentence.toCharArray();
		
		for(char ch :sentence.toCharArray() ) {
			if(ch != ' ')
				charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
		}
		return charMap;
	}

}
