package files;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LetterRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String word = "a7b8c9";
		char letter =' ';
		int digit=0;
		for(int i=0; i<word.length(); i++) {
			letter = word.charAt(i);
			if(Character.isAlphabetic(letter) && Character.isDigit(word.charAt(i+1))) {
				digit = Character.getNumericValue(word.charAt(i+1));
				
				for(int j=0; j< digit; j++) {
					System.out.print(letter);
				}
				System.out.println();
			}
			
		}
						
		String str = "My name is Krishna".toLowerCase();	
		
		char [] charArray = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		char e = ' ';
		for(int i=0; i<charArray.length; i++) {
			e = charArray[i];
			if(e!=' ')
				map.put(e, map.getOrDefault(e, 0)+1);
				
		}
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() +" "+ entry.getValue());
		}
		
		
		/*for(Map.Entry<Character, Integer> entry: getCharSequence(str).entrySet()) {
			System.out.println(entry.getKey() +" : "+ entry.getValue());
		}
		
		String palindrome="madam";
		String reverse="";
		for(int i=palindrome.length()-1; i>=0; i--) {
			reverse+=palindrome.charAt(i);
		}
		System.out.println("reverse "+reverse);*/
		
		
	}

	static Map<Character, Integer> getCharSequence(String sentence){
		char [] charArray = sentence.toCharArray();
		Map <Character, Integer> mapSequnce = new HashMap<>();
		char letter =' ';
		for(int i=0; i<charArray.length; i++) {
			letter = charArray[i];
			if(letter != ' ')
				mapSequnce.put(letter, mapSequnce.getOrDefault(letter, 0) +1);
		}
		return mapSequnce;
	}
	
	}


