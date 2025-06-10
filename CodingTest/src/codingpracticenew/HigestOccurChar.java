package codingpracticenew;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HigestOccurChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello world";
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c: str.toCharArray()) {
			if(c !=' ')
				map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		int max=0;
		char key=' ';
		
		for(Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		
		System.out.println(key + " -> "+ max);
		
		
	}

}
