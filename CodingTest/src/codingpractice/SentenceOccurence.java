package codingpractice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SentenceOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sentence = "My name is Krisha".toLowerCase();
		char [] charArray = sentence.toCharArray();
		
		Map <Character, Integer> mapCharCount = new HashMap<>();
		
		for(char letter : charArray) {
			if(letter !=' ')
			mapCharCount.put(letter, mapCharCount.getOrDefault(letter, 0) +1);
		}
		
		for(Map.Entry<Character, Integer> map : mapCharCount.entrySet()) {
			System.out.println(map.getKey() +":" + map.getValue());
		}
}
}
