package stream;

import java.util.HashMap;
import java.util.Map;

public class HigestOccuringChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello world";
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char ch: str.toCharArray()) {
			if(ch !=' ') {
				map.put(ch, map.getOrDefault(ch, 0)+1);
			}
		}
		
		int maxCount =0;
		char charOccor=' ';
		for(Map.Entry<Character, Integer> m : map.entrySet()) {
			
			if(m.getValue() > maxCount) {
				maxCount = m.getValue();
				charOccor = m.getKey();
			}
		}
		
		System.out.println("Max char occure for "+charOccor +" count "+maxCount);
		
	}

}
