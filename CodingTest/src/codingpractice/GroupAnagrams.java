package codingpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> groupedWords = groupAngrams(input);
		
		for(List<String> group :groupedWords ) {
			System.out.println(group);
		}
		
	}
	
	public static List<List<String>> groupAngrams(String[] strs){
		
		Map <String, List<String>> map = new HashMap<>();
		for(String word: strs) {
			char [] chars = word.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
			/*
			 * if (!map.containsKey(key)) {
    			map.put(key, new ArrayList<>());
				}
				map.get(key).add(word);
			 * */
		}
		return new ArrayList<>(map.values());
	}

}
