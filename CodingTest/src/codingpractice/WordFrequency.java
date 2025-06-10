package codingpractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "my name is Rohan Rohan";
		String [] inputArray = input.split(" ");
		
		HashMap <String, Integer> map = new HashMap<String, Integer>();
		
		for(String word:inputArray) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			//System.out.println(entry.getKey() + "-> "+entry.getValue());
		}
		
		for(String key: map.keySet()) {
			//System.out.println(key+ "= "+map.get(key));
		}
		map.keySet().stream().forEach(key ->System.out.println(key+" "+map.get(key)));
		map.forEach((key, value) -> System.out.println(key +" "+value));
		int [] aa = {4,3,2};
		Arrays.stream(aa).forEach(n -> System.out.print(n + " "));
		
		
	}

}
