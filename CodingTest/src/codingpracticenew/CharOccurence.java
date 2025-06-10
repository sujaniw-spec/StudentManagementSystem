package codingpracticenew;

import java.util.LinkedHashMap;

public class CharOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "My name is Krishna".toLowerCase();
		
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
		
		for(char c: str.toCharArray()) {
			if(c !=' ') {
				map.put(c, map.getOrDefault(c, 0)+1);
			}
		}
		
		map.forEach((key, value) -> System.out.println(key +" -> "+ value));
		StringBuilder sb = new StringBuilder();
		for(char c: str.toCharArray()) {
			if(c !=' ') {
				sb.append(c);
			}
		}
		System.out.println(sb.reverse());
		String reverse="";
		str = str.replaceAll("\\s+", "");
		for(int i=str.length()-1; i>=0; i--) {
			reverse+=str.charAt(i);
		}
		System.out.println(reverse);
	}

}
