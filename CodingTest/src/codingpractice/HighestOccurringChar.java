package codingpractice;

import java.util.HashMap;
import java.util.Map;

public class HighestOccurringChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Character, Integer> map = new HashMap<>();
		String str = "hello world";
		
		for(char c : str.toCharArray()) {
			if(c!= ' ') {
				map.put(c, map.getOrDefault(c,0)+1);
			}
		}
		
		char cChar=' ';
		int maxCount = 0;
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				cChar = entry.getKey();
			}
		}
		
		System.out.println("Highest occur character: "+cChar+ " and occured "+maxCount);	
				
	}

}
