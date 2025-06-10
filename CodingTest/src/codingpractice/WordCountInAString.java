package codingpractice;

import java.util.HashMap;
import java.util.Map;

public class WordCountInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Hi bye good bye bye good morning good afternoon";
		Map<String, Integer> map = new HashMap<>();
		
		for(String word: str.split(" ")) {
			map.put(word, map.getOrDefault(word,0)+1);
		}
		
		for(String s: map.keySet()) {
			System.out.println("word "+s+" occurence "+map.get(s));
		}
		
	}

}
