package coding;

import java.util.HashSet;

public class PangramWithSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="the quick brown fox jumps over the lazy dog".toLowerCase();
		
		System.out.println(checkPangram(str));
		
	}

	private static boolean checkPangram(String str) {
		// TODO Auto-generated method stub
		HashSet <Character> set = new HashSet<>();
		char [] charArray = str.toCharArray();
		for(char c: charArray) {
			if(Character.isLetter(c)) {
				set.add(c);
			}
		}
		
		if(set.size() ==26) {
			return true;
		}
		return false;
	}

}
