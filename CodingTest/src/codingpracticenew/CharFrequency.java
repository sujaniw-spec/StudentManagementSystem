package codingpracticenew;

import java.util.LinkedHashMap;

public class CharFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My name is Krishna".toLowerCase();
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		for(char c: str.toCharArray()) {
			if(c !=' ')
				map.put(c, map.getOrDefault(c,0)+1);
		}
		map.forEach((key,value) -> System.out.println(key + " = "+value));
		
	}

}
