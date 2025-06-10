package coding;

import java.util.HashMap;

public class FindFrequencyOfSpecialCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str = "abs@3 @#!";
        
        char [] input = str.toCharArray();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c: input) {
        	if(!Character.isLetterOrDigit(c)) {
        		if(c !=' ')
        			map.put(c,  map.getOrDefault(c, 0)+1);
        	}
        }
        
        map.forEach((key, value) -> System.out.println(key + " "+value));
        
	}

}
