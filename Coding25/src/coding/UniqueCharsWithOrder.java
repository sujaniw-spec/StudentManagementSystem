package coding;

import java.util.LinkedHashSet;

public class UniqueCharsWithOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input ="abbaccdaab";
		
		char [] charArray = input.toCharArray();
		LinkedHashSet <Character> set = new LinkedHashSet<>();
		
		
		for(char c: charArray) {
			set.add(c);
		}
		
		set.forEach(c -> System.out.println(c));
	}

}
